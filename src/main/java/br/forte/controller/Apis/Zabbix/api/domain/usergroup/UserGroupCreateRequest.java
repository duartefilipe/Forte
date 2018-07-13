package br.forte.controller.Apis.Zabbix.api.domain.usergroup;
import br.forte.controller.Apis.Zabbix.api.domain.base.Permission;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;
import br.forte.controller.Apis.Zabbix.api.domain.base.UserGroup;

import java.util.*;


public class UserGroupCreateRequest extends RequestBase {
	public UserGroupCreateRequest() {
		super("usergroup.create");
	}
	private UserGroupCreateParams params = new UserGroupCreateParams();
	public void setParams(UserGroupCreateParams params) {
		this.params = params;
	}
	public UserGroupCreateParams getParams() {
		return params;
	}
	public static class UserGroupCreateParams extends UserGroup {
		private List<Permission> rights;
		private List<String> userids;
		public void setRights(List<Permission> rights) {
			this.rights = rights;
		}
		public List<Permission> getRights() {
			 if(rights==null){
				rights   = new ArrayList<Permission>();
				return rights;
			}
			 return rights;
		}
		public void setUserids(List<String> userids) {
			this.userids = userids;
		}
		public List<String> getUserids() {
			 if(userids==null){
				userids   = new ArrayList<String>();
				return userids;
			}
			 return userids;
		}
	}
}
