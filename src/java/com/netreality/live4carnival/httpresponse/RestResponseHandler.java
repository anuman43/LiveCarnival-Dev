/**
 * @date Jun 10, 2015
 */
package com.netreality.live4carnival.httpresponse;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

/**
 * @author ldurh516
 *
 * @date Jun 10, 2015
 *	
 */
public class RestResponseHandler implements ResponseErrorHandler {
	
	private Logger _log = Logger.getLogger(RestResponseHandler.class);

	/* (non-Javadoc)
	 * @see org.springframework.web.client.ResponseErrorHandler#handleError(org.springframework.http.client.ClientHttpResponse)
	 */
	@Override
	public void handleError(ClientHttpResponse errorResp) throws IOException {
		
		_log.error(errorResp);

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.client.ResponseErrorHandler#hasError(org.springframework.http.client.ClientHttpResponse)
	 */
	@Override
	public boolean hasError(ClientHttpResponse httpResp) throws IOException {
		if(httpResp != null && httpResp.getStatusText() != null)
			return false;
	else
			return true;
	}

}
