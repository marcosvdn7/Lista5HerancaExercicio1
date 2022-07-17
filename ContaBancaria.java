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

	protected ContaBancaria() {
	}

	protected ContaBancaria(String nomeCliente, String numConta) {
		this.nomeCliente = nomeCliente;
		this.numConta = numConta;
	}

	protected ContaBancaria(String nomeCliente, String numConta, double saldo) {
		this.nomeCliente = nomeCliente;
		this.numConta = numConta;
		this.saldo = saldo;
	}

	// GETTERS E SETTERS
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// METODOS
	
	public boolean sacar(double valor) {
		if (this.saldo != 0 && valor <= this.saldo) {
			this.saldo -= valor;
			return true;
		} else {
			return false;
		}
	}

	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	protected String toString() {
		return "\n---------------------------" + "\nNome: " + nomeCliente + "" + "\nNumero da conta: " + numConta + ""
				+ "\nSaldo: " + saldo + "\n";
	}

}
