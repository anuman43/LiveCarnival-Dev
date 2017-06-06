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
public class QPXAirfareResponseSegPricing {
	
		private String kind;
		private String fareId;
		private String segmentId;
		private List<QPXAirfareFreeBaggageTO> freeBaggageOption;
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
		 * @return the fareId
		 */
		public String getFareId() {
			return fareId;
		}
		/**
		 * @param fareId the fareId to set
		 */
		public void setFareId(String fareId) {
			this.fareId = fareId;
		}
		/**
		 * @return the segmentId
		 */
		public String getSegmentId() {
			return segmentId;
		}
		/**
		 * @param segmentId the segmentId to set
		 */
		public void setSegmentId(String segmentId) {
			this.segmentId = segmentId;
		}

}
