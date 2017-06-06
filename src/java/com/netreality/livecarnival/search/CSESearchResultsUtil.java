/**
 * 
 */
package com.netreality.livecarnival.search;

import java.util.List;

import org.apache.log4j.Logger;

import com.netreality.vertie.alpha.to.SearchResultTO;
import com.netreality.vertie.alpha.to.SearchTO;

/**
 * @author JahLion
 *
 */
public class CSESearchResultsUtil {
	
	
	private static Logger _log = Logger.getLogger(CSESearchResultsUtil.class);
	
	
	public static SearchTO generateSearchTOForCseResults(String searchPhrase,List<SearchResultTO> results)
	{
		SearchTO cseSearchTO = null;
		
		
		if(searchPhrase != null && !results.isEmpty())
		{
			cseSearchTO = new SearchTO();
			cseSearchTO.setSearchPhrase(searchPhrase);
			cseSearchTO.setResultSetSize(results.size());
			cseSearchTO.setResultPages(StrictMath.abs(cseSearchTO.getResultSetSize() / cseSearchTO.getPagingSize()));
		
		}
		
		
		return cseSearchTO;
	}

}
