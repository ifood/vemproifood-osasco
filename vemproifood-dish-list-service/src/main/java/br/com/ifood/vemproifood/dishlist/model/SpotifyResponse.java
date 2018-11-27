package br.com.ifood.vemproifood.dishlist.model;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;



public class SpotifyResponse {
	
	private MainInformations main;

	@VisibleForTesting
	static SpotifyResponse getTrack(final String track) {
		final SpotifyResponse response = new SpotifyResponse();
		response.main = new MainInformations();
		response.main.temp = track;
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
		private String temp;

		public String getTemp() {
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
