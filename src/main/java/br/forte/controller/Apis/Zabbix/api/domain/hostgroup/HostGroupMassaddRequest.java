package br.forte.controller.Apis.Zabbix.api.domain.hostgroup;

import br.forte.controller.Apis.Zabbix.api.domain.base.Host;
import br.forte.controller.Apis.Zabbix.api.domain.base.HostGroup;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;
import br.forte.controller.Apis.Zabbix.api.domain.base.Template;

import java.util.ArrayList;
import java.util.List;

public class HostGroupMassaddRequest extends RequestBase {
	public HostGroupMassaddRequest() {
		super("hostgroup.massadd");
	}
	private HostGroupMassaddParams params = new HostGroupMassaddParams();
	public void setParams(HostGroupMassaddParams params) {
		this.params = params;
	}
	public HostGroupMassaddParams getParams() {
		return params;
	}
	public static class HostGroupMassaddParams extends HostGroup {
		private List<HostGroup> groups;
		private List<Host> hosts;
		private List<Template> templates;
		public void setGroups(List<HostGroup> groups) {
			this.groups = groups;
		}
		public List<HostGroup> getGroups() {
			 if(groups==null){
				groups   = new ArrayList<HostGroup>();
				return groups;
			}
			 return groups;
		}
		public void setHosts(List<Host> hosts) {
			this.hosts = hosts;
		}
		public List<Host> getHosts() {
			 if(hosts==null){
				hosts   = new ArrayList<Host>();
				return hosts;
			}
			 return hosts;
		}
		public void setTemplates(List<Template> templates) {
			this.templates = templates;
		}
		public List<Template> getTemplates() {
			 if(templates==null){
				templates   = new ArrayList<Template>();
				return templates;
			}
			 return templates;
		}
	}
}
