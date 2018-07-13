package br.forte.controller.Apis.Zabbix.api.service;

import br.forte.controller.Apis.Zabbix.api.domain.base.HostGroup;
import br.forte.controller.Apis.Zabbix.api.domain.hostgroup.*;

import java.util.List;

/**
 * @ClassName: IHostgroupService
 * @Description: 设备组接口
 * @author 李庆雷
 * @date 2013-9-23 上午11:56:11
 */
public interface IHostgroupService {
	/**
	 * 
	 * @Title: hostGroupGet
	 * @Description: 获取设备组信息（json）
	 * @param hostGroupGet
	 * @return Object
	 * @throws
	 */
	public Object hostGroupGet(HostGroupGetRequest hostGroupGet);
	
	/**
	 * 
	 * @Title: getHostGroupBean
	 * @Description: 获取设备组信息（bean）
	 * @param hostGroupGet
	 * @return List<HostGroup>
	 * @throws
	 */
	public List<HostGroup> getHostGroupBean(HostGroupGetRequest hostGroupGet);
	
	
	public Object hostGroupCreate(HostGroupCreateRequest hostGroupCreate);
	public Object hostGroupDelete(HostGroupDeleteRequest hostGroupDelete);
	public Object hostGroupExists(HostGroupExistsRequest hostGroupExists);
	public Object hostGroupGetobjects(HostGroupGetobjectsRequest hostGroupGetobjects);
	public Object hostGroupIsreadable(HostGroupIsreadableRequest hostGroupIsreadable);
	public Object hostGroupIswritable(HostGroupIswritableRequest hostGroupIswritable);
	public Object hostGroupMassadd(HostGroupMassaddRequest hostGroupMassadd);
	public Object hostGroupMassremove(HostGroupMassremoveRequest hostGroupMassremove);
	public Object hostGroupMassupdate(HostGroupMassupdateRequest hostGroupMassupdate);
	public Object hostGroupUpdate(HostGroupUpdateRequest hostGroupUpdate);
}
