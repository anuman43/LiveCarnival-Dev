/**
 * @date Jun 14, 2015
 */
package com.netreality.live4carnival.integration.to;

import com.netreality.live4carnival.enums.QPXAirfareResponseEnum;

/**
 * @author ldurh516
 *
 * @date Jun 14, 2015
 *	
 */
public class QPXAirfareResponseCity {

		private String kind;
		private String code;
		private String country;
		private String name;
		/**
		 * @return the kind
		 */
		public String getKind() {
			return QPXAirfareResponseEnum.tripAirportCity.getQpxTypeVal();
		}
		/**
		 * @param kind the kind to set
		 */
		public void setKind(String kind) {
			this.kind = kind;
		}
		/**
		 * @return the code
		 */
		public String getCode() {
			return code;
		}
		/**
		 * @param code the code to set
		 */
		public void setCode(String code) {
			this.code = code;
		}
		/**
		 * @return the country
		 */
		public String getCountry() {
			return country;
		}
		/**
		 * @param country the country to set
		 */
		public void setCountry(String country) {
			this.country = country;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
}
