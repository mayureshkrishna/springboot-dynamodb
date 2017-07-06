/**
 * 
 */
package com.cox.bmw.iplookup.model;

import java.util.List;


/**
 * Response class for CustomerAccount
 * which holds response from the Service Operation.
 */
public class CustomerAccount {
	
	/**  account number 9. */
	private String accountNumber9;
	
	/**  account status. */
	private String accountStatus;
	
	
	/**  account type. */
	private String accountType;
	
	/**  site id. */
	private String siteId;
	
	/**  data service. */
	private List<DataService> dataService;

	
	
	/**
	 * Gets  account status.
	 *
	 * @return  account status
	 */
	public String getAccountStatus() {
		return accountStatus;
	}
	
	/**
	 * Sets  account status.
	 *
	 * @param accountStatus  new account status
	 */
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
		
	/**
	 * Gets  account number 9.
	 *
	 * @return  account number 9
	 */
	public String getAccountNumber9() {
		return accountNumber9;
	}
	
	/**
	 * Sets  account number 9.
	 *
	 * @param accountNumber9  new account number 9
	 */
	public void setAccountNumber9(String accountNumber9) {
		this.accountNumber9 = accountNumber9;
	}
	
	/**
	 * Gets  account type.
	 *
	 * @return  account type
	 */
	public String getAccountType() {
		return accountType;
	}
	
	/**
	 * Sets  account type.
	 *
	 * @param accountType  new account type
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	/**
	 * Gets  site id.
	 *
	 * @return  site id
	 */
	public String getSiteId() {
		return siteId;
	}
	
	/**
	 * Sets  site id.
	 *
	 * @param siteId  new site id
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	
	/**
	 * Gets  data service.
	 *
	 * @return  data service
	 */
	public List<DataService> getDataService() {
		return dataService;
	}
	
	/**
	 * Sets  data service.
	 *
	 * @param dataService  new data service
	 */
	public void setDataService(List<DataService> dataService) {
		this.dataService = dataService;
	}

}
