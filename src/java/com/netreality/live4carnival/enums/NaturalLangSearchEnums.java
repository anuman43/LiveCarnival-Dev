/**
 * @date Oct 28, 2015
 */
package com.netreality.live4carnival.enums;

/**
 * @author ldurh516
 *
 * @date Oct 28, 2015
 *	
 */
public enum NaturalLangSearchEnums {
	
	IN_NATURAL_LANAGUAGE_MODE(0),
	IN_BOOLEAN_MODE(1),
	IN_QUERY_EXPANSION_MODE(2);
	
	NaturalLangSearchEnums(Integer srchVal)
	{
		srchTypeVal = srchVal;
	}
	
	private Integer srchTypeVal;

	/**
	 * @return the srchTypeVal
	 */
	public Integer getSrchTypeVal() {
		return srchTypeVal;
	}
}
