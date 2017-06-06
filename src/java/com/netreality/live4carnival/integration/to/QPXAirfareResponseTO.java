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
public class QPXAirfareResponseTO {
	
	private String kind = QPXAirfareResponseEnum.tripSearch.getQpxTypeVal();
	private QPXAirfareResponseTrip trips;
	/**
	 * @return the trips
	 */
	public QPXAirfareResponseTrip getTrips() {
		return trips;
	}
	/**
	 * @param trips the trips to set
	 */
	public void setTrips(QPXAirfareResponseTrip trips) {
		this.trips = trips;
	}
	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}
	

}
