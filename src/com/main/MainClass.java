/**
 * 
 */
package com.main;

import com.mymongo.MongoConnector;

/**
 * @author farhanrahman
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MongoConnector mongo = new MongoConnector();
		mongo.testConnection();
	}

}
