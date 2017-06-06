/**
 * @date Jun 5, 2015
 */
package com.netreality.live4carnival.enums;

/**
 * @author ldurh516
 *
 * @date Jun 5, 2015
 *	
 */
public enum HttpActionEnum {
	
	Head(0),
	Get(1),
	Post(2),
	Get1(3),
	RestPost(4);
	
	HttpActionEnum(int value)
	{
		actionValue = value;
	}
	
	private int actionValue;
	
	public int getAction()
	{
		return actionValue;
	}

}
