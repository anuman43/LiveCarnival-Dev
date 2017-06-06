/**
 * 
 */
package com.netreality.live4carnival.airfare.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.netreality.live4carnival.integration.to.AirTravelForm;
import com.netreality.live4carnival.integration.to.QPXAirfareRequest;
import com.netreality.live4carnival.integration.to.QPXAirfareResponseFlight;
import com.netreality.live4carnival.integration.to.QPXAirfareResponseSegLeg;
import com.netreality.live4carnival.integration.to.QPXAirfareResponseSegment;
import com.netreality.live4carnival.integration.to.QPXAirfareResponseSliceTO;
import com.netreality.live4carnival.integration.to.QPXAirfareResponseTO;
import com.netreality.live4carnival.integration.to.QPXAirfareResponseTrip;
import com.netreality.live4carnival.integration.to.QPXAirfareResponseTripOption;
import com.netreality.live4carnival.integration.to.QPXPassengersTO;
import com.netreality.live4carnival.integration.to.QPXSlice;
import com.netreality.vertie.alpha.airfare.to.AirFareTripDisplaySegLegTO;
import com.netreality.vertie.alpha.airfare.to.AirFareTripDisplaySegTO;
import com.netreality.vertie.alpha.airfare.to.AirfareResultDisplayTO;
import com.netreality.vertie.alpha.airfare.to.AirfareResultTripDisplayTO;
import com.netreality.vertie.alpha.airfare.to.AirfareResultsViewTO;

/**
 * @author Lyndon
 *
 */
public class QPXAirfareHelper {
	
	private static String MAX_TRIP_PRICE = "USD5000.00";
	private static Integer FLIGHT_SOLUTIONS = 20;
	private static String DEFAULT_CABIN = "COACH";
	private static String DEFAULT_SALE_COUNTRY = "US";
	private static Boolean SEARCH_IS_REFUNDABLE =true;
	private static Integer DEFAULT_AIRFARE_RESULT_SOLUTIONS = 20;
	
	private static Logger _log = Logger.getLogger(QPXAirfareHelper.class);
	
	
	
	public static QPXAirfareRequest createAirfareRequestFromSearch(AirTravelForm airfareReq)
	{
		QPXAirfareRequest searchReq = null;
		List<QPXSlice> trips = null;
		QPXSlice fromSlice = null;
		QPXSlice toSlice = null;
		QPXPassengersTO passengers = null;
		if(airfareReq != null)
		{
			searchReq = new QPXAirfareRequest();
			searchReq.setMaxPrice(MAX_TRIP_PRICE);
			searchReq.setSolutions(FLIGHT_SOLUTIONS);
			searchReq.setSaleCountry(DEFAULT_SALE_COUNTRY);
			searchReq.setRefundable(SEARCH_IS_REFUNDABLE);
			searchReq.setSolutions(DEFAULT_AIRFARE_RESULT_SOLUTIONS);
			//create trip slices- From and To slices
			fromSlice = new QPXSlice();
			fromSlice.setOrigin(airfareReq.getFromAirport());
			fromSlice.setDestination(airfareReq.getToAirport());
			fromSlice.setDate(airfareReq.getFromDate());
			fromSlice.setPreferredCabin(DEFAULT_CABIN);
			
			//Destination Slice
			toSlice = new QPXSlice();
			toSlice.setOrigin(airfareReq.getToAirport());
			toSlice.setDate(airfareReq.getToDate());
			toSlice.setDestination(airfareReq.getFromAirport());
			toSlice.setPreferredCabin(DEFAULT_CABIN);
			
			trips = new ArrayList<QPXSlice>();
			//trips.add(toSlice);
			trips.add(fromSlice);
			//create Passenger information
			passengers = new QPXPassengersTO();
			passengers.setAdultCount(Integer.valueOf(airfareReq.getAdultPassengers()));
			passengers.setChildCount(Integer.valueOf(airfareReq.getKidPassengers()));
			passengers.setInfantInSeatCount(Integer.valueOf(airfareReq.getInfantPassengers()));
			searchReq.setPassengers(passengers);
			searchReq.setSlice(trips);
	
		}
		
		return searchReq;
	}
	
