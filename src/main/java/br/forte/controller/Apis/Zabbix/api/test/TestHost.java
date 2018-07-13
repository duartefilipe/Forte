package br.forte.controller.Apis.Zabbix.api.test;

import java.util.ArrayList;
import java.util.List;

import br.forte.DAO.UsuarioDao;
import br.forte.controller.Apis.Zabbix.api.domain.base.*;
import br.forte.controller.Apis.Zabbix.api.domain.host.HostCreateRequest;
import br.forte.controller.Apis.Zabbix.api.domain.host.HostGetRequest;
import br.forte.controller.Apis.Zabbix.api.service.IHostService;
import br.forte.controller.Apis.Zabbix.api.service.impl.HostServiceImpl;
import junit.framework.TestCase;

import org.junit.Test;


public class TestHost extends TestCase {
//
//	private static IHostService hostService = new HostServiceImpl();
//	static {
//		System.out.println("ta aqui no login do zabbix dao");
//		new UsuarioDao().login();
//	}
//
//	@Test
//	public boolean testCreate() {
//		// 数据准备
//		System.out.println("ta aqui no testCreate");
//		boolean retorno = false;
//
//
//		HostCreateRequest create = new HostCreateRequest();
//
//		create.getParams().setHost("123");
//		// create.getParams().setName("testName7");
//		HostGroup hostGroup = new HostGroup();
//		hostGroup.setGroupid("2");
//		create.getParams().getGroups().add(hostGroup);
//
//		HostInterface hif = new HostInterface();
//
//
//		hif.setType(1);
//		hif.setIp("177.36.44.210");
//		hif.setDns("www.basu.com");
//		hif.setUseip(1);
//		hif.setMain(1);
//		hif.setPort("161");
//		create.getParams().getInterfaces().add(hif);
//		// hif = new HostInterface();
//		// hif.setUseip(0);
//		// hif.setType(3);
//		// hif.setMain(1);
//		// hif.setIp("");
//		// hif.setDns("www.baudi.com");
//		// hif.setPort("8181");
//		// create.getParams().getInterfaces().add(hif);
//		// hif = new HostInterface();
//		// hif.setUseip(0);
//		// hif.setType(1);
//		// hif.setMain(2);
//		// hif.setIp("");
//		// hif.setDns("www.baidu.com");
//		// hif.setPort("8181");
//		// create.getParams().getInterfaces().add(hif);
//
//		create.getParams().setStatus(1);
//
//		Template tem = new Template();
//		tem.setTemplateid("100066");
//
//		create.getParams().getTemplates().add(tem);
//
//		// create.getParams().setIpmi_password("123");
//
//		hostService.create(create);
//			retorno = true;
//
//
//		return retorno;
//
//	}
//
//	@Test
//	public void testGet() {
//		// 数据准备 shorten, refer, extend
//		// HostGetRequest get = new HostGetRequest();
//		// get.getParams().setOutput("extend");
//		// // get.getParams().setHostids("10084");
//		// get.getParams().setSelectTigges("select * from triggers");
//		// // get.getParams().setSelectItems("extend");
//		// hostService.get(get);
//		// String proxyid= "10828";
////		String proxyid = null;
////		HostGetRequest getRequest = new HostGetRequest();
////		HostGetParams param = getRequest.getParams();
////		param.setOutput("shorten");
////		if (proxyid != null) {
////			String[] proxyids = { proxyid };
////			param.setProxyids(proxyids);
////		}
////		List<String> ips = new ArrayList<String>();
////		// ips.add("10.17.1.131");
////		ips.add("192.168.153.26");
////		param.getFilter().setIp(ips);
////		Object object = hostService.get(getRequest);
////		System.out.println(object.toString());
//		// JSONObject object = (JSONObject) hostService.get(getRequest);
//		// if(object.containsKey("result")){
//		// JSONArray array = object.getJSONArray("result");
//		// JSONObject jsonObject = array.getJSONObject(0);
//		// hostid = jsonObject.getString("hostid");
//		// }
//		HostGetRequest hostGetRequest = new HostGetRequest();
//		hostGetRequest.getParams().setOutput("extend");
//		List<String> nameList = new ArrayList<String>();
//		nameList.add("192.168.199.72");
//		hostGetRequest.getParams().getFilter().setName(nameList);
//		List<Host> hostList = hostService.getHostToBean(hostGetRequest);
//
//	}
//
//	// {
//	// "jsonrpc": "2.0",
//	// "method": "host.get",
//	// "params": {
//	// "output": "extend",
//	// "selectInterfaces":"extend",
//	// "proxyids":["10828"],
//	// "filter": {
//	// "ips": [
//	// "192.168.153.223"
//	// ]
//	// }
//	// },
//	// "auth": "005a36950a18e5f9768b29a1f475d0ed",
//	// "id": 1
//	// }
///*
//	@Test
//	public void testGetToBean() {
//		// 数据准备 shorten, refer, extend
//		HostGetRequest get = new HostGetRequest();
//		get.getParams().setOutput("shorten");
//		// String[] proxyids = {"10828"};
//		// get.getParams().setProxyids(proxyids);;
//		// get.getParams().setSelectItems("extend")
//		List<String> ips = new ArrayList<String>();
//		ips.add("192.168.153.26");
//		get.getParams().getFilter().setIp(ips);
//		;
//		List<Host> hosts = hostService.getHostToBean(get);
//		System.out.println(hosts.size());
//
//	}
//*/
//	@Test
//	public boolean testCreateHost() {
//		boolean retorno = false;
//		System.out.println("ta no test create host");
//		Host host = new Host();
//		Macro macro = new Macro();
//		HostGroup group = new HostGroup();
//		HostInterface hostInterface = new HostInterface();
//		Template template = new Template();
//		host.setName("teste");
//		host.setHost("teste");
//		macro.setMacro("{$SNMP_COMMUNITY");
//		macro.setValue("Forte");
//		host.setStatus(1);
//		group.setGroupid("2");
//		host.setProxy_hostid("10066");
//		hostInterface.setType(2); // 1 - agent; 2 - SNMP; 3 - IPMI 4 - JMX.
//		hostInterface.setIp("177.36.44.210");
//		hostInterface.setDns("");
//		hostInterface.setUseip(1); // 0 - connect using host DNS name 1 -
//									// connect using host IP address.
//		hostInterface.setMain(1); // 0 - not default; 1 - default.
//		hostInterface.setPort("161"); // agent监控默认端口
//		template.setTemplateid("10081");
//		String ss = hostService
//				.createHost(host, hostInterface, group, template, macro);
//		System.out.println(ss);
//
//		retorno = true;
//
//
//		return retorno;
//	}
}