/**
 * 
 */
package com.cox.bmw.iplookup.api.model;

import java.io.Serializable;

import com.cox.bmw.commons.model.message.ResponseHeader;
import com.cox.bmw.iplookup.model.CustomerAccount;


/**
 *  Response class for AccountsSearchResponse
 *  which holds response from the Service Operation.
 *  @author ravirama
 */
public class AccountsSearchResponse implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7981124347136945658L;
	private ResponseHeader responseHeader;
	
	/** The account. */
	private CustomerAccount account;
	
	/** The block type. */
	private String blockType;
	
	/** The ip format. */
	private String ipFormat;
	
	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	public CustomerAccount getAccount() {
		return account;
	}

	/**
	 * Sets the account.
	 *
	 * @param account the new account
	 */
	public void setAccount(CustomerAccount account) {
		this.account = account;
	}

	/**
	 * Instantiates a new accounts search response.
	 */
	public AccountsSearchResponse() {

	}

	/**
	 * @return the responseHeader
	 */
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	/**
	 * @param responseHeader the responseHeader to set
	 */
	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}
	/**
	 * Gets the block type.
	 *
	 * @return the block type
	 */
	public String getBlockType() {
		return blockType;
	}

	/**
	 * Sets the block type.
	 *
	 * @param blockType the new block type
	 */
	public void setBlockType(String blockType) {
		this.blockType = blockType;
	}

	/**
	 * Gets the ip format.
	 *
	 * @return the ip format
	 */
	public String getIpFormat() {
		return ipFormat;
	}

	/**
	 * Sets the ip format.
	 *
	 * @param ipFormat the new ip format
	 */
	public void setIpFormat(String ipFormat) {
		this.ipFormat = ipFormat;
	}

}
