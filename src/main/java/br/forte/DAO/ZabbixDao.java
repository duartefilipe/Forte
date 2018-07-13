package br.forte.DAO;

import br.forte.Model.HostIntegration;
import br.forte.Model.Usuario;
import br.forte.controller.Apis.Zabbix.api.domain.base.*;
import br.forte.controller.Apis.Zabbix.api.domain.host.HostDeleteRequest;
import br.forte.controller.Apis.Zabbix.api.domain.host.HostGetRequest;
import br.forte.controller.Apis.Zabbix.api.domain.hostgroup.HostGroupCreateRequest;
import br.forte.controller.Apis.Zabbix.api.domain.hostgroup.HostGroupGetRequest;
import br.forte.controller.Apis.Zabbix.api.domain.hostinterface.HostInterfaceGetRequest;
import br.forte.controller.Apis.Zabbix.api.domain.usergroup.UserGroupCreateRequest;
import br.forte.controller.Apis.Zabbix.api.domain.usergroup.UserGroupGetRequest;
import br.forte.controller.Apis.Zabbix.api.service.*;
import br.forte.controller.Apis.Zabbix.api.service.impl.*;
import br.forte.controller.Apis.Zabbix.util.FormatData;
import br.forte.util.Connect;
import com.google.gson.Gson;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

import static br.forte.DAO.UsuarioDao.login;

public class ZabbixDao {

    private static IHostService hostService = new HostServiceImpl();
    private static IUserService userService = new UserServiceImpl();
    private static IHostinterfaceService hostinterfaceService = new HostinterfaceServiceImpl();
    private static IHostgroupService hostgroupService = new HostgroupServiceImpl();


    private static Logger log = Logger.getLogger(String.valueOf(HostinterfaceServiceImpl.class));

//    static {
//        System.out.println("ta aqui no login do zabbix dao");
//        new UsuarioDao().login();
//    }

    public boolean CreateHost(Usuario usuario, Host host, HostGroup hostGroup, HostInterface hostInterface, Template template, Macro macro) {
        boolean retorno;

        System.out.println("ta no test create host");

        try {

            Connection c = null;
            PreparedStatement stmt = null;

            String nome = host.getName();
            String hos = host.getHost();
            String status = String.valueOf(host.getStatus());
            String tipo = String.valueOf(hostInterface.getType());
            String ip = hostInterface.getIp();
            String dns = hostInterface.getDns();
            String useip = String.valueOf(hostInterface.getUseip());
            String main = String.valueOf(hostInterface.getMain());
            String porta = hostInterface.getPort();
            String temp = template.getTemplateid();
            String mac = macro.getMacro();
            String val = macro.getValue();
            int idUsuario = Integer.parseInt(usuario.getIdUsuario());
            int grupoid = Integer.parseInt(hostGroup.getGroupid());


            try {
                c = Connect.getConexao();
                String sql = "INSERT INTO host (nome, hos, status, tipo, ip, dns, useip, main, porta, temp, mac, val, idusuario) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                stmt = c.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, hos);
                stmt.setString(3, status);
                stmt.setString(4, tipo);
                stmt.setString(5, ip);
                stmt.setString(6, dns);
                stmt.setString(7, useip);
                stmt.setString(8, main);
                stmt.setString(9, porta);
                stmt.setString(10, temp);
                stmt.setString(11, mac);
                stmt.setString(12, val);
                stmt.setInt(13, idUsuario);
//                stmt.setInt(14, grupoid);

//          ARRUMAR AQUI NA TABELA DO POSTGRES O HOSTGROUP NAME
                stmt.execute();
                stmt.close();


                String ss = hostService.createHost(host, hostInterface, hostGroup, template, macro);

//                HostGroupCreateRequest hostGroupCreate = new HostGroupCreateRequest();
//
//                hostGroup.setName(String.valueOf(grupoid));
//                hostGroupCreate.getParams().add(hostGroup);
//
//                JSONObject rs = (JSONObject) hostgroupService.hostGroupCreate(hostGroupCreate);
//                if (rs.has("result")) {
//                    try {
//                        JSONObject result =(JSONObject) rs.get("result");
//                        JSONArray ids  = (JSONArray) result.get("groupids");
//                        String id = (String) ids.get(0);
//                        System.out.println("Aqui no IDs: "+id);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//                else if (rs.has("error")) {
//                    try {
//                        JSONObject result = (JSONObject) rs.get("error");
//                        String errormessage = (String) result.get("data");
//                        System.out.println(errormessage);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }

//                System.out.println(rs);
                System.out.println(ss);
            } catch (Exception e) {
                System.out.println("Erro para o cadastro: " + e);
            }

            retorno = true;

            return retorno;
        }catch (Exception e){
            System.out.println("ERRO: "+e);
        }

        retorno = true;
        return retorno;
    }

