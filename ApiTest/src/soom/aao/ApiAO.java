package soom.aao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface ApiAO {
	JSONObject detailView(String movieCode) throws Exception;//�󼼺���

	JSONArray listView() throws Exception;//listing
	
	JSONObject searchView(String movieName) throws Exception;
}
