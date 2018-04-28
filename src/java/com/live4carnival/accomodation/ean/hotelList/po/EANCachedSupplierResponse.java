/**
 * 
 */
package com.live4carnival.accomodation.ean.hotelList.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author JahLion
 *
 */
public class EANCachedSupplierResponse {

	private String supplierCacheTolerance;
	
	@JsonProperty("@supplierCacheTolerance")
	public String getSupplierCacheTolerance() {
		return supplierCacheTolerance;
	}
	
	@JsonProperty("@cachedTime")
	public String getCachedTime() {
		return cachedTime;
	}
	@JsonProperty("@cachedTime")
	public void setCachedTime(String cachedTime) {
		this.cachedTime = cachedTime;
	}
	@JsonProperty("@otherOverheadTime")
	public String getOtherOverheadTime() {
		return otherOverheadTime;
	}
	@JsonProperty("@otherOverheadTime")
	public void setOtherOverheadTime(String otherOverheadTime) {
		this.otherOverheadTime = otherOverheadTime;
	}
	@JsonProperty("@matchedCurrency")
	public String getMatchedCurrency() {
		return matchedCurrency;
	}
	@JsonProperty("@matchedCurrency")
	public void setMatchedCurrency(String matchedCurrency) {
		this.matchedCurrency = matchedCurrency;
	}
	@JsonProperty("matchedLocale")
	public String getMatchedLocale() {
		return matchedLocale;
	}
	@JsonProperty("@matchedLocale")
	public void setMatchedLocale(String matchedLocale) {
		this.matchedLocale = matchedLocale;
	}
	@JsonProperty("@supplierCacheTolerance")
	public void setSupplierCacheTolerance(String supplierCacheTolerance) {
		this.supplierCacheTolerance = supplierCacheTolerance;
	}
	private String cachedTime;
	private String candidatePreptime;
	@JsonProperty("@candidatePreptime")
	public String getCandidatePreptime() {
		return candidatePreptime;
	}
	@JsonProperty("@candidatePreptime")
	public void setCandidatePreptime(String candidatePreptime) {
		this.candidatePreptime = candidatePreptime;
	}
	private String otherOverheadTime;
	private String matchedCurrency;
	private String matchedLocale;
	private String tpidUsed;

	@JsonProperty("@tpidUsed")
	public String getTpidUsed() {
		return tpidUsed;
	}
	@JsonProperty("@tpidUsed")
	public void setTpidUsed(String tpidUsed) {
		this.tpidUsed = tpidUsed;
	}
	
}