    public boolean CreateHostGroup(HostGroup hostGroup) {
        boolean retorno;
//        HostGroup hostGroup = new HostGroup();

        System.out.println("ta no test create hostgroup");

        try {

            Connection c = null;
            PreparedStatement stmt = null;

            String nome = hostGroup.getName();
//            int iduser = Integer.parseInt(hostGroup.getGroupid());
//            System.out.println("Nome do grupo que vai cadastrar host group: " + nome);

                c = Connect.getConexao();
                String sql = "INSERT INTO hostgroup (name) values(?)";
                stmt = c.prepareStatement(sql);
                stmt.setString(1, nome);
//                stmt.setInt(2, iduser);

                stmt.execute();
                stmt.close();

                login();

                HostGroupCreateRequest hostGroupCreate = new HostGroupCreateRequest();
                hostGroup.setName(String.valueOf(nome));
                hostGroupCreate.getParams().add(hostGroup);
                JSONObject rs = (JSONObject) hostgroupService.hostGroupCreate(hostGroupCreate);
                if (rs.has("result")) {
                    try {
                        JSONObject result = (JSONObject) rs.get("result");
                        JSONArray ids = (JSONArray) result.get("groupids");
                        String id = (String) ids.get(0);
                        System.out.println("Aqui no IDs: " + id);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (rs.has("error")) {
                    try {
                        JSONObject result = (JSONObject) rs.get("error");
                        String errormessage = (String) result.get("data");
                        System.out.println(errormessage);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(rs);

            UsuarioDao usuarioDao = new UsuarioDao();
            UserGroup userGroup = new UserGroup();
            userGroup.setName(nome);

            usuarioDao.cadastraUserGroup(userGroup);

            retorno = true;
            return retorno;

        }catch (Exception e){
            System.out.println("Erro: "+e);
        }
        retorno = true;
        return retorno;
    }


    public boolean AlteraHost(Host host, HostGroup hostGroup, HostInterface hostInterface, Template template, Macro macro) {
        boolean retorno;

        System.out.println("ta no test altera host");

        try {
            String ss = hostService.alteraHost(host, hostInterface, hostGroup, template, macro);

            System.out.println(ss);
        }catch (Exception e){
            System.out.println("Erro para o altera: "+e);
        }


        retorno = true;

        return retorno;
    }

    public List<HostIntegration> getHost() {

        ArrayList<HostIntegration> hostIntegrations = new ArrayList<HostIntegration>();


        ArrayList<Host> hosts = new ArrayList<Host>();

        HostGetRequest hostGet = new HostGetRequest();

        JSONObject result = (JSONObject) this.hostGet(hostGet);
        System.out.println("Objet JSON host :  "+result.toString());
        if (result != null) {
            if (result.has("result")) {
                try {
                    JSONArray array = result.getJSONArray("result");

                    if (array != null && array.length() > 0) {

                        for (int i = 0; i < array.length(); i++) {

                            Host host = new Host();

                            JSONObject object = array.getJSONObject(i);
                            host.setHost(object.getString("host"));
                            host.setHostid(object.getString("hostid"));
                            host.setName(object.getString("name"));

                            hosts.add(host);

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }

            } else if (result.has("error")) {
                return null;
            }
        }

        ArrayList<HostInterface> hostinterfaces = new ArrayList<HostInterface>();

        HostInterfaceGetRequest hostinterfaceGet = new HostInterfaceGetRequest();

        JSONObject hostinterfacesObject = (JSONObject) this.hostInterfaceGet(hostinterfaceGet);

        System.out.println("Objet JSON host interfaces:  "+hostinterfacesObject.toString());
        if(hostinterfacesObject!=null){
            if (hostinterfacesObject.has("result")) {
                try {
                    JSONArray array = hostinterfacesObject.getJSONArray("result");

                    if (array != null && array.length() > 0) {

                        for (int i = 0; i < array.length(); i++) {

                            HostInterface hostInterface = new HostInterface();

                            JSONObject object = array.getJSONObject(i);
                            hostInterface.setInterfaceid(object.getString("interfaceid"));
                            hostInterface.setIp(object.getString("ip"));
                            hostInterface.setHostid(object.getString("hostid"));
                            hostInterface.setDns(object.getString("dns"));
                            hostInterface.setPort(object.getString("port"));

                            hostinterfaces.add(hostInterface);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            }else {
                System.out.println("ERRO no objeto: ");
        }

        ArrayList<HostGroup> HostGroups = new ArrayList<HostGroup>();

        HostGroupGetRequest hostgroupGet = new HostGroupGetRequest();

        JSONObject hostgroupsObject = (JSONObject) this.hostGroupGet(hostgroupGet);

        System.out.println("Objet JSON host groups:  "+hostgroupsObject.toString());
        if(hostgroupsObject!=null){
            if (hostinterfacesObject.has("result")) {
                try {
                    JSONArray array = hostgroupsObject.getJSONArray("result");

                    if (array != null && array.length() > 0) {

                        for (int i = 0; i < array.length(); i++) {

                            HostGroup hostGroup = new HostGroup();

                            JSONObject object = array.getJSONObject(i);
                            hostGroup.setGroupid(object.getString("groupid"));
                            hostGroup.setName(object.getString("name"));
                            hostGroup.setInternal(object.getInt("internal"));
                            hostGroup.setFlags(object.getString("flags"));

                            HostGroups.add(hostGroup);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }else {
            System.out.println("ERRO no objeto: ");
        }

//        ArrayList<UserGroup> userGroups = new ArrayList<UserGroup>();
//
//        UserGroupGetRequest usergroupGet = new UserGroupGetRequest();
//
//        JSONObject usergroupsObject = (JSONObject) this.userGroupGet(usergroupGet);
//
//        System.out.println("Objet JSON user groups :  "+usergroupsObject.toString());
//        if(hostgroupsObject!=null){
//            if (hostinterfacesObject.has("result")) {
//                try {
//                    JSONArray array = usergroupsObject.getJSONArray("result");
//
//                    if (array != null && array.length() > 0) {
//
//                        for (int i = 0; i < array.length(); i++) {
//
//                            UserGroup userGroup = new UserGroup();
//
//                            JSONObject object = array.getJSONObject(i);
//                            userGroup.setUsrgrpid(object.getString("usergroupid"));
//                            userGroup.setName(object.getString("name"));
//                            userGroup.setDebug_mode(object.getInt("debug_mode"));
//                            userGroup.setGui_access(object.getInt("gui_access"));
//                            userGroup.setUsers_status(object.getInt("users_status"));
//                            userGroups.add(userGroup);
//                        }
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }else {
//            System.out.println("ERRO no objeto: ");
//        }

        //trazer apenas hosts do usuario logado
        HostIntegration hostIntegration = null;
            for (int h = 0; h < hosts.size() ; h++ ) {
                hostIntegration = new HostIntegration();
                    for (int hi = 0 ;hi < hostinterfaces.size() ; hi++) {
                        if (hosts.get(h).getHostid().equals(hostinterfaces.get(hi).getHostid())) {
                            hostIntegration.setHost(hosts.get(h));
                            hostIntegration.setHostInterface(hostinterfaces.get(hi));
//                            System.out.println("Host IF: "+hostIntegration.getHost().getHost()+" IP IF: "+hostIntegration.getHostInterface().getIp());
                        } else {
                            hostIntegration.setHost(hosts.get(h));
//                            System.out.println("Host ELSE: "+hostIntegration.getHost().getHost());
                        }
                    }
                hostIntegrations.add(hostIntegration);
            }
        return hostIntegrations;
    }

    public Object hostGet(HostGetRequest hostGet){
        Gson js = new Gson();
        HttpClient client = new HttpClient();
        PostMethod putMethod = new PostMethod(FormatData.API_URL);
        putMethod.setRequestHeader("Content-Type", "application/json-rpc");
        JSONObject rs =null;
        try {
            String json = js.toJson(hostGet);
            putMethod.setRequestBody( FormatData.fromString(json));
            client.executeMethod(putMethod);
            String response = putMethod.getResponseBodyAsString();
            rs = new JSONObject(response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public List<HostInterface> getHostInterface() {

        ArrayList<HostInterface> hostinterfaces = new ArrayList<HostInterface>();

        HostInterfaceGetRequest hostinterfaceGet = new HostInterfaceGetRequest();

        JSONObject result = (JSONObject) this.hostInterfaceGet(hostinterfaceGet);

        if(result!=null){
            if (result.has("result")) {
                try {
                    JSONArray array = result.getJSONArray("result");

                    if(array!=null&&array.length()>0){

                        for(int i=0;i<array.length();i++){

                            HostInterface hostInterface = new HostInterface();

                            JSONObject object = array.getJSONObject(i);

                            hostInterface.setIp(object.getString("ip"));

                            hostinterfaces.add(hostInterface);

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
                return hostinterfaces;
            }else if (result.has("error")) {
                return null;
            }
        }
        return hostinterfaces;
    }

    public Object hostInterfaceGet(HostInterfaceGetRequest hostInterfaceGet){
        Gson js = new Gson();
        HttpClient client = new HttpClient();
        PostMethod putMethod = new PostMethod(FormatData.API_URL);
        putMethod.setRequestHeader("Content-Type", "application/json-rpc");
        JSONObject rs =null;
        try {
            String json = js.toJson(hostInterfaceGet);
            putMethod.setRequestBody( FormatData.fromString(json));
            client.executeMethod(putMethod);
            String response = putMethod.getResponseBodyAsString();
            rs = new JSONObject(response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public List<HostGroup> getHostGroup() {

        ArrayList<HostGroup> hostGroups = new ArrayList<HostGroup>();

        HostGroupGetRequest hostGroupGet = new HostGroupGetRequest();

        JSONObject result = (JSONObject) this.hostGroupGet(hostGroupGet);

        if(result!=null){
            if (result.has("result")) {
                try {
                    JSONArray array = result.getJSONArray("result");

                    if(array!=null&&array.length()>0){

                        for(int i=0;i<array.length();i++){

                            HostGroup hostGroup = new HostGroup();

                            JSONObject object = array.getJSONObject(i);

                            hostGroup.setGroupid(object.getString("groupid"));
                            hostGroup.setName(object.getString("name"));
                            hostGroup.setInternal(object.getInt("internal"));
                            hostGroup.setFlags(object.getString("flags"));
                            hostGroups.add(hostGroup);

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
                return hostGroups;
            }else if (result.has("error")) {
                return null;
            }
        }
        return hostGroups;
    }

    public Object hostGroupGet(HostGroupGetRequest hostGroupGet){
        Gson js = new Gson();
        HttpClient client = new HttpClient();
        PostMethod putMethod = new PostMethod(FormatData.API_URL);
        putMethod.setRequestHeader("Content-Type", "application/json-rpc");
        JSONObject rs =null;
        try {
            String json = js.toJson(hostGroupGet);
            putMethod.setRequestBody( FormatData.fromString(json));
            client.executeMethod(putMethod);
            String response = putMethod.getResponseBodyAsString();
            rs = new JSONObject(response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public List<UserGroup> getUserGroup() {

        ArrayList<UserGroup> userGroups = new ArrayList<UserGroup>();

        UserGroupGetRequest userGroupGet = new UserGroupGetRequest();

        JSONObject result = (JSONObject) this.userGroupGet(userGroupGet);

        if(result!=null){
            if (result.has("result")) {
                try {
                    JSONArray array = result.getJSONArray("result");

                    if(array!=null&&array.length()>0){

                        for(int i=0;i<array.length();i++){

                            UserGroup userGroup = new UserGroup();

                            JSONObject object = array.getJSONObject(i);

                            userGroup.setUsrgrpid(object.getString("usergroupid"));
                            userGroup.setName(object.getString("name"));
                            userGroup.setDebug_mode(object.getInt("debug_mode"));
                            userGroup.setGui_access(object.getInt("gui_access"));
                            userGroup.setUsers_status(object.getInt("user_status"));

                            userGroups.add(userGroup);

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
                return userGroups;
            }else if (result.has("error")) {
                return null;
            }
        }
        return userGroups;
    }

    public Object userGroupGet(UserGroupGetRequest userGroupGet){
        Gson js = new Gson();
        HttpClient client = new HttpClient();
        PostMethod putMethod = new PostMethod(FormatData.API_URL);
        putMethod.setRequestHeader("Content-Type", "application/json-rpc");
        JSONObject rs =null;
        try {
            String json = js.toJson(userGroupGet);
            putMethod.setRequestBody( FormatData.fromString(json));
            client.executeMethod(putMethod);
            String response = putMethod.getResponseBodyAsString();
            rs = new JSONObject(response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public boolean Delete(String id) {
        int id2 = Integer.parseInt(id);
        Connection c = null;
        PreparedStatement stmt = null;
        boolean retorno = false;

        HostDeleteRequest hostDeleteRequest = new HostDeleteRequest();
        Host host = new Host();


        try {

            c = Connect.getConexao();
            String sql=" delete from host where idhost=?";
            stmt = c.prepareStatement(sql);
            stmt.setString(1,id);
            stmt.execute();
            stmt.close();

            host.setHostid(id);

            retorno = hostDeleteRequest.getParams().add(id);

            hostService.delete(hostDeleteRequest);

            System.out.println("retorno: "+retorno);

            return retorno;

        }catch (Exception e){
            System.out.println("Erro: "+e);
            return retorno;

        }


    }

    public ArrayList<HostIntegration> getHostsAdmin(String id, int tipo) throws ClassNotFoundException {

        System.out.println("ID do usuario: " + id);
        System.out.println("tipo do usuario: " + tipo);

        ArrayList<HostIntegration> hostIntegrations = new ArrayList<HostIntegration>();
//        HostIntegration hostIntegration = new HostIntegration();

        ArrayList<Host> hosts = new ArrayList<Host>();
        ArrayList<HostInterface> hostInterfaces = new ArrayList<HostInterface>();

//        Host h = null;
//        HostInterface hi = null;

        Connection con = Connect.getConexao();

        try {
            String sql = null;
//                String sql = "SELECT idhost, nome, hos, status, tipo, ip, dns, useip, main, porta FROM host";
            if(tipo == 3){
                sql = "SELECT * FROM host";
            }else if(tipo == 2){
                sql = "select*from host where idusuario = "+id+"";
            }
            System.out.println("SQL: "+sql);
//            String sql = "SELECT * FROM host";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            //ta trazendo a quantidade de hosts certa, mas repetidos

            while (rs.next()) {
                Host h = new Host();
                HostInterface hi = new HostInterface();

                h.setHostid(rs.getString("idhost"));
                h.setName(rs.getString("nome"));
                h.setHost(rs.getString("hos"));
                h.setStatus(rs.getInt("status"));

                hosts.add(h);

                hi.setType(rs.getInt("tipo"));
                hi.setIp(rs.getString("ip"));
                hi.setDns(rs.getString("dns"));
                hi.setUseip(rs.getInt("useip")); //1 - SNMP
                hi.setMain(rs.getInt("main"));
                hi.setPort(rs.getString("porta"));

                hostInterfaces.add(hi);

            }

            //trazer apenas hosts do usuario logado

                HostIntegration hostIntegration = null;
                for (int h = 0; h < hosts.size(); h++) {
                    for (int hi = 0; hi < hostInterfaces.size(); hi++) {
                        hostIntegration = new HostIntegration();
                        hostIntegration.setHost(hosts.get(h));
                        hostIntegration.setHostInterface(hostInterfaces.get(hi));
                    }
                    hostIntegrations.add(hostIntegration);
                }

        }catch (Exception e) {

            System.out.println("ERRO no try catch: " + e);
        }
        return hostIntegrations;

    }
}
