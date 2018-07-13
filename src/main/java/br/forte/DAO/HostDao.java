package br.forte.DAO;


import br.forte.Model.UsuHost;
import br.forte.util.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HostDao {

//    public boolean cadastraHost(Host h) throws SQLException {
//        Connection c = null;
//        PreparedStatement stmt = null;
//        boolean retorno = false;
//
//        String nome = h.getNome();
//        String cpu = h.getCpu();
//        String memoria = h.getMemoria();
//        String disco = h.getDisco();
//        String interfaces = h.getInterfaces();
//        String disponibilidade = h.getDisponibilidade();
//        String n_sessoes = h.getN_sessoes();
//        String n_ips_rede = h.getN_ips_rede();
//        String n_regras_firewall = h.getN_regras_firewall();
//        String tamanho_log = h.getTamanho_log();
//        String quant_ataques = h.getQuant_ataques();
//        String contas_email = h.getContas_email();
//
//        try {
//            c = Connect.getConexao();
//            String sql="INSERT INTO host (nome, cpu, memoria, disco, interfaces, disponibilidade, n_sessoes, n_ips_rede, n_regras_firewall, tamanho_log, quant_ataques, contas_email) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
//            stmt = c.prepareStatement(sql);
//            stmt.setString(1, nome);
//            stmt.setString(2, cpu);
//            stmt.setString(3, memoria);
//            stmt.setString(4, disco);
//            stmt.setString(5, interfaces);
//            stmt.setString(6, disponibilidade);
//            stmt.setString(7, n_sessoes);
//            stmt.setString(8, n_ips_rede);
//            stmt.setString(9, n_regras_firewall);
//            stmt.setString(10, tamanho_log);
//            stmt.setString(11, quant_ataques);
//            stmt.setString(12, contas_email);
//
//            stmt.execute();
//            stmt.close();
//            retorno = true;
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            return retorno;
//        }
//        return retorno;
//    }
//
//    public ArrayList<Host> getHosts() throws ClassNotFoundException {
//
//        ArrayList<Host> hosts = new ArrayList<Host>();
//        Connection con = Connect.getConexao();
//        Host h;
//
//
//        try {
//            String sql = "Select * from Host";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                h = new Host();
//                h.setIdhost(rs.getString("idHost"));
//                h.setNome(rs.getString("nome"));
//                h.setHos(rs.getString("hos"));
//                h.setStatus(rs.getString("status"));
//                h.setGrupoid(rs.getString("grupoid"));
//                h.setTipo(rs.getString("tipo"));
//                h.setIp(rs.getString("ip"));
//                h.setDns(rs.getString("dns"));
//                h.setUseip(rs.getString("useip"));
//                h.setMain(rs.getString("main"));
//                h.setPorta(rs.getString("porta"));
//                h.setTemp(rs.getString("temp"));
//                h.setMac(rs.getString("mac"));
//                h.setVal(rs.getString("val"));
//
//                hosts.add(h);
//               // System.out.println("Host Adicionado no Array = " +h.getIdHost());
//               // System.out.println("Nome Adicionado no Array = " +h.getNome());
//
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return hosts;
//    }

//
//    public boolean deletarHost(int id) throws SQLException, Exception {
//        boolean deletar = false;
//        Connection c = null;
//        PreparedStatement stmt = null;
//
//        c = Connect.getConexao();
//        String sql=" delete from Host where idhost=?";
//        stmt = c.prepareStatement(sql);
//        stmt.setInt(1,id);
//        stmt.execute();
//        stmt.close();
//        deletar = true;
//
//        return deletar;
//    }
//
//    public boolean alteraHost(Host h) throws ClassNotFoundException, SQLException {
//        boolean retorno = false;
//        Connection c = null;
//        PreparedStatement stmt = null;
//
//        c = Connect.getConexao();
//        String sql="UPDATE host SET nome=?, cpu=?, memoria=?, disco=?, interfaces=?, disponibilidade=?, n_sessoes=?, n_ips_rede=?, n_regras_firewall=?, tamanho_log=?, quant_ataques=?, contas_email=? WHERE idhost=?";
//        stmt = c.prepareStatement(sql);
//
//        stmt.setString(1, h.getNome());
//        stmt.setString(2, h.getCpu());
//        stmt.setString(3, h.getMemoria());
//        stmt.setString(4, h.getDisco());
//        stmt.setString(5, h.getInterfaces());
//        stmt.setString(6, h.getDisponibilidade());
//        stmt.setString(7, h.getN_sessoes());
//        stmt.setString(8, h.getN_ips_rede());
//        stmt.setString(9, h.getN_regras_firewall());
//        stmt.setString(10, h.getTamanho_log());
//        stmt.setString(11, h.getQuant_ataques());
//        stmt.setString(12, h.getContas_email());
//        stmt.setInt(13, h.getIdHost());
//
//        stmt.execute();
//        stmt.close();
//        retorno = true;
//        //System.out.println("AQUI NO ALTERAR DAO -- "+h.getIdHost());
//        //System.out.println("AQUI NO ALTERAR DAO -- "+h.getNome());
//
//        return retorno;
//    }




}
