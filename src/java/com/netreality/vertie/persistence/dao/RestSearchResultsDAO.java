/**
 * 
 */
package com.netreality.vertie.persistence.dao;

import java.util.List;

import com.netreality.vertie.alpha.to.PagedResultTO;
import com.netreality.vertie.alpha.to.SearchResultTO;
import com.netreality.vertie.alpha.to.SearchTO;

/**
 * @author JahLion
 *
 */
public class RestSearchResultsDAO {
	
	
	public PagedResultTO  paginateRestSearchResults(SearchTO cseSearch,List<SearchResultTO> results) 
	{
		PagedResultTO pgResults = null;
		//List<SearchResultTO> resultList = null;
		
		if(results != null && !results.isEmpty())
		{
			pgResults = new PagedResultTO();
			pgResults.setPagedResultSet(results);
			
		}
		
		
		return pgResults;
	}
	

}
