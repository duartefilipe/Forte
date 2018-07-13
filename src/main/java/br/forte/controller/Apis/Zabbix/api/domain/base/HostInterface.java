package br.forte.controller.Apis.Zabbix.api.domain.base;

public class HostInterface {
	private String interfaceid;
	private String dns;
	private String hostid;
	private String ip;
	private Integer main;
	private String port;
	private Integer type;
	private Integer useip;

    public void setInterfaceid(String interfaceid) {
		this.interfaceid = interfaceid;
	}
	public String getInterfaceid() {
		return interfaceid;
	}
	public void setDns(String dns) {
		this.dns = dns;
	}
	public String getDns() {
		return dns;
	}
	public void setHostid(String hostid) {
		this.hostid = hostid;
	}
	public String getHostid() {
		return hostid;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIp() {
		return ip;
	}
	public void setMain(Integer main) {
		this.main = main;
	}
	public Integer getMain() {
		return main;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getPort() {
		return port;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getType() {
		return type;
	}
	public void setUseip(Integer useip) {
		this.useip = useip;
	}
	public Integer getUseip() {
		return useip;
	}
}
