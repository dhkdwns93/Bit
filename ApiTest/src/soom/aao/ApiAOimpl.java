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
		 * ���� ��¥�� �����ʹ� ���������ʾƼ� ������ �����͸� �����ɴϴ�.
		 */
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, -1);
		String date = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		JSONParser parser = new JSONParser();
		String listJson = rest.getDailyBoxOffice(true, date, "20", null, null, null);// json���� ,
																						// ��¥,�����ͼ�,��ȭ����,�ѱ���ȭ?�ܱ���ȭ?,�����ڵ�
		Object obj = parser.parse(listJson);
		JSONArray jArr = (JSONArray) ((JSONObject) ((JSONObject) obj).get("boxOfficeResult")).get("dailyBoxOfficeList");// json
																														// parsing
		return jArr;
	}

	@Override
	public JSONObject searchView(String movieName) throws Exception {
		rest = ApiConnection.getInstance();
		String searchJson = rest.getMovieList(true, "1", "20", movieName, null, null, null, null, null, null, null);// json����,��������,����������
		// row��,moviename
		JSONParser parser = new JSONParser();
		JSONObject jObj = (JSONObject) ((JSONObject) parser.parse(searchJson)).get("movieListResult");

		return jObj;
	}

}
