/**
 * 
 */
package com.live4carnival.accomodation.ean.configuration;

/**
 * @author JahLion
 *
 */
public enum EANEndpointsEnum {
	
	EanGeneralEndPoint("https://api.ean.com"),
	EanBookingEndPoint("https://book.api.ean.com");
	
	
	EANEndpointsEnum(String endPoint)
	{
		endPointValue = endPoint;
	}
	
	public String getEndPointVal()
	{
		return endPointValue;
	}
	
	private String endPointValue;
	
}