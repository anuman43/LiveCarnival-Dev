/**
 * @date Jun 20, 2015
 */
package com.netreality.live4carnival.integration.to;

import java.util.List;

/**
 * @author ldurh516
 *
 * @date Jun 20, 2015
 *	
 */
public class QPXAirfareResponseSegment {
	
	private String kind;
	private Integer duration;
	private String id;
	private String cabin;
	private String bookingCode;
	private Integer bookingCodeCount;
	private String marriedSegmentGroup;
	private Boolean subjectToGovernmentApproval;
	private Integer connectionDuration;
	private List<QPXAirfareResponseSegLeg> leg;
	private QPXAirfareResponseFlight flight;
	
	
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
	 * @return the cabin
	 */
	public String getCabin() {
		return cabin;
	}
	/**
	 * @param cabin the cabin to set
	 */
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}
	/**
	 * @return the bookingCode
	 */
	public String getBookingCode() {
		return bookingCode;
	}
	/**
	 * @param bookingCode the bookingCode to set
	 */
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}
	/**
	 * @return the bookingCodeCount
	 */
	public Integer getBookingCodeCount() {
		return bookingCodeCount;
	}
	/**
	 * @param bookingCodeCount the bookingCodeCount to set
	 */
	public void setBookingCodeCount(Integer bookingCodeCount) {
		this.bookingCodeCount = bookingCodeCount;
	}
	/**
	 * @return the marriedSegmentGroup
	 */
	public String getMarriedSegmentGroup() {
		return marriedSegmentGroup;
	}
	/**
	 * @param marriedSegmentGroup the marriedSegmentGroup to set
	 */
	public void setMarriedSegmentGroup(String marriedSegmentGroup) {
		this.marriedSegmentGroup = marriedSegmentGroup;
	}
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
	 * @return the leg
	 */
	public List<QPXAirfareResponseSegLeg> getLeg() {
		return leg;
	}
	/**
	 * @param leg the leg to set
	 */
	public void setLeg(List<QPXAirfareResponseSegLeg> leg) {
		this.leg = leg;
	}
	/**
	 * @return the flight
	 */
	public QPXAirfareResponseFlight getFlight() {
		return flight;
	}
	/**
	 * @param flight the flight to set
	 */
	public void setFlight(QPXAirfareResponseFlight flight) {
		this.flight = flight;
	}
	/**
	 * @return the subjectToGovernmentApproval
	 */
	public Boolean getSubjectToGovernmentApproval() {
		return subjectToGovernmentApproval;
	}
	/**
	 * @param subjectToGovernmentApproval the subjectToGovernmentApproval to set
	 */
	public void setSubjectToGovernmentApproval(Boolean subjectToGovernmentApproval) {
		this.subjectToGovernmentApproval = subjectToGovernmentApproval;
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

}
