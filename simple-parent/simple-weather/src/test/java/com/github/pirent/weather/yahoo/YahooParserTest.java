package com.github.pirent.weather.yahoo;

import java.io.InputStream;

import junit.framework.TestCase;

import com.github.pirent.weather.Weather;
import com.github.pirent.weather.YahooParser;

public class YahooParserTest extends TestCase {

	public YahooParserTest(String name) {
		super(name);
	}
	
	public void testParser() throws Exception {
		InputStream data = getClass().getClassLoader().getResourceAsStream("ny-weather.xml");
		
		Weather weather = new YahooParser().parse(data);
		
		assertEquals("New York", weather.getCity() );
        assertEquals("NY", weather.getRegion() );
        assertEquals("US", weather.getCountry() );
        assertEquals("39", weather.getTemp() );
        assertEquals("Fair", weather.getCondition() );
        assertEquals("39", weather.getChill() );
        assertEquals("67", weather.getHumidity() );
	}
}
