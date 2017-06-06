/**
 * 
 */
package com.netreality.live4carnival.integration.to;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JahLion
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CSESearchResultQueries {
	
	
	//private List<CSESearchResultRequestQuery> metaData;

	/*public List<CSESearchResultRequestQuery> getMetaData() {
		return metaData;
	}

	public void setMetaData(List<CSESearchResultRequestQuery> metaData) {
		this.metaData = metaData;
	}
	*/
	
	private Map<String,CSESearchResultRequestQuery> key;

	public Map<String, CSESearchResultRequestQuery> getKey() {
		return key;
	}

	public void setKey(Map<String, CSESearchResultRequestQuery> key) {
		this.key = key;
	}

}
