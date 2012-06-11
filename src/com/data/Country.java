package com.data;


/**
 * 
 * @author farhanrahman
 *
 */
public class Country {
	private CountryData countryData = new CountryData();
	private String id;
	public CountryData getCountries() {
		return countryData;
	}

	public void setCountries(CountryData countryData) {
		this.countryData = countryData;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String toString(){
		String s = "";
		s += "id: " + id;
		s += "countryData: " + countryData.toString();
		return s;
	}	
}
