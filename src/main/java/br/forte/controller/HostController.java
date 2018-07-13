package br.forte.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HostController {


//    @RequestMapping("Hosts")
//    public String redirecionaCadHost() { return "Hosts/Hosts"; }
//
//    @RequestMapping ("CadastrarHost")
//    public String adiciona (Host host, HttpServletRequest rq) throws ClassNotFoundException, SQLException {
//        boolean retorno = new HostDao().cadastraHost(host);
//        if(retorno){
//            rq.setAttribute("mensagem", "Host cadastrado sucesso");
//            return "Hosts/Hosts";
//        }else{
//            return "Hosts/Hosts";
//        }
//    }
//
//    @RequestMapping("RemoverHost")
//    public String DeletaHost(int idHost , HttpServletRequest rq) throws SQLException, Exception{
//
//        HostDao hD = new HostDao();
//
//
//        System.out.println("mural :  "+idHost);
//
//        boolean retorno = hD.deletarHost(idHost);
//        if(retorno){
//            rq.setAttribute("host", hD.getHosts());
//            return "Hosts/Hosts";
//        }else{
//            rq.setAttribute("msg","problema pra excluir");
//            return "Hosts/Hosts";
//        }
//    }
//
//    @RequestMapping("AlterarHost")
//    public String AlteraHost(Host h, HttpServletRequest rq) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException{
//
//        HostDao hD = new HostDao();
//        HttpSession sessao = rq.getSession(true);
//        boolean retorno = hD.alteraHost(h);
//
//        System.out.println("No Altera host  :   "+retorno);
//        if(retorno){
//            sessao = rq.getSession();
//            sessao.setAttribute("host", h);
//            return "Hosts/Hosts";
//        }else{
//            rq.setAttribute("msg","problemas ao alterar host");
//            return "Hosts/Hosts";
//        }
//    }



}
