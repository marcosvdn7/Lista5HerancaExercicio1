package Lista5HerancaExercicio1;

import java.util.Scanner;

public class ClasseParaTestes {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		ContaBancaria[] contas = new ContaBancaria[10];
		
		int opcao = 0;
		int opcaoConta = 0;
		int valorRendimento = 0;
		String numConta;
		boolean sair = false;
		
		while (opcao != 4) {
			System.out.println("-------------Sistema Banc√°rio-------------");
			System.out.println("1 - Abrir conta especial.");
			System.out.println("2 - Abrir conta poupan√ßa.");
			System.out.println("3 - Acessar conta existente.");
			System.out.println("4 - Encerrar.");
			System.out.println("---------------------------------------");
			opcao = read.nextInt();
			
				if (opcao == 1) {
					ContaEspecial contaEspecial = new ContaEspecial();
					
					System.out.println("Informe o nome: ");
					contaEspecial.setNomeCliente(read.next());
					
					System.out.println("Informe o n√∫mero da conta: ");
					contaEspecial.setNumConta(read.next());
					
					System.out.println("Informe o saldo da conta: ");
					contaEspecial.setSaldo(read.nextDouble());
					
					System.out.println("Informe o valor do limite especial: ");
					contaEspecial.setLimiteMaximo(read.nextDouble());
					contaEspecial.setLimiteAtual(contaEspecial.getLimiteMaximo());
					
					for (int i = 0; i < contas.length; i++) {
						if (contas[i] == null) {
							contas[i] = contaEspecial;
							break;
						}
					}
					
				} else if (opcao == 2) {
					ContaPoupanca contaPoupanca = new ContaPoupanca();
					
					System.out.println("Informe o nome: ");
					contaPoupanca.setNomeCliente(read.next());
					
					System.out.println("Informe o n√∫mero da conta: ");
					contaPoupanca.setNumConta(read.next());
					
					System.out.println("Informe o saldo da conta: ");
					contaPoupanca.setSaldo(read.nextDouble());
					
					System.out.println("Informe o dia do rendimento: ");
					contaPoupanca.setDiaRendimento(read.next());
					
					for (int i = 0; i < contas.length; i++) {
						if (contas[i] == null) {
							contas[i] = contaPoupanca;
							break;
						}
					}
				} else if (opcao == 3) {
					System.out.println("Informe o n˙mero da conta: ");
					numConta = read.next();
					
					for (int i = 0; i < contas.length; i++) {
						if (contas[i] == null) {
							break;
						}
						if (numConta.equalsIgnoreCase(contas[i].getNumConta())) {
							
							do {
								sair = false;
								opcaoConta = 0;
								double valor;
								System.out.println("---------- Conta " +contas[i].getNumConta()+ " ----------");
								System.out.println("1 - Sacar.");
								System.out.println("2 - Depositar.");
								System.out.println("3 - Mostrar InformaÁıes.");
								System.out.println((contas[i] instanceof ContaPoupanca ? "4 - Mostrar saldo com rendimento\n5 - Voltar." : "4 - Voltar"));
								System.out.println("---------------------------------------");
								opcaoConta = read.nextInt();
								
								switch (opcaoConta) {
								
								case 1: 
									System.out.println("Informe o valor que deseja sacar: ");
									valor = read.nextDouble();
									int retornoSaque = contas[i].sacar(valor);
									if (retornoSaque == 0) {
										System.out.println("Saque realizado com sucesso!");
										System.out.println("Novo Saldo = " +((ContaEspecial)contas[i]).getSaldo());
										System.out.println((contas[i] instanceof ContaEspecial ? "Novo Limite = " +((ContaEspecial)contas[i]).getLimiteAtual() : ""));break;
									} else if (retornoSaque == 1){
										System.out.println("Saque realizado com sucesso!");
										System.out.println("Novo Saldo: " +((ContaEspecial)contas[i]).getSaldo());
										System.out.println((contas[i] instanceof ContaEspecial ? "Limite Atual = " +((ContaEspecial)contas[i]).getLimiteAtual() : ""));break;
									}
									
								case 2:
									System.out.println("Informe o valor que deseja depositar: ");
									valor = read.nextDouble();
									contas[i].depositar(valor);
									System.out.println("Novo saldo: " +contas[i].getSaldo());
									System.out.println((contas[i] instanceof ContaEspecial ? "Limite Atual: " +((ContaEspecial)contas[i]).getLimiteAtual() : ""));
									break;
									
								case 3:
									System.out.println((contas[i] instanceof ContaEspecial ? ((ContaEspecial)contas[i]).toString() : 
																							 ((ContaPoupanca)contas[i]).toString()));break;
																							 
								case 4:
									if (contas[i] instanceof ContaEspecial) {
										sair = true;
										break;
									}
									
									System.out.println("Informe o valor do rendimento (em porcentagem): ");
									valorRendimento = read.nextInt();
									
									if (contas[i] instanceof ContaPoupanca) {
										((ContaPoupanca)contas[i]).calcularNovoSaldo(valorRendimento);
										System.out.println("Saldo Atual: " +contas[i].getSaldo());
									}
								case 5: sair = true;break;
								}
								
							} while (!sair);
						}
					}
				}
		}

		read.close();

	}

}
