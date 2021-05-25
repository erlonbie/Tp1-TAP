
public class Imovel {
	
	private String categoria;
	private String endereco;
	private double area;
	private int qntQuartos;
	private int qntSuites;
	private int qntVagasEstacionamento;
	private double custo;
	private boolean alugado=false;
	
	public Imovel(String categoria, String endereco, double area, int qntQuartos, int qntSuites,
			int qntVagasEstacionamento, double custo) {
		super();
		this.categoria = categoria;
		this.endereco = endereco;
		this.area = area;
		this.qntQuartos = qntQuartos;
		this.qntSuites = qntSuites;
		this.qntVagasEstacionamento = qntVagasEstacionamento;
		this.custo = custo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getQntQuartos() {
		return qntQuartos;
	}

	public void setQntQuartos(int qntQuartos) {
		this.qntQuartos = qntQuartos;
	}

	public int getQntSuites() {
		return qntSuites;
	}

	public void setQntSuites(int qntSuites) {
		this.qntSuites = qntSuites;
	}

	public int getQntVagasEstacionamento() {
		return qntVagasEstacionamento;
	}

	public void setQntVagasEstacionamento(int qntVagasEstacionamento) {
		this.qntVagasEstacionamento = qntVagasEstacionamento;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	
	
}
