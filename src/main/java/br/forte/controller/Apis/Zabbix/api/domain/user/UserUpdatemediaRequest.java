package br.forte.controller.Apis.Zabbix.api.domain.user;


import br.forte.controller.Apis.Zabbix.api.domain.base.Media;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;
import br.forte.controller.Apis.Zabbix.api.domain.base.User;

import java.util.ArrayList;
import java.util.List;

public class UserUpdatemediaRequest extends RequestBase {
	public UserUpdatemediaRequest() {
		super("user.updatemedia");
	}
	private UserUpdatemediaParams params = new UserUpdatemediaParams();
	public void setParams(UserUpdatemediaParams params) {
		this.params = params;
	}
	public UserUpdatemediaParams getParams() {
		return params;
	}
	public static class UserUpdatemediaParams{
		private List<Media> medias;
		private List<User> users;
		public void setMedias(List<Media> medias) {
			this.medias = medias;
		}
		public List<Media> getMedias() {
			 if(medias==null){
				medias   = new ArrayList<Media>();
				return medias;
			}
			 return medias;
		}
		public void setUsers(List<User> users) {
			this.users = users;
		}
		public List<User> getUsers() {
			 if(users==null){
				users   = new ArrayList<User>();
				return users;
			}
			 return users;
		}
	}
}
