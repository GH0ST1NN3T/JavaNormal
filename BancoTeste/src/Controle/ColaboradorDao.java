package Controle;
import Entidade.Colaborador;
import Entidade.ColaboradorResult;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ColaboradorDao {
     public boolean inserir(Colaborador colaborador) {
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("insert into colaborador (nome,cpf,email) values (?,?,?);");
            pstm.setString(1, colaborador.getNome());
            pstm.setString(2, colaborador.getCpf());
            pstm.setString(3, colaborador.getEmail());
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
    public boolean atualizar(Colaborador colaborador) {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("update colaborador set nome=?, cpf=?, email=? where id_colaborador=?;");
            pstm.setString(1, colaborador.getNome());
            pstm.setString(2, colaborador.getCpf());
            pstm.setString(3, colaborador.getEmail());
            pstm.setInt(4, colaborador.getId());

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
 public Colaborador buscar(Integer id) {
        Connection conexao = (Connection) FabricaConexao.getConnection();
        Colaborador colaborador = new Colaborador();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("select * from colaborador where id_colaborador=?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                colaborador = new Colaborador();
                colaborador.setId(rs.getInt("id_colaborador"));
                colaborador.setNome(rs.getString("nome"));
                colaborador.setCpf(rs.getString("cpf"));
                colaborador.setEmail(rs.getString("email"));
            }
            conexao.close();
            return colaborador;
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
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("delete from colaborador where id_colaborador=?");
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
    public List<Colaborador> getListaColaboradores() {
        List<Colaborador> lista = new LinkedList<Colaborador>();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        Colaborador colaborador = new Colaborador();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao
                    .prepareStatement("select * from colaborador");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                colaborador = new Colaborador();
                colaborador.setId(rs.getInt("id_colaborador"));
                colaborador.setNome(rs.getString("nome"));
                colaborador.setCpf(rs.getString("cpf"));
                colaborador.setEmail(rs.getString("email"));
                lista.add(colaborador);
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


