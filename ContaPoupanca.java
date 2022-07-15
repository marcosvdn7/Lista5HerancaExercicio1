package Lista5HerancaExercicio1.Lista5HerancaExercicio1;

public class ContaPoupanca extends ContaBancaria {

	private String diaRendimento;
	
	public ContaPoupanca() {
	}
	
	public ContaPoupanca(String nomeCliente, String numConta, double saldo) {
		super (nomeCliente, numConta, saldo);
	}
	
	public ContaPoupanca(String diaRendimento) {
		this.diaRendimento = diaRendimento;
	}
	
	public ContaPoupanca(String nomeCliente, String numConta) {
		super (nomeCliente, numConta);
	}

	public String getDiaRendimento() {
		return diaRendimento;
	}

	public void setDiaRendimento(String diaRendimento) {
		this.diaRendimento = diaRendimento;
	}
	
	public double calcularNovoSaldo(double rendimento) {
		rendimento /= 100;
		double valorASomar = super.getSaldo() * rendimento;
		super.setSaldo(valorASomar + super.getSaldo());
		return super.getSaldo();
	}
	
	public void mostrarInfo() {
		super.mostrarInfo();
		System.out.println("Dia do Rendimento: " +this.diaRendimento);
		System.out.println("---------------------------");
	}
	
}
