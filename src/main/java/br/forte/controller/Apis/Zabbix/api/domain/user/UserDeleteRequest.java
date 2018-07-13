package br.forte.controller.Apis.Zabbix.api.domain.user;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;
import br.forte.controller.Apis.Zabbix.api.domain.base.User;

import java.util.ArrayList;
import java.util.List;

public class UserDeleteRequest extends RequestBase {
	public UserDeleteRequest() {
		super("user.delete");
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
