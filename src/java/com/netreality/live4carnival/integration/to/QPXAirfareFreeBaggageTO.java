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
public class QPXAirfareFreeBaggageTO {
	
	private String kind;
	private Integer kilos;
	private Integer kilosPerPiece;
	private Integer pieces;
	private Integer pounds;
	private List<QPXAirfareResponseBagDescriptor> bagDescriptor;
	
	
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
	 * @return the kilos
	 */
	public Integer getKilos() {
		return kilos;
	}
	/**
	 * @param kilos the kilos to set
	 */
	public void setKilos(Integer kilos) {
		this.kilos = kilos;
	}
	/**
	 * @return the kilosPerPiece
	 */
	public Integer getKilosPerPiece() {
		return kilosPerPiece;
	}
	/**
	 * @param kilosPerPiece the kilosPerPiece to set
	 */
	public void setKilosPerPiece(Integer kilosPerPiece) {
		this.kilosPerPiece = kilosPerPiece;
	}
	/**
	 * @return the pieces
	 */
	public Integer getPieces() {
		return pieces;
	}
	/**
	 * @param pieces the pieces to set
	 */
	public void setPieces(Integer pieces) {
		this.pieces = pieces;
	}
	/**
	 * @return the pounds
	 */
	public Integer getPounds() {
		return pounds;
	}
	/**
	 * @param pounds the pounds to set
	 */
	public void setPounds(Integer pounds) {
		this.pounds = pounds;
	}
}
