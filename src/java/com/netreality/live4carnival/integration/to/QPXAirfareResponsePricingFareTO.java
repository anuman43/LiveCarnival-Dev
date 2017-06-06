/**
 * @date Jun 22, 2015
 */
package com.netreality.live4carnival.integration.to;

/**
 * @author ldurh516
 *
 * @date Jun 22, 2015
 *	
 */
public class QPXAirfareResponsePricingFareTO {
	
	private String kind;
	private String id;
	private String carrier;
	private String origin;
	private String destination;
	private String basis;
	private Boolean Private;
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
	 * @return the carrier
	 */
	public String getCarrier() {
		return carrier;
	}
	/**
	 * @param carrier the carrier to set
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the basis
	 */
	public String getBasis() {
		return basis;
	}
	/**
	 * @param basis the basis to set
	 */
	public void setBasis(String basis) {
		this.basis = basis;
	}
	/**
	 * @return the private
	 */
	public Boolean getPrivate() {
		return Private;
	}
	/**
	 * @param private1 the private to set
	 */
	public void setPrivate(Boolean private1) {
		Private = private1;
	}

}
