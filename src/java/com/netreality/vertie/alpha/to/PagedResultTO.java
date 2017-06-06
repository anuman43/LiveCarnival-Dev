/**
 * @date Oct 26, 2014
 */
package com.netreality.vertie.alpha.to;

import java.util.List;

/**
 * @author ldurh516
 *
 * @date Oct 26, 2014
 *	
 */
public class PagedResultTO extends SearchTO {
	
	private List<SearchResultTO> pagedResultSet;

	/**
	 * @return the pagedResultSet
	 */
	public List<SearchResultTO> getPagedResultSet() {
		return pagedResultSet;
	}

	/**
	 * @param pagedResultSet the pagedResultSet to set
	 */
	public void setPagedResultSet(List<SearchResultTO> pagedResultSet) {
		this.pagedResultSet = pagedResultSet;
	}

}
