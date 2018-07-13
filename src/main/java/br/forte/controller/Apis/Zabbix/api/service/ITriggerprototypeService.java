package br.forte.controller.Apis.Zabbix.api.service;

import br.forte.controller.Apis.Zabbix.api.domain.base.TriggerPrototype;
import br.forte.controller.Apis.Zabbix.api.domain.triggerprototype.TriggerPrototypeCreateRequest;
import br.forte.controller.Apis.Zabbix.api.domain.triggerprototype.TriggerPrototypeDeleteRequest;
import br.forte.controller.Apis.Zabbix.api.domain.triggerprototype.TriggerPrototypeGetRequest;
import br.forte.controller.Apis.Zabbix.api.domain.triggerprototype.TriggerPrototypeUpdateRequest;

import java.util.List;

public interface ITriggerprototypeService {
	public Object triggerPrototypeCreate(TriggerPrototypeCreateRequest triggerPrototypeCreate);
	public Object addTriggerPrototype(TriggerPrototype triggerPrototype);
	public Object triggerPrototypeDelete(TriggerPrototypeDeleteRequest triggerPrototypeDelete);
	public Object triggerPrototypeGet(TriggerPrototypeGetRequest triggerPrototypeGet);
	public Object triggerPrototypeUpdate(TriggerPrototypeUpdateRequest triggerPrototypeUpdate);
	List<TriggerPrototype> triggerPrototypeGetToBean(TriggerPrototypeGetRequest triggerPrototypeGet);
}
