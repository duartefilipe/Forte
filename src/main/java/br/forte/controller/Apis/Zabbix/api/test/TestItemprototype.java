package br.forte.controller.Apis.Zabbix.api.test;

import br.forte.DAO.UsuarioDao;
import br.forte.controller.Apis.Zabbix.api.domain.itemprototype.*;
import br.forte.controller.Apis.Zabbix.api.service.IItemprototypeService;
import br.forte.controller.Apis.Zabbix.api.service.impl.ItemprototypeServiceImpl;
import junit.framework.TestCase;



public class TestItemprototype extends TestCase {
//	private static IItemprototypeService itemprototypeService = new ItemprototypeServiceImpl();
//	static {
//		System.out.println("ta aqui no login do zabbix dao");
//		new UsuarioDao().login();
//	}
//
//	public void testItemPrototypeCreate() {
//		// 数据准备
//		ItemPrototypeCreateRequest itemPrototypeCreate = new ItemPrototypeCreateRequest();
//
//		itemPrototypeCreate.getParams().setName("12345");
//		itemPrototypeCreate.getParams().setRuleid("1");
//		itemPrototypeCreate.getParams().setKey_("ipAdEntAddr3[{#SNMPVALUE}]");
//		itemPrototypeCreate.getParams().setHostid("93");
//		itemPrototypeCreate.getParams().setType(4);
//		itemPrototypeCreate.getParams().setValue_type(3);
//		itemPrototypeCreate.getParams().setDelay(30);
//		itemPrototypeCreate.getParams().setInterfaceid("54");
////		itemPrototypeCreate.getParams().getApplications().add("13");
//
//		itemprototypeService.itemPrototypeCreate(itemPrototypeCreate);
//
//	}
//
//	public void testItemPrototypeDelete() {
//		// 数据准备
//		ItemPrototypeDeleteRequest itemPrototypeDelete = new ItemPrototypeDeleteRequest();
//		itemPrototypeDelete.getParams().add("42734");
//		itemprototypeService.itemPrototypeDelete(itemPrototypeDelete);
//
//	}
//
//	public void testItemPrototypeExists() {
//		// 数据准备
//		ItemPrototypeExistsRequest itemPrototypeExists = new ItemPrototypeExistsRequest();
//
//		itemPrototypeExists.getParams().setKey_("ipAdEntAddr[{#SNMPVALUE}]");
//		itemprototypeService.itemPrototypeExists(itemPrototypeExists);
//
//	}
//
//	public void testItemPrototypeGet() {
//		// 数据准备
//		ItemPrototypeGetRequest itemPrototypeGet = new ItemPrototypeGetRequest();
//		itemPrototypeGet.getParams().setOutput("extend");
//		itemPrototypeGet.getParams().setItemids("10001");
//		itemprototypeService.itemPrototypeGet(itemPrototypeGet);
//
//	}
//
//	public void testItemPrototypeGetToBean() {
//		// 数据准备
//		ItemPrototypeGetRequest itemPrototypeGet = new ItemPrototypeGetRequest();
//		itemPrototypeGet.getParams().setOutput("extend");
//		itemPrototypeGet.getParams().setItemids("10001");
//		itemprototypeService.itemPrototypeGetToBean(itemPrototypeGet);
//
//	}
//
//	public void testItemPrototypeIsreadable() {
//		// 数据准备
//		ItemPrototypeIsreadableRequest itemPrototypeIsreadable = new ItemPrototypeIsreadableRequest();
//		itemPrototypeIsreadable.getParams().add("42734");
//		itemprototypeService.itemPrototypeIsreadable(itemPrototypeIsreadable);
//
//	}
//
//	public void testItemPrototypeIswritable() {
//		// 数据准备
//		ItemPrototypeIswritableRequest itemPrototypeIswritable = new ItemPrototypeIswritableRequest();
//		itemPrototypeIswritable.getParams().add("42734");
//		itemprototypeService.itemPrototypeIswritable(itemPrototypeIswritable);
//
//	}
//
//	public void testItemPrototypeUpdate() {
//		// 数据准备
//		ItemPrototypeUpdateRequest itemPrototypeUpdate = new ItemPrototypeUpdateRequest();
//
//		itemPrototypeUpdate.getParams().setItemid("42734");
//		itemPrototypeUpdate.getParams().setName("15test");
//		itemPrototypeUpdate.getParams().setRuleid("1");
//		itemPrototypeUpdate.getParams().setKey_("ipAdEntAddr3[{#SNMPVALUE}]");
//		itemPrototypeUpdate.getParams().setHostid("93");
//		itemPrototypeUpdate.getParams().setType(4);
//		itemPrototypeUpdate.getParams().setValue_type(3);
//		itemPrototypeUpdate.getParams().setDelay(30);
//		itemPrototypeUpdate.getParams().setInterfaceid("54");
////		itemPrototypeCreate.getParams().getApplications().add("13");
//
//
//		itemprototypeService.itemPrototypeUpdate(itemPrototypeUpdate);
//
//	}
}