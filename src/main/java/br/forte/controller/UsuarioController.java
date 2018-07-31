package br.forte.controller;

import br.forte.DAO.UsuarioDao;
import br.forte.DAO.ZabbixDao;
import br.forte.Model.Usuario;
import br.forte.controller.Apis.Zabbix.api.domain.base.HostGroup;
import br.forte.controller.Apis.Zabbix.api.domain.base.User;
import br.forte.controller.Apis.Zabbix.api.domain.base.UserGroup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Controller
public class UsuarioController {

    @RequestMapping("Usuario")
    public String redirecionaUsuario() {
        System.out.println("Foi pro Usuario");
        return "Usuario/Usuario";
    }

    @RequestMapping("APIs")
    public String redirecionaApis() {
        System.out.println("Foi pra API");
        return "API/API";
    }

    @RequestMapping("index")
    public String redirecionaIndexUser() {
//        System.out.println("Foi pra index");
        return "Index/index";
    }

    @RequestMapping("login")
    public String AutenticaUsuario(String email, String senha , HttpServletRequest rq) {

        System.out.println("Foi pro Autenticar");
        HttpSession sessao = rq.getSession(true);
        try{

            Usuario u = new Usuario();
            UsuarioDao uD = new UsuarioDao();

            u = uD.autenticar(email, senha);

            if(u != null){

                if(u.getTipo() == 3){
                    rq.getSession().invalidate();
                    sessao = rq.getSession();
                    sessao.setAttribute("usuario", u);

                    return "Index/index";
                }
                else{
                    rq.getSession().invalidate();
                    sessao = rq.getSession();
                    sessao.setAttribute("usuario", u);
                    return "Index/index";
                }


            }else{
                rq.setAttribute("msg","Problemas ao Logar");
                return "Index/login";

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return "Index/login";
    }

    @RequestMapping("logout")
    public String logout (HttpServletRequest rq){
        System.out.println("Foi pro Logout");
        rq.getSession().invalidate();
        return "Index/login";
    }

    @RequestMapping ("CadastrarUsuario")
    public String adiciona (Usuario usuario, HttpServletRequest rq) {
        System.out.println("Entrou no cadastrar usuario");

        HostGroup hostGroup = new HostGroup();
        hostGroup.setName(usuario.getNome());

        UserGroup userGroup = new UserGroup();
        userGroup.setName(usuario.getNome());


        try {
            boolean retorno1 = new ZabbixDao().CreateHostGroup(hostGroup);
            boolean retorno2 = new UsuarioDao().cadastraUserGroup(userGroup);
            boolean retorno3 = new UsuarioDao().cadastraUsuario(usuario);

            if (retorno1 && retorno2 && retorno3) {
                rq.setAttribute("mensagem", "usuario cadastrado sucesso");
                return "Usuario/Usuario";
            }else {
                return "Usuario/Usuario";
            }
        }catch (Exception e){
            System.out.println("ERRO pra cadastrar os usu, hostgroup e usergroup: "+e);
        }
        return "Usuario/Usuario";
    }

    @RequestMapping("AlterarUsuario")
    public String AlteraPerfilUsuario(Usuario u, HttpServletRequest rq) throws ClassNotFoundException, SQLException{

        UsuarioDao uD = new UsuarioDao();
        HttpSession sessao = rq.getSession(true);
        boolean retorno = uD.alteraUsuario(u);

        System.out.println("No Altera usuario  :   "+retorno);
        if(retorno){
            sessao = rq.getSession();
            sessao.setAttribute("usuario", u);
            return "Usuario/Usuario";
        }else{
            rq.setAttribute("msg","problemas ao alterar usuario");
            return "Usuario/Usuario";
        }
    }

    @RequestMapping("RemoverUsuario")
    public String DeletaUsuario(String idUsuario , HttpServletRequest rq) throws ClassNotFoundException {

        Usuario u = new Usuario();
        String nome  = u.getNome();

        System.out.println("Nome no controller: "+nome);

        UsuarioDao uD = new UsuarioDao();

        boolean retorno1 = uD.removerUsuario(idUsuario);
//        boolean retorno2 = uD.removerUsuario(idUsuario);
//        boolean retorno3 = uD.removerUsuario(idUsuario);


        if(retorno1){
            rq.setAttribute("usuarios", uD.getUsuarios());
            System.out.println("Usuario excluido");
            return "Usuario/Usuario";
        }else{
            rq.setAttribute("msg","problema pra excluir");
            System.out.println("\nProblema para excluir");
            return "Usuario/Usuario";
        }
    }
}
