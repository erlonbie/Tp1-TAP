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
	
	public String listaUmCliente(String id) {
		String s = "Imóvel Adicionado: \n";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM imoveis WHERE id="+id);
			while(rs.next()) {
				s += "Id: " + rs.getString(1) + "\n" + "Categoria: " + rs.getString(2) + "\n" + "Endereço: " + rs.getString(3)+ "\n" + "Area: " + rs.getString(4) + "\n" + "Custo: " + rs.getString(5) + "\n" + "Quartos: " + rs.getString(6) + "\n" + "Suítes: " + rs.getString(7) + "\n" + "Vagas de estacionamento: " + rs.getString(8) + "\n" + "Piscina: " + rs.getString(9) + "\n" + "Churrasqueira: " + rs.getString(10) + "\n" + "Playground: " + rs.getString(11) + "\n" + "Alugado: " + rs.getString(12) +"\n";
			}
			return s;
		}
		catch (SQLException e) { 
			System.out.println("Falhou no listaUmCliente");
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	public int idUltimoCliente() {
		int id = 0;
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE id=(SELECT LAST_INSERT_ID())");
			while(rs.next()) {
				id = Integer.parseInt(rs.getString(1));
			}
			return id;
		}
		catch (SQLException e) { 
			System.out.println("Falhou no idUltimoCliente");
			System.out.println(e.getMessage());
		}
		return id;
	}
	
	public int imovelUltimoCliente() {
		int id = 0;
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE id=(SELECT LAST_INSERT_ID())");
			while(rs.next()) {
				id = Integer.parseInt(rs.getString(2));
			}
			return id;
		}
		catch (SQLException e) { 
			System.out.println("Falhou no imovelUltimoCliente");
			System.out.println(e.getMessage());
		}
		return id;
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
			System.out.println("Falhou no listaComboBox");
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
			System.out.println("Falhou no listaComboBox2");
			System.out.println(e.getMessage());
		}
		
	}
	
	public boolean removeCliente(String id) {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE id="+id);
			while(rs.next()) {
				String imovel_id = rs.getString(2);
				Statement st2 = conexao.createStatement();
				ResultSet rs2 = st2.executeQuery("SELECT * FROM alugueis WHERE cliente_imovel="+imovel_id);
				while(rs2.next()) {
					String aluguel_id = rs2.getString(1);
					Statement st3 = conexao.createStatement();
					st3.executeUpdate("DELETE FROM alugueis WHERE id="+aluguel_id);
				}
				Statement st3 = conexao.createStatement();
				st3.executeUpdate("DELETE FROM clientes WHERE id="+id);
			}
			return true;
		}
		catch (SQLException e) { 
			System.out.println("Falhou no removeCliente");
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public void atualizaCLiente(String[] imo) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("UPDATE clientes SET nome='"+imo[2]+"', idade='"+imo[3]+"' WHERE id=" + imo[0]);
		}
		catch (SQLException e){
			System.out.println("Falhou no atualizaCLiente");
			System.out.println(e.getMessage());
		}
	}
	
	public String retornImovelDoCLiente(String id) {
		String s = "";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE id="+id);
			while(rs.next()) {
				s = rs.getString(2);
			}
			return s;
		}
		catch (SQLException e) { 
			System.out.println("Falhou no retornImovelDoCLiente");
			System.out.println(e.getMessage());
		}
		return null;
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
