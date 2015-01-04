package com.github.pirent.weather.yahoo;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

import com.github.pirent.weather.Weather;
import com.github.pirent.weather.WeatherFormatter;
import com.github.pirent.weather.YahooParser;

public class WeatherFormaterTest extends TestCase {

	public WeatherFormaterTest(String name) {
		super(name);
	}

	public void testFormat() throws Exception {
		InputStream data = getClass().getClassLoader().getResourceAsStream(
				"ny-weather.xml");
		Weather weather = new YahooParser().parse(data);

		String formattedResult = new WeatherFormatter().format(weather);

		InputStream expected = getClass().getClassLoader().getResourceAsStream(
				"format-expected.dat");

		assertEquals(IOUtils.toString(expected).trim(), formattedResult.trim());
	}
}
