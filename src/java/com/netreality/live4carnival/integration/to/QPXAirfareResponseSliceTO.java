/**
 * @date Jun 19, 2015
 */
package com.netreality.live4carnival.integration.to;

import java.util.List;

/**
 * @author ldurh516
 *
 * @date Jun 19, 2015
 *	
 */
public class QPXAirfareResponseSliceTO {
	
	
	
	private String kind;
	private Integer duration;
	private List<QPXAirfareResponseSegment> segment;
	
	public List<QPXAirfareResponseSegment> getSegment() {
		return segment;
	}
	public void setSegment(List<QPXAirfareResponseSegment> segment) {
		this.segment = segment;
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
	 * @return the id
	 */
	

}
