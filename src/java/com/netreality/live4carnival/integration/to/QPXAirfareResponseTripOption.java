/**
 * @date Jun 14, 2015
 */
package com.netreality.live4carnival.integration.to;

import java.util.Collection;
import java.util.List;

/**
 * @author ldurh516
 *
 * @date Jun 14, 2015
 *	
 */
public class QPXAirfareResponseTripOption {
	
	private String kind;
	private String saleTotal;
	private String id;
	private List<QPXAirfareResponseSliceTO> slice;
	private List<QPXAirfareResponsePricingTO> pricing;
	
	private List<QPXAirfareResponseTripOptionTax> tax;
	
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
	 * @return the saleTotal
	 */
	public String getSaleTotal() {
		return saleTotal;
	}
	/**
	 * @param saleTotal the saleTotal to set
	 */
	public void setSaleTotal(String saleTotal) {
		this.saleTotal = saleTotal;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the slice
	 */
	public List<QPXAirfareResponseSliceTO> getSlice() {
		return slice;
	}
	/**
	 * @param slice the slice to set
	 */
	public void setSlice(List<QPXAirfareResponseSliceTO> slice) {
		this.slice = slice;
	}
	/**
	 * @return the pricing
	 */
	public List<QPXAirfareResponsePricingTO> getPricing() {
		return pricing;
	}
	/**
	 * @param pricing the pricing to set
	 */
	public void setPricing(List<QPXAirfareResponsePricingTO> pricing) {
		this.pricing = pricing;
	}
	
	/**
	 * @return the tax
	 */
	public Collection<QPXAirfareResponseTripOptionTax> getTax() {
		return tax;
	}
	/**
	 * @param tax the tax to set
	 */
	public void setTax(List<QPXAirfareResponseTripOptionTax> tax) {
		this.tax = tax;
	}
	

}
