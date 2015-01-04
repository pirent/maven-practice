package com.github.pirent.weather;

import java.io.InputStream;

public class WeatherService {

	public WeatherService() {}

	public String retrieveForecast(String zip) throws Exception {
		// Retrieve data
		InputStream dataIn = new YahooRetriever().retrieve(zip);

		// Parse data
		Weather weather = new YahooParser().parse(dataIn);

		// Format data
		return new WeatherFormatter().format(weather);
	}
}