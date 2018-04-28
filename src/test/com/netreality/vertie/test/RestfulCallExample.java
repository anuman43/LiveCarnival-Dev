package com.netreality.vertie.test;


import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse; 
import org.apache.http.client.methods.HttpGet; 
import org.apache.http.impl.client.DefaultHttpClient; 


@SuppressWarnings("deprecation")
public class RestfulCallExample 
{   
	public static String service = "http://api.ean.com/ean-services/rs/hotel/";
	public static String version = "v3/"; 
	public static String method = "list";  
	public static String hotelId ="201252"; 
	public static String otherElementsStr = "&cid=55505&minorRev=[x]" +	"&customerUserAgent=[xxx]&customerIpAddress=[xxx]&locale=en_US&currencyCode=USD";
	public static String apikey = "xxx-YourAPIkey-xxx";
	public static String secret = "xxYourSecretxx";
	
		public static void main(String[] args) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		long timeInSeconds = (System.currentTimeMillis() / 1000);
		String input = 		apikey + secret + timeInSeconds;
		md.update(input.getBytes()); 
		String sig = String.format("%032x",	new BigInteger(1, md.digest())); 
		String url = service + version + method+ "?apikey=" + apikey  + "&sig=" + sig + otherElementsStr + "hotelIdList=" + hotelId;
		System.out.println("URL = " + url); DefaultHttpClient httpclient = new DefaultHttpClient(); 
		// Create an HTTP GET request
		HttpGet httpget = new HttpGet(url);  // Execute the request 
		httpget.getRequestLine(); HttpResponse response = null; try {
		response = httpclient.execute(httpget); } catch (IOException e) {  e.printStackTrace(); return; }   HttpEntity entity =
				response.getEntity(); // Print the response
		System.out.println(response.getStatusLine());  if (entity != null) {  try {
		InputStream inputStream = entity.getContent(); // Process the response
		BufferedReader bufferedReader = new BufferedReader(  new
		InputStreamReader(inputStream)); String line; while ((line = bufferedReader.readLine()) != null) {  System.out.println(line); }
		bufferedReader.close();  } catch (IOException e) { e.printStackTrace();  } } // shut down the connection manager to free up system resources.
		httpclient.getConnectionManager().shutdown();  } }

