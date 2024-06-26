
public class Imovel {
	
	private String categoria;
	private String endereco;
	private double area;
	private double custo;
	private int qntQuartos;
	private int qntSuites;
	private int qntVagasEstacionamento;
	private int piscina;
	private int churrasqueira;
	private int playground;
	private int alugado;
	
	public Imovel(String categoria, String endereco, double area, double custo, int qntQuartos, int qntSuites,
			int qntVagasEstacionamento, int piscina, int churrasqueira, int playground, int alugado) {
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
	
	public Imovel(String categoria, String endereco, double area, double custo) {
		super();
		this.categoria = categoria;
		this.endereco = endereco;
		this.area = area;
		this.custo = custo;
	}

	public Imovel(String categoria, String endereco, double area, double custo, int qntQuartos, int qntSuites,
			int qntVagasEstacionamento) {
		super();
		this.categoria = categoria;
		this.endereco = endereco;
		this.area = area;
		this.custo = custo;
		this.qntQuartos = qntQuartos;
		this.qntSuites = qntSuites;
		this.qntVagasEstacionamento = qntVagasEstacionamento;
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

	public int isPiscina() {
		return piscina;
	}

	public void setPiscina(int piscina) {
		this.piscina = piscina;
	}

	public int isChurrasqueira() {
		return churrasqueira;
	}

	public void setChurrasqueira(int churrasqueira) {
		this.churrasqueira = churrasqueira;
	}

	public int isPlayground() {
		return playground;
	}

	public void setPlayground(int playground) {
		this.playground = playground;
	}

	public int isAlugado() {
		return alugado;
	}

	public void setAlugado(int alugado) {
		this.alugado = alugado;
	}
	
}
