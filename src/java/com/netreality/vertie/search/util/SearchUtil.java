/**
 * @date Oct 29, 2014
 */
package com.netreality.vertie.search.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.netreality.vertie.alpha.to.PagedResultsViewTO;
import com.netreality.vertie.alpha.to.RecentSearchTO;
import com.netreality.vertie.alpha.to.SearchTO;
import com.netreality.vertie.reveng.Tblrecentsearches;

/**
 * @author ldurh516
 *
 * @date Oct 29, 2014
 *	
 */
public class SearchUtil {
	
	private static Logger _log = Logger.getLogger(SearchUtil.class);
	private final static long generatedLong = 8732970627536958491L;
	
	public static Long generateSearchId()
	{
		Long genLid;
		Random gen = new Random(generatedLong);
		genLid = gen.nextLong();
		_log.info("Search ID is-" + genLid);
		return genLid;
	}
	
	public static Integer getFirstResult(int page)
	{
		Integer startRow = 0;
		if(page > 1)
		{
			startRow = (page - 1 ) * 10;
		}
		_log.debug("Result start row is-" + startRow);
		return startRow;
	}
	
	public static Integer getLastResult(int page)
	{
		Integer lastRow = 10;
		if(page > 1)
		{
			lastRow = page * lastRow;
		}
		_log.debug("Result last row is-" + lastRow);
		return lastRow;
	}
	
	private static RecentSearchTO convertSearchData(Tblrecentsearches recentSearchQry)
	{
		RecentSearchTO converted = null;
		
		if(recentSearchQry != null)
		{
			converted = new RecentSearchTO();
			converted.setCreatedDate(recentSearchQry.getCreatedDate());
			converted.setSearchWords(recentSearchQry.getSearchWords());
		}
		
		
		return converted;
	}
	
	
	public static List<RecentSearchTO> convertSearchDataCollection(List<Tblrecentsearches> searchDataCol)
	{
		List<RecentSearchTO> searchList = null;
		
		if(searchDataCol != null && !searchDataCol.isEmpty())
		{
			searchList = new ArrayList<RecentSearchTO>(searchDataCol.size());
			RecentSearchTO rs = new RecentSearchTO();
			for(Tblrecentsearches tb: searchDataCol)
			{
				rs = convertSearchData(tb);
				searchList.add(rs);
				
			}
			
		}
		
		return searchList;
	}
	
	
	public static SearchTO paginateResults(SearchTO searchResult)
	{
		SearchTO pagedSeachResult = null;
		
		
		if(searchResult != null)
		{
			pagedSeachResult = searchResult;
			if(searchResult.getSelectedPage() >= 1)
			{
				pagedSeachResult.setNextPage(searchResult.getSelectedPage());
				pagedSeachResult.setPrevPage(searchResult.getSelectedPage() - 1);
			}
			
		}
		else
		{
			_log.error("Method parameter searchResult is null");
		}
		
		pagedSeachResult.setSelectedPage(searchResult.getSelectedPage());
		return pagedSeachResult;
		
	}
	
	public static PagedResultsViewTO paginateView(SearchTO result, PagedResultsViewTO view)
	{
		PagedResultsViewTO updatedView = null;
		
		if(result != null && view != null)
		{
			updatedView = view;
			if(result.getNextPage() > view.getViewRangeEnd())
			{
				updatedView = goToNextViewRange(updatedView);
				//view.setViewRangeStart(view.getViewRangeEnd() + 1);
				//view.setViewRangeEnd(view.getViewRangeEnd() + view.getPagesPerView());
			}
			
			if(result.getNextPage() < view.getViewRangeStart())
			{
				updatedView = goToPreviousViewRange(updatedView);
			}
			
			updatedView.setCurrentPageIndex(result.getSelectedPage());
		}
		
		return updatedView;
	}
	
	public static PagedResultsViewTO goToNextViewRange(PagedResultsViewTO aResultView)
	{
		PagedResultsViewTO nxtRange = null;
		
		if(aResultView != null)
		{
			nxtRange = aResultView;
			nxtRange.setViewRangeStart(aResultView.getViewRangeEnd() + 1);
			nxtRange.setViewRangeEnd(aResultView.getViewRangeEnd() + aResultView.getPagesPerView());
		}
		
		return nxtRange;
	}
	
	
	public static PagedResultsViewTO goToPreviousViewRange(PagedResultsViewTO aResultView)
	{
		PagedResultsViewTO prevRange = null;
		
		if(aResultView != null)
		{
			prevRange = aResultView;
			prevRange.setViewRangeStart(aResultView.getViewRangeStart() - aResultView.getPagesPerView());
			prevRange.setViewRangeEnd(aResultView.getViewRangeEnd() - aResultView.getPagesPerView());
			_log.info("View Page previous range is from-" + prevRange.getViewRangeStart() + "to" + prevRange.getViewRangeEnd());
		}
		
		return prevRange;
	}
	
	public static PagedResultsViewTO initView(SearchTO result)
	{
		PagedResultsViewTO initView = null;
		if(result != null)
		{
			initView = new PagedResultsViewTO();
			if(result.getResultPages() < result.getPagingSize())
			{
				initView.setResultPages(result.getResultPages());
				initView.setViewRangeEnd(result.getResultPages());
				_log.info("Creating paged view for search result with less than 10 pages of results" + " eaxct number is:" + initView.getResultPages());
			}
		}
		return initView;
	}

}
