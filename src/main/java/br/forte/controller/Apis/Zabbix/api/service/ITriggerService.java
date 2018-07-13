package br.forte.controller.Apis.Zabbix.api.service;

import br.forte.controller.Apis.Zabbix.api.domain.base.Trigger;
import br.forte.controller.Apis.Zabbix.api.domain.trigger.*;

import java.util.List;

public interface ITriggerService {
	public Object adddependencies(TriggerAdddependenciesRequest adddependencies);
	public Object create(TriggerCreateRequest create);
	public Object addTrigger(Trigger trigger);
	public Object deletedependencies(TriggerDeletedependenciesRequest deletedependencies);
	public Object delete(TriggerDeleteRequest delete);
	public Object exists(TriggerExistsRequest exists);
	public Object getobjects(TriggerGetobjectsRequest getobjects);
	public Object get(TriggerGetRequest get);
	public Object isreadable(TriggerIsreadableRequest isreadable);
	public Object iswritable(TriggerIswritableRequest iswritable);
	public Object update(TriggerUpdateRequest update);
	public List<Trigger> getTriggerBean(TriggerGetRequest get);
	
}
