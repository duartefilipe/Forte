package br.forte.Model;

import br.forte.controller.Apis.Zabbix.api.domain.base.Media;
import br.forte.controller.Apis.Zabbix.api.domain.base.User;
import br.forte.controller.Apis.Zabbix.api.domain.base.UserGroup;

import java.util.List;

public class Integration {

    private Media media;
    private User user;
    private UserGroup userGroup;

    public List<Media> getMideas() {
        return mideas;
    }

    public void setMideas(List<Media> mideas) {
        this.mideas = mideas;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<Media> mideas;
    private List<User> users;
    private List<UserGroup> groups;

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public List<UserGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<UserGroup> groups) {
        this.groups = groups;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Media getMedia() {

        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
