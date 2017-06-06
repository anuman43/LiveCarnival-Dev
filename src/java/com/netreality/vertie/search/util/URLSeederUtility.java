/**
 * @date May 22, 2015
 */
package com.netreality.vertie.search.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * @author ldurh516
 *
 * @date May 22, 2015
 *	
 */
public class URLSeederUtility {
	
	private static String URL_SEED_FILE_NAME = "E:\\Vertie\\VertieData\\SchedulerURLs.txt";
	private static String URL_SEED_FILE_ERROR_MESSAGE = "Unable to locate or open scheduler seed file";
	private static Logger _log = Logger.getLogger(URLSeederUtility.class);
	
	
	public static Integer populateScheduler(String seedFile)
	{
		File seederFile = null;
		Scanner scn = null;
		Integer urlSeeds = 0;
		String urlEntry = null;
		List<String> schedList = null;
		
		if(seedFile != null)
		{
			seederFile = new File(seedFile);
			
			
		}
		else
		{
			seederFile = new File(URL_SEED_FILE_NAME);		
			
		}
		
		if(seederFile.exists())
		{
			try {
				scn = new Scanner(seederFile);
				while(scn.hasNext())
				{
					urlEntry = scn.next();
					_log.debug(urlEntry);
					urlSeeds ++;
				}
					
			} catch (FileNotFoundException ffe) {
				_log.error(ffe);
			}
			finally
			{
				scn.close();
			}
		}
		else
		{
			_log.error(URL_SEED_FILE_ERROR_MESSAGE);
		}
		
		return urlSeeds;
	}
	
	public static List<String> createUrlScheduleList(String seedFile)
	{
		List<String> schedList = null;
		File seederFile = null;
		Scanner scn = null;
		String seedUrlStr = null;
		
		if(seedFile != null)
		{
			seederFile = new File(seedFile);
			
			
		}
		else
		{
			seederFile = new File(URL_SEED_FILE_NAME);		
			
		}
		
		if(seederFile.exists())
		{
			schedList = new ArrayList<String>();
			try {
				scn = new Scanner(seederFile);
				while(scn.hasNext())
				{
					seedUrlStr = scn.next();
					_log.debug(seedUrlStr);
					if(seedUrlStr != null)schedList.add(seedUrlStr);
				}
					
			} catch (FileNotFoundException ffe) {
				_log.error(ffe);
			}
			finally
			{
				scn.close();
			}
			
		}
		else
		{
			_log.error(URL_SEED_FILE_ERROR_MESSAGE);
		}
		
		
		return schedList;
	}
	
}
