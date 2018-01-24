package soom.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface ApiService {
	JSONObject detailView(String movieCode) throws Exception;

	JSONArray listView() throws Exception;

	JSONObject searchView(String moviceName) throws Exception;
}
