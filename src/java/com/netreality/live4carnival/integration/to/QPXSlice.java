/**
 * @date Jun 7, 2015
 */
package com.netreality.live4carnival.integration.to;

/**
 * @author ldurh516
 *
 * @date Jun 7, 2015
 *	
 */
public class QPXSlice extends QPXExpressRequestData{
	
	private static String kind = "qpxexpress#sliceInput";
	private String origin;
	private String destination;
	private String date;
	private Integer maxStops = 0;
	private Integer maxConnectionDuration = 0;
	private String preferredCabin;
	private String alliance;
	private QPXExpressSliceDepatureTime depTime;
	private String permittedCarrier;
	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the maxStops
	 */
	public Integer getMaxStops() {
		return maxStops;
	}
	/**
	 * @param maxStops the maxStops to set
	 */
	public void setMaxStops(Integer maxStops) {
		this.maxStops = maxStops;
	}
	/**
	 * @return the maxConnectionDuration
	 */
	public Integer getMaxConnectionDuration() {
		return maxConnectionDuration;
	}
	/**
	 * @param maxConnectionDuration the maxConnectionDuration to set
	 */
	public void setMaxConnectionDuration(Integer maxConnectionDuration) {
		this.maxConnectionDuration = maxConnectionDuration;
	}
	/**
	 * @return the preferredCabin
	 */
	public String getPreferredCabin() {
		return preferredCabin;
	}
	/**
	 * @param preferredCabin the preferredCabin to set
	 */
	public void setPreferredCabin(String preferredCabin) {
		this.preferredCabin = preferredCabin;
	}
	/**
	 * @return the alliance
	 */
	public String getAlliance() {
		return alliance;
	}
	/**
	 * @param alliance the alliance to set
	 */
	public void setAlliance(String alliance) {
		this.alliance = alliance;
	}
	/**
	 * @return the depTime
	 */
	public QPXExpressSliceDepatureTime getDepTime() {
		return depTime;
	}
	/**
	 * @param depTime the depTime to set
	 */
	public void setDepTime(QPXExpressSliceDepatureTime depTime) {
		this.depTime = depTime;
	}
	/**
	 * @return the permittedCarrier
	 */
	public String getPermittedCarrier() {
		return permittedCarrier;
	}
	/**
	 * @param permittedCarrier the permittedCarrier to set
	 */
	public void setPermittedCarrier(String permittedCarrier) {
		this.permittedCarrier = permittedCarrier;
	}
	/**
	 * @return the kind
	 */
	public static String getKind() {
		return kind;
	}
	

}
