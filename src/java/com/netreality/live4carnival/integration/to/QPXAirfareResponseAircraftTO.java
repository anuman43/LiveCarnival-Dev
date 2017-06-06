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
public class QPXAirfareResponseAircraftTO {

		private String kind = QPXAirfareResponseEnum.tripAirportAircraft.getQpxTypeVal();
		private String code;
		private String name;
		/**
		 * @return the kind
		 */
		public String getKind() {
			return QPXAirfareResponseEnum.tripAirportAircraft.getQpxTypeVal();
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
