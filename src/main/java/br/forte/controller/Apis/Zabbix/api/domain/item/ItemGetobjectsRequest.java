package br.forte.controller.Apis.Zabbix.api.domain.item;
import br.forte.controller.Apis.Zabbix.api.domain.base.Item;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;

import java.util.*;


public class ItemGetobjectsRequest extends RequestBase {
	public ItemGetobjectsRequest() {
		super("item.getobjects");
	}
	private ItemGetobjectsParams params = new ItemGetobjectsParams();
	public void setParams(ItemGetobjectsParams params) {
		this.params = params;
	}
	public ItemGetobjectsParams getParams() {
		return params;
	}
	public static class ItemGetobjectsParams extends Item {
		private List<String> host;
		private String node;
		private List<String> nodeids;
		public void setHost(List<String> host) {
			this.host = host;
		}
		public List<String> getHost() {
			 if(host==null){
				host   = new ArrayList<String>();
				return host;
			}
			 return host;
		}
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
