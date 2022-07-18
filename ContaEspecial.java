package Lista5HerancaExercicio1;

public class ContaEspecial extends ContaBancaria {

	// ATRIBUTOS DE INSTANCIA

	private double limiteAtual;
	private double limiteMaximo;

	// CONSTRUTORES

	/**
	 * Construtor vazio da classe ContaEspecial.
	 */
	public ContaEspecial() {
		super();
		this.limiteAtual = this.limiteMaximo;
	}

	/**
	 * Construtor da classe ContaEspecial que so requere o nome do cliente e o
	 * numero da conta.
	 * 
	 * @param nomeCliente nome do cliente.
	 * @param numConta    numero da conta em <code>String</code>.
	 */
	public ContaEspecial(String nomeCliente, String numConta) {
		super(nomeCliente, numConta);
	}

	/**
	 * Construtor da classe ContaEspecial que nao requere limite.
	 * 
	 * @param nomeCliente nome do cliente.
	 * @param numConta    numero da conta em <code>String</code>.
	 * @param saldo       da conta em <code>double</code>.
	 */
	public ContaEspecial(String nomeCliente, String numConta, double saldo) {
		super(nomeCliente, numConta, saldo);
	}

	/**
	 * Construtor completo da classe ContaEspecial.
	 * 
	 * @param nomeCliente nome do cliente.
	 * @param numConta    numero da conta em <code>String</code>.
	 * @param saldo       da conta em <code>double</code>.
	 * @param limiteMaximo      do cheque especial em <code>double</code>.
	 */
	public ContaEspecial(String nomeCliente, String numConta, double saldo, double limiteMaximo) {
		super(nomeCliente, numConta, saldo);
		this.limiteMaximo = limiteMaximo;
	}

	// GETTERS E SETTERS

	/**
	 * Informa o limite atual do cheque especial da conta.
	 * 
	 * @return o limite atual em <code>double</code>.
	 */
	public double getLimiteAtual() {
		return limiteAtual;
	}

	/**
	 * Define o limite atual do cheque especial da conta.
	 *  
	 * @param limite atual a ser definido em <code>double</code>.
	 */
	public void setLimiteAtual(double limiteAtual) {
		this.limiteAtual = limiteAtual;
	}
	
	/**
	 * Define o limite maximo do cheque especial da conta.
	 *  
	 * @param limite maximo a ser definido em <code>double</code>.
	 */
	public double getLimiteMaximo() {
		return limiteMaximo;
	}

	/**
	 * Define o limite maximo do cheque especial da conta.
	 *  
	 * @param limite maximo a ser definido em <code>double</code>.
	 */
	public void setLimiteMaximo(double limiteMaximo) {
		this.limiteMaximo = limiteMaximo;
	}
	
	// METODOS

	@Override
	public boolean sacar(double valor) {
		double resto = 0;
		if (valor > super.getSaldo() + this.limiteAtual && super.getSaldo() >= 0) {
			return false;
		} else if (valor <= super.getSaldo()) {
			super.setSaldo(super.getSaldo() - valor);
			return true;
		} else if (valor > super.getSaldo() && this.limiteAtual <= 0) {
			return false;
		} else if (valor > super.getSaldo() && this.limiteAtual > 0) {
			if (super.getSaldo() > 0) {
				resto = valor - super.getSaldo();
				super.setSaldo(super.getSaldo() - valor);
				this.limiteAtual -= resto;
				return true;
			} else if (super.getSaldo() <= 0 && valor > this.limiteAtual) {
				return false;
			}
		}
		if (super.getSaldo() <= 0 && valor <= this.limiteAtual) {
			this.limiteAtual -= valor;
			super.setSaldo(super.getSaldo() - valor);
			return true;
		}

		return false;
	}

	public void depositar(double valor) {
		if (this.limiteAtual < this.limiteMaximo && super.getSaldo() <= 0) {
			this.limiteAtual += valor;
			super.setSaldo(super.getSaldo() + valor);
			if (this.limiteAtual > limiteMaximo) {
				this.limiteAtual = limiteMaximo;
			}
		} else if (this.limiteAtual == limiteMaximo) {
			super.setSaldo(super.getSaldo() + valor);
		}
	}

	public void mostrarLimite() {
		System.out.println(this.limiteAtual);
	}

}
