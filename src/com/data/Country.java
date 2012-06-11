package com.data;


/**
 * 
 * @author farhanrahman
 *
 */
public class Country {
	private CountryData countryData;
	public CountryData getCountries(){return countryData;}
	public void setCountries(CountryData countryData){this.countryData = countryData;}
	
	public String toString(){
		String s = "";
		s += "countryData: " + countryData.toString();
		return s;
	}	
}
