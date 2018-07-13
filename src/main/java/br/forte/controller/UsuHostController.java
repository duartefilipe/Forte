package br.forte.controller;

import br.forte.DAO.UsuHostDao;
import br.forte.Model.UsuHost;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class UsuHostController {

    @RequestMapping("CadUsuHost")
    public String cadusuhost (UsuHost usuHost, HttpServletRequest rq) throws ClassNotFoundException, SQLException {
        boolean retorno = new UsuHostDao().cadastraUsuHost(usuHost);
        if(retorno){
            rq.setAttribute("mensagem", "Host cadastrado sucesso");
            return "Hosts/Hosts";
        }else{
            return "Hosts/Hosts";
        }
    }
}
