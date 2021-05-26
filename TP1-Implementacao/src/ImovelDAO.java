import java.sql.*;

public class ImovelDAO extends BancoDeDados {
	public boolean adicionaImoveis(Imovel i) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO AluguelBD.imoveis (categoria, endereco, area, custo, qntQuartos, qntSuites, qntVagasEstacionamento, piscina, churrasqueira, playground, alugado) VALUES (NULL, '" + i.getCategoria() + "', '"+ i.getEndereco() + "', '" + i.getArea() + "', '" + i.getCusto() + "', '" + i.getQntQuartos() + "', '" + i.getQntSuites() + "', '" + i.getQntVagasEstacionamento() + "', '" + i.isPiscina() + "', '" + i.isChurrasqueira() + "', '" + i.isPlayground() + "', '" + i.isAlugado() + "')");
			return true;
		}
		catch (SQLException e){
			System.out.println("Falhou no adicionaImoveis");
			return false;
		}
	}
	
	public void listaPersonagens() {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM imoveis");
			while(rs.next()) {
				System.out.println("Id: " + rs.getString(1) + "\n" + "Categoria: " + rs.getString(2) + "\n" + "Endereço: " + rs.getString(3)+ "\n" + "Area: " + rs.getString(4) + "\n" + "Custo: " + rs.getString(5) + "\n" + "Quartos: " + rs.getString(6) + "\n" + "Suítes: " + rs.getString(7) + "\n" + "Vagas de estacionamento: " + rs.getString(8) + "\n" + "Piscina: " + rs.getString(9) + "\n" + "Churrasqueira: " + rs.getString(10) + "\n" + "Playground: " + rs.getString(11) + "\n" + "Alugado: " + rs.getString(12) +"\n");
			}
		}
		catch (SQLException e) { System.out.println("Falhou no listaImoveis");}
	}
	
	public static void main (String args[]) {
		ImovelDAO iDAO = new ImovelDAO ();
		Imovel i = new Imovel("Casa Padrao", "Rua1", 12.5, 100.00, 3, 2, 2, false, false, false, false);
		iDAO.adicionaImoveis(i);
		iDAO.listaPersonagens();
		
	}
}
