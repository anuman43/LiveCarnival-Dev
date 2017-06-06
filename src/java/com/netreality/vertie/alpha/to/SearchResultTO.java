/**
 * @date Sep 13, 2014
 */
package com.netreality.vertie.alpha.to;

import java.util.ArrayList;
import java.util.List;

import com.netreality.live4carnival.integration.to.CseResultsMetaTag;
import com.netreality.live4carnival.integration.to.CseSearchResultThumbNail;

/**
 * @author ldurh516
 *
 * @date Sep 13, 2014
 *	
 */
public class SearchResultTO {

	private String searchPhrase;
	private String resultUrl;
	private Double resultScore;
	private String domainTerm;
	private String resultPageTitle;
	private String resultSnippet;
	private String resultHtmlSnippet;
	public String getResultHtmlSnippet() {
		return resultHtmlSnippet;
	}
	public void setResultHtmlSnippet(String resultHtmlSnippet) {
		this.resultHtmlSnippet = resultHtmlSnippet;
	}
	private List<CseSearchResultThumbNail> thumbList;
	public List<CseSearchResultThumbNail> getThumbList() {
		return thumbList;
	}
	public void setThumbList(List<CseSearchResultThumbNail> thumbList) {
		this.thumbList = thumbList;
	}
	public List<CseResultsMetaTag> getMetaTagList() {
		return metaTagList;
	}
	public void setMetaTagList(List<CseResultsMetaTag> metaTagList) {
		this.metaTagList = metaTagList;
	}
	private List<CseResultsMetaTag> metaTagList;
	public String getResultSnippet() {
		return resultSnippet;
	}
	public void setResultSnippet(String resultSnippet) {
		this.resultSnippet = resultSnippet;
	}
	public String getResultPageTitle() {
		return resultPageTitle;
	}
	public void setResultPageTitle(String resultPageTitle) {
		this.resultPageTitle = resultPageTitle;
	}
	public String getDomainTerm() {
		return domainTerm;
	}
	public void setDomainTerm(String domainTerm) {
		this.domainTerm = domainTerm;
	}
	public String getSearchPhrase() {
		return searchPhrase;
	}
	public void setSearchPhrase(String searchPhrase) {
		this.searchPhrase = searchPhrase;
	}
	public String getResultUrl() {
		return resultUrl;
	}
	public void setResultUrl(String resultUrl) {
		this.resultUrl = resultUrl;
	}
	public Double getResultScore() {
		return resultScore;
	}
	public void setResultScore(Double resultScore) {
		this.resultScore = resultScore;
	}
	
}
