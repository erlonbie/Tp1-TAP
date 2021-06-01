import java.sql.*;

public class BancoDeDados {
	private static String url = "jdbc:mysql://localhost:3306/AluguelBD";
	private static String user = "aluguel";
	private static String pass = "abc123";
	protected static Connection conexao = null;
//	protected static Connection conexao2 = null;
//	protected static Connection conexao3 = null;
	
	public BancoDeDados() {
		if(conexao == null) {
			conecta();
		}
//		if(conexao2 == null) {
//			conecta2();
//		}
//		if(conexao3 == null) {
//			conecta3();
//		}
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
	
//	private static boolean conecta2() {
//		try {
//			conexao2 = DriverManager.getConnection(url, user, pass);
//			return true;
//		}
//		catch (SQLException e) {
//			System.out.println("Falhou no conecta2");
//			System.out.println(e.getMessage());
//			return false;
//		}
//	}
//	
//	private static boolean conecta3() {
//		try {
//			conexao3 = DriverManager.getConnection(url, user, pass);
//			return true;
//		}
//		catch (SQLException e) {
//			System.out.println("Falhou no conecta3");
//			System.out.println(e.getMessage());
//			return false;
//		}
//	}
	
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
	
//	public static boolean desconecta2() {
//		try {
//			conexao2.close();
//			return true;
//		}
//		catch(SQLException e) {
//			System.out.println("Falhou no desconecta2");
//			System.out.println(e.getMessage());
//			return false;
//		}
//	}
//	
//	public static boolean desconecta3() {
//		try {
//			conexao3.close();
//			return true;
//		}
//		catch(SQLException e) {
//			System.out.println("Falhou no desconecta3");
//			System.out.println(e.getMessage());
//			return false;
//		}
//	}
	
}
