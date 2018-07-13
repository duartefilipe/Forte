package br.forte.controller.Apis.Zabbix.api.test;

import java.util.ArrayList;
import java.util.List;

import br.forte.DAO.UsuarioDao;
import br.forte.controller.Apis.Zabbix.api.domain.base.Host;
import br.forte.controller.Apis.Zabbix.api.domain.base.HostGroup;
import br.forte.controller.Apis.Zabbix.api.domain.base.Template;
import br.forte.controller.Apis.Zabbix.api.domain.template.*;
import br.forte.controller.Apis.Zabbix.api.service.ITemplateService;
import br.forte.controller.Apis.Zabbix.api.service.impl.TemplateServiceImpl;
import junit.framework.TestCase;




public class TestTemplate extends TestCase {
//	private static ITemplateService templateService = new TemplateServiceImpl();
//	static {
//		System.out.println("ta aqui no login do zabbix dao");
//		new UsuarioDao().login();
//	}
//
//	public void testCreate() {
//		// 数据准备
//		TemplateCreateRequest create = new TemplateCreateRequest();
//
//		create.getParams().setHost("testTemplate_wei123");
//		create.getParams().setName("testTemplate123");
//		HostGroup hg = new HostGroup();
//		hg.setGroupid("1");
//		create.getParams().getGroups().add(hg);
//
//		Host h = new Host();
//		h.setHostid("158");
//		create.getParams().getHosts().add(h);
//
//		templateService.create(create);
//
//	}
//
//	public void testDelete() {
//		// 数据准备
//		TemplateDeleteRequest delete = new TemplateDeleteRequest();
//		delete.getParams().add("164");
//		templateService.delete(delete);
//
//	}
//
//	public void testExists() {
//		// 数据准备
//		TemplateExistsRequest exists = new TemplateExistsRequest();
//		exists.getParams().getTemplateid().add("1");
//		templateService.exists(exists);
//
//	}
//
//	public void testGetobjects() {
//		// 数据准备
//		TemplateGetobjectsRequest getobjects = new TemplateGetobjectsRequest();
//
//		getobjects.getParams().setHost("test_weiwei");
//
//		templateService.getobjects(getobjects);
//
//	}
//
//	public void testGet() {
//		// 数据准备
//		TemplateGetRequest get = new TemplateGetRequest();
//		get.getParams().setOutput("extend");
//		templateService.get(get);
//
//	}
//
//	public void testGetBean() {
//		// 数据准备
//		TemplateGetRequest get = new TemplateGetRequest();
//		get.getParams().setOutput("extend");
//		List<String> hosts = new ArrayList<String>();
//		hosts.add("Template OS Windows");
//		get.getParams().getFilter().setHost(hosts);
//		List<Template> templates = templateService.getTemplateToBean(get);
//
//	}
//
//	public void testIsreadable() {
//		// 数据准备
//		TemplateIsreadableRequest isreadable = new TemplateIsreadableRequest();
//		isreadable.getParams().add("163");
//		templateService.isreadable(isreadable);
//
//	}
//
//	public void testIswritable() {
//		// 数据准备
//		TemplateIswritableRequest iswritable = new TemplateIswritableRequest();
//		iswritable.getParams().add("163");
//		templateService.iswritable(iswritable);
//
//	}
//
//	public void testMassadd() {
//		// 数据准备
//		TemplateMassaddRequest massadd = new TemplateMassaddRequest();
//
//		Template t = new Template();
//		t.setTemplateid("163");
//		massadd.getParams().getTemplates().add(t);
//
//		t = new Template();
//		t.setTemplateid("68");
//		massadd.getParams().getTemplates().add(t);
//
//		HostGroup hg = new HostGroup();
//		hg.setGroupid("6");
//		massadd.getParams().getGroups().add(hg);
////		massadd.getParams().getGroups().add(hg);
//
//		templateService.massadd(massadd);
//
//	}
//
//	public void testMassremove() {
//		// 数据准备
//		TemplateMassremoveRequest massremove = new TemplateMassremoveRequest();
//
//		massremove.getParams().getTemplateids().add("68");
//		massremove.getParams().getTemplateids().add("163");
//
//		massremove.getParams().setGroupids("1");
//		templateService.massremove(massremove);
//
//	}
//
//	public void testMassupdate() {
//		// 数据准备
//		TemplateMassupdateRequest massupdate = new TemplateMassupdateRequest();
//
//		Template tem = new Template();
//		tem.setTemplateid("163");
//		massupdate.getParams().getTemplates().add(tem);
//
//		HostGroup hg = new HostGroup();
//		hg.setGroupid("6");
//		massupdate.getParams().getGroups().add(hg);
//
//		Host h = new Host();
//		h.setHostid("28");
//		massupdate.getParams().getHosts().add(h);
//
//		Template t = new Template();
//		t.setTemplateid("44");
//		massupdate.getParams().getTemplates_clear().add("44");
//
//		templateService.massupdate(massupdate);
//
//	}
//
//	public void testUpdate() {
//		// 数据准备
//		TemplateUpdateRequest update = new TemplateUpdateRequest();
//
//		update.getParams().setTemplateid("163");
//		update.getParams().setHost("test_weiwei");
//		update.getParams().setName("test_weiwei");
//		HostGroup hg = new HostGroup();
//		hg.setGroupid("1");
//		update.getParams().getGroups().add(hg);
//
//		Host h = new Host();
//		h.setHostid("27");
//		update.getParams().getHosts().add(h);
//
//		Template t = new Template();
//		t.setTemplateid("44");
//		update.getParams().getTemplates_clear().add(t);
//
//		templateService.update(update);
//
//	}
}