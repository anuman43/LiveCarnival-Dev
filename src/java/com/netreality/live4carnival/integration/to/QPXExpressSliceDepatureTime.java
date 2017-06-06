/**
 * @date Jun 7, 2015
 */
package com.netreality.live4carnival.integration.to;

import com.netreality.live4carnival.enums.QPXExpressData;

/**
 * @author ldurh516
 *
 * @date Jun 7, 2015
 *	
 */
public class QPXExpressSliceDepatureTime extends QPXExpressRequestData{
	
	private String earliestTime;
	private String latestTime;
	/**
	 * @return the earliestTime
	 */
	public String getEarliestTime() {
		return earliestTime;
	}
	/**
	 * @param earliestTime the earliestTime to set
	 */
	public void setEarliestTime(String earliestTime) {
		this.earliestTime = earliestTime;
	}
	/**
	 * @return the latestTime
	 */
	public String getLatestTime() {
		return latestTime;
	}
	/**
	 * @param latestTime the latestTime to set
	 */
	public void setLatestTime(String latestTime) {
		this.latestTime = latestTime;
	}

}
