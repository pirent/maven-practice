package com.github.pirent.weather;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;

public class Main {
	
	private static final String DEFAULT_ZIP_CODE = "60202";
	private String zip;
	
	public Main(String zip) {
		this.zip = zip;
	}

	public static void main(String[] args) throws Exception {
		// Configure log4j
		PropertyConfigurator.configure(Main.class.getClassLoader().getResource(
				"log4j.properties"));
		
		// Read zip code from command line
		// If not provided, use the default value
		String zipcode = DEFAULT_ZIP_CODE;
		
		try {
			zipcode = args[0];
		}
		catch (Exception e) {
			// In case of argument is not provided
			// Ignore the exception to keep program running
		}
		
		// Start the program
		new Main(zipcode).start();
	}

	public void start() throws Exception {
		// Retrieve data
		InputStream dataIn = new YahooRetriever().retrieve(zip);
		
		// Parse data
		Weather weather = new YahooParser().parse(dataIn);
		
		// Format data
		System.out.println(new WeatherFormatter().format(weather));
	}
}
