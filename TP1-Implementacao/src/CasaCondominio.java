
public class CasaCondominio extends Imovel {

	public CasaCondominio(String categoria, String endereco, double area, double custo, int qntQuartos, int qntSuites,
			int qntVagasEstacionamento) {
		super(categoria, endereco, area, custo, qntQuartos, qntSuites, qntVagasEstacionamento);
		this.setPiscina(1);
		this.setChurrasqueira(1);
		this.setPlayground(1);
	}
}
