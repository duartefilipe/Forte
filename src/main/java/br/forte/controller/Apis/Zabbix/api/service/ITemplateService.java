package br.forte.controller.Apis.Zabbix.api.service;

import br.forte.controller.Apis.Zabbix.api.domain.base.Template;
import br.forte.controller.Apis.Zabbix.api.domain.template.*;

import java.util.List;

public interface ITemplateService {
	public Object create(TemplateCreateRequest create);
	public Object delete(TemplateDeleteRequest delete);
	public Object exists(TemplateExistsRequest exists);
	public Object getobjects(TemplateGetobjectsRequest getobjects);
	public Object get(TemplateGetRequest get);
	public Object isreadable(TemplateIsreadableRequest isreadable);
	public Object iswritable(TemplateIswritableRequest iswritable);
	public Object massadd(TemplateMassaddRequest massadd);
	public Object massremove(TemplateMassremoveRequest massremove);
	public Object massupdate(TemplateMassupdateRequest massupdate);
	public Object update(TemplateUpdateRequest update);
	List<Template> getTemplateToBean(TemplateGetRequest get);
}
