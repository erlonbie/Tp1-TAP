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
				i.imoveis.add(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3)+  "|" + rs.getString(4)  + "|" + rs.getString(5) +  "|" + rs.getString(6) +  "|" + rs.getString(7) +  "|" + rs.getString(8));
			}
		}
		catch (SQLException e) { 
			System.out.println("Falhou no listaImoveis");
			System.out.println(e.getMessage());
		}
		
	}
	
	public void removeImoveis(String id) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM imoveis WHERE id=" + id);
		}
		catch (SQLException e){
			System.out.println("Falhou no removeImoveis");
			System.out.println(e.getMessage());
		}
	}
	
	public void atualizaImovel(String[] imo) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("UPDATE imoveis SET endereco='"+imo[2]+"', area='"+imo[3]+"', custo='"+imo[4]+"', qntQuartos='"+imo[5]+"', qntSuites='"+imo[6]+"', qntVagasEstacionamento='"+imo[7]+"'  WHERE id=" + imo[0]);
		}
		catch (SQLException e){
			System.out.println("Falhou no atualizaImovel");
			System.out.println(e.getMessage());
		}
		 
	}
	
	public String retornaCusto(String id) {
		String s = "";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM imoveis WHERE id="+id);
			while(rs.next()) {
				s =  rs.getString(5);
			}
			return s;
		}
		catch (SQLException e) { 
			System.out.println("Falhou no retornaCusto");
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	public void alugaImovel(String id) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("UPDATE imoveis SET alugado='1' WHERE id="+id);
		}
		catch (SQLException e){
			System.out.println("Falhou no alugaImovel");
			System.out.println(e.getMessage());
		}
		 
	}
	
	public void desalugaImovel(String id) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("UPDATE imoveis SET alugado='0' WHERE id="+id);
		}
		catch (SQLException e){
			System.out.println("Falhou no alugaImovel");
			System.out.println(e.getMessage());
		}
	}
	
	public boolean alugado(String id) {
		String s = "";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM imoveis WHERE id="+id);
			while(rs.next()) {
				s =  rs.getString(12);
			}
			if(Integer.parseInt(s) == 1) {
				return true;
			}
		}
		catch (SQLException e) { 
			System.out.println("Falhou no verificaAlugado");
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public String ultimoImovelAdicionado() {
		String s = "";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM imoveis WHERE id=(SELECT LAST_INSERT_ID())");
			while(rs.next()) {
				//i.imoveis.add(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3)+  "|" + rs.getString(4)  + "|" + rs.getString(5) +  "|" + rs.getString(6) +  "|" + rs.getString(7) +  "|" + rs.getString(8));
				s = rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3)+  "|" + rs.getString(4)  + "|" + rs.getString(5) +  "|" + rs.getString(6) +  "|" + rs.getString(7) +  "|" + rs.getString(8);
			}
			return s;
		}
		catch (SQLException e) { 
			System.out.println("Falhou no imovelUltimoCliente");
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
