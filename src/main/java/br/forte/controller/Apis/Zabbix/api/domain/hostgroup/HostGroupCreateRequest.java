package br.forte.controller.Apis.Zabbix.api.domain.hostgroup;

import br.forte.controller.Apis.Zabbix.api.domain.base.HostGroup;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;

import java.util.ArrayList;
import java.util.List;

public class HostGroupCreateRequest extends RequestBase {

	public HostGroupCreateRequest() {

		super("hostgroup.create");
	}
	private List<HostGroup> params;
	public void setParams(List<HostGroup> params) {
		this.params = params;
	}
	public List<HostGroup> getParams() {
		 if(params==null){
			params   = new ArrayList<HostGroup>();
			return params;
		}
		 return params;
	}
}
