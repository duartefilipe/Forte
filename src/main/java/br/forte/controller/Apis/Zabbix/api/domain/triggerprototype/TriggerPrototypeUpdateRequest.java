package br.forte.controller.Apis.Zabbix.api.domain.triggerprototype;

import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;
import br.forte.controller.Apis.Zabbix.api.domain.base.TriggerPrototype;

public class TriggerPrototypeUpdateRequest extends RequestBase {
	public TriggerPrototypeUpdateRequest() {
		super("triggerprototype.update");
	}
	private TriggerPrototypeUpdateParams params = new TriggerPrototypeUpdateParams();
	public void setParams(TriggerPrototypeUpdateParams params) {
		this.params = params;
	}
	public TriggerPrototypeUpdateParams getParams() {
		return params;
	}
	public static class TriggerPrototypeUpdateParams extends TriggerPrototype {
	}
}
