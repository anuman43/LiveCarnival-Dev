/**
 * @date Sep 10, 2014
 */
package com.netreality.vertie.test;

import org.apache.log4j.Logger;

/**
 * @author ldurh516
 *
 * @date Sep 10, 2014
 *	
 */
public class BaseUnitTest {
	
	private static Logger _log;	
	protected static String ASSERT_NULL_MESSAGE = "Object is not null";
	protected static String ASSERT_NOT_NULL_MESSAGE = "Object is null";
	protected static String ASSERT_CONDITION_TRUE = "Condition is false";
	protected static String ASSERT_CONDITION_FALSE = "Condition is true";
	
	
	
	public static Logger getLog()
	{
		return _log;
	}
	
	public static void setLogger(Logger log)
	{
		_log = log;
	}

}