	public static AirfareResultsViewTO createAirfareResultsView(QPXAirfareResponseTO response)
	{
		
		AirfareResultsViewTO travelView = null;
		List<AirfareResultTripDisplayTO> travelOpList = null;
		if(response != null)
		{
			travelView = new AirfareResultsViewTO();
			QPXAirfareResponseTrip respTrip = response.getTrips();
			if(respTrip != null && !respTrip.getTripOption().isEmpty())
			{
				List<QPXAirfareResponseTripOption> tripOptions = respTrip.getTripOption();
				_log.debug("There are " + tripOptions.size() + " trip options");
				List<QPXAirfareResponseSliceTO> tripSlices = null;
				List<QPXAirfareResponseSegment> tripSegments = null;
				travelOpList = new ArrayList<AirfareResultTripDisplayTO>();
				AirfareResultTripDisplayTO displayObj = null;
				for(QPXAirfareResponseTripOption tp: tripOptions)
				{
					
					if(tp != null)
					{
						 displayObj = new AirfareResultTripDisplayTO();
						displayObj.setTripCost(tp.getSaleTotal());
						displayObj.setIsRoundTrip(isRoundTrip(tp));
						tripSlices = tp.getSlice();
						_log.debug("Trip Option has-" + tripSlices.size());
								for(QPXAirfareResponseSliceTO sl: tripSlices)
								{
									if(sl != null)
									{
										tripSegments = sl.getSegment();
										displayObj.setTripSegments(createTripSegments(sl));
										_log.debug("This trip slice has-" + tripSegments.size());
										
									}
									
										
								}
					}
					travelOpList.add(displayObj);
						}
			}
			travelView.setTripResults(travelOpList);
		}
		
		
		return travelView;
	}
	
	
	private static Boolean isRoundTrip(QPXAirfareResponseTripOption tripOpt)
	{
		Boolean roundTrip = null;
		
		if(tripOpt.getSlice().size() > 1)
			roundTrip = true;
		else
			roundTrip = false;
		
		return roundTrip;
	}
	
	private static List<AirFareTripDisplaySegTO> createTripSegments(QPXAirfareResponseSliceTO tSlice)
	{
		List<AirFareTripDisplaySegTO> sliceSegList = null;
		List<QPXAirfareResponseSegment> sliceSegmentList = null;
		if(tSlice != null )
		{
			sliceSegList = new ArrayList<AirFareTripDisplaySegTO>();
			AirFareTripDisplaySegTO tripSeg = null;
			sliceSegmentList = tSlice.getSegment();
			for(QPXAirfareResponseSegment seg : sliceSegmentList)
			{
				if(seg != null)
				{
					 tripSeg = new AirFareTripDisplaySegTO();
					 tripSeg.setBookingCode(seg.getBookingCode());
					 tripSeg.setSegLegList(getSegmentLegList(seg));
					 QPXAirfareResponseFlight segFlight = seg.getFlight();
					 	if(segFlight != null)
					 			tripSeg.setAirCarrier(segFlight.getCarrier());
					 
				}
				sliceSegList.add(tripSeg);
			}
		}
		
		return sliceSegList;
	}
	
	
	private static List<AirFareTripDisplaySegLegTO> getSegmentLegList(QPXAirfareResponseSegment tripSeg)
	{
		List<AirFareTripDisplaySegLegTO> segmentLegsList = null;
		List<QPXAirfareResponseSegLeg> legs = null;
		if(tripSeg != null)
		{
			legs = tripSeg.getLeg();
			AirFareTripDisplaySegLegTO asegLeg = null;
			segmentLegsList = new ArrayList<AirFareTripDisplaySegLegTO>();
				for(QPXAirfareResponseSegLeg segLeg : legs)
				{
					if(segLeg != null)
					{
						asegLeg = new AirFareTripDisplaySegLegTO();
						asegLeg.setArrivalTime(segLeg.getArrivalTime());
						asegLeg.setDepatureTime(segLeg.getDepartureTime());
						asegLeg.setDestinationAirport(segLeg.getDestination());
						asegLeg.setOriginAirport(segLeg.getOrigin());
						asegLeg.setTripDuration(segLeg.getDuration());
						_log.debug("Segment duration is" +segLeg.getDuration());
						
					}
					segmentLegsList.add(asegLeg);
				}
			
		}
		
		
		return segmentLegsList;
	}
	
	
	

}
