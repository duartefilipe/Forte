package br.forte.controller.Apis.Zabbix.api.domain.base;
public class Template{
	private String templateid;
	private String host;
	private String nameTemplate;
	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}
	public String getTemplateid() {
		return templateid;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getHost() {
		return host;
	}

	public String getNameTemplate() {
		return nameTemplate;
	}

	public void setNameTemplate(String nameTemplate) {
		this.nameTemplate = nameTemplate;
	}
}
