package com.cox.bmw.iplookup.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AmazonDynamoDBException;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.cox.bmw.commons.logging.LogEntry;
import com.cox.bmw.commons.logging.LogMessage;
import com.cox.bmw.commons.model.message.ResponseHeader;
import com.cox.bmw.commons.model.message.ResponseMessage;
import com.cox.bmw.commons.util.CommonConstants.C_ErrorCodes;
import com.cox.bmw.commons.util.CommonConstants.C_Errors;
import com.cox.bmw.commons.util.CommonConstants.C_HeaderFields;
import com.cox.bmw.commons.util.CommonConstants.C_Properties;
import com.cox.bmw.commons.util.Util;
import com.cox.bmw.iplookup.api.model.AccountsSearchRequest;
import com.cox.bmw.iplookup.api.model.AccountsSearchResponse;
import com.cox.bmw.iplookup.dao.model.CustomerAccountInfo;
import com.cox.bmw.iplookup.dao.repository.CustomerAccountRepository;
import com.cox.bmw.iplookup.exception.BusinessException;
import com.cox.bmw.iplookup.model.CustomerAccount;
import com.cox.bmw.iplookup.model.DataService;

@Component("iplookupProcessor")
public class IPLookupProcessor {

	private DynamoDBMapper dynamoDBMapper;

	@Autowired
	private AmazonDynamoDB amazonDynamoDB;

	@Autowired
	CustomerAccountRepository repository;

	/***
	 * Method: searchComments Description: search xHastage for IPLookupProcessor
	 * within parameters
	 * 
	 * @category method
	 * @author Mayuresh Krishna
	 * @param exchange
	 * @throws BusinessException
	 * @throws Exception
	 */
	public AccountsSearchResponse accountsSearch(Exchange exchange, AccountsSearchRequest request)
			throws Exception, ResourceNotFoundException, AmazonDynamoDBException {

		LogEntry logEntry = (LogEntry) exchange.getProperties().get(C_Properties.LOG_ENTRY_KEY);

		AccountsSearchResponse response = new AccountsSearchResponse();
		ResponseHeader responseHeader = new ResponseHeader();

		try {
			// Configuration configuration=new Configuration();

			/**
			 * Add Service Name and Operation Name to Log Entry
			 */

			logEntry.setService("iplookup");
			logEntry.setResource("accountsSearch");
			logEntry.setOperation("accountsSearch");

			List<DataService> dataServiceList = new ArrayList<>();
			DataService dataservice = new DataService();
			dataservice.setOccurrence("1");
			dataservice.setStatus("active");
			dataServiceList.add(dataservice);

			CustomerAccount account = new CustomerAccount();

			account.setAccountNumber9("1604");
			account.setAccountStatus("active");
			account.setAccountType("residential");
			account.setSiteId("436");
			account.setDataService(dataServiceList);

			response.setIpFormat("ipv4");

			/**
			 * Add Log Message
			 */

			List<LogMessage> messages = logEntry.getMessages();
			LogMessage message = new LogMessage("SUCCESS", "IPLookupProcessor - Default Values for response is set");
			messages.add(message);

			logEntry.setMessages(messages);

			// List<CustomerAccountInfo> result = (List<CustomerAccountInfo>)
			// repository.findById("754c971e-f8d2-4b6b-a33b-f825f3e4e29b");

			List<CustomerAccountInfo> result = (List<CustomerAccountInfo>) repository
					.findByipaddress(request.getIpAddress());
			System.out.println("RESULT from DB: " + result.isEmpty());

			/**
			 * Add Log Message
			 */

			message = new LogMessage("SUCCESS", "IPLookupProcessor - DynamoDB Lookup Successful");
			messages.add(message);

			logEntry.setMessages(messages);

			responseHeader.setSuccess(true);
			responseHeader.setServiceName("customer-comments");
			responseHeader.setResourceName("comments");
			responseHeader.setOperationName("search");
			responseHeader.setVersion("1.0");

			if (result.isEmpty()) {

				List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();
				ResponseMessage responseMessage = new ResponseMessage(C_ErrorCodes.NO_RECORDS_FOUND,
						C_Errors.NO_RECORDS_FOUND + ": No Comment Details found");
				responseMessages.add(responseMessage);
				responseHeader.setMessages(responseMessages);
			} else {
				account.setAccountNumber9(result.get(0).getAccountNumber9());
				account.setAccountStatus(result.get(0).getAccountStatus());
				account.setAccountType(result.get(0).getAccountType());
				account.setDataService(result.get(0).getDataService());
				account.setSiteId(result.get(0).getSiteId());
				response.setAccount(account);
			}

			response.setResponseHeader(responseHeader);

		} catch (ResourceNotFoundException rf) {

			responseHeader.setSuccess(false);
			responseHeader.setServiceName("iplookup");
			responseHeader.setResourceName("accountsSearch");
			responseHeader.setOperationName("accountsSearch");
			responseHeader.setVersion("1.0");

			List<ResponseMessage> messages = new ArrayList<>();
			ResponseMessage error = new ResponseMessage(rf.getErrorCode(), rf.getErrorMessage(), rf.getMessage());
			messages.add(error);
			responseHeader.setMessages(messages);
			response.setResponseHeader(responseHeader);

			/**
			 * Add Log Message
			 */
			List<LogMessage> logmessages = logEntry.getMessages();
			LogMessage message = new LogMessage("FAILURE",
					"DynamoDB Error - " + rf.getErrorCode() + " " + rf.getErrorMessage() + " " + rf.getMessage());
			logmessages.add(message);

			logEntry.setMessages(logmessages);
		}

		catch (AmazonDynamoDBException rf) {

			responseHeader.setSuccess(false);
			responseHeader.setServiceName("iplookup");
			responseHeader.setResourceName("accountsSearch");
			responseHeader.setOperationName("accountsSearch");
			responseHeader.setVersion("1.0");

			List<ResponseMessage> messages = new ArrayList<>();
			ResponseMessage error = new ResponseMessage(rf.getErrorCode(), rf.getErrorMessage(), rf.getMessage());
			messages.add(error);
			responseHeader.setMessages(messages);
			response.setResponseHeader(responseHeader);

			/**
			 * Add Log Message
			 */
			List<LogMessage> logmessages = logEntry.getMessages();
			LogMessage message = new LogMessage("FAILURE",
					"DynamoDB Error - " + rf.getErrorCode() + " " + rf.getErrorMessage() + " " + rf.getMessage());
			logmessages.add(message);

			logEntry.setMessages(logmessages);
		}
		if (Util.isNotNullEmpty(exchange.getIn().getHeader(C_HeaderFields.TRANSACTION_ID_KEY))) {
			responseHeader.setTransactionId(exchange.getIn().getHeader(C_HeaderFields.TRANSACTION_ID_KEY).toString());
		} else
			responseHeader.setTransactionId(exchange.getIn().getHeader(C_HeaderFields.BREADCRUMB_ID).toString());

		Util.logIt(response, logEntry);
		return response;
	}

