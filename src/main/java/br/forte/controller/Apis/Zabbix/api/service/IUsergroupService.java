package br.forte.controller.Apis.Zabbix.api.service;

import br.forte.controller.Apis.Zabbix.api.domain.usergroup.*;

public interface IUsergroupService {
	public Object userGroupCreate(UserGroupCreateRequest userGroupCreate);
	public Object userGroupDelete(UserGroupDeleteRequest userGroupDelete);
	public Object userGroupExists(UserGroupExistsRequest userGroupExists);
	public Object userGroupGetobjects(UserGroupGetobjectsRequest userGroupGetobjects);
	public Object userGroupGet(UserGroupGetRequest userGroupGet);
	public Object userGroupIsreadable(UserGroupIsreadableRequest userGroupIsreadable);
	public Object userGroupIswritable(UserGroupIswritableRequest userGroupIswritable);
	public Object userGroupMassadd(UserGroupMassaddRequest userGroupMassadd);
	public Object userGroupMassupdate(UserGroupMassupdateRequest userGroupMassupdate);
	public Object userGroupUpdate(UserGroupUpdateRequest userGroupUpdate);
}
