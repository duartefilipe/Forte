package br.forte.DAO;

import br.forte.Model.HostIntegration;
import br.forte.Model.Usuario;
import br.forte.controller.Apis.Zabbix.api.domain.base.*;
import br.forte.controller.Apis.Zabbix.api.domain.host.HostCreateRequest;
import br.forte.controller.Apis.Zabbix.api.domain.host.HostDeleteRequest;
import br.forte.controller.Apis.Zabbix.api.domain.host.HostGetRequest;
import br.forte.controller.Apis.Zabbix.api.domain.hostgroup.HostGroupCreateRequest;
import br.forte.controller.Apis.Zabbix.api.domain.hostgroup.HostGroupGetRequest;
import br.forte.controller.Apis.Zabbix.api.domain.hostinterface.HostInterfaceGetRequest;
import br.forte.controller.Apis.Zabbix.api.domain.template.TemplateGetRequest;
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
    private static IHostgroupService hostgroupService = new HostgroupServiceImpl();


    private static Logger log = Logger.getLogger(String.valueOf(HostinterfaceServiceImpl.class));

    public boolean CreateHost(Usuario usuario, Host host, HostGroup hostGroup, HostInterface hostInterface, Template template, Macro macro) {
        boolean retorno;

        System.out.println("ta no test create host");

        try {

            Connection c = null;
            PreparedStatement stmt = null;

            String nome = host.getName();
            String hos = host.getHost();
            int status = host.getStatus();
            int tipo = hostInterface.getType(); // 1 - agent; 2 - SNMP; 3 - IPMI 4 - JMX.
            String ip = hostInterface.getIp();
            String dns = hostInterface.getDns();
            int useip = hostInterface.getUseip();  // 0 - connect using host DNS name 1 - // connect using host IP address.
            int main = hostInterface.getMain(); // 0 - not default; 1 - default.
            String porta = hostInterface.getPort();
            String temp = template.getNameTemplate();
            String mac = macro.getMacro();
            String val = macro.getValue();
            int idUsuario = Integer.parseInt(usuario.getIdUsuario());
            String grupo = hostGroup.getGroupid();

            c = Connect.getConexao();

            String sql = "INSERT INTO host (namehost, hos, status, tipo, ip, dns, useip, main, porta, temp, mac, val, idusuario) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, hos);
            stmt.setInt(3, status);
            stmt.setInt(4, tipo);
            stmt.setString(5, ip);
            stmt.setString(6, dns);
            stmt.setInt(7, useip);
            stmt.setInt(8, main);
            stmt.setString(9, porta);
            stmt.setString(10, temp);
            stmt.setString(11, mac);
            stmt.setString(12, val);
            stmt.setInt(13, idUsuario);

            stmt.execute();
            stmt.close();

            login();

		HostCreateRequest create = new HostCreateRequest();

		create.getParams().setHost(hos);
		create.getParams().setName(nome);
		hostGroup.setGroupid(grupo);

		create.getParams().getGroups().add(hostGroup);
		hostInterface.setType(tipo);
		hostInterface.setIp(ip);
		hostInterface.setDns(dns);
		hostInterface.setUseip(useip);
		hostInterface.setMain(main);
		hostInterface.setPort(porta);
		create.getParams().getInterfaces().add(hostInterface);

		macro.setMacro(mac);
		macro.setValue(val);

		create.getParams().getMacros().add(macro);
		create.getParams().setStatus(status);
		template.setTemplateid(temp);
		create.getParams().getTemplates().add(template);

		hostService.create(create);

        retorno = true;
        return retorno;

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }

        retorno = true;
        return retorno;
    }

    public boolean CreateHostGroup(HostGroup hostGroup) {
        System.out.println("Ta no metodo cad hostGroup");
        boolean retorno;

        try {
            Connection c = null;
            PreparedStatement stmt = null;
            String nome = hostGroup.getName();

            c = Connect.getConexao();

            //alterar e colocar o id do hostgroup no usuario e tirar do hostgrouo
            String sql = "INSERT INTO hostgroup (namehostgroup) values(?)";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, nome);

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
                    //String id = (String) ids.get(0);
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

            retorno = true;
            return retorno;

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
        retorno = true;
        return retorno;
    }

    public ArrayList<HostGroup> getUltHostGroup() throws ClassNotFoundException {

        ArrayList<HostGroup> HostGroups = new ArrayList<HostGroup>();
        Connection con = Connect.getConexao();
        HostGroup hos;

        try {
            String sql = "SELECT hostgroupid FROM hostgroup ORDER BY hostgroupid DESC LIMIT 1;";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                hos = new HostGroup();
                hos.setGroupid(rs.getString("hostgroupid"));
                HostGroups.add(hos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return HostGroups;
    }

    public boolean AlteraHost(Host host, HostGroup hostGroup, HostInterface hostInterface, Template template, Macro macro) {
        boolean retorno;

        System.out.println("ta no test altera host");

        try {
            String ss = hostService.alteraHost(host, hostInterface, hostGroup, template, macro);

            System.out.println(ss);
        } catch (Exception e) {
            System.out.println("Erro para o altera: " + e);
        }


        retorno = true;

        return retorno;
    }

    public List<HostIntegration> getHost() {

        ArrayList<HostIntegration> hostIntegrations = new ArrayList<HostIntegration>();
        ArrayList<Host> hosts = new ArrayList<Host>();
        HostGetRequest hostGet = new HostGetRequest();
        JSONObject result = (JSONObject) this.hostGet(hostGet);
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

        if (hostinterfacesObject != null) {
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
        } else {
            System.out.println("ERRO no objeto: ");
        }

        ArrayList<HostGroup> HostGroups = new ArrayList<HostGroup>();

        HostGroupGetRequest hostgroupGet = new HostGroupGetRequest();

        JSONObject hostgroupsObject = (JSONObject) this.hostGroupGet(hostgroupGet);

//        System.out.println("Objet JSON host groups:  "+hostgroupsObject.toString());
        if (hostgroupsObject != null) {
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
        } else {
            System.out.println("ERRO no objeto: ");
        }

        //trazer apenas hosts do usuario logado
        HostIntegration hostIntegration = null;
        for (int h = 0; h < hosts.size(); h++) {
            hostIntegration = new HostIntegration();
            for (int hi = 0; hi < hostinterfaces.size(); hi++) {
                if (hosts.get(h).getHostid().equals(hostinterfaces.get(hi).getHostid())) {
                    hostIntegration.setHost(hosts.get(h));
                    hostIntegration.setHostInterface(hostinterfaces.get(hi));
                } else {
                    hostIntegration.setHost(hosts.get(h));
                }
            }
            hostIntegrations.add(hostIntegration);
        }
        return hostIntegrations;
    }

    public Object hostGet(HostGetRequest hostGet) {
        Gson js = new Gson();
        HttpClient client = new HttpClient();
        PostMethod putMethod = new PostMethod(FormatData.API_URL);
        putMethod.setRequestHeader("Content-Type", "application/json-rpc");
        JSONObject rs = null;
        try {
            String json = js.toJson(hostGet);
            putMethod.setRequestBody(FormatData.fromString(json));
            client.executeMethod(putMethod);
            String response = putMethod.getResponseBodyAsString();
            rs = new JSONObject(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public List<HostInterface> getHostInterface() {

        ArrayList<HostInterface> hostinterfaces = new ArrayList<HostInterface>();

        HostInterfaceGetRequest hostinterfaceGet = new HostInterfaceGetRequest();

        JSONObject result = (JSONObject) this.hostInterfaceGet(hostinterfaceGet);

        if (result != null) {
            if (result.has("result")) {
                try {
                    JSONArray array = result.getJSONArray("result");

                    if (array != null && array.length() > 0) {

                        for (int i = 0; i < array.length(); i++) {

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
            } else if (result.has("error")) {
                return null;
            }
        }
        return hostinterfaces;
    }

    public Object hostInterfaceGet(HostInterfaceGetRequest hostInterfaceGet) {
        Gson js = new Gson();
        HttpClient client = new HttpClient();
        PostMethod putMethod = new PostMethod(FormatData.API_URL);
        putMethod.setRequestHeader("Content-Type", "application/json-rpc");
        JSONObject rs = null;
        try {
            String json = js.toJson(hostInterfaceGet);
            putMethod.setRequestBody(FormatData.fromString(json));
            client.executeMethod(putMethod);
            String response = putMethod.getResponseBodyAsString();
            rs = new JSONObject(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public List<HostGroup> getHostGroup() {

        ArrayList<HostGroup> hostGroups = new ArrayList<HostGroup>();

        HostGroupGetRequest hostGroupGet = new HostGroupGetRequest();

        JSONObject result = (JSONObject) this.hostGroupGet(hostGroupGet);

        if (result != null) {
            if (result.has("result")) {
                try {
                    JSONArray array = result.getJSONArray("result");

                    if (array != null && array.length() > 0) {

                        for (int i = 0; i < array.length(); i++) {

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
            } else if (result.has("error")) {
                return null;
            }
        }
        return hostGroups;
    }

    public Object hostGroupGet(HostGroupGetRequest hostGroupGet) {
        Gson js = new Gson();
        HttpClient client = new HttpClient();
        PostMethod putMethod = new PostMethod(FormatData.API_URL);
        putMethod.setRequestHeader("Content-Type", "application/json-rpc");
        JSONObject rs = null;
        try {
            String json = js.toJson(hostGroupGet);
            putMethod.setRequestBody(FormatData.fromString(json));
            client.executeMethod(putMethod);
            String response = putMethod.getResponseBodyAsString();
            rs = new JSONObject(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public List<UserGroup> getUserGroup() {

        ArrayList<UserGroup> userGroups = new ArrayList<UserGroup>();

        UserGroupGetRequest userGroupGet = new UserGroupGetRequest();

        JSONObject result = (JSONObject) this.userGroupGet(userGroupGet);

        if (result != null) {
            if (result.has("result")) {
                try {
                    JSONArray array = result.getJSONArray("result");

                    if (array != null && array.length() > 0) {

                        for (int i = 0; i < array.length(); i++) {

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
            } else if (result.has("error")) {
                return null;
            }
        }
        return userGroups;
    }

    public Object userGroupGet(UserGroupGetRequest userGroupGet) {
        Gson js = new Gson();
        HttpClient client = new HttpClient();
        PostMethod putMethod = new PostMethod(FormatData.API_URL);
        putMethod.setRequestHeader("Content-Type", "application/json-rpc");
        JSONObject rs = null;
        try {
            String json = js.toJson(userGroupGet);
            putMethod.setRequestBody(FormatData.fromString(json));
            client.executeMethod(putMethod);
            String response = putMethod.getResponseBodyAsString();
            rs = new JSONObject(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public boolean Delete(String id) {
        System.out.println("Entrou no remover zabbic dao com o id: "+id);

        int id2 = Integer.parseInt(id);

        Connection c = null;
        PreparedStatement stmt = null;
        boolean retorno = false;

        Host host = new Host();

        try {
            c = Connect.getConexao();
            String sql = " delete from host where idhost=?";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id2);
            stmt.execute();
            stmt.close();

            login();

            HostDeleteRequest hostDeleteRequest = new HostDeleteRequest();

            hostDeleteRequest.getParams().add(id);

            hostService.delete(hostDeleteRequest);

            System.out.println("retorno: " + retorno);

            retorno = true;
            return retorno;

        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return retorno;

        }


    }

    public ArrayList<HostIntegration> getHostsAdmin(String id, int tipo) throws ClassNotFoundException {

        ArrayList<HostIntegration> hostIntegrations = new ArrayList<HostIntegration>();
        ArrayList<Host> hosts = new ArrayList<Host>();
        ArrayList<HostInterface> hostInterfaces = new ArrayList<HostInterface>();
        Connection con = Connect.getConexao();

        try {
            String sql = null;
            if (tipo == 3) {
                sql = "SELECT * FROM host";
//            } else if (tipo == 2) {
            } else{
                sql = "select*from host where idusuario = " + id + "";
            }
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            //ta trazendo a quantidade de hosts certa, mas repetidos
            while (rs.next()) {
                Host h = new Host();
                HostInterface hi = new HostInterface();

                h.setHostid(rs.getString("idhost"));
                h.setName(rs.getString("namehost"));
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

            //todos hosts
            HostIntegration hostIntegration = null;
            for (int h = 0; h < hosts.size(); h++) {
                hostIntegration = new HostIntegration();
                for (int hi = 0; hi < hostInterfaces.size(); hi++) {
                    hostIntegration.setHost(hosts.get(h));
                    hostIntegration.setHostInterface(hostInterfaces.get(hi));
                }
                hostIntegrations.add(hostIntegration);
            }

        } catch (Exception e) {

            System.out.println("ERRO no try catch trazer hosts: " + e);
        }
        return hostIntegrations;

    }

    public ArrayList<HostGroup> getHostsGroup() throws ClassNotFoundException {

        ArrayList<HostIntegration> hostIntegrations = new ArrayList<HostIntegration>();
        ArrayList<Host> hosts = new ArrayList<Host>();
        ArrayList<HostInterface> hostInterfaces = new ArrayList<HostInterface>();
        ArrayList<HostGroup> hostgroups = new ArrayList<HostGroup>();

        Connection con = Connect.getConexao();

        try {
            String sql = "select * from hostgroup";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            //ta trazendo a quantidade de hosts certa, mas repetidos
            while (rs.next()) {
                Host h = new Host();
                HostInterface hi = new HostInterface();
                HostGroup hg = new HostGroup();

                hg.setGroupid(rs.getString("hostgroupid"));
                hg.setName(rs.getString("namehostgroup"));
                hostgroups.add(hg);
            }



        } catch (Exception e) {

            System.out.println("ERRO no try catch trazer hosts: " + e);
        }
        return hostgroups;

    }

    public List<Template> getTemplate() {

        ArrayList<Template> templates = new ArrayList<Template>();

        TemplateGetRequest templateGet = new TemplateGetRequest();

        JSONObject result = (JSONObject) this.templateGet(templateGet);

        if (result != null) {
            if (result.has("result")) {
                try {
                    JSONArray array = result.getJSONArray("result");

                    if (array != null && array.length() > 0)for (int i = 0; i < array.length(); i++) {

                            Template template = new Template();

                            JSONObject object = array.getJSONObject(i);

                            template.setTemplateid(object.getString("templateid"));
                            template.setNameTemplate(object.getString("nameTemplate"));

                            templates.add(template);


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
                return templates;
            } else if (result.has("error")) {
                return null;
            }
        }
        return templates;
    }

    public Object templateGet(TemplateGetRequest templateGet) {
        Gson js = new Gson();
        HttpClient client = new HttpClient();
        PostMethod putMethod = new PostMethod(FormatData.API_URL);
        putMethod.setRequestHeader("Content-Type", "application/json-rpc");
        JSONObject rs = null;
        try {
            String json = js.toJson(templateGet);
            putMethod.setRequestBody(FormatData.fromString(json));
            client.executeMethod(putMethod);
            String response = putMethod.getResponseBodyAsString();
            rs = new JSONObject(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
