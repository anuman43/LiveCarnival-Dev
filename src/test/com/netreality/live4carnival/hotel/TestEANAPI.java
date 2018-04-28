/**
 * 
 */
package com.netreality.live4carnival.hotel;

import org.apache.log4j.LogManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.live4carnival.accomodation.ean.configuration.EANRequestConfigurator;
import com.live4carnival.accomodation.ean.ping.json.po.EANPingResponsePO;
import com.live4carnival.web.integration.rest.util.EANHotelApiRequests;
import com.live4carnival.web.integration.rest.util.Live4CarnivalRestUtil;
import com.netreality.vertie.test.BaseUnitTest;

import org.junit.Assert;

/**
 * @author JahLion
 *
 */
public class TestEANAPI extends BaseUnitTest {
	
	private static EANHotelApiRequests eanHReq;
	
	
	@BeforeClass
	public static void setUp()
	{
		setLogger(LogManager.getLogger(TestEANAPI.class));
		eanHReq = new EANHotelApiRequests();
	}
	
	@AfterClass
	public static void tearDown()
	{
		getLog().debug("Cleaning up resources");
	}
	
	
	@Ignore
	public void testCreateCommonReq()
	{
		String eanCommonReqStr = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, eanCommonReqStr);
		EANRequestConfigurator eanConfig = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, eanConfig);
		eanConfig = new EANRequestConfigurator();
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, eanConfig);
		eanCommonReqStr = eanConfig.buildCommonEANReqStr();
		getLog().debug(eanCommonReqStr);
	}
	
	@Ignore
	public void testCreatePingStr()
	{
		String eanPingReqStr = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, eanPingReqStr);
		EANHotelApiRequests apiReq = new EANHotelApiRequests();
		eanPingReqStr = apiReq.createRestEchoRequest();
		getLog().debug(eanPingReqStr);
	}
	
	@Test
	public void executePingRequest()
	{
		EANPingResponsePO pingResult = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, pingResult);
		String pingQryStr = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE,  pingQryStr);
		String pingResultStr = null;
		//pingResult = Live4CarnivalRestUtil.executeEANPingRequest(eanHReq.getPingUrl(),eanHReq.createRestEchoRequest());
		pingResultStr = Live4CarnivalRestUtil.executeEANPingRestRequest(eanHReq.getPingUrl(),eanHReq.createRestEchoRequest());
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, pingResultStr);
	}
	

}
