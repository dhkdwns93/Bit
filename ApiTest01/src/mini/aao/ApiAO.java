package mini.aao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface ApiAO {//ApiAccessObject
	JSONObject detailView(String movieCode) throws Exception;//상세보기

	JSONArray listView() throws Exception;//listing을 위해 Array로 반환
	
	JSONObject searchView(String movieName) throws Exception;//영화 이름으로 검색
}
