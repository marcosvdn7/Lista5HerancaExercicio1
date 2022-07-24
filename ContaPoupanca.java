/**
 * Conta Poupanca
 * @date jul/2022
 * @authors Ana Júlia da Cunha - Entra21
 * 			Gabriel Roger da Cunha - Entra21
 * 			Marcos Vinicius do Nascimento - Entra21
 * 	
 * Lista 5: Exercicio 1.
 */

package Lista5HerancaExercicio1;

public class ContaPoupanca extends ContaBancaria {

	// ATRIBUTOS DE INSTANCIA

	private String diaRendimento;

	// CONSTRUTORES

	/**
	 * Construtor vazio da classe ContaPoupanca.
	 */
	public ContaPoupanca() {
		super();
	}

	/**
	 * Construtor da classe ContaPoupanca que so requere o nome do cliente e o
	 * numero da conta.
	 * 
	 * @param nomeCliente nome do cliente.
	 * @param numConta    numero da conta em <code>String</code>.
	 */
	public ContaPoupanca(String nomeCliente, String numConta) {
		super(nomeCliente, numConta);
	}

	/**
	 * Construtor da classe ContaPoupanca que nao requere dia do rendimento.
	 * 
	 * @param nomeCliente nome do cliente.
	 * @param numConta    numero da conta em <code>String</code>.
	 * @param saldo       da conta em <code>double</code>.
	 */
	public ContaPoupanca(String nomeCliente, String numConta, double saldo) {
		super(nomeCliente, numConta, saldo);
	}

	/**
	 * Construtor da clase ContaPoupanca que so requere o dia do rendimento.
	 * @param diaRendimento em <code>String</code>.
	 */
	public ContaPoupanca(String diaRendimento) {
		super();
		this.diaRendimento = diaRendimento;
	}

	// GETTER E SETTER

	/**
	 * Informa o dia do rendimento da poupanca.
	 * @return dia do rendimento em <code>String</code>.
	 */
	public String getDiaRendimento() {
		return diaRendimento;
	}

	/**
	 * Define o dia do rendimento da poupanca.
	 * @param diaRendimento em <code>String</code> para definir.
	 */
	public void setDiaRendimento(String diaRendimento) {
		this.diaRendimento = diaRendimento;
	}

	// METODOS

	/**
	 * Calcula o novo saldo da poupanca de acordo com o rendimento.
	 * 
	 * @param rendimento rendimento da poupanca.
	 */
	public void calcularNovoSaldo(double rendimento) {
		rendimento /= 100;
		super.setSaldo((super.getSaldo() * rendimento) + super.getSaldo());
	}

	@Override
	public String toString() {
		return super.toString() + "Tipo de conta: Poupanca" + "\nDia do rendimento: " + diaRendimento
				+ "\n---------------------------";
	}
}
