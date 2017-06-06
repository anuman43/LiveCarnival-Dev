/**
 * 
 */
package com.netreality.livecarnival.search;

import org.apache.log4j.Logger;

/**
 * @author JahLion
 *
 */
public class GoogleCSESearchHelper {
	
	private static String CSE_GOOGLE_LIVECARNIVALBETA_ENGINE_ID = "003115069608776384649:rrhitb9ek_0";
	private static String CSE_GOOGLE_DEVELOPER_API_KEY = "AIzaSyAmuWfqdXhmD1HarV1v6RPA1CIS_jZ4rzY";
	private static String API_KEY_PARAM ="key=";
	private static String CSE_REST_TARGET_URL ="https://www.googleapis.com/customsearch/v1";
	private static String CSE_CLIENT_PARAM_KEY ="client=";
	private static String CSE_CLIENT_PARAM_VALUE = "google-csbe";
	private static String CSE_ID_PARAM_KEY = "cx=";
	private static String CSE_OUTPUT_PARAM_KEY = "output=";
	private static String CSE_OUTPUT_PARAM_VALUE = "xml";
	private static String CSE_SEARCH_QRY_WORDS_PARAM = "q=";
	private static String PARAM_ARG_SEPERATOR ="&";
	private static String CSE_QUERY_RESULTS_NUM = "10";
	private static String CSE_QUERY_RESULTS_PARAM_NAME = "num=";
	
	private static Logger _log = Logger.getLogger(GoogleCSESearchHelper.class);
	
	public static String buildCSERestSearchQry(String searchTerms)
	{
		String restSrchReqStr = "";
		restSrchReqStr +=  API_KEY_PARAM + CSE_GOOGLE_DEVELOPER_API_KEY + PARAM_ARG_SEPERATOR;
		restSrchReqStr += CSE_ID_PARAM_KEY + CSE_GOOGLE_LIVECARNIVALBETA_ENGINE_ID + PARAM_ARG_SEPERATOR;
		restSrchReqStr += CSE_CLIENT_PARAM_KEY + CSE_CLIENT_PARAM_VALUE + PARAM_ARG_SEPERATOR;
		restSrchReqStr += CSE_OUTPUT_PARAM_KEY + CSE_OUTPUT_PARAM_VALUE + PARAM_ARG_SEPERATOR;
		restSrchReqStr += CSE_QUERY_RESULTS_PARAM_NAME + CSE_QUERY_RESULTS_NUM + PARAM_ARG_SEPERATOR;
		restSrchReqStr += CSE_SEARCH_QRY_WORDS_PARAM + searchTerms;
		
		_log.debug("Google CSE search request is-" + restSrchReqStr);
		
		return restSrchReqStr;
	}

}
