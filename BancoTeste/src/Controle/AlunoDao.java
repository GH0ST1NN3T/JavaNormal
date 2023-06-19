
package Controle;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import Entidade.Aluno;
import Entidade.AlunoResult;
public class AlunoDao {
         public boolean inserir(Aluno aluno) {
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("insert into aluno (nome,cpf,email) values (?,?,?);");
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCpf());
            pstm.setString(3, aluno.getEmail());
            pstm.setString(4, aluno.getMatricula());
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
    public boolean atualizar(Aluno aluno) {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("update aluno set nome=?, cpf=?, email=? where id_aluno=?;");
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCpf());
            pstm.setString(3, aluno.getEmail());
            pstm.setString(4, aluno.getMatricula());
            pstm.setInt(5, aluno.getId());

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
 public Aluno buscar(Integer id) {
        Connection conexao = (Connection) FabricaConexao.getConnection();
        Aluno aluno = new Aluno();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("select * from aluno where id_aluno=?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setId(rs.getInt("id_aluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setEmail(rs.getString("email"));
                aluno.setMatricula(rs.getString("matricula"));
            }
            conexao.close();
            return aluno;
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
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("delete from aluno where id_aluno=?");
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
    public List<Aluno> getListaAlunos() {
        List<Aluno> lista = new LinkedList<Aluno>();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        Aluno aluno = new Aluno();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao
                    .prepareStatement("select * from aluno");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setId(rs.getInt("id_aluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setEmail(rs.getString("email"));
                aluno.setMatricula(rs.getString("matricula"));
                lista.add(aluno);
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
