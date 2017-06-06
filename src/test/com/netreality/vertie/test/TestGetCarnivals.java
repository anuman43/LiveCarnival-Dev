/**
 * 
 */
package com.netreality.vertie.test;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.live4carnival.xml.util.XMLHelper;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;



/**
 * @author JahLion
 *
 */
public class TestGetCarnivals extends BaseUnitTest {
	
	private static String TEST_CARNIVAL_LIST_FILE_NAME = "carnivals.xml";
	private static String TEST_CARNIVAL_FILE_LOCATION ="C:\\LiveCarnivalBeta\\eventSrc\\";
	private static File TEST_CARNIVAL_EVENTS_FILE;
	
	@BeforeClass
	public static void setup()
	{
		setLogger(Logger.getLogger(TestGetCarnivals.class));
		TEST_CARNIVAL_EVENTS_FILE = new File(TEST_CARNIVAL_FILE_LOCATION + TEST_CARNIVAL_LIST_FILE_NAME);
	}
	
	
	@AfterClass
	public static void tearDown()
	{
		TEST_CARNIVAL_EVENTS_FILE = null;
	}
	
	
	@Test
	public void testgetCarnivals()
	{
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, TEST_CARNIVAL_EVENTS_FILE);
		String elementName = "carnival";
		List<String> carnivalList = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, carnivalList);
		carnivalList = XMLHelper.getElementsAsCollection(elementName, TEST_CARNIVAL_EVENTS_FILE);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, carnivalList);
		for(String st: carnivalList)
		{
			getLog().info(st);
		}
	}
	
	
	

}
