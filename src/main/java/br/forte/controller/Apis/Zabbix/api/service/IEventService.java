package br.forte.controller.Apis.Zabbix.api.service;

import br.forte.controller.Apis.Zabbix.api.domain.base.Event;
import br.forte.controller.Apis.Zabbix.api.domain.event.EventGetRequest;

import java.util.List;

/**
 * @ClassName: IEventService
 * @Description: event接口
 * @author 李庆雷
 * @date 2013-9-23 上午11:47:57
 */
public interface IEventService {
	/**
	 * @Title: get
	 * @Description: 获得event信息（json格式）
	 * @param get
	 * @return Object
	 * @throws
	 */
	public Object get(EventGetRequest get);

	/**
	 * @Title: getEventToBean
	 * @Description: 获取event的信息（bean）
	 * @param get
	 * @return List<Event>
	 * @throws
	 */
	public List<Event> getEventToBean(EventGetRequest get);
}
