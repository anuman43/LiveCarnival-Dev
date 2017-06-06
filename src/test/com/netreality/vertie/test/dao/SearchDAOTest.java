/**
 * @date Sep 10, 2014
 */
package com.netreality.vertie.test.dao;

import java.math.BigInteger;
import java.util.List;







import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.netreality.live4carnival.enums.NaturalLangSearchEnums;
import com.netreality.vertie.persistence.dao.SearchResultsDAO;
import com.netreality.vertie.reveng.Carnivaltermsindextbl;
import com.netreality.vertie.test.BaseUnitTest;

/**
 * @author ldurh516
 *
 * @date Sep 10, 2014
 *	
 */
public class SearchDAOTest extends BaseUnitTest {
	
	private String TEST_SEARCH_KEYWORD = "Carnival";
	private static SearchResultsDAO dao = null;
	private String TEST_RELEVANCE_SEARCH_PHRASE = "Trinidad Carnival";
	
	
	
	@BeforeClass
	public static void setup()
	{
		setLogger(Logger.getLogger(SearchDAOTest.class));
		getLog().info("Before Class Setup");
		dao = new SearchResultsDAO();
	}

	
	
	@AfterClass
	public static void tearDown()
	{
		dao = null;
		
	}
	
	@Ignore
	public void testSearchByKeywords()
	{
		List<Carnivaltermsindextbl> results = null;
		Assert.assertNull("DAO object is not null", dao);
		
		Assert.assertNotNull("DAO is null", dao);
		Assert.assertNull("Results collection object is not null", results);
		results = dao.getResultsByKeyword(TEST_SEARCH_KEYWORD);
		Assert.assertTrue("No results were returned for search", !results.isEmpty());
	}
	
	@Test
	public void testgetSearchRelevance()
	{
		BigInteger relevanceCount = null;
		Assert.assertNull(ASSERT_NULL_MESSAGE, relevanceCount);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, dao);
		relevanceCount = dao.getSearchRelevanceNtl(TEST_RELEVANCE_SEARCH_PHRASE,NaturalLangSearchEnums.IN_BOOLEAN_MODE);
		Assert.assertNotNull(ASSERT_NOT_NULL_MESSAGE, relevanceCount);
		getLog().debug(relevanceCount);
		
	}
}
