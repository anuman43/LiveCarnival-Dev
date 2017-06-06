/**
 * @date Jul 11, 2015
 */
package com.netreality.vertie.topUp.idt;

import java.util.List;



import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.live4carnival.web.integration.rest.util.LiveCarnivalIDT;
import com.netreality.live4carnival.idt.LiveCarnivalTopUp;
import com.netreality.live4carnival.idt.Json.to.TopUpProduct;
import com.netreality.vertie.test.BaseUnitTest;

/**
 * @author ldurh516
 *
 * @date Jul 11, 2015
 *	
 */
public class IDTAPITest extends BaseUnitTest {
	
	private String TARGET_API_ENDPOINT = "https://api.idtbeyond.com/v1/status";
	private static LiveCarnivalTopUp topUp;
	private static String TEST_LOCAL_COUNTRY_CODE = "TR";
	
	
	@BeforeClass
	public static void setUp()
	{
		setLogger(Logger.getLogger(IDTAPITest.class));
		topUp = new LiveCarnivalTopUp();
	}

	
	
	@AfterClass
	public static void tearDown()
	{
		topUp = null;
	}
	
	@Test
	public void testIDTStatus()
	{
		String idtStatus = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, idtStatus);
		idtStatus = LiveCarnivalIDT.getIDTAPIStatus(TARGET_API_ENDPOINT);
	}
	
	@Test
	public void testGetAllProducts()
	{
		List<TopUpProduct> allProducts = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, allProducts);
		allProducts = topUp.getAllProducts();
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, allProducts);
		Assert.assertTrue(ASSERT_CONDITION_TRUE, !allProducts.isEmpty());
		for(TopUpProduct tp: allProducts)
		{
			getLog().debug("Country is-" + tp.getCountry());
			getLog().debug("Carrier is-" + tp.getCarrier());
		}
		
	}
	
	@Test
	public void testGetLocalProduct()
	{
		
	}
}
