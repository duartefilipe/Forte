package br.forte.controller.Apis.Zabbix.api.domain.trigger;


import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;
import br.forte.controller.Apis.Zabbix.api.domain.base.Trigger;

import java.util.ArrayList;
import java.util.List;

public class TriggerCreateRequest extends RequestBase {
	public TriggerCreateRequest() {
		super("trigger.create");
	}
	private TriggerCreateParams params = new TriggerCreateParams();
	public void setParams(TriggerCreateParams params) {
		this.params = params;
	}
	public TriggerCreateParams getParams() {
		return params;
	}
	public static class TriggerCreateParams extends Trigger {
		private List<Trigger> dependencies;
		public void setDependencies(List<Trigger> dependencies) {
			this.dependencies = dependencies;
		}
		public List<Trigger> getDependencies() {
			 if(dependencies==null){
				dependencies   = new ArrayList<Trigger>();
				return dependencies;
			}
			 return dependencies;
		}
	}
}
