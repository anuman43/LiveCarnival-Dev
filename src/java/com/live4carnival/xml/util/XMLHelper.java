/**
 * 
 */
package com.live4carnival.xml.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jboss.logging.Logger;

/**
 * @author JahLion
 *
 */
public class XMLHelper {
	
	
	private static Logger _log = Logger.getLogger(XMLHelper.class);
	
	
	public static List<String> getElementsAsCollection(String elementName,File xmlFile)
	{
		List<String> elemList = null;
		Document xmlDoc = null;
		SAXReader reader = null;
		String subNameElement = "name";
		
		if(elementName != null && xmlFile.exists())
		{
			reader = new SAXReader();
			try {
				xmlDoc = reader.read(xmlFile);
			} catch (DocumentException dxe) {
				_log.error(dxe);
			}
			Element rootEle = xmlDoc.getRootElement();
			List<Element> elements = rootEle.elements(elementName);
			_log.debug("Found-" + elements.size() + " elements");
			elemList = new ArrayList<String>();
			for(Element ele : elements)
			{
				if(ele != null)
				{
					Element name = ele.element(subNameElement);
					_log.debug(name.getStringValue());
					elemList.add(name.getStringValue());
				}
			}
		}
		
		
		return elemList;
		
	}

}
