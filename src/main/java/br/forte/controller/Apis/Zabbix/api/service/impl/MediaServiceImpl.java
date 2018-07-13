package br.forte.controller.Apis.Zabbix.api.service.impl;
import java.io.IOException;
import java.util.logging.Logger;

import br.forte.controller.Apis.Zabbix.api.domain.media.MediaGetRequest;
import br.forte.controller.Apis.Zabbix.api.service.IMediaService;
import br.forte.controller.Apis.Zabbix.util.FormatData;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class MediaServiceImpl implements IMediaService {
	private static Logger log = Logger.getLogger("allmoniapi");
	public Object get(MediaGetRequest get){
		Object result = null;
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
			if (rs.has("result")) {
				result = rs.get("result");
			}
			 else if (rs.has("error")) {
				result = rs.get("error");
			}
		}
		 catch (HttpException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
		 catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}
}
