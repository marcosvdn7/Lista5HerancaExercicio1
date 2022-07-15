package Lista5HerancaExercicio1;

public class ContaEspecial extends ContaBancaria {

	double limite;
	
	public ContaEspecial() {
	}
	
	public ContaEspecial(String nomeCliente, String numConta, double saldo) {
		super (nomeCliente, numConta, saldo);
	}

	public ContaEspecial(String nomeCliente, String numConta) {
		super (nomeCliente, numConta);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public boolean sacar (double valor) {
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
			} else if (super.getSaldo() <= 0 && valor > this.limite){
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
	
	public void depositar (double valor, double limiteMax) {
		if (this.limite < limiteMax && super.getSaldo() <= 0) {
			this.limite += valor;
			super.setSaldo(super.getSaldo() + valor);
			if (this.limite > limiteMax) {
				this.limite = limiteMax;
			}
		} else if (this.limite == limiteMax){
			super.setSaldo(super.getSaldo() + valor);
		}
	}
	
	public void mostrarInfo() {
		System.out.println("Conta Especial!");
		super.mostrarInfo();
		System.out.println("Valor do Limite Especial: " +this.limite);
		System.out.println("---------------------------");
	}
	
	public void mostrarLimite() {
		System.out.println(this.limite);
	}
	
}
