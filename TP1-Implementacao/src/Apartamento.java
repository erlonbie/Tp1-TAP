
public class Apartamento extends Imovel {

	public Apartamento(String categoria, String endereco, double area, double custo, int qntQuartos, int qntSuites,
			int qntVagasEstacionamento) {
		super(categoria, endereco, area, custo, qntQuartos, qntSuites, qntVagasEstacionamento);
		this.setPiscina(1);
		this.setChurrasqueira(0);
		this.setPlayground(1);
	}
}
