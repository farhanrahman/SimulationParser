/**
 * 
 */
package com.data;

import java.util.Collection;

/**
 * @author farhanrahman
 *
 */
public class Countries {
	private Collection<Country> countries;

	public Collection<Country> getCountries() {
		return countries;
	}

	public void setCountries(Collection<Country> countries) {
		this.countries = countries;
	}
	
	public String toString(){
		String s = "";
		for(Country c : countries){
			s += c.toString();
			s += "\n";
		}
		return s;
	}
}
