/**
 * Conta Bancaria
 * @date jul/2022
 * @authors Ana Júlia da Cunha - Entra21
 * 			Gabriel Roger da Cunha - Entra21
 * 			Marcos Vinicius do Nascimento - Entra21
 * 	
 * Lista 5: Exercicio 1.
 */

package Lista5HerancaExercicio1.Lista5HerancaExercicio1;

public abstract class ContaBancaria {

	// ATRIBUTOS DE INSTANCIA

	private String nomeCliente;
	private String numConta;
	private double saldo;

	// CONSTRUTORES

	/**
	 * Construtor vazio da classe ContaBancaria.
	 */
	protected ContaBancaria() {
	}

	/**
	 * Construtor da classe ContaBancaria que so requere o nome do cliente e o
	 * numero da conta.
	 * 
	 * @param nomeCliente nome do cliente.
	 * @param numConta    numero da conta em <code>String</code>.
	 */
	protected ContaBancaria(String nomeCliente, String numConta) {
		this.nomeCliente = nomeCliente;
		this.numConta = numConta;
	}

	/**
	 * Construtor da classe ContaBancaria.
	 * 
	 * @param nomeCliente nome do cliente.
	 * @param numConta    numero da conta em <code>String</code>.
	 * @param saldo       da conta em <code>double</code>.
	 */
	protected ContaBancaria(String nomeCliente, String numConta, double saldo) {
		this.nomeCliente = nomeCliente;
		this.numConta = numConta;
		this.saldo = saldo;
	}

	// GETTERS E SETTERS

	/**
	 * Informa o nome do cliente dono da conta.
	 * 
	 * @return o nome como <code>String</code>.
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * Define o nome do cliente dono da conta.
	 * 
	 * @param nomeCliente em <code>String</code> para definir.
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	/**
	 * Informa o numero da conta.
	 * 
	 * @return o numero como <code>String</code>.
	 */
	public String getNumConta() {
		return numConta;
	}

	/**
	 * Define o numero da conta
	 * 
	 * @param numConta em <code>String</code> para definir.
	 */
	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	/**
	 * Informa o saldo da conta.
	 * 
	 * @return o saldo como <code>double</code>.
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Define o saldo da conta corrente.
	 * 
	 * @param saldo em <code>double</code> para definir, nao tem nada haver com
	 *              saque e deposito.
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// METODOS

	/**
	 * Saca um valor na conta bancaria se a mesma possuir saldo suficiente.
	 * 
	 * @param valor precisa ser um <code>double</code> maior que 0 (zero).
	 * @return <code>true</code> se a transacao foi efetuada com sucesso ou
	 *         <code>false</code> caso falhe.
	 */
	public boolean sacar(double valor) {
		if (valor > 0 && valor <= this.saldo) {
			// SE O VALOR FOR MAIOR QUE ZERO E MENOR OU IGUAL AO SALDO, O VALOR É SACADO
			this.saldo -= valor;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Deposita um valor na conta bancaria.
	 * 
	 * @param valor a ser depositado em <code>double</code>.
	 */
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	protected String toString() {
		return "\n---------------------------" + "\nNome: " + nomeCliente + "" + "\nNumero da conta: " + numConta + ""
				+ "\nSaldo: " + saldo + "\n";
	}

}
