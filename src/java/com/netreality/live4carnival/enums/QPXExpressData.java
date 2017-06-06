/**
 * @date Jun 7, 2015
 */
package com.netreality.live4carnival.enums;

/**
 * @author ldurh516
 *
 * @date Jun 7, 2015
 *	
 */
public enum QPXExpressData {
	
	Kind("kind");

	QPXExpressData(String value)
	{
		dataValue = value;
	}
	
	private String dataValue;

	/**
	 * @return the dataValue
	 */
	public String getDataValue() {
		return dataValue;
	}
	
}
