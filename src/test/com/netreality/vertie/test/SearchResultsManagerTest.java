/**
 * @date Sep 14, 2014
 */
package com.netreality.vertie.test;


import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.netreality.vertie.alpha.to.SearchResultTO;
import com.netreality.vertie.web.SearchResultsManager;

/**
 * @author ldurh516
 *
 * @date Sep 14, 2014
 *	
 */
public class SearchResultsManagerTest extends BaseUnitTest {
	
	private String TEST_SEARCH_KEYWORDS_1 = "Mas";
	private String TEST_SEARCH_KEYWORDS_2 = "Miami Carnival";
	private String TEST_SEARCH_KEYWORDS_3 = "Soca Music";
	private String TEST_SEARCH_KEYWORDS_4 = "Hotel Accomodation";
	private String TEST_SEARCH_KEYWORDS_5 = "Airfare";
	private String TEST_SEARCH_KEYWORDS_6_LIVECARNIVAL = "Trinidad Carnival 2017";
	

	@BeforeClass
	public static void setup()
	{
		setLogger(Logger.getLogger(SearchResultsManagerTest.class));
		getLog().info("searchResultsManager Test");
	}
	
	
	@AfterClass
	public static void tearDown()
	{
		
	}
	
	@Ignore
	public void testSearchByKeywords()
	{
		List<SearchResultTO> results = null;
		SearchResultsManager sMgr = null;
		Assert.assertNull("Object is not null", sMgr);
		sMgr = new SearchResultsManager();
		Assert.assertNotNull("Object is null", sMgr);
		Assert.assertNull("Object is not null", results);
		results = sMgr.searchByKeywords(TEST_SEARCH_KEYWORDS_1);
		Assert.assertTrue("Search returned no results", !results.isEmpty());
		
		
	}
	
	@Test
	public void testSearchByRest()
	{
		List<SearchResultTO> results = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, results);
		SearchResultsManager sMgr = null;
		sMgr = new SearchResultsManager();
		Assert.assertNotNull("Object is null", sMgr);
		results = sMgr.searchByRest(TEST_SEARCH_KEYWORDS_6_LIVECARNIVAL);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, results);
	}
	
	
}
