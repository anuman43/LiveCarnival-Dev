/**
 * @date Nov 25, 2015
 */
package com.netreality.live4carnival.enums;

/**
 * @author ldurh516
 *
 * @date Nov 25, 2015
 *	
 */
public enum QPXAirfareRequestEnum {
	
	
	tripPassengerCount("qpxexpress#passengerCounts"),
	tripSliceInput("qpxexpress#sliceInput");
	
	
	QPXAirfareRequestEnum(String typeVal)
	{
		this.qpxTypeVal = typeVal;
	}
	
	private String qpxTypeVal;

	/**
	 * @return the qpxTypeVal
	 */
	public String getQpxTypeVal() {
		return qpxTypeVal;
	}

}
