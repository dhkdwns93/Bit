package mini.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mini.aao.ApiAO;
import mini.aao.ApiAOimpl;

public class ApiServieimpl implements ApiService {

	ApiAO aao = new ApiAOimpl();

	@Override
	public JSONObject detailView(String movieCode) throws Exception {

		if (movieCode == "" || movieCode.isEmpty()) {
			throw new Exception("검색할 내용이 없습니다.");
		}
		return aao.detailView(movieCode);
	}

	@Override
	public JSONArray listView() throws Exception {
		JSONArray jArr = aao.listView();
		if (jArr.isEmpty() || jArr == null) {
			throw new Exception("검색 결과가 없습니다.");
		}
		return jArr;
	}

	@Override
	public JSONObject searchView(String movieName) throws Exception {
		if (movieName == "" || movieName == null) {
			throw new Exception("입력후 검색해주세요.");
		}
		return aao.searchView(movieName);
	}

}
