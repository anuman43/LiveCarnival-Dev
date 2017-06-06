/**
 * @date Jun 7, 2015
 */
package com.netreality.live4carnival.integration.to;

import com.netreality.live4carnival.enums.QPXAirfareRequestEnum;
import com.netreality.live4carnival.enums.QPXExpressData;

/**
 * @author ldurh516
 *
 * @date Jun 7, 2015
 *	
 */
public class QPXPassengersTO {
	
	//private String kind = QPXAirfareRequestEnum.tripPassengerCount.getQpxTypeVal();
	
	private Integer adultCount = 0;
	private Integer childCount = 0;
	private Integer infantInLapCount = 0;
	private Integer infantInSeatCount = 0;
	private Integer seniorCount = 0;
	private String kind;
	
	
	/**
	 * @return the adultCount
	 */
	public Integer getAdultCount() {
		return adultCount;
	}
	/**
	 * @param adultCount the adultCount to set
	 */
	public void setAdultCount(Integer adultCount) {
		this.adultCount = adultCount;
	}
	/**
	 * @return the childCount
	 */
	public Integer getChildCount() {
		return childCount;
	}
	/**
	 * @param childCount the childCount to set
	 */
	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}
	/**
	 * @return the infantInLapCount
	 */
	public Integer getInfantInLapCount() {
		return infantInLapCount;
	}
	/**
	 * @param infantInLapCount the infantInLapCount to set
	 */
	public void setInfantInLapCount(Integer infantInLapCount) {
		this.infantInLapCount = infantInLapCount;
	}
	/**
	 * @return the infantInSeatCount
	 */
	public Integer getInfantInSeatCount() {
		return infantInSeatCount;
	}
	/**
	 * @param infantInSeatCount the infantInSeatCount to set
	 */
	public void setInfantInSeatCount(Integer infantInSeatCount) {
		this.infantInSeatCount = infantInSeatCount;
	}
	/**
	 * @return the seniorCount
	 */
	public Integer getSeniorCount() {
		return seniorCount;
	}
	/**
	 * @param seniorCount the seniorCount to set
	 */
	public void setSeniorCount(Integer seniorCount) {
		this.seniorCount = seniorCount;
	}
	/**
	 * @return the kind
	 
	public String getKind() {
		return kind;
	}
	/**
	 * @param kind the kind to set
	 
	public void setKind(String kind) {
		this.kind = kind;
	}
	*/
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
	
	

}
