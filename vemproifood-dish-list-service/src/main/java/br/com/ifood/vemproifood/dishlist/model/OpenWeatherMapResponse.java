package br.com.ifood.vemproifood.dishlist.model;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;

public class OpenWeatherMapResponse {

	private MainInformations main;

	@VisibleForTesting
	static OpenWeatherMapResponse withTemperature(final double temperature) {
		final OpenWeatherMapResponse response = new OpenWeatherMapResponse();
		response.main = new MainInformations();
		response.main.temp = temperature;	
		
		return response;
	}

	public MainInformations getMain() {
		return main;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("main", main)
				.toString();
	}

	public static class MainInformations {
		private double temp;

		public double getTemp() {
			return temp;
		}

		@Override
		public String toString() {
			return MoreObjects.toStringHelper(this)
					.add("temp", temp)
					.toString();
		}
	}
}