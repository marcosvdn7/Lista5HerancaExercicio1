package ListaOOB5HerançaExercicio1;

public abstract class ContaBancaria {
	private String nomeCliente;
	private String numConta;
	private double saldo;
	
	public ContaBancaria() {}
	
	public ContaBancaria(String nomeCliente, String numConta, double saldo) {
		this.nomeCliente = nomeCliente;
		this.numConta = numConta;
		this.saldo = saldo;
	}
	
	public ContaBancaria(String nomeCliente, String numConta) {
		this.nomeCliente = nomeCliente;
		this.numConta = numConta;
	}
	
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

	public boolean sacar (double valor) {
		if (this.saldo != 0 && valor <= this.saldo) {
			this.saldo -= valor;
			return true;
		} else if (valor > this.saldo){
			return false;
		} 
		
		return false;
	}
	
	public void depositar (double valor) {
		this.saldo += valor;
	}
	
	public void mostrarInfo() {
		System.out.println("---------------------------");
		System.out.println("Nome: " +this.nomeCliente);
		System.out.println("Numero da conta: " +this.numConta);
		System.out.println("Saldo: " +this.saldo);
		
	}
	
	public void mostrarLimite() {
	}
}
