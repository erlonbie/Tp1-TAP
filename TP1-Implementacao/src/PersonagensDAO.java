import java.sql.*;

public class PersonagensDAO extends BancoDeDados {
	public void listaPersonagens() {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM personagens");
			while(rs.next()) {
				System.out.println("Personagem " + rs.getString(2) + " (" + rs.getNString(3) + ")" + " do filme " + rs.getNString(4));
			}
		}
		catch (SQLException e) { }
	}
	
//	public static void main (String args[]) {
//		PersonagensDAO per = new PersonagensDAO();
//		per.listaPersonagens();
//	}
}
