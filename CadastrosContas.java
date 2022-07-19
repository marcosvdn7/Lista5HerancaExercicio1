package Lista5HerancaExercicio1;

import java.util.Scanner;

public class CadastrosContas {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		ContaEspecial[] contasEspeciais = new ContaEspecial[10];
		ContaPoupanca[] contasPoupancas = new ContaPoupanca[10];
		
		int opcao = 0;
		
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
			}
			
			read.close();
			
	}
}
