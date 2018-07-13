package br.forte.controller.Apis.Zabbix.api.service;

import br.forte.controller.Apis.Zabbix.api.domain.mediatype.MediaTypeCreateRequest;
import br.forte.controller.Apis.Zabbix.api.domain.mediatype.MediaTypeDeleteRequest;
import br.forte.controller.Apis.Zabbix.api.domain.mediatype.MediaTypeGetRequest;
import br.forte.controller.Apis.Zabbix.api.domain.mediatype.MediaTypeUpdateRequest;

public interface IMediatypeService {
	public Object mediaTypeCreate(MediaTypeCreateRequest mediaTypeCreate);
	public Object mediaTypeDelete(MediaTypeDeleteRequest mediaTypeDelete);
	public Object mediaTypeGet(MediaTypeGetRequest mediaTypeGet);
	public Object mediaTypeUpdate(MediaTypeUpdateRequest mediaTypeUpdate);
}
