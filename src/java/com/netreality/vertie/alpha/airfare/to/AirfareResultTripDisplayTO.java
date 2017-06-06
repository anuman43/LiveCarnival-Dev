package com.netreality.vertie.alpha.airfare.to;

import java.util.List;

public class AirfareResultTripDisplayTO {

	private Boolean isRoundTrip;
	public Boolean getIsRoundTrip() {
		return isRoundTrip;
	}
	public void setIsRoundTrip(Boolean isRoundTrip) {
		this.isRoundTrip = isRoundTrip;
	}
	public String getTripCost() {
		return tripCost;
	}
	public void setTripCost(String tripCost) {
		this.tripCost = tripCost;
	}
	public List<AirFareTripDisplaySegTO> getTripSegments() {
		return tripSegments;
	}
	public void setTripSegments(List<AirFareTripDisplaySegTO> tripSegments) {
		this.tripSegments = tripSegments;
	}
	private String tripCost;
	List<AirFareTripDisplaySegTO> tripSegments;
}
