package br.forte.controller.Apis.Zabbix.api.test;

import java.util.ArrayList;
import java.util.List;

import br.forte.DAO.UsuarioDao;
import br.forte.controller.Apis.Zabbix.api.domain.base.HostGroup;
import br.forte.controller.Apis.Zabbix.api.domain.hostgroup.*;
import br.forte.controller.Apis.Zabbix.api.service.IHostgroupService;
import br.forte.controller.Apis.Zabbix.api.service.impl.HostgroupServiceImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import junit.framework.TestCase;



public class TestHostgroup extends TestCase {
//	private static IHostgroupService hostgroupService = new HostgroupServiceImpl();
//	static {
//		System.out.println("ta aqui no login do zabbix dao");
//		new UsuarioDao().login();
//	}
//	public void testHostGroupCreate() {
//
//		HostGroupCreateRequest hostGroupCreate = new HostGroupCreateRequest();
//
//		HostGroup hostGroup = new HostGroup();
//		hostGroup.setName("teste");
//		hostGroupCreate.getParams().add(hostGroup);
////
////		hostGroup = new HostGroup();
////		hostGroup.setName("testHost2a");
////		hostGroupCreate.getParams().add(hostGroup);
//
//		JSONObject rs = (JSONObject) hostgroupService.hostGroupCreate(hostGroupCreate);
//		if (rs.has("result")) {
//			try {
//				JSONObject result =(JSONObject) rs.get("result");
//				JSONArray ids  = (JSONArray) result.get("groupids");
//				String id = (String) ids.get(0);
//				System.out.println(id);
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		 else if (rs.has("error")) {
//		    try {
//		       	JSONObject result = (JSONObject) rs.get("error");
//		    	String errormessage = (String) result.get("data");
//		    	System.out.println(errormessage);
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	public void testHostGroupExist(){
//		HostGroupExistsRequest request = new HostGroupExistsRequest();
//		List<String> nameList = new ArrayList<String>();
//		nameList.add("");
//		request.getParams().setName(nameList);
//		Boolean result = (Boolean)hostgroupService.hostGroupExists(request);
//	}
//
//	public void testHostGroupDelete() {
//		// 数据准备
//		HostGroupDeleteRequest hostGroupDelete = new HostGroupDeleteRequest();
//
//		hostGroupDelete.getParams().add("18");
//
//		hostgroupService.hostGroupDelete(hostGroupDelete);
//
//	}
//
//	public void testHostGroupExists() {
//		// 数据准备
//		HostGroupExistsRequest hostGroupExists = new HostGroupExistsRequest();
//
////		hostGroupExists.getParams().getGroupid().add("191");
//		hostGroupExists.getParams().getName().add("windows");
////		hostGroupExists.getParams().getName().add("testHost3");
//
//		boolean result = (Boolean) hostgroupService.hostGroupExists(hostGroupExists);
//
//		System.out.println(result);
//	}
//
//	public void testHostGroupGetobjects() {
//		// 数据准备
//		HostGroupGetobjectsRequest hostGroupGetobjects = new HostGroupGetobjectsRequest();
//
//		hostGroupGetobjects.getParams().getName().add("testHost3");
//
//		hostgroupService.hostGroupGetobjects(hostGroupGetobjects);
//
//	}
//
//	public void testHostGroupGet() {
//		// 数据准备
//		HostGroupGetRequest hostGroupGet = new HostGroupGetRequest();
//
//		hostGroupGet.getParams().setOutput("extend");
////		hostGroupGet.getParams().setSelectHosts("extend");
////		hostGroupGet.getParams().setName("Templates");
////		hostGroupGet.getParams().getGroupids().add("1");
//
//		hostgroupService.hostGroupGet(hostGroupGet);
//
//	}
//
//	public void testgetHostGroupBean() {
//		// 数据准备
//		HostGroupGetRequest hostGroupGet = new HostGroupGetRequest();
//
//		hostGroupGet.getParams().setOutput("extend");
//		List<String> names = new ArrayList<String>();
//		names.add("windows");
//		names.add("Linux servers");
//		hostGroupGet.getParams().getFilter().setName(names);
////		hostGroupGet.getParams().setSelectHosts("extend");
////		hostGroupGet.getParams().setName("Templates");
////		hostGroupGet.getParams().getGroupids().add("1");
//
//		List<HostGroup> groups = hostgroupService.getHostGroupBean(hostGroupGet);
//		System.out.println(groups.size());
//	}

	
}