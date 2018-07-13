package br.forte.controller.Apis.Zabbix.api.service;

import br.forte.controller.Apis.Zabbix.api.domain.base.ItemPrototype;
import br.forte.controller.Apis.Zabbix.api.domain.itemprototype.*;

import java.util.List;

public interface IItemprototypeService {
	public Object itemPrototypeCreate(ItemPrototypeCreateRequest itemPrototypeCreate);
	public Object itemPrototypeDelete(ItemPrototypeDeleteRequest itemPrototypeDelete);
	public Object itemPrototypeExists(ItemPrototypeExistsRequest itemPrototypeExists);
	public Object itemPrototypeGet(ItemPrototypeGetRequest itemPrototypeGet);
	public Object itemPrototypeIsreadable(ItemPrototypeIsreadableRequest itemPrototypeIsreadable);
	public Object itemPrototypeIswritable(ItemPrototypeIswritableRequest itemPrototypeIswritable);
	public Object itemPrototypeUpdate(ItemPrototypeUpdateRequest itemPrototypeUpdate);
	public List<ItemPrototype> itemPrototypeGetToBean(ItemPrototypeGetRequest itemPrototypeGet);
}
