package Lista5HerancaExercicio1.Lista5HerancaExercicio1;

import java.util.Scanner;

public class ClasseTeste2 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		ContaEspecial[] contasEspeciais = new ContaEspecial[10];
		ContaPoupanca[] contasPoupancas = new ContaPoupanca[10];
		
		int opcao = 0;
		String numConta;
		
		while (opcao != 4) {
			System.out.println("-------------Sistema Bancário-------------");
			System.out.println("1 - Abrir conta especial.");
			System.out.println("2 - Abrir conta poupança.");
			System.out.println("3 - Acessar conta existente.");
			System.out.println("4 - Encerrar.");
			opcao = read.nextInt();
			
			while (opcao != 4) {
				if (opcao == 1) {
					ContaEspecial contaEspecial = new ContaEspecial();
					
					System.out.println("Informe o nome: ");
					contaEspecial.setNomeCliente(read.next());
					
					System.out.println("Informe o número da conta: ");
					contaEspecial.setNumConta(read.next());
					
					System.out.println("Informe o saldo da conta: ");
					contaEspecial.setSaldo(read.nextDouble());
					
					System.out.println("Informe o valor do limite especial: ");
					contaEspecial.setLimite(read.nextDouble());
					
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
					
					System.out.println("Informe o número da conta: ");
					contaPoupanca.setNumConta(read.next());
					
					System.out.println("Informe o saldo da conta: ");
					contaPoupanca.setSaldo(read.nextDouble());
					
					System.out.println("Informe o dia do rendimento: ");
					contaPoupanca.setDiaRendimento(read.next());
					
					for (int i = 0; i < contasEspeciais.length; i++) {
						if (contasEspeciais[i] == null) {
							contasPoupancas[i] = contaPoupanca;
							break;
						}
					}
				} else if (opcao == 3) {
					System.out.println("Informe o número da conta: ");
					numConta = read.next();
					
					for (int i = 0; i < contasEspeciais.length; i++) {
						if (numConta.equals(contasEspeciais[i].getNumConta())){
							//mostra o menu de opcoes sacar, depositar e mostrar informações de uma conta especial.
						} else if (numConta.equals(contasPoupancas[i].getNumConta())) {
							//mostra o menu de opcoes sacar, depositar e mostrar informações de uma conta poupanca.
						}
					}
				}
			}
			
			
			
		}

		read.close();
		
	}

}
