package br.forte.controller.Apis.Zabbix.api.domain.item;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;

import java.util.*;


public class ItemIsreadableRequest extends RequestBase {
	public ItemIsreadableRequest() {
		super("item.isreadable");
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
