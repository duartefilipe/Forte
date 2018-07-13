package br.forte.controller.Apis.Zabbix.api.test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import br.forte.DAO.UsuarioDao;
import br.forte.controller.Apis.Zabbix.api.domain.base.IntegerHistory;
import br.forte.controller.Apis.Zabbix.api.domain.history.HistoryGetRequest;
import br.forte.controller.Apis.Zabbix.api.service.IHistoryService;
import br.forte.controller.Apis.Zabbix.api.service.impl.HistoryServiceImpl;
import junit.framework.TestCase;


public class TestHistory extends TestCase {
//	private static IHistoryService historyService = new HistoryServiceImpl();
//	static {
//		System.out.println("ta aqui no login do zabbix dao");
//		new UsuarioDao().login();
//	}
//
//	public void testGet(){
//		//数据准备
//		HistoryGetRequest get = new HistoryGetRequest();
//		get.getParams().setOutput("extend");//refer
//		get.getParams().setHistory(0);
//		List<String> ss =new  ArrayList<String>();
//		ss.add("23305");
//		get.getParams().setItemids(ss);
//		get.getParams().setTime_from(1399168800l);
////		List<String> sort = new ArrayList<String>();
////		sort.add("DESC");
////		get.getParams().setSortorder(sort);
////		get.getParams().setLimit(10);
//		Object object = historyService.get(get);
//		System.out.println(object);
//	}
//
//	public void testGetHistory(){
//		//数据准备
//		Date startdate = new Date();
//		HistoryGetRequest get = new HistoryGetRequest();
//		get.getParams().setOutput("extend");//refer
//		get.getParams().setHistory(0);
//		List<String> ss =new  ArrayList<String>();
//		ss.add("23301");//23305,37814
//		get.getParams().setItemids(ss);
//		get.getParams().setTime_from(1399973481l);
//		get.getParams().setTime_till(1399973481l);
////		List<String> sort = new ArrayList<String>();
////		sort.add("DESC");
////		get.getParams().setSortorder(sort);
////		get.getParams().setLimit(10);
//		List<IntegerHistory> historys = historyService.getHistoryToBean(get,0);
//		Collections.sort(historys);
//		Date enddate = new Date();
////		System.out.println((enddate.getTime()-startdate.getTime())/1000);
//		System.out.println(historys.size());
//
//	}
//
	
}