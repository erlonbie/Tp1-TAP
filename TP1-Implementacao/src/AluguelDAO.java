import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class AluguelDAO extends BancoDeDados {
	
	VisualControleClientes i = new VisualControleClientes();
	java.util.Date dt = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    private DecimalFormat dec = new DecimalFormat("#0.00");
	
	public boolean adicionaAluguel(Aluguel i) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO alugueis VALUES (NULL, '" + i.getCliente_id() + "', '"+ i.getClinte_imovel() + "', '" + sdf.format(i.getInicio()) +"', '" + sdf.format(i.getTermino()) + "', '" +i.getSeguro() +"', '"+i.getChaveExtra()+"', '"+i.getMobiliado()+ "', '" + (i.getSeguro()+i.getChaveExtra()+i.getMobiliado()) + "')");
			return true;
		}
		catch (SQLException e){
			System.out.println("Falhou no adicionaAluguel");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
//	public void listarClientes() {
//		try {
//			Statement st = conexao.createStatement();
//			ResultSet rs = st.executeQuery("SELECT * FROM clientes");
//			while(rs.next()) {
//				System.out.println("Id: " + rs.getString(1) + "\n" + "Imovel_id: " + rs.getString(2) + "\n" + "Nome: " + rs.getString(3)+ "\n" + "Idade: " + rs.getString(4) + "\n"+"\n");
//			}
//		}
//		catch (SQLException e) { 
//			System.out.println("Falhou no listarClientes");
//			System.out.println(e.getMessage());
//		}
//	}
//	
//	public String listaApenasUmImovel() {
//		String s = "Imóvel Adicionado: \n";
//		try {
//			Statement st = conexao.createStatement();
//			ResultSet rs = st.executeQuery("SELECT * FROM imoveis WHERE id=(SELECT LAST_INSERT_ID())");
//			while(rs.next()) {
//				s += "Id: " + rs.getString(1) + "\n" + "Categoria: " + rs.getString(2) + "\n" + "Endereço: " + rs.getString(3)+ "\n" + "Area: " + rs.getString(4) + "\n" + "Custo: " + rs.getString(5) + "\n" + "Quartos: " + rs.getString(6) + "\n" + "Suítes: " + rs.getString(7) + "\n" + "Vagas de estacionamento: " + rs.getString(8) + "\n" + "Piscina: " + rs.getString(9) + "\n" + "Churrasqueira: " + rs.getString(10) + "\n" + "Playground: " + rs.getString(11) + "\n" + "Alugado: " + rs.getString(12) +"\n";
//			}
//			return s;
//		}
//		catch (SQLException e) { 
//			System.out.println("Falhou no listaApenasUmImovel");
//			System.out.println(e.getMessage());
//		}
//		return s;
//	}
//	
//	public String retornarImoveis() {
//		String s = "";
//		try {
//			Statement st = conexao.createStatement();
//			ResultSet rs = st.executeQuery("SELECT * FROM imoveis");
//			while(rs.next()) {
//				//s += "Id: " + rs.getString(1) + '\n' + "Categoria: " + rs.getString(2) + "\n" + "Endereço: " + rs.getString(3)+ "\n" + "Area: " + rs.getString(4) + "\n" + "Custo: " + rs.getString(5) + "\n" + "Quartos: " + rs.getString(6) + "\n" + "Suítes: " + rs.getString(7) + "\n" + "Vagas de estacionamento: " + rs.getString(8) + "\n" + "Piscina: " + rs.getString(9) + "\n" + "Churrasqueira: " + rs.getString(10) + "\n" + "Playground: " + rs.getString(11) + "\n" + "Alugado: " + rs.getString(12) +"\n--------------------\n";
//				s += String.format("Id:%43s\nCategoria:%41s\nEndereco:%34s\nArea:%41s\nCusto:%41s\nQuartos:%33s\nSuítes:%36s\nVagas de Estacionamento:%5s\nPiscina:%35s\nChurrasqueira:%24s\nPlayground:%29s\nAlugado:%34s\n---------------------------------------------------------------------------\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
//			}
//			return s;
//		}
//		catch (SQLException e) { 
//			System.out.println("Falhou no listaImoveis");
//			System.out.println(e.getMessage());
//		}
//		return null;
//	}
	
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
	
//	public void removeClientes(String id) {
//		try {
//			Statement st = conexao.createStatement();
//			st.executeUpdate("DELETE FROM clientes WHERE id=" + id);
//		}
//		catch (SQLException e){
//			System.out.println("Falhou no removeClientes");
//			System.out.println(e.getMessage());
//		}
//	}
	
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
	
	public String retornaIdClienteImovel(String mes, String ano) {
		String s = "";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alugueis WHERE ("+mes+"BETWEEN month(inicio) AND month(termino)) AND ("+ano+"BETWEEN YEAR(inicio) AND YEAR(termino))");
			while(rs.next()) {
				s = rs.getString(2)+rs.getString(3);
			}
			return s;
		}
		catch (SQLException e) { 
			System.out.println("Falhou no retornaIdClienteImovel");
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public String[] retornaDatas(String id) {
		String[] s = new String[2];
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alugueis WHERE cliente_imovel="+id);
			while(rs.next()) {
				s[0] = rs.getString(4);
				s[1] = rs.getString(5);
			}
			return s;
		}
		catch (SQLException e) { 
			System.out.println("Falhou no retornaDatas");
			System.out.println(e.getMessage());
		}
		return null;
	}
	
//	public boolean deletaUmAluguel(String id) {
//		try {
//			Statement st = conexao.createStatement();
//			st.executeUpdate();
//			return true;
//		}
//		catch (SQLException e){
//			System.out.println("Falhou no adicionaAluguel");
//			System.out.println(e.getMessage());
//			return false;
//		}
//		return false;
//	}
	
//	public String textoRelatorio3(String id_cliente) {
//		String s = "";
//		try {
//			Statement st = conexao.createStatement();
//			ResultSet rs3 = st.executeQuery("SELECT * FROM clientes WHERE id="+id_cliente);
//			while(rs3.next()) {
//				s = "Cliente: " + rs3.getString(3)+'\n';
//			}
//		}
//		catch (SQLException e) {
//			System.out.println("Falhou no textoRelatorio3");
//			System.out.println(e.getMessage());
//		}
//		return null;
//	}
//	
//	public String textoRelatorio2(String id_imovel) {
//		
//		String s = "";
//		try {
//			Statement st = conexao.createStatement();
//			ResultSet rs2 = st.executeQuery("SELECT * FROM clientes WHERE id="+id_imovel);
//			while(rs2.next()) {
//				s = "Imóvel_ID: " + rs2.getString(1)+", Categoria: "+rs2.getString(2)+'\n'+"Custo: "+rs2.getString(5)+" R$"+'\n';
//			}
//		}
//		catch (SQLException e) {
//			System.out.println("Falhou no textoRelatorio2");
//			System.out.println(e.getMessage());
//		}
//		return null;
//	}
	
	public String textoRelatorio(String mes, String ano) {
		String s = "";
		double total = 0;
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM AluguelBD.alugueis WHERE ("+mes+" BETWEEN month(inicio) AND month(termino)) AND ("+ano+" BETWEEN YEAR(inicio) AND YEAR(termino))");
			while(rs.next()) {
				String id_cliente = rs.getString(2);
				String id_imovel = rs.getString(3);
//				System.out.println(id_cliente);
//				System.out.println(id_imovel);
				Statement st2 = conexao.createStatement();
				ResultSet rs2 = st2.executeQuery("SELECT * FROM imoveis WHERE id="+id_imovel);
				while(rs2.next()) {
					Statement st3 = conexao.createStatement();
					ResultSet rs3 = st3.executeQuery("SELECT * FROM clientes WHERE id="+id_cliente);
					while(rs3.next()) {
						s += "Cliente: " + rs3.getString(3)+'\n';
					}
					//st3.close();
					s += "Imóvel_ID: " + rs2.getString(1)+", Categoria: "+rs2.getString(2)+'\n'+"Custo: "+rs2.getString(5)+" R$"+'\n';
					total = Double.parseDouble(rs2.getString(5));
				}
				total += Double.parseDouble(rs.getString(9));
				double seg = Double.parseDouble(rs.getString(6));
				double mob = Double.parseDouble(rs.getString(8));
				s += "No mês "+mes+" de "+ano+":"+'\n'+"    "+"Seguro: "+dec.format(seg)+" R$"+'\n'+"    "+"Chave-extra: "+rs.getString(7)+" R$"+'\n'+"    "+"Mobília: "+dec.format(mob)+" R$"+'\n'+"    "+"Subtotal: "+rs.getString(9)+" R$"+'\n'+ "Total(Subtotal + custo): "+String.valueOf(total) + " R$" +'\n' +'\n';
			}
			if(s.length() > 0) {
				return s;				
			}
			return "Nenhum aluguél encontrado no mês selecionado";
		}
		catch (SQLException e) { 
			System.out.println("Falhou no textoRelatorio");
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
