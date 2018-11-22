package br.com.ifood.vemproifood.dishlist.model;

import java.util.List;

public class GoogleMapsResponse {

	private List<AddressData> results;

	public List<AddressData> getResults() {
		return results;
	}

	public void setResults(List<AddressData> results) {
		this.results = results;
	}
}
