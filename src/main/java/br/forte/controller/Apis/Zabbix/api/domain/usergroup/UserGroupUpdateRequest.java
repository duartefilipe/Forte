package br.forte.controller.Apis.Zabbix.api.domain.usergroup;
import br.forte.controller.Apis.Zabbix.api.domain.base.Permission;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;
import br.forte.controller.Apis.Zabbix.api.domain.base.UserGroup;

import java.util.*;


public class UserGroupUpdateRequest extends RequestBase {
	public UserGroupUpdateRequest() {
		super("usergroup.update");
	}
	private UserGroupUpdateParams params = new UserGroupUpdateParams();
	public void setParams(UserGroupUpdateParams params) {
		this.params = params;
	}
	public UserGroupUpdateParams getParams() {
		return params;
	}
	public static class UserGroupUpdateParams extends UserGroup {
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
