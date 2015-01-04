package com.github.pirent.web;

import com.github.pirent.weather.WeatherService;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WeatherServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String zip = request.getParameter("zip");
		WeatherService weatherService = new WeatherService();
		PrintWriter out = response.getWriter();

		try {
			out.println(weatherService.retrieveForecast(zip));
		}
		catch (Exception e) {
			out.println("Errow while retrieving forecast: " + e.getMessage());
		}
		out.flush();
		out.close();
	}
}