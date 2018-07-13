package br.forte.controller.Apis.Zabbix.api.domain.trigger;

import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;
import br.forte.controller.Apis.Zabbix.api.domain.base.Trigger;

import java.util.ArrayList;
import java.util.List;

public class TriggerDeletedependenciesRequest extends RequestBase {
	public TriggerDeletedependenciesRequest() {
		super("trigger.deletedependencies");
	}
	private List<Trigger> params;
	public void setParams(List<Trigger> params) {
		this.params = params;
	}
	public List<Trigger> getParams() {
		 if(params==null){
			params   = new ArrayList<Trigger>();
			return params;
		}
		 return params;
	}
}
