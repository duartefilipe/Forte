package br.forte.controller.Apis.Zabbix.api.domain.itemprototype;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;

import java.util.*;

public class ItemPrototypeIswritableRequest extends RequestBase {
	public ItemPrototypeIswritableRequest() {
		super("itemprototype.iswritable");
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
