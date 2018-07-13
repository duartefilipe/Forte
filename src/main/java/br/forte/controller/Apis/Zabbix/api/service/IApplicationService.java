package br.forte.controller.Apis.Zabbix.api.service;


import br.forte.controller.Apis.Zabbix.api.domain.application.ApplicationGetRequest;
import br.forte.controller.Apis.Zabbix.api.domain.base.Application;

import java.util.List;

public interface IApplicationService {

    public Object get(ApplicationGetRequest get);

    List<Application> getApplicationToBean(ApplicationGetRequest get);
}
