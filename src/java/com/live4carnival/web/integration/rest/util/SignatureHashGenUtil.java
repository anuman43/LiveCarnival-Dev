/**
 * 
 */
package com.live4carnival.web.integration.rest.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author JahLion
 *
 */
public class SignatureHashGenUtil {
	
	public static String genEANSigHash(String apiKey, String secretStr)
	{
		String genHash = null;
		String inputStr = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			Long timeInSeconds = (System.currentTimeMillis() / 1000);
			inputStr = apiKey + secretStr + timeInSeconds;
			md.update(inputStr.getBytes());
			genHash = String.format("%032x",	new BigInteger(1, md.digest()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return genHash;
	}

}
