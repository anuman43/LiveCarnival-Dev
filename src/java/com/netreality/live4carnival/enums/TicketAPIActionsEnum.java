/**
 * 
 */
package com.netreality.live4carnival.enums;

/**
 * @author JahLion
 *
 */
public enum TicketAPIActionsEnum {
	
	AllEvents(0),
	SearchEvents(1),
	EventDetails(2),
	Allaffilates(3),
	AllOrganizers(4);
	
	
	
	TicketAPIActionsEnum(Integer actionVal)
	{
		actionValue = actionVal;
	}
	
	public Integer getActionValue()
	{
		return actionValue;
	}
	
	private Integer actionValue;
	
}
