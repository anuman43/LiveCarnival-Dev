/**
 * @date Jan 4, 2015
 */
package com.netreality.vertie.web;

import java.util.List;

import org.apache.log4j.Logger;

import com.netreality.vertie.alpha.to.RecentSearchTO;
import com.netreality.vertie.persistence.dao.SearchDAO;
import com.netreality.vertie.search.SearchData;
import com.netreality.vertie.search.util.SearchUtil;

/**
 * @author ldurh516
 *
 * @date Jan 4, 2015
 *	
 */
public class SearchManager implements SearchData {

	/**
	 * 
	 */
	public SearchManager() {
		super();
		dao = new SearchDAO();
	}

	private SearchDAO dao = null;
	private Logger _log = Logger.getLogger(SearchManager.class);
	
	/* (non-Javadoc)
	 * @see com.netreality.vertie.search.SearchData#addSearch(java.lang.Object)
	 */
	@Override
	public void addSearch(Object searchPhrase) {
		// TODO Auto-generated method stub
		
		
	}

	/* (non-Javadoc)
	 * @see com.netreality.vertie.search.SearchData#getRecentSearches()
	 */
	@Override
	public List<RecentSearchTO> getRecentSearches() {
		
		List<RecentSearchTO> searches = null;
		
		searches = SearchUtil.convertSearchDataCollection(dao.getRecentSearches());
		
		return searches;
	}

	/* (non-Javadoc)
	 * @see com.netreality.vertie.search.SearchData#findRecentSearch(java.lang.String)
	 */
	@Override
	public List<RecentSearchTO> findRecentSearch(String searchPhrase) {
		// TODO Auto-generated method stub
		return null;
	}

}
