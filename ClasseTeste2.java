package Lista5HerancaExercicio1;

import java.util.Scanner;

public class ClasseTeste2 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		ContaEspecial[] contasEspeciais = new ContaEspecial[10];
		ContaPoupanca[] contasPoupancas = new ContaPoupanca[10];
		
		int opcao = 0;
		int opcaoConta = 0;
		String numConta;
		
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
					
					for (int i = 0; i < contasEspeciais.length; i++) {
						if (contasEspeciais[i] == null) {
							contasEspeciais[i] = contaEspecial;
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
					
					for (int i = 0; i < contasEspeciais.length; i++) {
						if (contasPoupancas[i] == null) {
							contasPoupancas[i] = contaPoupanca;
							break;
						}
					}
				} else if (opcao == 3) {
					System.out.println("Selecione uma conta: ");
					
					for (int i = 0; i < contasEspeciais.length; i++) {
						if (contasEspeciais[i] != null) {
							System.out.println("Nome: " +contasEspeciais[i].getNomeCliente()+ " - Numero Conta: " +contasEspeciais[i].getNumConta());
						}
					}
					
					for (int i = 0; i < contasPoupancas.length; i++) {
						if (contasPoupancas[i] != null) {
							System.out.println("Nome: " +contasPoupancas[i].getNomeCliente()+ " - Numero Conta: " +contasPoupancas[i].getNumConta());
						}
					}
					
					numConta = read.next();
					
					for (int i = 0; i < contasEspeciais.length; i++) {
						ContaEspecial contasAux = contasEspeciais[i];
						if (contasAux != null) {
							if (numConta.equals(contasEspeciais[i].getNumConta())){
								opcaoConta = 0;
								while (opcaoConta != 4) {
									double valor;
									System.out.println("---------- Conta " +contasEspeciais[i].getNumConta()+ " ----------");
									System.out.println("1 - Sacar.");
									System.out.println("2 - Depositar.");
									System.out.println("3 - Mostrar InformaÁıes.");
									System.out.println("4 - Retornar.");
									System.out.println("---------------------------------------");
									opcaoConta = read.nextInt();
									
									switch (opcaoConta) {
									
									case 1: 
										System.out.println("Informe o valor que deseja sacar: ");
										valor = read.nextDouble();
										if (contasEspeciais[i].sacar(valor) == true) {
											System.out.println("Saque realizado com sucesso!");
											System.out.println("Novo Saldo = " +contasEspeciais[i].getSaldo());
											System.out.println("Novo Limite = " +contasEspeciais[i].getLimiteAtual());break;
										} else {
											System.out.println("Nao foi possÌvel realizar o saque! Tente novamente.");
											System.out.println("Saldo Atual: " +contasEspeciais[i].getSaldo());
											System.out.println("Limite Atual = " +contasEspeciais[i].getLimiteAtual());break;
										}
										
									case 2:
										System.out.println("Informe o valor que deseja depositar: ");
										valor = read.nextDouble();
										contasEspeciais[i].depositar(valor);
										System.out.println("DepÛsito efetuado com sucesso!");
										System.out.println("Novo Saldo: " +contasEspeciais[i].getSaldo());
										System.out.println("Limite Atual = " +contasEspeciais[i].getLimiteAtual());break;
									
									case 3:
										System.out.println(contasEspeciais[i].toString());break;
									}
								}
								break;
							} 
						}
					}
					
					for (int i = 0; i < contasPoupancas.length; i++) {
						ContaPoupanca contasAux = contasPoupancas[i]; 
						if (contasAux != null) {
							if (numConta.equals(contasPoupancas[i].getNumConta())){
								opcaoConta = 0;
								while (opcaoConta != 4) {
									double valor;
									System.out.println("---------- Conta " +contasPoupancas[i].getNumConta()+ " ----------");
									System.out.println("1 - Sacar.");
									System.out.println("2 - Depositar.");
									System.out.println("3 - Mostrar InformaÁıes.");
									System.out.println("4 - Retornar.");
									System.out.println("---------------------------------------");
									opcaoConta = read.nextInt();
									
									switch (opcaoConta) {
									
									case 1: 
										System.out.println("Informe o valor que deseja sacar: ");
										valor = read.nextDouble();
										if (contasPoupancas[i].sacar(valor) == true) {
											System.out.println("Saque realizado com sucesso!");
											System.out.println("Novo Saldo = " +contasPoupancas[i].getSaldo());
										} else {
											System.out.println("Nao foi possÌvel realizar o saque! Tente novamente.");
											System.out.println("Saldo Atual: " +contasPoupancas[i].getSaldo());
										}
										
									case 2:
										System.out.println("Informe o valor que deseja depositar: ");
										valor = read.nextDouble();
										contasEspeciais[i].depositar(valor);
										System.out.println("DepÛsito efetuado com sucesso!");
										System.out.println("Novo Saldo: " +contasPoupancas[i].getSaldo());
									
									case 3:
										System.out.println(contasPoupancas[i].toString());break;
									}
								}
								break;
							} 
						}
					}
				}
		}

		read.close();
	}
}
