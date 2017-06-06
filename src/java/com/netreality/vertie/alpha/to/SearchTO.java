/**
 * @date Oct 26, 2014
 */
package com.netreality.vertie.alpha.to;

/**
 * @author ldurh516
 *
 * @date Oct 26, 2014
 *	
 */
public class SearchTO {
	
	private String searchPhrase;
	private Integer resultSetSize = 0;
	private Integer resultPages = 0;
	private Integer pagingSize = 10;
	private Integer prevPage = 0;
	private Integer nextPage = 1;
	private Boolean isCached = false;
	private Integer selectedPage = 1;
	private Long searchId;
	
	/**
	 * @return the searchPhrase
	 */
	public String getSearchPhrase() {
		return searchPhrase;
	}
	/**
	 * @param searchPhrase the searchPhrase to set
	 */
	public void setSearchPhrase(String searchPhrase) {
		this.searchPhrase = searchPhrase;
	}
	/**
	 * @return the resultSetSize
	 */
	public Integer getResultSetSize() {
		return resultSetSize;
	}
	/**
	 * @param resultSetSize the resultSetSize to set
	 */
	public void setResultSetSize(Integer resultSetSize) {
		this.resultSetSize = resultSetSize;
	}
	/**
	 * @return the resultPages
	 */
	public Integer getResultPages() {
		return resultPages;
	}
	/**
	 * @param resultPages the resultPages to set
	 */
	public void setResultPages(Integer resultPages) {
		this.resultPages = resultPages;
	}
	/**
	 * @return the pagingSize
	 */
	public Integer getPagingSize() {
		return pagingSize;
	}
	/**
	 * @param pagingSize the pagingSize to set
	 */
	public void setPagingSize(Integer pagingSize) {
		this.pagingSize = pagingSize;
	}
	/**
	 * @return the prevPage
	 */
	public Integer getPrevPage() {
		return prevPage;
	}
	/**
	 * @param prevPage the prevPage to set
	 */
	public void setPrevPage(Integer prevPage) {
		this.prevPage = prevPage;
	}
	/**
	 * @return the nextPage
	 */
	public Integer getNextPage() {
		return nextPage;
	}
	/**
	 * @param nextPage the nextPage to set
	 */
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	/**
	 * @return the isCached
	 */
	public Boolean getIsCached() {
		return isCached;
	}
	/**
	 * @param isCached the isCached to set
	 */
	public void setIsCached(Boolean isCached) {
		this.isCached = isCached;
	}
	/**
	 * @return the searchId
	 */
	public Long getSearchId() {
		return searchId;
	}
	/**
	 * @param searchId the searchId to set
	 */
	public void setSearchId(Long searchId) {
		this.searchId = searchId;
	}
	/**
	 * @return the selectedPage
	 */
	public Integer getSelectedPage() {
		return selectedPage;
	}
	/**
	 * @param selectedPage the selectedPage to set
	 */
	public void setSelectedPage(Integer selectedPage) {
		this.selectedPage = selectedPage;
	}

}
