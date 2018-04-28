/**
 * 
 */
package com.live4carnival.accomodation.ean.ping.json.po;

/**
 * @author JahLion
 *
 */
public class EANPingResponseServerInfo {
	
	private String instance;
	public String getInstance() {
		return instance;
	}
	public void setInstance(String instance) {
		this.instance = instance;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getServerTime() {
		return serverTime;
	}
	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}
	private String timeStamp;
	private String serverTime;

}
