/**
 * @date Jul 12, 2015
 */
package com.netreality.live4carnival.idt.Json.to;

/**
 * @author ldurh516
 *
 * @date Jul 12, 2015
 *	
 */
public class LocalTopUpProduct {
	
	private String country_code;
	private String carrier_code;
	private String currency_code;
	private Integer amount;
	/**
	 * @return the country_code
	 */
	public String getCountry_code() {
		return country_code;
	}
	/**
	 * @param country_code the country_code to set
	 */
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	/**
	 * @return the carrier_code
	 */
	public String getCarrier_code() {
		return carrier_code;
	}
	/**
	 * @param carrier_code the carrier_code to set
	 */
	public void setCarrier_code(String carrier_code) {
		this.carrier_code = carrier_code;
	}
	/**
	 * @return the currency_code
	 */
	public String getCurrency_code() {
		return currency_code;
	}
	/**
	 * @param currency_code the currency_code to set
	 */
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
	/**
	 * @return the amount
	 */
	public Integer getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
