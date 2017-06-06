/**
 * @date May 25, 2015
 */
package com.netreality.vertie.test;

import java.io.File;



import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.netreality.vertie.search.util.URLSeederUtility;

/**
 * @author ldurh516
 *
 * @date May 25, 2015
 *	
 */
public class SchedulerConverter extends BaseUnitTest{

	private static File TEST_SEED_FILE;
	private static String TEST_SEED_FILE_LOCATION = "D:\\SchedulerURLs.txt";
	
	@BeforeClass
	public static void setup()
	{
		setLogger(Logger.getLogger(SchedulerConverter.class));
		
		//TEST_SEED_FILE = new File(TEST_SEED_FILE_LOCATION);
	}
	
	
	@AfterClass
	public static void tearDown()
	{
		getLog().debug("Test completed");
	}
	
	@Test
	public void scanSeedFile()
	{
		Integer urlSeed = 0;
		urlSeed = URLSeederUtility.populateScheduler(TEST_SEED_FILE_LOCATION);
		Assert.assertTrue("File does not contain any urls", urlSeed > 0);
		getLog().debug("There are " + urlSeed + " urls");
	}
	
}
