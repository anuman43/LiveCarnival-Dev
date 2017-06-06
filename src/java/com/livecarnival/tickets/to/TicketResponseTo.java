/**
 * 
 */
package com.livecarnival.tickets.to;

/**
 * @author JahLion
 *
 */
public class TicketResponseTo {
	
	private Object data;
	
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String success;
	
	private String message;

}
