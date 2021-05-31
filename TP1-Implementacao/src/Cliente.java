
public class Cliente {
	private int imovel_id;
	private String nome;
	private int idade;
	
	public Cliente(int imovel_id, String nome, int idade) {
		super();
		this.imovel_id = imovel_id;
		this.nome = nome;
		this.idade = idade;
	}

	public int getImovel_id() {
		return imovel_id;
	}

	public void setImovel_id(int imovel_id) {
		this.imovel_id = imovel_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
