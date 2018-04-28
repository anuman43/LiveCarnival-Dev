/**
 * 
 */
package com.live4carnival.accomodation.ean.ping.json.po;

/**
 * @author JahLion
 *
 */
public class EANPingResponsePO {
	
	private String customerSessionId;
	public String getCustomerSessionId() {
		return customerSessionId;
	}
	public void setCustomerSessionId(String customerSessionId) {
		this.customerSessionId = customerSessionId;
	}
	public String getEcho() {
		return echo;
	}
	public void setEcho(String echo) {
		this.echo = echo;
	}
	public EANPingResponseServerInfo getServerInfo() {
		return ServerInfo;
	}
	public void setServerInfo(EANPingResponseServerInfo serverInfo) {
		ServerInfo = serverInfo;
	}
	private String echo;
	private EANPingResponseServerInfo ServerInfo;
	
	
	
}
