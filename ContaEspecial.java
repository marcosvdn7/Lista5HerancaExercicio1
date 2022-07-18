package Lista5HerancaExercicio1.Lista5HerancaExercicio1;

public class ContaEspecial extends ContaBancaria {

	// ATRIBUTOS DE INSTANCIA

	private double limite;

	// CONSTRUTORES

	/**
	 * Construtor vazio da classe ContaEspecial.
	 */
	public ContaEspecial() {
		super();
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
	 * @param limite      do cheque especial em <code>double</code>.
	 */
	public ContaEspecial(String nomeCliente, String numConta, double saldo, double limite) {
		super(nomeCliente, numConta, saldo);
		this.limite = limite;
	}

	// GETTERS E SETTERS

	/**
	 * Informa o limite do cheque especial da conta.
	 * 
	 * @return o limite em <code>double</code>.
	 */
	public double getLimite() {
		return limite;
	}

	/**
	 * Define o limite do cheque especial da conta.
	 *  
	 * @param limite a ser definido em <code>double</code>.
	 */
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	// METODOS

	@Override
	public boolean sacar(double valor) {
		double resto = 0;
		if (valor > super.getSaldo() + this.limite) {
			return false;
		} else if (valor <= super.getSaldo()) {
			super.setSaldo(super.getSaldo() - valor);
			return true;
		} else if (valor > super.getSaldo() && this.limite <= 0) {
			return false;
		} else if (valor > super.getSaldo() && this.limite > 0) {
			if (super.getSaldo() > 0) {
				resto = valor - super.getSaldo();
				super.setSaldo(super.getSaldo() - valor);
				this.limite -= resto;
				return true;
			} else if (super.getSaldo() <= 0 && valor > this.limite) {
				return false;
			}
		}
		if (super.getSaldo() <= 0 && valor <= this.limite) {
			this.limite -= valor;
			super.setSaldo(super.getSaldo() - valor);
			return true;
		}

		return false;
	}

	public void depositar(double valor, double limiteMax) {
		if (this.limite < limiteMax && super.getSaldo() <= 0) {
			this.limite += valor;
			super.setSaldo(super.getSaldo() + valor);
			if (this.limite > limiteMax) {
				this.limite = limiteMax;
			}
		} else if (this.limite == limiteMax) {
			super.setSaldo(super.getSaldo() + valor);
		}
	}

	public void mostrarLimite() {
		System.out.println(this.limite);
	}

}
