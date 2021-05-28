import java.sql.*;
import java.util.ArrayList;

public class ImovelDAO extends BancoDeDados {
	
	VisualControleImoveis i = new VisualControleImoveis();
	
	public boolean adicionaImoveis(Imovel i) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO imoveis VALUES (NULL, '" + i.getCategoria() + "', '"+ i.getEndereco() + "', '" + i.getArea() + "', '" + i.getCusto() + "', '" + i.getQntQuartos() + "', '" + i.getQntSuites() + "', '" + i.getQntVagasEstacionamento() + "', '" + i.isPiscina() + "', '" + i.isChurrasqueira() + "', '" + i.isPlayground() + "', '" + i.isAlugado() + "')");
			return true;
		}
		catch (SQLException e){
			System.out.println("Falhou no adicionaImoveis");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public void listarImoveis() {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM imoveis");
			while(rs.next()) {
				System.out.println("Id: " + rs.getString(1) + "\n" + "Categoria: " + rs.getString(2) + "\n" + "Endereço: " + rs.getString(3)+ "\n" + "Area: " + rs.getString(4) + "\n" + "Custo: " + rs.getString(5) + "\n" + "Quartos: " + rs.getString(6) + "\n" + "Suítes: " + rs.getString(7) + "\n" + "Vagas de estacionamento: " + rs.getString(8) + "\n" + "Piscina: " + rs.getString(9) + "\n" + "Churrasqueira: " + rs.getString(10) + "\n" + "Playground: " + rs.getString(11) + "\n" + "Alugado: " + rs.getString(12) +"\n");
			}
		}
		catch (SQLException e) { 
			System.out.println("Falhou no listaImoveis");
			System.out.println(e.getMessage());
		}
	}
	
	public String retornarImoveis() {
		String s = "";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM imoveis");
			while(rs.next()) {
				//s += "Id: " + rs.getString(1) + '\n' + "Categoria: " + rs.getString(2) + "\n" + "Endereço: " + rs.getString(3)+ "\n" + "Area: " + rs.getString(4) + "\n" + "Custo: " + rs.getString(5) + "\n" + "Quartos: " + rs.getString(6) + "\n" + "Suítes: " + rs.getString(7) + "\n" + "Vagas de estacionamento: " + rs.getString(8) + "\n" + "Piscina: " + rs.getString(9) + "\n" + "Churrasqueira: " + rs.getString(10) + "\n" + "Playground: " + rs.getString(11) + "\n" + "Alugado: " + rs.getString(12) +"\n--------------------\n";
				s += String.format("Id:%43s\nCategoria:%41s\nEndereco:%34s\nArea:%41s\nCusto:%41s\nQuartos:%33s\nSuítes:%36s\nVagas de Estacionamento:%5s\nPiscina:%35s\nChurrasqueira:%24s\nPlayground:%29s\nAlugado:%34s\n---------------------------------------------------------------------------\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
			}
			return s;
		}
		catch (SQLException e) { 
			System.out.println("Falhou no listaImoveis");
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void listaComboBox() {
		int x = 0;
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM imoveis");
			while(rs.next()) {
				i.imoveis.add("Id: " + rs.getString(1) + " - " + "Categoria: " + rs.getString(2));
				//i.getComboBox().addItem(rs.next());
				x++;
			}
		}
		catch (SQLException e) { 
			System.out.println("Falhou no listaImoveis");
			System.out.println(e.getMessage());
		}
		
	}
	
//	public static void main (String args[]) {
//		ImovelDAO iDAO = new ImovelDAO ();
//		Imovel i = new Imovel("Casa Padrao2", "Rua2", 12.0, 150.00, 2, 2, 1, 0, 1, 1, 0);
//		iDAO.adicionaImoveis(i);
//		iDAO.listaPersonagens();
//		
//	}
}
