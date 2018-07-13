package br.forte.controller.Apis.Zabbix.api.test;
import java.util.ArrayList;
import java.util.List;

import br.forte.DAO.UsuarioDao;
import br.forte.controller.Apis.Zabbix.api.domain.base.HostInterface;
import br.forte.controller.Apis.Zabbix.api.domain.hostinterface.HostInterfaceGetRequest;
import br.forte.controller.Apis.Zabbix.api.service.IHostinterfaceService;
import br.forte.controller.Apis.Zabbix.api.service.impl.HostinterfaceServiceImpl;
import junit.framework.TestCase;



public class TestHostinterface extends TestCase {
//	private static IHostinterfaceService hostinterfaceService = new HostinterfaceServiceImpl();
//	static {
//		System.out.println("ta aqui no login do zabbix dao");
//		new UsuarioDao().login();
//	}
//
//	public void testHostInterfaceGet(){
//		//数据准备
//		HostInterfaceGetRequest hostInterfaceGet = new HostInterfaceGetRequest();
//		hostInterfaceGet.getParams().setOutput("extend");
//		List<String> ids = new ArrayList<String>();
//		ids.add("10084");
//		hostInterfaceGet.getParams().setHostids(ids);
//		hostinterfaceService.hostInterfaceGet(hostInterfaceGet);
//
//	}
//
//	public void testHostInterfaceGetToBean(){
//		//数据准备
//		HostInterfaceGetRequest hostInterfaceGet = new HostInterfaceGetRequest();
//		hostInterfaceGet.getParams().setOutput("extend");
////		List<String> ids = new ArrayList<String>();
////		ids.add("10084");
////		hostInterfaceGet.getParams().setHostids(ids);
//		List ips = new ArrayList();
//		ips.add("192.168.153.26");
//		hostInterfaceGet.getParams().getFilter().setIp(ips);
//		List<HostInterface> list = hostinterfaceService.getHostInterfaceBean(hostInterfaceGet);
//		System.out.println(list.size());
//	}
}