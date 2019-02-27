package org.naveenkumar.jiofiinfo.util;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.naveenkumar.jiofiinfo.JioFiException;
import org.w3c.dom.Document;

public class NetworkUtil {
	private static DocumentBuilderFactory documentBuilderFactory;
	private static DocumentBuilder documentBuilder;

	public static Document getDocumentFromUrl(String url) {
		try {
			URL lteUrl = new URL(url);
			InputStream stream = lteUrl.openStream();
			Document doc = getDocumentBuilder().parse(stream);
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
			throw new JioFiException(e.getMessage());
		}
	}
	
	public static DocumentBuilder getDocumentBuilder() {
		if (documentBuilder == null) {
			try {
				documentBuilder = getDocumentBuilderFactory().newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw new JioFiException(e.getMessage());
			}
		}
		return documentBuilder;
	}

	public static DocumentBuilderFactory getDocumentBuilderFactory() {
		if (documentBuilderFactory == null) {
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
		}
		return documentBuilderFactory;
	}
}
