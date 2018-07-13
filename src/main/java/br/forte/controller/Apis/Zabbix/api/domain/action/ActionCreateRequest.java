package br.forte.controller.Apis.Zabbix.api.domain.action;

import br.forte.controller.Apis.Zabbix.api.domain.base.Action;
import br.forte.controller.Apis.Zabbix.api.domain.base.ActionCondition;
import br.forte.controller.Apis.Zabbix.api.domain.base.ActionOperation;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;

import java.util.ArrayList;
import java.util.List;

public class ActionCreateRequest extends RequestBase {
	public ActionCreateRequest() {
		super("action.create");
	}
	private ActionCreateParams params = new ActionCreateParams();
	public void setParams(ActionCreateParams params) {
		this.params = params;
	}
	public ActionCreateParams getParams() {
		return params;
	}
	public static class ActionCreateParams extends Action {
		private List<ActionOperation> operations;
		private List<ActionCondition> conditions;
		public void setOperations(List<ActionOperation> operations) {
			this.operations = operations;
		}
		public List<ActionOperation> getOperations() {
			 if(operations==null){
				operations   = new ArrayList<ActionOperation>();
				return operations;
			}
			 return operations;
		}
		public void setConditions(List<ActionCondition> conditions) {
			this.conditions = conditions;
		}
		public List<ActionCondition> getConditions() {
			 if(conditions==null){
				conditions   = new ArrayList<ActionCondition>();
				return conditions;
			}
			 return conditions;
		}
	}
}
