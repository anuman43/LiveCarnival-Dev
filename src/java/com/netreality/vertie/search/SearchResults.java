/**
 * @date Sep 13, 2014
 */
package com.netreality.vertie.search;

import java.util.Date;
import java.util.List;

import com.netreality.vertie.alpha.to.RecentSearchTO;
import com.netreality.vertie.alpha.to.SearchResultTO;

/**
 * @author ldurh516
 *
 * @date Sep 13, 2014
 *	
 */
public interface SearchResults {
	
	List<SearchResultTO> searchByKeywords(String keywords);
	List<SearchResultTO> searchByReserveKeyWords(String reserveWords);
	List<SearchResultTO> searchByDate(Date start, Date end);
	List<SearchResultTO> searchByRegion(Object region);
	List<SearchResultTO> searchByRest(String searchStr);
	void addSearch(RecentSearchTO search);
		
}
