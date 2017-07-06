package com.cox.bmw.iplookup.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

/**
 * Response class for DataService
 * which holds response from the Service Operation.
 */
@DynamoDBDocument
public class DataService {

	/**  occurrence. */
	private String occurrence;
	
	/**  status. */
	private String status;
	
	
	/**
	 * Gets  occurrence.
	 *
	 * @return  occurrence
	 */
	public String getOccurrence() {
		return occurrence;
	}
	
	/**
	 * Sets  occurrence.
	 *
	 * @param occurrence  new occurrence
	 */
	public void setOccurrence(String occurrence) {
		this.occurrence = occurrence;
	}
	
	/**
	 * Gets  status.
	 *
	 * @return  status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets  status.
	 *
	 * @param status  new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
