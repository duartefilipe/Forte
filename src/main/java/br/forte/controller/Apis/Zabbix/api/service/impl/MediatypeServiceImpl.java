package br.forte.controller.Apis.Zabbix.api.service.impl;
import java.io.IOException;

import br.forte.controller.Apis.Zabbix.api.domain.mediatype.MediaTypeCreateRequest;
import br.forte.controller.Apis.Zabbix.api.domain.mediatype.MediaTypeDeleteRequest;
import br.forte.controller.Apis.Zabbix.api.domain.mediatype.MediaTypeGetRequest;
import br.forte.controller.Apis.Zabbix.api.domain.mediatype.MediaTypeUpdateRequest;
import br.forte.controller.Apis.Zabbix.api.service.IMediatypeService;
import br.forte.controller.Apis.Zabbix.util.FormatData;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class MediatypeServiceImpl implements IMediatypeService {
	public Object mediaTypeCreate(MediaTypeCreateRequest mediaTypeCreate){
		Object result = null;
		Gson js = new Gson();
		HttpClient client = new HttpClient();
		PostMethod putMethod = new PostMethod(FormatData.API_URL);
		putMethod.setRequestHeader("Content-Type", "application/json-rpc");
		JSONObject rs =null;
		try {
			System.out.println(js.toJson(mediaTypeCreate));
			putMethod.setRequestBody( FormatData.fromString(js.toJson(mediaTypeCreate)));
			client.executeMethod(putMethod);
			String response = putMethod.getResponseBodyAsString();
			System.out.println(response);
			 rs = new JSONObject(response);
			System.out.println(rs);
//			if (rs.has("result")) {
//				result = rs.get("result");
//			}
//			 else if (rs.has("error")) {
//				result = rs.get("error");
//			}
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
		return rs;
	}
	public Object mediaTypeDelete(MediaTypeDeleteRequest mediaTypeDelete){
		Object result = null;
		Gson js = new Gson();
		HttpClient client = new HttpClient();
		PostMethod putMethod = new PostMethod(FormatData.API_URL);
		putMethod.setRequestHeader("Content-Type", "application/json-rpc");
		JSONObject rs =null;
		try {
			System.out.println(js.toJson(mediaTypeDelete));
			putMethod.setRequestBody( FormatData.fromString(js.toJson(mediaTypeDelete)));
			client.executeMethod(putMethod);
			String response = putMethod.getResponseBodyAsString();
			System.out.println(response);
			 rs = new JSONObject(response);
			System.out.println(rs);
//			if (rs.has("result")) {
//				result = rs.get("result");
//			}
//			 else if (rs.has("error")) {
//				result = rs.get("error");
//			}
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
		return rs;
	}
	public Object mediaTypeGet(MediaTypeGetRequest mediaTypeGet){
		Object result = null;
		Gson js = new Gson();
		HttpClient client = new HttpClient();
		PostMethod putMethod = new PostMethod(FormatData.API_URL);
		putMethod.setRequestHeader("Content-Type", "application/json-rpc");
		JSONObject rs =null;
		try {
			System.out.println(js.toJson(mediaTypeGet));
			putMethod.setRequestBody( FormatData.fromString(js.toJson(mediaTypeGet)));
			client.executeMethod(putMethod);
			String response = putMethod.getResponseBodyAsString();
//			System.out.println(response);
			 rs = new JSONObject(response);
//			System.out.println(rs);
//			if (rs.has("result")) {
//				result = rs.get("result");
//			}
//			 else if (rs.has("error")) {
//				result = rs.get("error");
//			}
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
		return rs;
	}
	public Object mediaTypeUpdate(MediaTypeUpdateRequest mediaTypeUpdate){
		Object result = null;
		Gson js = new Gson();
		HttpClient client = new HttpClient();
		PostMethod putMethod = new PostMethod(FormatData.API_URL);
		putMethod.setRequestHeader("Content-Type", "application/json-rpc");
		JSONObject rs =null;
		try {
			System.out.println(js.toJson(mediaTypeUpdate));
			putMethod.setRequestBody( FormatData.fromString(js.toJson(mediaTypeUpdate)));
			client.executeMethod(putMethod);
			String response = putMethod.getResponseBodyAsString();
			System.out.println(response);
			 rs = new JSONObject(response);
			System.out.println(rs);
//			if (rs.has("result")) {
//				result = rs.get("result");
//			}
//			 else if (rs.has("error")) {
//				result = rs.get("error");
//			}
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
		return rs;
	}
}
