package soom.aao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import soom.util.ApiConnection;

public class ApiAOimpl implements ApiAO {
	KobisOpenAPIRestService rest = null;

	@Override
	public JSONObject detailView(String movieCode) throws Exception {

		rest = ApiConnection.getInstance();
		String detail = rest.getMovieInfo(true, movieCode);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(detail);
		JSONObject jObj = (JSONObject) ((JSONObject) ((JSONObject) obj).get("movieInfoResult")).get("movieInfo");
		return jObj;

	}

	@Override
	public JSONArray listView() throws Exception {
		rest = ApiConnection.getInstance();
		/*
		 * 당일 날짜의 데이터는 제공하지않아서 전날의 데이터를 가져옵니다.
		 */
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, -1);
		String date = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		JSONParser parser = new JSONParser();
		String listJson = rest.getDailyBoxOffice(true, date, "20", null, null, null);// json의향 ,
																						// 날짜,데이터수,영화종류,한국영화?외국영화?,지역코드
		Object obj = parser.parse(listJson);
		JSONArray jArr = (JSONArray) ((JSONObject) ((JSONObject) obj).get("boxOfficeResult")).get("dailyBoxOfficeList");// json
																														// parsing
		return jArr;
	}

	@Override
	public JSONObject searchView(String movieName) throws Exception {
		rest = ApiConnection.getInstance();
		String searchJson = rest.getMovieList(true, "1", "20", movieName, null, null, null, null, null, null, null);// json의향,페이지수,한페이지당
		// row수,moviename
		JSONParser parser = new JSONParser();
		JSONObject jObj = (JSONObject) ((JSONObject) parser.parse(searchJson)).get("movieListResult");

		return jObj;
	}

}
