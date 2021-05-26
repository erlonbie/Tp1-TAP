
public class Kitchenette extends Imovel {

	public Kitchenette(String categoria, String endereco, double area, double custo) {
		super(categoria, endereco, area, custo);
		this.setQntQuartos(1);
		this.setQntSuites(1);
		this.setQntVagasEstacionamento(1);
		this.setPiscina(0);
		this.setChurrasqueira(0);
		this.setPlayground(0);
	}
}
