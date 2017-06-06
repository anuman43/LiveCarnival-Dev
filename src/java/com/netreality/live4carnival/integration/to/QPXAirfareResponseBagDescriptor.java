/**
 * @date Jun 14, 2015
 */
package com.netreality.live4carnival.integration.to;

import java.util.List;

/**
 * @author ldurh516
 *
 * @date Jun 14, 2015
 *	
 */
public class QPXAirfareResponseBagDescriptor {
	
	private String kind;
	private String commercialName;
	private Integer count;
	private List<String> description;
	/**
	 * @return the kind
	 */
	public String getKind() {
		return kind;
	}
	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}
	/**
	 * @return the commercialName
	 */
	public String getCommercialName() {
		return commercialName;
	}
	/**
	 * @param commercialName the commercialName to set
	 */
	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}
	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * @return the description
	 */
	public List<String> getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(List<String> description) {
		this.description = description;
	}
	

}
