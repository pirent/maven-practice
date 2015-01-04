package com.github.pirent.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class YahooRetriever {

	private static Logger log = Logger.getLogger(YahooRetriever.class);
	private static final String YAHOO_URL = "http://weather.yahooapis.com/forecastrss?p=";

	public InputStream retrieve(String zip) throws Exception {
		log.info("Retrieving Weather Data...");
		String url = YAHOO_URL + zip;
		URLConnection conn = new URL(url).openConnection();
		return conn.getInputStream();
	}

}
