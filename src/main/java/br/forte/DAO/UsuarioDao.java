package br.forte.DAO;

import br.forte.Model.Integration;
import br.forte.Model.Usuario;
import br.forte.controller.Apis.Zabbix.api.domain.base.*;
import br.forte.controller.Apis.Zabbix.api.domain.hostgroup.HostGroupDeleteRequest;
import br.forte.controller.Apis.Zabbix.api.domain.media.MediaGetRequest;
import br.forte.controller.Apis.Zabbix.api.domain.user.UserCreateRequest;
import br.forte.controller.Apis.Zabbix.api.domain.user.UserDeleteRequest;
import br.forte.controller.Apis.Zabbix.api.domain.user.UserGetRequest;
import br.forte.controller.Apis.Zabbix.api.domain.usergroup.UserGroupCreateRequest;
import br.forte.controller.Apis.Zabbix.api.domain.usergroup.UserGroupDeleteRequest;
import br.forte.controller.Apis.Zabbix.api.domain.usergroup.UserGroupGetRequest;
import br.forte.controller.Apis.Zabbix.api.service.IHostgroupService;
import br.forte.controller.Apis.Zabbix.api.service.IUserService;
import br.forte.controller.Apis.Zabbix.api.service.IUsergroupService;
import br.forte.controller.Apis.Zabbix.api.service.impl.HostgroupServiceImpl;
import br.forte.controller.Apis.Zabbix.api.service.impl.UserServiceImpl;
import br.forte.controller.Apis.Zabbix.api.service.impl.UsergroupServiceImpl;
import br.forte.controller.Apis.Zabbix.util.FormatData;
import br.forte.util.Connect;
import com.google.gson.Gson;
import org.apache.commons.httpclient.methods.PutMethod;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONStringer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuarioDao {

    private static IUserService userService = new UserServiceImpl();
    private static IUsergroupService userGroupService = new UsergroupServiceImpl();
    private static IHostgroupService hostGroupService = new HostgroupServiceImpl();
    private static IUsergroupService usergroupService = new UsergroupServiceImpl();

    public static final String url = "http://192.168.199.104/zabbix/api_jsonrpc.php";  //forte pc
    private static String loginName;
    private static String password;

//    private static String loginName = "filipe";
//    private static String password = "eumesmo";

    static{
        FormatData.API_URL = url;
    }

    public Usuario autenticar(String email, String senha) throws ClassNotFoundException, SQLException {

        Connection con = Connect.getConexao();

        System.out.println("Autenticando...");

        String sql = "SELECT * FROM usuario where email =? and senha=?";
        PreparedStatement stmt = con.prepareStatement(sql);

        Usuario u = null;
        System.out.println("SQL: "+sql);
        stmt.setString(1, email);
        stmt.setString(2, senha);


        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            u = new Usuario();

            u.setIdUsuario(rs.getString("idusuario"));
            //System.out.print("Id do usuario: "+u.getIdUsuario()+"\n");

            u.setNome(rs.getString("nome"));
            //System.out.println("nome: " +u.getNome());

            u.setSobrenome(rs.getString("sobrenome"));
            //System.out.println("sobrenome: " +u.getSobrenome());

            u.setEmail(rs.getString("email"));
            //System.out.println("email: " +u.getEmail());

            u.setTelefone(rs.getString("telefone"));
            //System.out.println("telefone: " +u.getTelefone());

            u.setEndereco(rs.getString("endereco"));
            //System.out.println("endereco: " +u.getEndereco());

            u.setSenha(rs.getString("senha"));
            //System.out.println("senha: " +u.getSenha());

            u.setTipo(rs.getInt("tipo"));
            //System.out.println("tipo: " +u.getTipo());

            u.setUserzabbix(rs.getString("userzabbix"));
            //System.out.println("usuario zabbix: " +u.getUserzabbix());

            u.setSenhazabbix(rs.getString("senhazabbix"));
            //System.out.println("senha do zabbix: " +u.getSenhazabbix());

            u.setGrupo(rs.getString("grupo"));
            //System.out.println("senha do zabbix: " +u.getSenhazabbix());



        }
        loginName = u.getUserzabbix();
        password = u.getSenhazabbix();

        return u;
    }

    private static String loginJson(String loginName, String password) {
        JSONStringer js = new JSONStringer();

        try {
            js.object();
            js.key("jsonrpc").value("2.0");
            js.key("method").value("user.login");
            js.key("id").value(1);

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("user", loginName);
            System.out.println("Usuario no Util: "+loginName);

            jsonObject.put("password", password);
            System.out.println("Senha no Util: "+password);

            js.key("params").value(jsonObject);

            js.endObject();

        } catch (JSONException e) {
            return null;
        }
        return js.toString();
    }

    public static HttpClient login() {


        try {
            HttpClient client = new HttpClient();
            PutMethod putMethod = new PutMethod(url);
            putMethod.setRequestHeader("Content-Type", "application/json-rpc");
            String jsonrpc = loginJson(loginName, password);
            JSONObject jsonObj = new JSONObject(jsonrpc);

            putMethod.setRequestBody(FormatData.fromString(jsonObj.toString()));
            String loginResponse = "";
            client.executeMethod(putMethod);
            loginResponse = putMethod.getResponseBodyAsString();
            JSONObject obj = new JSONObject(loginResponse);
            String sessionId = "";

            if (obj.has("result")) {
                sessionId = obj.getString("result");

                FormatData.auth = sessionId; //
                System.out.println(loginResponse);
                System.out.println(sessionId);
                return client;

            } else if (obj.has("error")) {
                sessionId = obj.getJSONObject("error").getString("data");
                throw new Exception(sessionId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean cadastraUsuario(Usuario u) throws SQLException {
        System.out.println("Ta no cadstrar usuario");
        Connection c = null;
        PreparedStatement stmt = null;
        boolean retorno = false;

        String nome = u.getNome();
        String sobrenome = u.getSobrenome();
        String email = u.getEmail();
        String telefone = u.getTelefone();
        String endereco = u.getEndereco();
        String senha = u.getSenha();
        int tipo = u.getTipo();
        String userzabbix = u.getUserzabbix();
        String senhazabbix = u.getSenhazabbix();
        String grupo = u.getGrupo();

        try {
            c = Connect.getConexao();
            String sql="INSERT INTO Usuario (nome, sobrenome, email, telefone, endereco, senha, tipo, userzabbix, senhazabbix, grupo) values(?,?,?,?,?,?,?,?,?,?)";
//            String sql="INSERT INTO Usuario (nome, sobrenome, email, telefone, endereco, senha, tipo, userzabbix, senhazabbix) values(?,?,?,?,?,?,?,?,?)";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, sobrenome);
            stmt.setString(3, email);
            stmt.setString(4, telefone);
            stmt.setString(5, endereco);
            stmt.setString(6, senha);
            stmt.setInt(7, tipo);
            stmt.setString(8, nome);
            stmt.setString(9, senha);
            stmt.setString(10, grupo);

            stmt.execute();
            stmt.close();

            login();

            UserCreateRequest create = new UserCreateRequest();
            List<String> usrgrps = new ArrayList<String>();
            Media media = new Media();

            //parametros do HOST
            create.getParams().setName(nome);
            create.getParams().setAlias(nome);
            create.getParams().setSurname(sobrenome);
            create.getParams().setPasswd(senha);

            //tipo de usuario
            if(grupo.equals("Zabbix administrators")){
                usrgrps.add("7");
            }
            else{
                usrgrps.add(nome);
            }
            create.getParams().setUsrgrps(usrgrps);
            create.getParams().setType(tipo);

            //parametros para a midia (email)
            media.setMediatypeid("1");
            media.setSendto(email);
            media.setPeriod("1-7,00:00-24:00");
            media.setActive("0");
            media.setSeverity("63");
            media.setActive("0");

            create.getParams().getUser_medias().add(media);

            userService.create(create);

            ZabbixDao zabbixDao = new ZabbixDao();
            HostGroup hostGroup = new HostGroup();
            hostGroup.setName(nome);

            //pegando o id do ultimo host cadastrado inicio

            for(Usuario id : getUltUsu()) {
                System.out.println("ULTIMO ID CADASTRADO: "+id);
            }

            //pegando o id do ultimo host cadastrado fim

            //zabbixDao.CreateHostGroup(hostGroup);

            retorno = true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return retorno;
        }
        return retorno;
    }

    public boolean cadastraUserGroup(UserGroup userGroup) {
        boolean retorno;
//        HostGroup hostGroup = new HostGroup();

        System.out.println("ta no test create hostgroup");

        try {

            Connection c = null;
            PreparedStatement stmt = null;

            String nome = userGroup.getName();
            int status = 0;

            c = Connect.getConexao();
            String sql = "INSERT INTO usergroup (name, users_status) values(?,?)";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, status);

            stmt.execute();
            stmt.close();

            login();

            UserGroupCreateRequest userGroupCreate = new UserGroupCreateRequest();

            userGroupCreate.getParams().setName(nome);
            userGroupCreate.getParams().setUsers_status(status);

            System.out.println("Aqui user group: "+userGroup.getName());

                //o grupo de hosts que vai permitir no hostgroup
                List<Permission> rights = new ArrayList<>();
                Permission permission = new Permission();
                permission.setId("16");//id do hostgroup
                permission.setPermission(2); //aqui e o grupo de nivel de acesso dele
                rights.add(permission);

                userGroupCreate.getParams().setRights(rights);
                List<String> ids = new ArrayList<>();
                ids.add("1"); //id do host que vai cadastrar nas permissoes
                userGroupCreate.getParams().setUserids(ids);

            usergroupService.userGroupCreate(userGroupCreate);
            retorno = true;
            return retorno;

        }catch (Exception e){
            System.out.println("Aqui user group1: "+userGroup.getName());
            System.out.println("Erro: "+e);
        }

        retorno = true;
        return retorno;
    }


    public ArrayList<Usuario> getUsuarios() throws ClassNotFoundException {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Connection con = Connect.getConexao();
        Usuario usu;


        try {
            String sql = "Select * From Usuario ";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usu = new Usuario();
                usu.setIdUsuario(rs.getString("idusuario"));
                usu.setNome(rs.getString("nome"));
                usu.setSobrenome(rs.getString("sobrenome"));
                usu.setEmail(rs.getString("email"));
                usu.setTelefone(rs.getString("telefone"));
                usu.setEndereco(rs.getString("endereco"));
                usu.setSenha(rs.getString("senha"));
                usu.setTipo(rs.getInt("tipo"));
                usu.setUserzabbix(rs.getString("userzabbix"));
                usu.setSenhazabbix(rs.getString("senhazabbix"));
                usu.setGrupo(rs.getString("grupo"));

                usuarios.add(usu);/*
                System.out.println("IdUsuario Adicionado no Array = " +usu.getIdUsuario());
                System.out.println("Nome Adicionado no Array = " +usu.getNome());
                System.out.println("sobrenome Adicionado no Array = " +usu.getSobrenome());
                System.out.println("email Adicionado no Array = " +usu.getEmail());
                System.out.println("telefone Adicionado no Array = " +usu.getTelefone());
                System.out.println("endereco Adicionado no Array = " +usu.getEndereco());
                System.out.println("tipo Adicionado no Array = " +usu.getTipo() +"\n");
*/

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public ArrayList<Usuario> getUltUsu() throws ClassNotFoundException {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Connection con = Connect.getConexao();
        Usuario usu;


        try {
            String sql = "SELECT idusuario FROM usuario ORDER BY idusuario DESC LIMIT 1;";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usu = new Usuario();
                usu.setIdUsuario(rs.getString("idusuario"));
                usuarios.add(usu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public boolean alteraUsuario(Usuario u) throws ClassNotFoundException, SQLException {
        boolean retorno = false;
        Connection c = null;
        PreparedStatement stmt = null;

        c = Connect.getConexao();
        String sql="UPDATE usuario SET nome=?, sobrenome=?, email=?, telefone=?, endereco=?, senha=? WHERE idusuario=?";
        stmt = c.prepareStatement(sql);

        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getSobrenome());
        stmt.setString(3, u.getEmail());
        stmt.setString(4, u.getTelefone());
        stmt.setString(5, u.getEndereco());
        stmt.setString(6, u.getSenha());
        stmt.setString(7, u.getIdUsuario());

        stmt.execute();
        stmt.close();
        retorno = true;
        System.out.println("AQUI NO ALTERAR DAO -- "+u.getIdUsuario());
        System.out.println("AQUI NO ALTERAR DAO -- "+u.getNome());

        return retorno;
    }

    public boolean removerUsuario(String idUsuario) {
        int id = Integer.parseInt(idUsuario);

        boolean deletar = false;
        Connection c = null;
        PreparedStatement stmt = null;

        try {
            c = Connect.getConexao();
            String sql=" delete from usuario where idusuario=?";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.execute();
            stmt.close();

            UserDeleteRequest delete = new UserDeleteRequest();
//            UserGroupDeleteRequest delete2 = new UserGroupDeleteRequest();
//            HostGroupDeleteRequest delete3 = new HostGroupDeleteRequest();
            User user = new User();

            user.setUserid(idUsuario);
            delete.getParams().add(idUsuario);

            JSONObject object = (JSONObject) userService.delete(delete);
//            JSONObject object2 = (JSONObject) userGroupService.userGroupDelete(delete2);
//            JSONObject object3 = (JSONObject) hostGroupService.hostGroupDelete(delete3);

            System.out.println(object.toString());
//            System.out.println(object2.toString());
//            System.out.println(object3.toString());

        }catch (Exception e){
            System.out.println("ERRO: "+e);
        }
        return  deletar;
    }

//    public boolean Delete(String id) {
//
//        boolean retorno = false;
//
//        UserDeleteRequest userDeleteRequest = new UserDeleteRequest();
//        User user = new User();
//
//        try {
//            user.setUserid(id);
//            System.out.println("usuario que vai ser escluido: "+user.getUserid());
//            retorno = userDeleteRequest.getParams().add(user);
//
//            userService.delete(userDeleteRequest);
//
//            System.out.println("retorno: "+retorno);
//
//            retorno = true;
//            return retorno;
//
//        }catch (Exception e){
//            System.out.println("Erro: "+e);
//            return retorno;
//        }
//    }

    public List<Integration> getUser() {

        ArrayList<Integration> integrations = new ArrayList<Integration>();

        ArrayList<User> users = new ArrayList<User>();

        UserGetRequest userGet = new UserGetRequest();

        JSONObject result = (JSONObject) this.userGet(userGet);


        if(result!=null){
            if (result.has("result")) {
                try {
                    JSONArray array = result.getJSONArray("result");
                    if(array!=null&&array.length()>0){
                        for ( int i=0; i<array.length();i++) {
                            JSONObject object = array.getJSONObject(i);
                            User user = new User();
                            user.setUserid(object.getString("userid"));
                            user.setName(object.getString("name"));
                            user.setSurname(object.getString("surname"));
                            user.setAlias(object.getString("alias"));
//                            user.setType(object.getInt("type"));
                            users.add(user);
                        }
                    }
                    System.out.println("\n");
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            } else if (result.has("error")) {
                return null;
            }
        }

        ArrayList<Media> medias = new ArrayList<Media>();
        MediaGetRequest mediaGet = new MediaGetRequest();
        JSONObject objectMedia = (JSONObject) this.mediaGet(mediaGet);

        if (objectMedia != null) {
            if (objectMedia.has("result")) {
                try {
                    JSONArray array = objectMedia.getJSONArray("result");
                    if( array != null && array.length() > 0 ) {
                        for (int i=0;  i < array.length(); i++) {
                            JSONObject object = array.getJSONObject(i);
                            Media media = new Media();
                            media.setUserid(object.getString("userid"));
                            media.setSendto(object.getString("sendto"));
                            media.setMediaid(object.getString("mediaid"));
                            medias.add(media);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Erro no objeto do media Get");
        }

//        ArrayList<UserGroup> userGroups = new ArrayList<UserGroup>();
//        UserGroupGetRequest userGroupGet = new UserGroupGetRequest();
//        JSONObject objectUserGroup = (JSONObject) this.userGroupGet(userGroupGet);
//
//        if (objectUserGroup != null) {
//            if (objectUserGroup.has("result")) {
//                try {
//                    JSONArray array = objectUserGroup.getJSONArray("result");
//                    if( array != null && array.length() > 0 ) {
//                        for (int i=0;  i < array.length(); i++) {
//                            JSONObject object = array.getJSONObject(i);
//                            UserGroup userGroup = new UserGroup();
//
//                            userGroup.setUsrgrpid(object.getString("usrgrpid"));
//                            userGroup.setName(object.getString("name"));
//
//                            userGroups.add(userGroup);
//                        }
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        } else {
//            System.out.println("Erro no objeto do media Get");
//        }

        Integration integration = null;
            for (int u = 0; u < users.size() ; u++ ) {
                integration = new Integration();
                    for (int m = 0 ;m < medias.size() ; m++) {
//                        for (int ug = 0; ug < userGroups.size(); m++) {
                            if (users.get(u).getUserid().equals(medias.get(m).getUserid())) {
                                integration.setUser(users.get(u));
                                integration.setMedia(medias.get(m));
//                                integration.setGroups(Collections.singletonList(userGroups.get(ug)));
                            } else {
                                integration.setUser(users.get(u));
                            }
//                        }
                    }
                integrations.add(integration);
            }
        return integrations;
    }

    public Object userGet(UserGetRequest userGet){
        Gson js = new Gson();
        HttpClient client = new HttpClient();
        PostMethod putMethod = new PostMethod(FormatData.API_URL);
        putMethod.setRequestHeader("Content-Type", "application/json-rpc");
        JSONObject rs =null;
        try {
            String json = js.toJson(userGet);
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

    public Object mediaGet(MediaGetRequest mediaGet){
        Gson js = new Gson();

        HttpClient client = new HttpClient();
        PostMethod putMethod = new PostMethod(FormatData.API_URL);
        putMethod.setRequestHeader("Content-Type", "application/json-rpc");

        JSONObject rs = null;

        try {
            String json = js.toJson(mediaGet);
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

    public Object userGroupGet(UserGroupGetRequest userGroupGet){
        Gson js = new Gson();

        HttpClient client = new HttpClient();
        PostMethod putMethod = new PostMethod(FormatData.API_URL);
        putMethod.setRequestHeader("Content-Type", "application/json-rpc");

        JSONObject rs = null;

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

    public ArrayList<Integration> getUsers() throws ClassNotFoundException {

        ArrayList<Integration> IntegrationUsers = new ArrayList<Integration>();
//        HostIntegration hostIntegration = new HostIntegration();

        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Media> medias = new ArrayList<Media>();

//        Host h = null;
//        HostInterface hi = null;

        Connection con = Connect.getConexao();

        try {
                String sql = "SELECT * FROM usuario";

            System.out.println("SQL: "+sql);
//            String sql = "SELECT * FROM host";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            //ta trazendo a quantidade de hosts certa, mas repetidos

            while (rs.next()) {
                User u = new User();
                Media m = new Media();

                u.setUserid(rs.getString("idusuario"));
                u.setAlias(rs.getString("userzabbix"));
                u.setName(rs.getString("nome"));
                u.setSurname(rs.getString("sobrenome"));

                users.add(u);

                m.setSendto(rs.getString("email"));

                medias.add(m);

            }

            //trazer apenas hosts do usuario logado

            Integration hostIntegration = null;
            for (int u = 0; u < users.size(); u++) {
                for (int m = 0; m < medias.size(); m++) {
                    hostIntegration = new Integration();
                    hostIntegration.setUser(users.get(u));
                    hostIntegration.setMedia(medias.get(m));
                }
                IntegrationUsers.add(hostIntegration);
            }

        }catch (Exception e) {

            System.out.println("ERRO no try catch: " + e);
        }
        return IntegrationUsers;

    }

}
