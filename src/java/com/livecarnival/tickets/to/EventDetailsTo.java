/**
 * 
 */
package com.livecarnival.tickets.to;

/**
 * @author JahLion
 *
 */
public class EventDetailsTo {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	private Object data;
	
	private String success;

}
