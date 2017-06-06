/**
 * @date Jun 14, 2015
 */
package com.netreality.live4carnival.integration.to;

/**
 * @author ldurh516
 *
 * @date Jun 14, 2015
 *	
 */
public class QPXAirfareResponseTripOptionSegment {
	
	private String kind;
	private Integer duration;
	private String id;
	private QPXAirfareFlightTO flight;
	private String cabin;
	private String bookingCode;
	private Integer bookingCodeCount;
	private String marriedSegmentGroup;
	private Boolean subjectToGovernmentApproval;
	private Integer connectionDuration;
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
	 * @return the flight
	 */
	public QPXAirfareFlightTO getFlight() {
		return flight;
	}
	/**
	 * @param flight the flight to set
	 */
	public void setFlight(QPXAirfareFlightTO flight) {
		this.flight = flight;
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
