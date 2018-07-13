package br.forte.controller.Apis.Zabbix.api.domain.host;
import br.forte.controller.Apis.Zabbix.api.domain.base.Host;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;

import java.util.*;


public class HostExistsRequest extends RequestBase {
	public HostExistsRequest() {
		super("host.exists");
	}
	private HostExistsParams params = new HostExistsParams();
	public void setParams(HostExistsParams params) {
		this.params = params;
	}
	public HostExistsParams getParams() {
		return params;
	}
	public static class HostExistsParams extends Host {
		private String node;
		private List<String> nodeids;
		public void setNode(String node) {
			this.node = node;
		}
		public String getNode() {
			return node;
		}
		public void setNodeids(List<String> nodeids) {
			this.nodeids = nodeids;
		}
		public List<String> getNodeids() {
			 if(nodeids==null){
				nodeids   = new ArrayList<String>();
				return nodeids;
			}
			 return nodeids;
		}
	}
}
