
public class CasaPadrao extends Imovel {

	public CasaPadrao(String categoria, String endereco, double area, double custo, int qntQuartos, int qntSuites,
			int qntVagasEstacionamento) {
		super(categoria, endereco, area, custo, qntQuartos, qntSuites, qntVagasEstacionamento);
		this.setPiscina(0);
		this.setChurrasqueira(1);
		this.setPlayground(0);
	}
}
