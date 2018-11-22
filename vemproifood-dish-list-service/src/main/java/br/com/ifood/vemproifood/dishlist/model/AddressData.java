package br.com.ifood.vemproifood.dishlist.model;

import java.util.List;

public class AddressData {

	private List<AddressComponent> address_components;

	public List<AddressComponent> getAddress_components() {
		return address_components;
	}

	public void setAddress_components(List<AddressComponent> address_components) {
		this.address_components = address_components;
	}
}
