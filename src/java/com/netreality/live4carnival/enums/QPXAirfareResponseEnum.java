/**
 * @date Jun 14, 2015
 */
package com.netreality.live4carnival.enums;

/**
 * @author ldurh516
 *
 * @date Jun 14, 2015
 *	
 */
public enum QPXAirfareResponseEnum {

	tripSearch("qpxExpress#tripsSearch"),
	tripOptions("qpxexpress#data"),
	tripAirportData("qpxexpress#airportData"),
	tripAirportCity("qpxexpress#cityData"),
	tripAirportAircraft("qpxexpress#aircraftData"),
	tripAirportTax("qpxexpress#taxData"),
	tripAirportCarrier("qpxexpress#carrierData"),
	tripOption("qpxexpress#tripOption"),
	trips("qpxexpress#tripOptions"),
	tripOptionSeg("qpxexpress#sliceInfo"),
	tripOptionSlice("qpxexpress#tripOption"),
	tripOptionSliceLeg("qpxexpress#legInfo"),
	tripPricing("qpxexpress#pricingInfo"),
	tripPricingFare("qpxexpress#fareInfo"),
	tripPricingSeg("qpxexpress#segmentPricing"),
	tripPicingBaggage("qpxexpress#freeBaggageAllowance"),
	tripPricingBagDesc("qpxexpress#bagDescriptor"),
	tripPassengersCount("qpxexpress#passengerCounts"),
	tripTaxInfo("qpxexpress#taxInfo"),
	tripData("qpxexpress#data");
	
	QPXAirfareResponseEnum(String qpxVal)
	{
		this.qpxTypeVal = qpxVal;
	}
	
	private String qpxTypeVal;

	/**
	 * @return the qpxTypeVal
	 */
	public String getQpxTypeVal() {
		return qpxTypeVal;
	}
	
	
}
