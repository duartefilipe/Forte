package br.forte.controller.Apis.Zabbix.api.service;
import br.forte.controller.Apis.Zabbix.api.domain.base.User;
import br.forte.controller.Apis.Zabbix.api.domain.user.*;

import java.util.List;

public interface IUserService {

	public Object get(UserGetRequest get);
	
	public Object login(UserLoginRequest login);
	
	public Object logout(UserLogoutRequest logout);

	public List<User> getUserBean(UserGetRequest get);
	
	public Object addmedia(UserAddmediaRequest addmedia);
	public Object authenticate(UserAuthenticateRequest authenticate);
	public Object create(UserCreateRequest create);
	public Object deleteMedia(UserDeleteMediaRequest deleteMedia);
	public Object delete(UserDeleteRequest delete);
	public Object isreadable(UserIsreadableRequest isreadable);
	public Object iswritable(UserIswritableRequest iswritable);
	public Object updatemedia(UserUpdatemediaRequest updatemedia);
	public Object updateProfile(UserUpdateProfileRequest updateProfile);
	public Object update(UserUpdateRequest update);
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public List<User> getUser(User user);
}
