/**
 * 
 */
package main;

import main.data.DataProvider;
import main.data.JSONObjectContainer;
import main.data.SimulationData;

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
