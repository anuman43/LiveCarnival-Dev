/**
 * @date Nov 21, 2014
 */
package com.netreality.vertie.test;



import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.netreality.vertie.alpha.to.PagedResultsViewTO;
import com.netreality.vertie.alpha.to.SearchTO;
import com.netreality.vertie.search.util.SearchUtil;

/**
 * @author ldurh516
 *
 * @date Nov 21, 2014
 *	
 */
public class PaginationTest extends BaseUnitTest {

	@BeforeClass
	public static void setup()
	{
		setLogger(Logger.getLogger(PaginationTest.class));
	}
	
	@AfterClass
	public static void tearDown()
	{
		
	}
	
	@Test
	public void paginateResultsView()
	{
		SearchTO testResults = null;
		PagedResultsViewTO view = null;
		Assert.assertNull("Object is not null", testResults);
		Assert.assertNull("Object is not null", view);
		testResults = new SearchTO();
		view = new PagedResultsViewTO();
		testResults.setSearchId(SearchUtil.generateSearchId());
		getLog().debug("Search Id is" + testResults.getSearchId());
		testResults.setNextPage(11);
		view = SearchUtil.paginateView(testResults, view);
		Assert.assertNotNull("Object is null", view);
		getLog().debug("Results view range is-" + view.getViewRangeStart() + " end is-" + view.getViewRangeEnd());
		getLog().debug("Current page is: " + view.getCurrentPageIndex());
		//
		testResults.setNextPage(21);
		view = SearchUtil.paginateView(testResults, view);
		Assert.assertNotNull("Object is null", view);
		getLog().debug("Results view range is-" + view.getViewRangeStart() + " end is-" + view.getViewRangeEnd());
		getLog().debug("Current page is: " + view.getCurrentPageIndex());
		//
		testResults.setNextPage(31);
		view = SearchUtil.paginateView(testResults, view);
		Assert.assertNotNull("Object is null", view);
		getLog().debug("Results view range is-" + view.getViewRangeStart() + " end is-" + view.getViewRangeEnd());
		getLog().debug("Current page is: " + view.getCurrentPageIndex());
		//
		testResults.setNextPage(41);
		view = SearchUtil.paginateView(testResults, view);
		Assert.assertNotNull("Object is null", view);
		getLog().debug("Results view range is-" + view.getViewRangeStart() + " end is-" + view.getViewRangeEnd());
		getLog().debug("Current page is: " + view.getCurrentPageIndex());
		//
		testResults.setNextPage(40);
		view = SearchUtil.paginateView(testResults, view);
		Assert.assertNotNull("Object is null", view);
		getLog().debug("Results view range is-" + view.getViewRangeStart() + " end is-" + view.getViewRangeEnd());
		getLog().debug("Current page is: " + view.getCurrentPageIndex());
		//
		testResults.setNextPage(39);
		view = SearchUtil.paginateView(testResults, view);
		Assert.assertNotNull("Object is null", view);
		getLog().debug("Results view range is-" + view.getViewRangeStart() + " end is-" + view.getViewRangeEnd());
		getLog().debug("Current page is: " + view.getCurrentPageIndex());
		//
		testResults.setNextPage(32);
		view = SearchUtil.paginateView(testResults, view);
		Assert.assertNotNull("Object is null", view);
		getLog().debug("Results view range is-" + view.getViewRangeStart() + " end is-" + view.getViewRangeEnd());
		getLog().debug("Current page is: " + view.getCurrentPageIndex());
		//
		testResults.setNextPage(30);
		view = SearchUtil.paginateView(testResults, view);
		Assert.assertNotNull("Object is null", view);
		getLog().debug("Results view range is-" + view.getViewRangeStart() + " end is-" + view.getViewRangeEnd());
		getLog().debug("Current page is: " + view.getCurrentPageIndex());
		
	}
	
	
}
