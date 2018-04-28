/**
 * 
 */
package com.live4carnival.accomodation.search;

import com.live4carnival.accomodation.search.to.AcommodationRequestTO;

/**
 * @author JahLion
 *
 */
public interface IAccomodationSearch {
	
	Object searchForAccomodation(AcommodationRequestTO searchObj);
	Object bookAccomodation(Object booking);
	Object retrieveAccomodation(Object reservation);

}
