/**
 * 
 */
package com.main;

import com.data.DataProvider;
import com.data.JSONObjectContainer;
import com.data.SimulationData;

/**
 * @author farhanrahman
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataProvider d = new DataProvider();
		JSONObjectContainer<SimulationData> o = d.getSimulationData(2);
		System.out.println(o.getObject().toString());
	}

}
