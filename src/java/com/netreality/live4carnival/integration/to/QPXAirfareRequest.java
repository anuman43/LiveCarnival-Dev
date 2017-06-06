/**
 * @date Jun 8, 2015
 */
package com.netreality.live4carnival.integration.to;

import java.util.List;

/**
 * @author ldurh516
 *
 * @date Jun 8, 2015
 *	
 */
public class QPXAirfareRequest {
	
	private QPXPassengersTO passengers;
	private List<QPXSlice> slice;
	private String maxPrice;
	private String saleCountry;
	private Integer solutions;
	private Boolean refundable;
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
	 * @return the slice
	 */
	public List<QPXSlice> getSlice() {
		return slice;
	}
	/**
	 * @param slice the slice to set
	 */
	public void setSlice(List<QPXSlice> slice) {
		this.slice = slice;
	}
	/**
	 * @return the maxPrice
	 */
	public String getMaxPrice() {
		return maxPrice;
	}
	/**
	 * @param maxPrice the maxPrice to set
	 */
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	/**
	 * @return the saleCountry
	 */
	public String getSaleCountry() {
		return saleCountry;
	}
	/**
	 * @param saleCountry the saleCountry to set
	 */
	public void setSaleCountry(String saleCountry) {
		this.saleCountry = saleCountry;
	}
	/**
	 * @return the solutions
	 */
	public Integer getSolutions() {
		return solutions;
	}
	/**
	 * @param solutions the solutions to set
	 */
	public void setSolutions(Integer solutions) {
		this.solutions = solutions;
	}
	public Boolean getRefundable() {
		return refundable;
	}
	public void setRefundable(Boolean refundable) {
		this.refundable = refundable;
	}

}
