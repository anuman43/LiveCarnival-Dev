/**
 * 
 */
package com.livecarnival.tickets.to;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author JahLion
 *
 */
public class GenericTicketRespTo {
	
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
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	private String success;
	private String message;
	private String count;

}
