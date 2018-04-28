/**
 * 
 */
package com.live4carnival.accomodation.ean.rest.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import com.live4carnival.accomodation.ean.hotelList.po.EANHotelListRoom;
import com.live4carnival.accomodation.ean.hotelList.po.EANHotelListRoomGroup;
import com.live4carnival.accomodation.search.to.RoomRequestChildInfo;
import com.live4carnival.accomodation.search.to.RoomRequestDetailsTO;

/**
 * @author JahLion
 *
 */
public class EANRestUtility {
	
	private static Logger _log = LogManager.getLogger(EANRestUtility.class);

	public String convertRestRoom(EANHotelListRoomGroup roomGrp)
	{
		String roomReqStr = null;
		
		if(roomGrp != null)
		{
			EANHotelListRoom roomInfo = roomGrp.getRoom();
			if(roomInfo != null)
			{
				roomReqStr ="room1=";
				roomReqStr += roomInfo.getNumberOfAdults();
				if(roomInfo.getNumberOfChildren() > 0)
				{
					for(int h=0; h < roomInfo.getNumberOfChildren();h++)
					{
						
					}
				}
			}
		}
		
		return roomReqStr;
	}
	
	
	public static String convertRoomPOToRest(RoomRequestDetailsTO request, String roomSeq)
	{
		String roomRestStr = "";
		
		if(request != null && roomSeq != null)
		{
			roomRestStr += "&room" + roomSeq + "=" + request.getNumOfAdults();
			for(RoomRequestChildInfo ks: request.getKids())
			{
				RoomRequestChildInfo child = ks;
				if(child != null)
				{
					roomRestStr += "," + child.getChildAge();
				}
			}
		}
		_log.debug("Room request=" + roomRestStr);
		return roomRestStr;
	}
	
}
