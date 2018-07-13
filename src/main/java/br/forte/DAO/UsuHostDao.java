package br.forte.DAO;

import br.forte.Model.UsuHost;
import br.forte.util.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuHostDao {
    public boolean cadastraUsuHost(UsuHost uh) throws SQLException {
        Connection c = null;
        PreparedStatement stmt = null;
        boolean retorno = false;

        String cliente = uh.getCliente();
        String host = uh.getHost();

        try {
            c = Connect.getConexao();
            String sql="insert into usuhost (idusuario, idhost) values(?, ?);";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, cliente);
            stmt.setString(2, host);


            stmt.execute();
            stmt.close();
            retorno = true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return retorno;
        }
        return retorno;
    }

}
