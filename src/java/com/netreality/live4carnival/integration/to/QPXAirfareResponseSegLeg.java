/**
 * @date Jun 14, 2015
 */
package com.netreality.live4carnival.integration.to;

import com.netreality.live4carnival.enums.QPXAirfareResponseEnum;

/**
 * @author ldurh516
 *
 * @date Jun 14, 2015
 *	
 */
public class QPXAirfareResponseSegLeg {
	
	private String kind;
	private String id;
	private String aircraft;
	private String arrivalTime;
	private String departureTime;
	private String origin;
	private String destination;
	private String originTerminal;
	private String destinationTerminal;
	private Integer duration;
	private String operatingDisclosure;
	private Integer onTimePerformance;
	private Integer mileage;
	private String meal;
	private Boolean secure;
	private Integer connectionDuration;
	private Boolean changePlane;
	/**
	 * @return the kind
	 */
	public String getKind() {
		return QPXAirfareResponseEnum.tripOptionSliceLeg.getQpxTypeVal();
	}
	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the aircraft
	 */
	public String getAircraft() {
		return aircraft;
	}
	/**
	 * @param aircraft the aircraft to set
	 */
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}
	/**
	 * @return the arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	/**
	 * @return the departureTime
	 */
	public String getDepartureTime() {
		return departureTime;
	}
	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
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
	 * @return the originTerminal
	 */
	public String getOriginTerminal() {
		return originTerminal;
	}
	/**
	 * @param originTerminal the originTerminal to set
	 */
	public void setOriginTerminal(String originTerminal) {
		this.originTerminal = originTerminal;
	}
	/**
	 * @return the destinationTerminal
	 */
	public String getDestinationTerminal() {
		return destinationTerminal;
	}
	/**
	 * @param destinationTerminal the destinationTerminal to set
	 */
	public void setDestinationTerminal(String destinationTerminal) {
		this.destinationTerminal = destinationTerminal;
	}
	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	/**
	 * @return the operatingDisclosure
	 */
	public String getOperatingDisclosure() {
		return operatingDisclosure;
	}
	/**
	 * @param operatingDisclosure the operatingDisclosure to set
	 */
	public void setOperatingDisclosure(String operatingDisclosure) {
		this.operatingDisclosure = operatingDisclosure;
	}
	/**
	 * @return the onTimePerformance
	 */
	public Integer getOnTimePerformance() {
		return onTimePerformance;
	}
	/**
	 * @param onTimePerformance the onTimePerformance to set
	 */
	public void setOnTimePerformance(Integer onTimePerformance) {
		this.onTimePerformance = onTimePerformance;
	}
	/**
	 * @return the mileage
	 */
	public Integer getMileage() {
		return mileage;
	}
	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}
	/**
	 * @return the meal
	 */
	public String getMeal() {
		return meal;
	}
	/**
	 * @param meal the meal to set
	 */
	public void setMeal(String meal) {
		this.meal = meal;
	}
	/**
	 * @return the secure
	 */
	public Boolean getSecure() {
		return secure;
	}
	/**
	 * @param secure the secure to set
	 */
	public void setSecure(Boolean secure) {
		this.secure = secure;
	}
	/**
	 * @return the connectionDuration
	 */
	public Integer getConnectionDuration() {
		return connectionDuration;
	}
	/**
	 * @param connectionDuration the connectionDuration to set
	 */
	public void setConnectionDuration(Integer connectionDuration) {
		this.connectionDuration = connectionDuration;
	}
	/**
	 * @return the changePlane
	 */
	public Boolean getChangePlane() {
		return changePlane;
	}
	/**
	 * @param changePlane the changePlane to set
	 */
	public void setChangePlane(Boolean changePlane) {
		this.changePlane = changePlane;
	}
	
	

}
