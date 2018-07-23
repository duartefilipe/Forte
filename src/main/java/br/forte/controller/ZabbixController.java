package br.forte.controller;

import br.forte.DAO.UsuarioDao;
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

import static br.forte.DAO.UsuarioDao.login;

@Controller
public class ZabbixController {

    @RequestMapping("Graphs")
    public String Login(){
        return "API/Zabbix/Graficos";
    }

    @RequestMapping ("CadZabbix")
    public String CadZabbix (Usuario usuario, Host host, HostGroup hostGroup, HostInterface hostInterface, Template template, Macro macro, HttpServletRequest rq){
        try {

            boolean retorno = new ZabbixDao().CreateHost(usuario, host, hostGroup, hostInterface, template, macro);

            if (retorno) {
                rq.setAttribute("mensagem", "Host cadastrado sucesso");
                return "API/API";
            } else {
                return "API/API";
            }
        }catch (Exception e){
            System.out.println("ERRO no cad zabbix: "+e);
        }
        return "API/API";
    }


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
