/**
 * Conta Especial
 * @date jul/2022
 * @authors Ana Júlia da Cunha - Entra21
 * 			Gabriel Roger da Cunha - Entra21
 * 			Marcos Vinicius do Nascimento - Entra21
 * 	
 * Lista 5: Exercicio 1.
 */

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
	 * @param nomeCliente  nome do cliente.
	 * @param numConta     numero da conta em <code>String</code>.
	 * @param saldo        da conta em <code>double</code>.
	 * @param limiteMaximo do cheque especial em <code>double</code>.
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
	public int sacar(double valor) {

		if (valor <= 0) {
			return -1; // VALOR NULO OU NEGATIVO
		}

		// SE O VALOR FOR MENOR OU IGUAL AO SALDO
		else if (valor <= super.getSaldo()) {
			super.setSaldo(super.getSaldo() - valor);
			return 0; // SUCESSO
		}

		// SE O VALOR FOR MAIOR QUE O SALDO SOMADO AO LIMITE ATUAL E O SALDO FOR MAIOR
		// OU IGUAL A ZERO
		else if (valor > (super.getSaldo() + this.limiteAtual) && super.getSaldo() >= 0) {
			return -2; // INSUFICIENCIA DE SALDO E LIMITE
		}

		// SE O VALOR FOR MAIOR QUE O SALDO E NAO HOUVER LIMITE
		else if (valor > super.getSaldo() && this.limiteAtual <= 0) {
			return -2; // INSUFICIENCIA DE SALDO E LIMITE
		}

		// SE O VALOR FOR MAIOR QUE O SALDO E HOUVER LIMITE
		else if (valor > super.getSaldo() && this.limiteAtual > 0) {

			// SE O SALDO FOR MENOR OU IGUAL A ZERO
			if (super.getSaldo() <= 0) {
				this.limiteAtual -= valor; // SACA-SE O VALOR DO LIMITE
				super.setSaldo(super.getSaldo() - valor); // E DESCONTA-SE NO SALDO
				return 1; // SUCESSO, MAS DESCONTADO DO LIMITE
			}
			// SE HOUVER SALDO
			else {
				double insuficiente = valor - super.getSaldo(); // PEGA O VALOR INSUFICIENTE PARA SAQUE

				// SE O INSUFICIENTE FOR MAIOR QUE O LIMITE
				if (insuficiente > this.limiteAtual) {
					return -2; // INSUFICIENCIA DE SALDO E LIMITE
				} else {
					super.setSaldo(super.getSaldo() - valor); // SACA-SE O VALOR DO SALDO
					this.limiteAtual -= insuficiente; // E DESCONTA-SE O INSUFICIENTE DO LIMITE ATUAL
					return 1; // SUCESSO, MAS DESCONTADO DO LIMITE
				}
			}

		}

		return -3; // ERRO INESPERADO
	}

	@Override
	public int depositar(double valor) {

		if (valor <= 0) {
			return -1; // VALOR NULO OU NEGATIVO

		} else {
			// SE O LIMITE ATUAL FOR MENOR QUE O LIMITE MAXIMO E O SALDO FOR MENOR OU IGUAL
			// A ZERO, O VALOR DEPOSITADO AUMENTA O LIMITE
			if (this.limiteAtual < this.limiteMaximo && super.getSaldo() <= 0) {
				this.limiteAtual += valor;

				// SE O LIMITE ULTRAPASSAR O LIMITE MAX, ELE RECEBE O VALOR DO LIMITE MAXIMO
				if (this.limiteAtual > limiteMaximo) {
					this.limiteAtual = limiteMaximo;
				}

				// E DEPOSITA O VALOR NA CONTA
				super.depositar(valor);

				return 0; // SUCESSO

			} else {
				return -3; // ERRO INESPERADO
			}
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Tipo de conta: Especial" + "\nLimite atual: " + limiteAtual + "\nLimite Maximo: "
				+ limiteMaximo + "\n---------------------------";
	}

}
