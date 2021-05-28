import java.sql.*;

public class BancoDeDados {
	private static String url = "jdbc:mysql://localhost:3306/AluguelBD";
	private static String user = "aluguel";
	private static String pass = "abc123";
	protected static Connection conexao = null;
	
	public BancoDeDados() {
		if(conexao == null) {
			conecta();
		}
	}
	
	private static boolean conecta() {
		try {
			conexao = DriverManager.getConnection(url, user, pass);
			return true;
		}
		catch (SQLException e) {
			System.out.println("Falhou no conecta");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static boolean desconecta() {
		try {
			conexao.close();
			return true;
		}
		catch(SQLException e) {
			System.out.println("Falhou no desconecta");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
}
