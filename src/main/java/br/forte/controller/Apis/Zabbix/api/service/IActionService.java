package br.forte.controller.Apis.Zabbix.api.service;

import br.forte.controller.Apis.Zabbix.api.domain.action.*;
import br.forte.controller.Apis.Zabbix.api.domain.base.Action;

import java.util.List;

/**
 * @ClassName: IActionService
 * @Description: 动作接口
 * @author 李庆雷
 * @date 2013-9-25 下午5:58:28
 * @version V1.0
 */
public interface IActionService {
	/**
	 * @Title: get
	 * @Description: 动作获取（json）
	 * @param get
	 * @return Object
	 * @throws
	 */
	public Object get(ActionGetRequest get);
	
	/**
	 * @Title: getActionBean
	 * @Description: 动作的获取（bean）
	 * @param get
	 * @return List<Action>
	 * @throws
	 */
	public List<Action> getActionBean(ActionGetRequest get);
	
	public Object create(ActionCreateRequest create);
	public Object delete(ActionDeleteRequest delete);
	public Object exists(ActionExistsRequest exists);
	public Object update(ActionUpdateRequest update);

	boolean addAction(Action action);
	boolean updateAction(Action action);
}
