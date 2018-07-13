package br.forte.controller.Apis.Zabbix.api.service;

import br.forte.controller.Apis.Zabbix.api.domain.base.*;
import br.forte.controller.Apis.Zabbix.api.domain.host.*;

import java.util.List;


public interface IHostService {
	public Object create(HostCreateRequest create);

	public Object get(HostGetRequest get);

	public List<Host> getHostToBean(HostGetRequest get);

	String createHost(Host host, HostInterface hostInterface, HostGroup hostgroup, Template template, Macro macro);
	String alteraHost(Host host, HostInterface hostInterface, HostGroup hostgroup, Template template, Macro macro);

	public Object delete(HostDeleteRequest delete);
	public Object exists(HostExistsRequest exists);
	public Object getobjects(HostGetobjectsRequest getobjects);
	public Object isreadable(HostIsreadableRequest isreadable);
	public Object iswritable(HostIswritableRequest iswritable);
	public Object massadd(HostMassaddRequest massadd);
	public Object massremove(HostMassremoveRequest massremove);
	public Object massupdate(HostMassupdateRequest massupdate);
	public Object update(HostUpdateRequest update);
	
}
