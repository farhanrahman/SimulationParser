/**
 * 
 */
package com.mymongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.beanutils.DynaBean;
import org.bson.BSONObject;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.data.Countries;
import com.data.Country;
import com.data.CountryData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

/**
 * @author farhanrahman
 *
 */
public class MongoConnector {

	private Integer port = 27017;
	private String host = "localhost";
	private String dbName = "presage";
	
	private String username = "";
	private String password = "";
	
	private Mongo m;
	private DB db;
	
	private final boolean SHOULD_AUTHENTICATE;
	
	/**
	 * 
	 */
	
	public MongoConnector(){
		this.SHOULD_AUTHENTICATE = false;
		try {
			this.m = new Mongo(this.host, this.port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
		
	}
	
	public MongoConnector(String host, String port, String dbName, String username, String password){
		this.port = Integer.parseInt(port);
		this.host = host;
		this.dbName = dbName;
		this.username = username;
		this.password = password;
		this.SHOULD_AUTHENTICATE = true;		
	}	
	
	public MongoConnector(String host, String port, String dbName) {
		this.SHOULD_AUTHENTICATE = false;
		this.port = Integer.parseInt(port);
		this.host = host;
		this.dbName = dbName;
	}
	
	private void openConnection(){
		try {
			this.m = new Mongo(this.host,this.port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}		
	}
	
	private void closeConnection(){
		if(this.m != null){
			this.m.close();
		}
	}
	
	private boolean authenticate(){
		if(this.db != null){
			return db.authenticate(username, this.password.toCharArray());
		}else{
			return false;
		}
	}
	
	public void testConnection(){
		this.openConnection();
		this.db = m.getDB(this.dbName);
		
		if(this.SHOULD_AUTHENTICATE == true){
			this.authenticate();
		}
		/*QUERY AND TEST*/
		
		Set<String> colls = db.getCollectionNames();

		for (String s : colls) {
		    System.out.println(s);
		}
		
		DBCollection collection = db.getCollection("simulations");
        BasicDBObject query = new BasicDBObject();
        
        query.put("_id", 8);
        
        List<DBObject> obj = collection.find(query).toArray();
        for(DBObject d : obj){
        	//System.out.println(d);
        	for(String key : d.keySet()){
        		//if(key.equals("countries")){
        		//	Country c = new Gson().fromJson(d.get(key).toString(), Country.class);
        		//	c.output();
        		//}
        		//String json = "{ 'Type' : 'Group 1/2' , 'name' : 'Australia' , 'ISO' : 'AUS' , 'agentName' : 'EU' , 'Ratified' : '39419' , 'totalArea' : '7692024' , 'landArea' : '7682300' , 'waterArea' : '58920' , 'arableLandArea' : '468503' , 'GDP' : '3.00893E+11' , 'GDPRate' : '0' , 'availableToSpend' : '0' , 'emissionsTarget' : '305994' , 'carbonOffset' : '0' , 'energyOutput' : '423248' , 'carbonOutput' : '0'}";
                
        		if(key.equals("countries")){
        			//System.out.println(d.get(key));
        			Gson gson = new GsonBuilder().create();
        			String json = "{'AUS':{ 'Type' : 'Group 1/2' , 'name' : 'Australia' , 'ISO' : 'AUS' , 'agentName' : 'EU' , 'Ratified' : '39419' , 'totalArea' : '7692024' , 'landArea' : '7682300' , 'waterArea' : '58920' , 'arableLandArea' : '468503' , 'GDP' : '3.00893E+11' , 'GDPRate' : '0' , 'availableToSpend' : '0' , 'emissionsTarget' : '305994' , 'carbonOffset' : '0' , 'energyOutput' : '423248' , 'carbonOutput' : '0'}}";
        			Country data = gson.fromJson(json, Country.class);
        			System.out.println(data.toString());
                }
        	}
        }
        
		this.closeConnection();
	}
	

	/*======GETTERS AND SETTERS=====*/
	
	public Integer getPort() {
		return port;
	}
	
	public void setPort(Integer port) {
		this.port = port;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
