/**
 * @date Dec 27, 2014
 */
package com.netreality.vertie.alpha.to;

import java.util.Date;

/**
 * @author ldurh516
 *
 * @date Dec 27, 2014
 *	
 */
public class RecentSearchTO {
	
	private String searchWords;
	/**
	 * @return the searchWords
	 */
	public String getSearchWords() {
		return searchWords;
	}
	/**
	 * @param searchWords the searchWords to set
	 */
	public void setSearchWords(String searchWords) {
		this.searchWords = searchWords;
	}
	/**
	 * @return the siteReferalPage
	 */
	public String getSiteReferalPage() {
		return siteReferalPage;
	}
	/**
	 * @param siteReferalPage the siteReferalPage to set
	 */
	public void setSiteReferalPage(String siteReferalPage) {
		this.siteReferalPage = siteReferalPage;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the referedIpaddress
	 */
	public String getReferedIpaddress() {
		return referedIpaddress;
	}
	/**
	 * @param referedIpaddress the referedIpaddress to set
	 */
	public void setReferedIpaddress(String referedIpaddress) {
		this.referedIpaddress = referedIpaddress;
	}
	private String siteReferalPage;
	private Date createdDate;
	private String referedIpaddress;

}
