package Lista5HerancaExercicio1;

import java.util.Scanner;

public class ClasseTeste {

	public static void main(String[] args) {
		//teste
		Scanner read = new Scanner(System.in);
		
		String nomeCliente;
		String numConta;
		int opcao;
		double valorRendimento;
		double limiteMaximo;
		
		System.out.println("Informe o nome do cliente: ");
		nomeCliente = read.nextLine();
		
		System.out.println("Informe o numero da conta: ");
		numConta = read.nextLine();
		
		System.out.println("Selecione o tipo de conta que deseja criar: ");
		System.out.println("1 - Poupança.");
		System.out.println("2 - Especial.");
		opcao = read.nextInt();
		
		while (opcao < 1 || opcao > 2) {
			System.out.println("Opção inválida! Seleciona uma das opções abaixo: ");
			System.out.println("1 - Poupança.");
			System.out.println("2 - Especial.");
			opcao = read.nextInt();
		}
		
		if (opcao == 1) {
			ContaPoupanca conta = new ContaPoupanca(nomeCliente, numConta);
			
			System.out.println("Informe o dia de rendimento da conta: ");
			conta.setDiaRendimento(read.next());
			
			System.out.println("Informe o saldo da conta: ");
			conta.setSaldo(read.nextDouble());
			
			while (opcao != 5) {
				System.out.println("-----------------------------------------");
				System.out.println("1 - Sacar.");
				System.out.println("2 - Depositar.");
				System.out.println("3 - Mostrar novo saldo com rendimento.");
				System.out.println("4 - Mostrar Informaçoes da Conta.");
				System.out.println("5 - Sair.");
				System.out.println("-----------------------------------------");
				opcao = read.nextInt();
				
				switch (opcao) {
				case 1: 
					System.out.println("Informe o valor que deseja sacar: ");
					if (conta.sacar(read.nextDouble()) == true) {
						System.out.println("Saque efetuado com sucesso!");
						System.out.println("---------------------------");
						System.out.println("Saldo Atual: " +conta.getSaldo());
						System.out.println("---------------------------");break;
					} else {
						System.out.println("N�o foi poss�vel realizar o saque!");break;
					}
					
				case 2:
					System.out.println("Informe o valor que deseja depositar: ");
					conta.depositar(read.nextDouble());
					System.out.println("---------------------------");
					System.out.println("Saldo Atual: " +conta.getSaldo());
					System.out.println("---------------------------");break;
					
				case 3:
					System.out.println("Informe o valor do rendimento (em porcentagem): ");
					valorRendimento = read.nextDouble(); 
					System.out.println("---------------------------");
					System.err.println(conta.calcularNovoSaldo(valorRendimento));
					System.out.println("---------------------------");break;
					
				case 4: 
					conta.toString();
				}
			}
			
		} else if (opcao == 2) {
			ContaEspecial conta = new ContaEspecial(nomeCliente, numConta);
			
			System.out.println("Informe o valor do limite especial: ");
			conta.setLimiteMaximo(read.nextDouble());
			limiteMaximo = conta.getLimiteAtual();
			
			System.out.println("Informe o saldo da conta: ");
			conta.setSaldo(read.nextDouble());
			
			while (opcao != 5) {
				System.out.println("Saldo Atual: " +conta.getSaldo());
				System.out.println("Limite Especial Atual: " +conta.getLimiteAtual());
				System.out.println("---------------------------");
				System.out.println("1 - Sacar.");
				System.out.println("2 - Depositar.");
				System.out.println("3 - Mostrar Limite Especial");
				System.out.println("4 - Mostrar Informaçoes da Conta.");
				System.out.println("5 - Sair.");
				System.out.println("---------------------------");
				opcao = read.nextInt();
				
				switch (opcao) {
				case 1: 
					System.out.println("Informe o valor que deseja sacar: ");
					if (conta.sacar(read.nextDouble()) == true){
						System.out.println("Saque efetuado com sucesso!");
						System.out.println("---------------------------");
						System.out.println("Saldo Atual: " +conta.getSaldo());
						System.out.println("Limite Atual: " +conta.getLimiteAtual());
						System.out.println("---------------------------");break;
					} else {
						System.out.println("Nao foi possivel efetuar o saque!!");break;
					}
					
				case 2:
					System.out.println("Informe o valor que deseja depositar: ");
					conta.depositar(read.nextDouble());
					System.out.println("---------------------------");
					System.out.println("Saldo Atual: " +conta.getSaldo());
					System.out.println("Limite Atual: " +conta.getLimiteAtual());
					System.out.println("---------------------------");break;
					
				case 3:
					System.out.println("---------------------------");
					System.out.println(conta.getLimiteAtual());
					System.out.println("---------------------------");break;
					
				case 4: 
					//conta.mostrarInfo();
					System.out.println();
				}
			}
		}
		
		read.close();
		
	}

}
