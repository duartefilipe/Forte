package br.forte.controller.Apis.Zabbix.api.domain.host;
import br.forte.controller.Apis.Zabbix.api.domain.base.Host;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;

import java.util.ArrayList;
import java.util.List;

public class HostDeleteRequest extends RequestBase {
	public HostDeleteRequest() {
		super("host.delete");
	}
	private List<String> params;
	public void setParams(List<String> params) {
		this.params = params;
	}
	public List<String> getParams() {
		 if(params==null){
			params   = new ArrayList<String>();
			return params;
		}
		 return params;
	}
}
