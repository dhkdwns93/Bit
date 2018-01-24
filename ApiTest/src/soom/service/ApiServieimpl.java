package soom.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import soom.aao.ApiAO;
import soom.aao.ApiAOimpl;

public class ApiServieimpl implements ApiService {

	ApiAO aao = new ApiAOimpl();

	@Override
	public JSONObject detailView(String movieCode) throws Exception {

		if (movieCode == "" || movieCode.isEmpty()) {
			throw new Exception("�˻��� ������ �����ϴ�.");
		}
		return aao.detailView(movieCode);
	}

	@Override
	public JSONArray listView() throws Exception {
		JSONArray jArr = aao.listView();
		if (jArr.isEmpty() || jArr == null) {
			throw new Exception("�˻� ����� �����ϴ�.");
		}
		return jArr;
	}

	@Override
	public JSONObject searchView(String movieName) throws Exception {
		if (movieName == "" || movieName == null) {
			throw new Exception("�Է��� �˻����ּ���.");
		}
		return aao.searchView(movieName);
	}

}
