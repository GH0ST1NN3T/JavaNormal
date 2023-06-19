
package Controle;
import Entidade.Cliente;
import Entidade.ClienteResult;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ClienteDao {
     public boolean inserir(Cliente cliente) {
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("insert into cliente (nome,cpf,email) values (?,?,?);");
            pstm.setString(1, cliente.getNome());
            pstm.setInt(2, cliente.getCpf());
            pstm.setString(3, cliente.getEmail());
            int linhas = pstm.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();

                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
        return false;
    }
    public boolean atualizar(Cliente cliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("update cliente set nome=?, cpf=?, email=? where id_cliente=?;");
            pstm.setString(1, cliente.getNome());
            pstm.setInt(2, cliente.getCpf());
            pstm.setString(3, cliente.getEmail());
            pstm.setInt(4, cliente.getId());

            int linhas = pstm.executeUpdate();

            conexao.close();

            return (linhas > 0) ? true : false;

        } catch (SQLException e) {

            System.err.println(e);

        } finally {

            if (conexao != null) {
                try {

                    conexao.close();

                } catch (SQLException e) {

                    System.err.println(e);

                }
            }
        }

        return false;
    }
 public Cliente buscar(Integer id) {
        Connection conexao = (Connection) FabricaConexao.getConnection();
        Cliente cliente = new Cliente();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("select * from cliente where id_cliente=?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setEmail(rs.getString("email"));
            }
            conexao.close();
            return cliente;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
        return null;
    }
      public boolean excluir(Integer id) {
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("delete from cliente where id_cliente=?");
            pstm.setInt(1, id);
            int linhas = pstm.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
        return false;
    }
    public List<Cliente> getListaclientes() {
        List<Cliente> lista = new LinkedList<Cliente>();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        Cliente cliente = new Cliente();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao
                    .prepareStatement("select * from cliente");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setEmail(rs.getString("email"));
                lista.add(cliente);
            }
            conexao.close();
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
        return null;
    }
}
