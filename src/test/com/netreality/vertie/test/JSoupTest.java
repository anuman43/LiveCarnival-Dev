package com.netreality.vertie.test;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @date Oct 18, 2014
 */

/**
 * @author ldurh516
 *
 * @date Oct 18, 2014
 *	
 */
public class JSoupTest extends BaseUnitTest {
	
	private String TEST_VERTIE_LINK = "http://carnivalpower.com/2011/07/miami-broward-one-carnival-sunday-oct-9/";
	private static Document linkDoc = null;
	
	@BeforeClass
	public static void setup()
	{
		setLogger(Logger.getLogger(JSoupTest.class));
		getLog().info("Running JSoup API test on retrieving html data from an URL");
	}
	
	
	@AfterClass
	public static void tearDown()
	{
		linkDoc = null;
	}
	
	@Test
	public void testGetLinkTitle()
	{
		String pageTitle = null;
		Assert.assertNull("Document object is not null", linkDoc);
		Assert.assertNull("Object is not null", pageTitle);
		try {
			Connection con = Jsoup.connect(TEST_VERTIE_LINK);
			con.timeout(15000);
			linkDoc = con.get();
			pageTitle = linkDoc.title();
		} catch (IOException ioe) {
			getLog().error("IO Exception connecting",ioe);
			Assert.fail();
		}
		Assert.assertNotNull("Document is null", linkDoc);
		Assert.assertNotNull("Page Title is null", pageTitle);
		getLog().info(pageTitle);
		
	}
	
}
