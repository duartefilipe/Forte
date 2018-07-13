package br.forte.controller;

import br.forte.DAO.ZabbixDao;
import br.forte.Model.Usuario;
import br.forte.controller.Apis.Zabbix.api.domain.base.*;
import br.forte.controller.Apis.Zabbix.api.service.IUserService;
import br.forte.controller.Apis.Zabbix.api.service.impl.UserServiceImpl;
import br.forte.util.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import java.sql.Timestamp;

@Controller
public class ZabbixController {
    private static Logger log = Logger.getLogger(String.valueOf(UserServiceImpl.class));
    private static IUserService userService = new UserServiceImpl();


    @RequestMapping("Graphs")
    public String Login(){
        return "API/Zabbix/Graficos";
    }

    @RequestMapping ("CadZabbix")
    public String CadZabbix (Usuario usuario, Host host, HostGroup hostGroup, HostInterface hostInterface, Template template, Macro macro, HttpServletRequest rq){

        host.setName(rq.getParameter("nomehost"));
        host.setHost(rq.getParameter("nomevisivel"));
        host.setStatus(Integer.valueOf(rq.getParameter("status")));

        hostGroup.setGroupid(rq.getParameter("grupoid"));

//        hostGroup.setName(rq.getParameter(""));

        hostInterface.setType(Integer.valueOf(rq.getParameter("tipo")));
        hostInterface.setIp(rq.getParameter("ip"));
        hostInterface.setDns(rq.getParameter("dns"));
        hostInterface.setUseip(Integer.valueOf(rq.getParameter("useip")));
        hostInterface.setMain(Integer.valueOf(rq.getParameter("main")));
        hostInterface.setPort(rq.getParameter("porta"));

        template.setTemplateid(rq.getParameter("temp"));

        macro.setMacro(rq.getParameter("macroname"));
        macro.setValue(rq.getParameter("value"));

        usuario.setIdUsuario(rq.getParameter("idUsuario"));

        boolean retorno = new ZabbixDao().CreateHost(usuario, host, hostGroup, hostInterface, template, macro);
//        boolean retorno2 = new ZabbixDao().CreateHostGroup(hostGroup);

        if(retorno){
            rq.setAttribute("mensagem", "Host cadastrado sucesso");
            return "API/API";
        }else{
            return "API/API";
        }
    }

//    @RequestMapping ("CadUserZabbix")
//    public void CreateUser() {
//        UserCreateRequest create = new UserCreateRequest();
//
//        create.getParams().setName("test4");
//        create.getParams().setAlias("test4");
//        create.getParams().setPasswd("skycloud");
//        List<String> usrgrps = new ArrayList<String>();
//        usrgrps.add("13");
//        create.getParams().setUsrgrps(usrgrps);
//        create.getParams().setType(1);
//
//        Media media = new Media();
//        media.setMediatypeid("1");
//        media.setSendto("admin");
//        media.setPeriod("1-7,00:00-24:00");
//        media.setActive("0");
//        media.setSeverity("63");
//        media.setActive("0");
//
//        create.getParams().getUser_medias().add(media);
//
////		create.getParams().getUser_medias().add("4");
//        userService.create(create);
//
//    }

    @RequestMapping ("AltZabbix")
    public String AltZabbix (Host host, HostGroup hostGroup, HostInterface hostInterface, Template template, Macro macro, HttpServletRequest rq){

        host.setName(rq.getParameter("nomehost"));
        host.setHost(rq.getParameter("nomevisivel"));
        host.setStatus(Integer.valueOf(rq.getParameter("status")));

        hostGroup.setGroupid(rq.getParameter("grupoid"));

        hostInterface.setType(Integer.valueOf(rq.getParameter("tipo")));
        hostInterface.setIp(rq.getParameter("ip"));
        hostInterface.setDns(rq.getParameter("dns"));
        hostInterface.setUseip(Integer.valueOf(rq.getParameter("useip")));
        hostInterface.setMain(Integer.valueOf(rq.getParameter("main")));
        hostInterface.setPort(rq.getParameter("porta"));

        template.setTemplateid(rq.getParameter("temp"));

        macro.setMacro(rq.getParameter("macroname"));
        macro.setValue(rq.getParameter("value"));

        boolean retorno = new ZabbixDao().AlteraHost(host, hostGroup, hostInterface, template, macro);

        if(retorno){
            rq.setAttribute("mensagem", "Usuario cadastrado sucesso");
            return "API/API";
        }else{
            return "API/API";
        }
    }

    @RequestMapping("Remover")
    public String Deleta(String idhost, HttpServletRequest rq, Host host) {

        idhost = host.getHostid();

        host.setHostid(rq.getParameter("hostid"));

        ZabbixDao zD = new ZabbixDao();

        System.out.println("Entrou no remover com o id: "+idhost);

        boolean retorno = zD.Delete(idhost);

        if(retorno){
            rq.setAttribute("host", zD.getHostInterface());
            System.out.println("|-----Host Excluido-----|");

            return "API/API";
        }else{
            rq.setAttribute("msg","problema pra excluir");
            System.out.println("\nProblema para excluir");
            return "API/API";
        }
    }

    @RequestMapping("mandarEmail")
    public String mandarEmail(HttpSession session, HttpServletRequest rq){
        Mail email = new Mail();

        HttpSession sessao = rq.getSession(true);

        boolean enviado;

        System.out.println("-------------Entrou no mandar email--------------");

        String emaildest = rq.getParameter("sendto");
        System.out.println("email destinatario: " +emaildest);

        String assunto = rq.getParameter("assunto");
        System.out.println("assunto: " + assunto);

        String mensagem = rq.getParameter("mensagem");
        System.out.println("mensagem: " + mensagem);

        enviado = email.enviarEmail( emaildest, assunto, mensagem);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Timestamp data = new Timestamp(System.currentTimeMillis());

        //ed.cadastraEmail(u.getId(), id_dest, assunto, mensagem, data);


        if(enviado){
            rq.setAttribute("enviadosim", "enviou");
            return "Usuario/Usuario";
        }else{
            rq.setAttribute("enviadonao", "nao enviou");
            return "Usuario/Usuario";
        }
    }


}
