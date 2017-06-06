/**
 * @date Jun 19, 2015
 */
package com.netreality.live4carnival.integration.to;

import java.util.List;

import com.netreality.live4carnival.enums.QPXAirfareResponseEnum;

/**
 * @author ldurh516
 *
 * @date Jun 19, 2015
 *	
 */
public class QPXAirfareResponseTrip {
	
	private String kind;
	private String requestId;
	private List<QPXAirfareResponseTripOption> tripOption;
	private QPXAirfareResponseData data;
	/**
	 * @return the kind
	 */
	public String getKind() {
		return QPXAirfareResponseEnum.trips.getQpxTypeVal();
	}
	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}
	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}
	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	/**
	 * @return the tripOption
	 */
	public List<QPXAirfareResponseTripOption> getTripOption() {
		return tripOption;
	}
	/**
	 * @param tripOption the tripOption to set
	 */
	public void setTripOption(List<QPXAirfareResponseTripOption> tripOption) {
		this.tripOption = tripOption;
	}
	/**
	 * @return the data
	 */
	public QPXAirfareResponseData getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(QPXAirfareResponseData data) {
		this.data = data;
	}

}
