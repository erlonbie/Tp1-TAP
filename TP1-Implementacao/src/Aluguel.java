import java.util.Calendar;
import java.util.Date;

public class Aluguel {
	
	private int cliente_id;
	private int clinte_imovel;
	private Date inicio;
	private Date termino;
	private double seguro;
	private double chaveExtra;
	private double mobiliado;
	private double total;
	
	public Aluguel(int cliente_id, int clinte_imovel, Date inicio, Date termino, double seguro, double chaveExtra,
			double mobiliado) {
		super();
		this.cliente_id = cliente_id;
		this.clinte_imovel = clinte_imovel;
		this.inicio = inicio;
		this.termino = termino;
		this.seguro = seguro;
		this.chaveExtra = chaveExtra;
		this.mobiliado = mobiliado;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_d(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public int getClinte_imovel() {
		return clinte_imovel;
	}

	public void setClinte_imovel(int clinte_imovel) {
		this.clinte_imovel = clinte_imovel;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public double getSeguro() {
		return seguro;
	}

	public void setSeguro(double seguro) {
		this.seguro = seguro;
	}

	public double getChaveExtra() {
		return chaveExtra;
	}

	public void setChaveExtra(double chaveExtra) {
		this.chaveExtra = chaveExtra;
	}

	public double getMobiliado() {
		return mobiliado;
	}

	public void setMobiliado(double mobiliado) {
		this.mobiliado = mobiliado;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
