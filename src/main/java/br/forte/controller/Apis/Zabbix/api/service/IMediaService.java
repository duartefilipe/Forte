package br.forte.controller.Apis.Zabbix.api.service;

import br.forte.controller.Apis.Zabbix.api.domain.media.MediaGetRequest;

public interface IMediaService {
	public Object get(MediaGetRequest get);
}
