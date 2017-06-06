/**
 * @date Jun 17, 2015
 */
package com.netreality.live4carnival.integration.to;

import java.util.List;

/**
 * @author ldurh516
 *
 * @date Jun 17, 2015
 *	
 */
public class QPXAirfareResponsePricingTO {
	
	private String kind;
	private String baseFareTotal;
	private String saleFareTotal;
	private String saleTaxTotal;
	private String saleTotal;
	private String fareCalculation;
	private String latestTicketingTime;
	private String ptc;
	private Boolean refundable;
	private List<QPXAirfareResponseSegPricing> segmentPricing;
	private List<QPXAirfareResponseTripsTripOptionPricingFare> fare;
	private QPXPassengersTO passengers;
	private  List<QPXAirfareResponseTripOptionTax> tax;
	
	
	
	/**
	 * @return the kind
	 */
	public String getKind() {
		return kind;
	}
	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}
	/**
	 * @return the baseFareTotal
	 */
	public String getBaseFareTotal() {
		return baseFareTotal;
	}
	/**
	 * @param baseFareTotal the baseFareTotal to set
	 */
	public void setBaseFareTotal(String baseFareTotal) {
		this.baseFareTotal = baseFareTotal;
	}
	/**
	 * @return the saleFareTotal
	 */
	public String getSaleFareTotal() {
		return saleFareTotal;
	}
	/**
	 * @param saleFareTotal the saleFareTotal to set
	 */
	public void setSaleFareTotal(String saleFareTotal) {
		this.saleFareTotal = saleFareTotal;
	}
	/**
	 * @return the saleTaxTotal
	 */
	public String getSaleTaxTotal() {
		return saleTaxTotal;
	}
	/**
	 * @param saleTaxTotal the saleTaxTotal to set
	 */
	public void setSaleTaxTotal(String saleTaxTotal) {
		this.saleTaxTotal = saleTaxTotal;
	}
	/**
	 * @return the saleTotal
	 */
	public String getSaleTotal() {
		return saleTotal;
	}
	/**
	 * @param saleTotal the saleTotal to set
	 */
	public void setSaleTotal(String saleTotal) {
		this.saleTotal = saleTotal;
	}
	/**
	 * @return the fareCalculation
	 */
	public String getFareCalculation() {
		return fareCalculation;
	}
	/**
	 * @param fareCalculation the fareCalculation to set
	 */
	public void setFareCalculation(String fareCalculation) {
		this.fareCalculation = fareCalculation;
	}
	/**
	 * @return the latestTicketingTime
	 */
	public String getLatestTicketingTime() {
		return latestTicketingTime;
	}
	/**
	 * @param latestTicketingTime the latestTicketingTime to set
	 */
	public void setLatestTicketingTime(String latestTicketingTime) {
		this.latestTicketingTime = latestTicketingTime;
	}
	/**
	 * @return the ptc
	 */
	public String getPtc() {
		return ptc;
	}
	/**
	 * @param ptc the ptc to set
	 */
	public void setPtc(String ptc) {
		this.ptc = ptc;
	}
	/**
	 * @return the refundable
	 */
	public Boolean getRefundable() {
		return refundable;
	}
	/**
	 * @param refundable the refundable to set
	 */
	public void setRefundable(Boolean refundable) {
		this.refundable = refundable;
	}
	/**
	 * @return the segmentPricing
	 */
	public List<QPXAirfareResponseSegPricing> getSegmentPricing() {
		return segmentPricing;
	}
	/**
	 * @param segmentPricing the segmentPricing to set
	 */
	public void setSegmentPricing(List<QPXAirfareResponseSegPricing> segmentPricing) {
		this.segmentPricing = segmentPricing;
	}
	/**
	 * @return the passengers
	 */
	public QPXPassengersTO getPassengers() {
		return passengers;
	}
	/**
	 * @param passengers the passengers to set
	 */
	public void setPassengers(QPXPassengersTO passengers) {
		this.passengers = passengers;
	}
	/**
	 * @return the fare
	 */
	public List<QPXAirfareResponseTripsTripOptionPricingFare> getFare() {
		return fare;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare(List<QPXAirfareResponseTripsTripOptionPricingFare> fare) {
		this.fare = fare;
	}
	/**
	 * @return the tax
	 */
	public List<QPXAirfareResponseTripOptionTax> getTax() {
		return tax;
	}
	/**
	 * @param tax the tax to set
	 */
	public void setTax(List<QPXAirfareResponseTripOptionTax> tax) {
		this.tax = tax;
	}

}
