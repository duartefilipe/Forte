package br.forte.Model;

import br.forte.controller.Apis.Zabbix.api.domain.base.Host;
import br.forte.controller.Apis.Zabbix.api.domain.base.HostInterface;

import java.util.ArrayList;
import java.util.List;

public class HostIntegration {

    private Host host;
    private HostInterface hostInterface;
    private List<Host> hosts;
    private List<HostInterface> hostInterfaces;

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
