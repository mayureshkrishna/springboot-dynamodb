/**
 * 
 */
package com.cox.bmw.iplookup.api.model;

import java.io.Serializable;

/**
 *  Request class for AccountsSearchRequest.
 *  which holds the user inputs.
 *  @author ravirama
 */
public class AccountsSearchRequest implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The ip address. */
	private String ipAddress;
	
	/** The time stamp. */
	private String timeStamp;
	
	/** The source port number. */
	private String sourcePortNumber;


	
	/**
	 * Instantiates a new accounts search request.
	 */
	public AccountsSearchRequest()
	{
		
	}
	


	/**
	 * Gets the ip address.
	 *
	 * @return the ip address
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Sets the ip address.
	 *
	 * @param ipAddress the new ip address
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Gets the time stamp.
	 *
	 * @return the time stamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Sets the time stamp.
	 *
	 * @param timeStamp the new time stamp
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * Gets the source port number.
	 *
	 * @return the source port number
	 */
	public String getSourcePortNumber() {
		return sourcePortNumber;
	}

	/**
	 * Sets the source port number.
	 *
	 * @param sourcePortNumber the new source port number
	 */
	public void setSourcePortNumber(String sourcePortNumber) {
		this.sourcePortNumber = sourcePortNumber;
	}

	
}
