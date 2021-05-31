import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO extends BancoDeDados {
	
	VisualControleClientes i = new VisualControleClientes();
	
	public boolean adicionaCliente(Cliente i) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO clientes VALUES (NULL, '" + i.getImovel_id() + "', '"+ i.getNome() + "', '" + i.getIdade() +"' )");
			return true;
		}
		catch (SQLException e){
			System.out.println("Falhou no adicionaCliente");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public void listarClientes() {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM clientes");
			while(rs.next()) {
				System.out.println("Id: " + rs.getString(1) + "\n" + "Imovel_id: " + rs.getString(2) + "\n" + "Nome: " + rs.getString(3)+ "\n" + "Idade: " + rs.getString(4) + "\n"+"\n");
			}
		}
		catch (SQLException e) { 
			System.out.println("Falhou no listarClientes");
			System.out.println(e.getMessage());
		}
	}
	
	public String listaApenasUmImovel() {
		String s = "Imóvel Adicionado: \n";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM imoveis WHERE id=(SELECT LAST_INSERT_ID())");
			while(rs.next()) {
				s += "Id: " + rs.getString(1) + "\n" + "Categoria: " + rs.getString(2) + "\n" + "Endereço: " + rs.getString(3)+ "\n" + "Area: " + rs.getString(4) + "\n" + "Custo: " + rs.getString(5) + "\n" + "Quartos: " + rs.getString(6) + "\n" + "Suítes: " + rs.getString(7) + "\n" + "Vagas de estacionamento: " + rs.getString(8) + "\n" + "Piscina: " + rs.getString(9) + "\n" + "Churrasqueira: " + rs.getString(10) + "\n" + "Playground: " + rs.getString(11) + "\n" + "Alugado: " + rs.getString(12) +"\n";
			}
			return s;
		}
		catch (SQLException e) { 
			System.out.println("Falhou no listaApenasUmImovel");
			System.out.println(e.getMessage());
		}
		return s;
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
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM imoveis");
			while(rs.next()) {
				i.imoveis1.add(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3)+  "|" + rs.getString(4)  + "|" + rs.getString(5) +  "|" + rs.getString(6) +  "|" + rs.getString(7) +  "|" + rs.getString(8) + "|" + (Integer.parseInt(rs.getString(12)) == 1? "Alugado" : "Disponível"));
			}
		}
		catch (SQLException e) { 
			System.out.println("Falhou no listaImoveis");
			System.out.println(e.getMessage());
		}
		
	}
	
	public void listaComboBox2() {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM clientes");
			while(rs.next()) {
				i.clientes.add(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3)+  "|" + rs.getString(4));
			}
		}
		catch (SQLException e) { 
			System.out.println("Falhou no listaImoveis");
			System.out.println(e.getMessage());
		}
		
	}
	
	public void removeClientes(String id) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM clientes WHERE id=" + id);
		}
		catch (SQLException e){
			System.out.println("Falhou no removeClientes");
			System.out.println(e.getMessage());
		}
	}
	
	public void atualizaCLiente(String[] imo) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("UPDATE clientes SET nome='"+imo[2]+"', idade='"+imo[3]+"' WHERE id=" + imo[0]);
		}
		catch (SQLException e){
			System.out.println("Falhou no atualizaImovel");
			System.out.println(e.getMessage());
		}
		 
	}
	
//	public static void main (String args[]) {
//		ImovelDAO iDAO = new ImovelDAO ();
//		iDAO.removeImoveis("4");
//		//Imovel i = new Imovel("Casa Padrao2", "Rua2", 12.0, 150.00, 2, 2, 1, 0, 1, 1, 0);
//		//iDAO.adicionaImoveis(i);
//		//iDAO.listaPersonagens();
//		
//	}
}
