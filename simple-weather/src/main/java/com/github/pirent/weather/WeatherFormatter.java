package com.github.pirent.weather;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class WeatherFormatter {

	private static final Logger LOG = Logger.getLogger(WeatherFormatter.class);

	public String format(Weather weather) throws Exception {
		LOG.info("Formatting Weather Data...");
		Reader reader = new InputStreamReader(getClass().getClassLoader()
				.getResourceAsStream("output.vm"));

		VelocityContext context = new VelocityContext();
		context.put("weather", weather);

		StringWriter writer = new StringWriter();
		Velocity.evaluate(context, writer, "", reader);
		return writer.toString();
	}

}
