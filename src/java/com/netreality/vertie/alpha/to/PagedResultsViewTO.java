/**
 * @date Nov 19, 2014
 */
package com.netreality.vertie.alpha.to;

/**
 * @author ldurh516
 *
 * @date Nov 19, 2014
 *	
 */
public class PagedResultsViewTO {
	
	private Integer currentPageIndex = 1;// the current index of paginated search result
	/**
	 * @return the currentPageIndex
	 */
	public Integer getCurrentPageIndex() {
		return currentPageIndex;
	}
	/**
	 * @param currentPageIndex the currentPageIndex to set
	 */
	public void setCurrentPageIndex(Integer currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
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
	 * @return the pagesPerView
	 */
	public Integer getPagesPerView() {
		return pagesPerView;
	}
	/**
	 * @param pagesPerView the pagesPerView to set
	 */
	public void setPagesPerView(Integer pagesPerView) {
		this.pagesPerView = pagesPerView;
	}
	/**
	 * @return the viewRangeStart
	 */
	public Integer getViewRangeStart() {
		return viewRangeStart;
	}
	/**
	 * @param viewRangeStart the viewRangeStart to set
	 */
	public void setViewRangeStart(Integer viewRangeStart) {
		this.viewRangeStart = viewRangeStart;
	}
	/**
	 * @return the viewRangeEnd
	 */
	public Integer getViewRangeEnd() {
		return viewRangeEnd;
	}
	/**
	 * @param viewRangeEnd the viewRangeEnd to set
	 */
	public void setViewRangeEnd(Integer viewRangeEnd) {
		this.viewRangeEnd = viewRangeEnd;
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
	private Integer resultPages = 0; // total number of result pages
	private Integer pagesPerView = 10;//number of page entries eligible to select from the bottom of the view
	private Integer viewRangeStart = 1;
	private Integer viewRangeEnd = 10;
	private Long searchId;
	
	
	
	
	
	
}