/**
 * 
 */
package com.data;

import java.util.Map;

/**
 * Datafield to parse
 * countries on their own 
 * @author farhanrahman
 *
 */
public class Countries {
	private Map<String,CountryData> countries;

	public Map<String,CountryData> getCountries(){return countries;}
	public void setCountries(Map<String,CountryData> countries){this.countries = countries;}
	
	public String toString(){
		String s = "";
		if(countries == null){
			System.out.println("Problem");
		}
		for(String key : countries.keySet()){
			s += countries.get(key).toString();
		}
		return s;
	}
}
