/**
 * @date Jan 4, 2015
 */
package com.netreality.vertie.search;

import java.util.List;

import com.netreality.vertie.alpha.to.RecentSearchTO;

/**
 * @author ldurh516
 *
 * @date Jan 4, 2015
 *	
 */
public interface SearchData {
	
	void addSearch(Object searchPhrase);
	List<RecentSearchTO> getRecentSearches();
	List<RecentSearchTO> findRecentSearch(String searchPhrase);

}
