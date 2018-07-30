package br.forte.Model;

import br.forte.controller.Apis.Zabbix.api.domain.base.Host;
import br.forte.controller.Apis.Zabbix.api.domain.base.HostGroup;
import br.forte.controller.Apis.Zabbix.api.domain.base.HostInterface;

import java.util.ArrayList;
import java.util.List;

public class HostIntegration {

    private Host host;
    private HostInterface hostInterface;
    private HostGroup hostGroup;
    private List<Host> hosts;
    private List<HostInterface> hostInterfaces;
    private List<HostGroup> hostGroups;

    public HostGroup getHostGroup() {
        return hostGroup;
    }

    public void setHostGroup(HostGroup hostGroup) {
        this.hostGroup = hostGroup;
    }

    public List<HostGroup> getHostGroups() {
        return hostGroups;
    }

    public void setHostGroups(List<HostGroup> hostGroups) {
        this.hostGroups = hostGroups;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public HostInterface getHostInterface() {
        return hostInterface;
    }

    public void setHostInterface(HostInterface hostInterface) {
        this.hostInterface = hostInterface;
    }

    public List<Host> getHosts() {
        return hosts;
    }

    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }

    public List<HostInterface> getHostInterfaces() {
        return hostInterfaces;
    }

    public void setHostInterfaces(List<HostInterface> hostInterfaces) {
        this.hostInterfaces = hostInterfaces;
    }
}
