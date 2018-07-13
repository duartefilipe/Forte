package br.forte.controller.Apis.Zabbix.api.domain.itemprototype;
import br.forte.controller.Apis.Zabbix.api.domain.base.ItemPrototype;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;

import java.util.*;


public class ItemPrototypeUpdateRequest extends RequestBase {
	public ItemPrototypeUpdateRequest() {
		super("itemprototype.update");
	}
	private ItemPrototypeUpdateParams params = new ItemPrototypeUpdateParams();
	public void setParams(ItemPrototypeUpdateParams params) {
		this.params = params;
	}
	public ItemPrototypeUpdateParams getParams() {
		return params;
	}
	public static class ItemPrototypeUpdateParams extends ItemPrototype {
		private String ruleid ;
		private List<String> applications;
		public void setRuleid (String ruleid ) {
			this.ruleid  = ruleid ;
		}
		public String getRuleid () {
			return ruleid ;
		}
		public void setApplications(List<String> applications) {
			this.applications = applications;
		}
		public List<String> getApplications() {
			 if(applications==null){
				applications   = new ArrayList<String>();
				return applications;
			}
			 return applications;
		}
	}
}
