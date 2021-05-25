
public class Imovel {
	
	private String categoria;
	private String endereco;
	private double area;
	private double custo;
	private int qntQuartos;
	private int qntSuites;
	private int qntVagasEstacionamento;
	private boolean piscina;
	private boolean churrasqueira;
	private boolean playground;
	private boolean alugado;
	
	public Imovel(String categoria, String endereco, double area, double custo, int qntQuartos, int qntSuites,
			int qntVagasEstacionamento, boolean piscina, boolean churrasqueira, boolean playground, boolean alugado) {
		super();
		this.categoria = categoria;
		this.endereco = endereco;
		this.area = area;
		this.custo = custo;
		this.qntQuartos = qntQuartos;
		this.qntSuites = qntSuites;
		this.qntVagasEstacionamento = qntVagasEstacionamento;
		this.piscina = piscina;
		this.churrasqueira = churrasqueira;
		this.playground = playground;
		this.alugado = alugado;
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

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
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

	public boolean isPiscina() {
		return piscina;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}

	public boolean isChurrasqueira() {
		return churrasqueira;
	}

	public void setChurrasqueira(boolean churrasqueira) {
		this.churrasqueira = churrasqueira;
	}

	public boolean isPlayground() {
		return playground;
	}

	public void setPlayground(boolean playground) {
		this.playground = playground;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
	
}
