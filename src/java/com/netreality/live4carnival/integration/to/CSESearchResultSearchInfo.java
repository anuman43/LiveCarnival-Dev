/**
 * 
 */
package com.netreality.live4carnival.integration.to;

/**
 * @author JahLion
 *
 */
public class CSESearchResultSearchInfo {
	
	private Double searchTime;
	public Double getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(Double searchTime) {
		this.searchTime = searchTime;
	}
	public String getFormattedSearchTime() {
		return formattedSearchTime;
	}
	public void setFormattedSearchTime(String formattedSearchTime) {
		this.formattedSearchTime = formattedSearchTime;
	}
	public Long getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}
	public String getFormattedTotalResults() {
		return formattedTotalResults;
	}
	public void setFormattedTotalResults(String formattedTotalResults) {
		this.formattedTotalResults = formattedTotalResults;
	}
	private String formattedSearchTime;
	private Long totalResults;
	private String formattedTotalResults;
	

}
