package br.forte.controller.Apis.Zabbix.api.service.impl;

import br.forte.controller.Apis.Zabbix.api.domain.base.IntegerHistory;
import br.forte.controller.Apis.Zabbix.api.domain.history.HistoryGetRequest;
import br.forte.controller.Apis.Zabbix.api.service.IHistoryService;
import br.forte.controller.Apis.Zabbix.util.FormatData;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class HistoryServiceImpl implements IHistoryService {
	private static Logger log = Logger.getLogger(String.valueOf(HistoryServiceImpl.class));
	
	public Object get(HistoryGetRequest get){
		Gson js = new Gson();
		HttpClient client = new HttpClient();
		PostMethod putMethod = new PostMethod(FormatData.API_URL);
		putMethod.setRequestHeader("Content-Type", "application/json-rpc");
		JSONObject rs =null;
		try {
			String json = js.toJson(get);
			log.info("json request:"+json);
			putMethod.setRequestBody( FormatData.fromString(json));
			client.executeMethod(putMethod);
			String response = putMethod.getResponseBodyAsString();
			log.info("json response:"+response);
			 rs = new JSONObject(response);
//			 System.out.println(rs);
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<IntegerHistory> getHistoryToBean(HistoryGetRequest get, int type) {
		JSONObject result = (JSONObject) this.get(get);
		List<IntegerHistory> histories = null;
		if (result.has("result")) {
			try {
				JSONArray array = result.getJSONArray("result");
				if(array!=null&&array.length()>0){
					histories = new ArrayList<IntegerHistory>();
					for(int i=0;i<array.length();i++){
						JSONObject object = array.getJSONObject(i);
						IntegerHistory history = new IntegerHistory();
						history.setClock(object.getString("clock"));
						history.setItemid(object.getString("itemid"));
						history.setNs(object.getInt("ns"));
						history.setValue(object.getString("value"));
						history.setType(type);
						histories.add(history);
						
					}
				}
			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}
			return histories;
		}else if (result.has("error")) {
			return null;
		}
		return histories;
	}
}
