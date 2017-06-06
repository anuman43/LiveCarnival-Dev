/**
 * 
 */
package com.netreality.live4carnival.integration.to;

/**
 * @author JahLion
 *
 */
public class CSESearchResultSpelling {

	private String correctedQuery;
	public String getCorrectedQuery() {
		return correctedQuery;
	}
	public void setCorrectedQuery(String correctedQuery) {
		this.correctedQuery = correctedQuery;
	}
	public String getHtmlCorrectedQuery() {
		return htmlCorrectedQuery;
	}
	public void setHtmlCorrectedQuery(String htmlCorrectedQuery) {
		this.htmlCorrectedQuery = htmlCorrectedQuery;
	}
	private String htmlCorrectedQuery;
}
