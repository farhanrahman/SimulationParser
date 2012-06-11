/**
 * 
 */
package com.data;

import java.util.Map;

/**
 * @author farhanrahman
 *
 */
public class Countries {
	private Map<String,CountryData> countries;

	public Map<String,CountryData> getCountries(){return countries;}
	public void setCountries(Map<String,CountryData> countries){this.countries = countries;}
	
	public String toString(){
		String s = "";
		for(String key : countries.keySet()){
			s += countries.get(key).toString();
			s += "\n";
		}
		return s;
	}
}