	public ResponseHeader ping(Exchange exchange) {

		// CommonsContext context = new CommonsContext();

		LogEntry logEntry = (LogEntry) exchange.getProperties().get(C_Properties.LOG_ENTRY_KEY);

		/**
		 * Add Service Name and Operation Name to Log Entry
		 */

		logEntry.setService("iplookup");
		logEntry.setResource("accountsSearch");
		logEntry.setOperation("ping");

		/**
		 * Add Log Message
		 */

		List<LogMessage> messages = logEntry.getMessages();
		LogMessage message = new LogMessage("SUCCESS", "IPLookupProcessor - PING Successful");
		messages.add(message);
		logEntry.setMessages(messages);

		// Ping ping = new Ping("Ping is Successful");
		ResponseHeader responseHeader = new ResponseHeader();
		responseHeader.setSuccess(true);
		responseHeader.setServiceName("iplookup");
		responseHeader.setResourceName("accountsSearch");
		responseHeader.setOperationName("ping");
		responseHeader.setVersion("1.0");
		if (Util.isNotNullEmpty(exchange.getIn().getHeader(C_HeaderFields.TRANSACTION_ID_KEY))) {
			responseHeader.setTransactionId(exchange.getIn().getHeader(C_HeaderFields.TRANSACTION_ID_KEY).toString());
		} else
			responseHeader.setTransactionId(exchange.getIn().getHeader(C_HeaderFields.BREADCRUMB_ID).toString());

		return responseHeader;

	}

	public ResponseHeader setup(Exchange exchange) {

		LogEntry logEntry = (LogEntry) exchange.getProperties().get(C_Properties.LOG_ENTRY_KEY);

		try {
			dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

			CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(CustomerAccountInfo.class);

			tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

			amazonDynamoDB.createTable(tableRequest);
		} catch (ResourceInUseException e) {
			// Do nothing, table already created
		}

		List<DataService> dataServiceList = new ArrayList<>();
		DataService dataservice = new DataService();
		dataservice.setOccurrence("1");
		dataservice.setStatus("active");
		dataServiceList.add(dataservice);
		CustomerAccountInfo customerInfo = new CustomerAccountInfo("10.2.1.2", "000001604", "Active", "Residential",
				"436", dataServiceList, "20170101", "");
		repository.save(customerInfo);

		/**
		 * Add Service Name and Operation Name to Log Entry
		 */

		logEntry.setService("iplookup");
		logEntry.setResource("accountsSearch");
		logEntry.setOperation("setup");

		/**
		 * Add Log Message
		 */

		List<LogMessage> messages = logEntry.getMessages();
		LogMessage message = new LogMessage("SUCCESS", "IPLookupProcessor - Setup Successful");
		messages.add(message);
		logEntry.setMessages(messages);

		ResponseHeader responseHeader = new ResponseHeader();
		responseHeader.setSuccess(true);
		responseHeader.setServiceName("iplookup");
		responseHeader.setResourceName("accountsSearch");
		responseHeader.setOperationName("setup");
		responseHeader.setVersion("1.0");
		if (Util.isNotNullEmpty(exchange.getIn().getHeader(C_HeaderFields.TRANSACTION_ID_KEY))) {
			responseHeader.setTransactionId(exchange.getIn().getHeader(C_HeaderFields.TRANSACTION_ID_KEY).toString());
		} else
			responseHeader.setTransactionId(exchange.getIn().getHeader(C_HeaderFields.BREADCRUMB_ID).toString());

		return responseHeader;

	}
}
