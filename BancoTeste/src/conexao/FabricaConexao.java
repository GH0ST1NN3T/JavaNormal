package conexao;
import java.sql.*;
public class FabricaConexao {
	private static final String URL_BD = "jdbc:mysql://localhost:3306/safra";
	private static final String USER_BD = "root";
	private static final String PWD_BD = "";
	public static Connection getConnection() {
		Connection conexao = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(URL_BD, USER_BD, PWD_BD);
			return conexao;
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		} catch (SQLException e) {
			System.err.println(e);
		}
		return null;
	}
}
