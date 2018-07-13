package br.forte.controller.Apis.Zabbix.api.domain.mediatype;

import br.forte.controller.Apis.Zabbix.api.domain.base.MediaType;
import br.forte.controller.Apis.Zabbix.api.domain.base.RequestBase;

import java.util.ArrayList;
import java.util.List;

public class MediaTypeCreateRequest extends RequestBase {
	public MediaTypeCreateRequest() {
		super("mediatype.create");
	}
	private List<MediaType> params;
	public void setParams(List<MediaType> params) {
		this.params = params;
	}
	public List<MediaType> getParams() {
		 if(params==null){
			params   = new ArrayList<MediaType>();
			return params;
		}
		 return params;
	}
}
