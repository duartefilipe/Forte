package br.forte.controller.Apis.Zabbix.api.domain.user;


import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;
import br.forte.controller.Apis.Zabbix.api.domain.base.User;

import java.util.ArrayList;
import java.util.List;

public class UserLogoutRequest extends RequestBase {
	public UserLogoutRequest() {
		super("user.logout");
	}
	private List<User> params;
	public void setParams(List<User> params) {
		this.params = params;
	}
	public List<User> getParams() {
		 if(params==null){
			params   = new ArrayList<User>();
			return params;
		}
		 return params;
	}
}
