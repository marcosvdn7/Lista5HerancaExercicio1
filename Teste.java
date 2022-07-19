/**
 * Teste
 * @date jul/2022
 * @authors Ana Júlia da Cunha - Entra21
 * 			Gabriel Roger da Cunha - Entra21
 * 			Marcos Vinicius do Nascimento - Entra21
 * 	
 * Lista 5: Exercicio 1.
 */

package Lista5HerancaExercicio1;

import java.util.Scanner;

public class Teste {

	/**
	 * Imprime o menu principal abaixo:
	 * <p>
	 * O que você deseja fazer?
	 * <p>
	 * 1 - Acessar conta.
	 * <p>
	 * 2 - Cadastrar conta.
	 */
	protected static void imprimirMenuPrincipal() {
		System.out.println("-------------------------");
		System.out.println("O que você deseja fazer?");
		System.out.println("1 - Acessar conta.");
		System.out.println("2 - Cadastrar conta.");
		System.out.println("3 - Sair.");
		System.out.println("-------------------------");
	}

	/**
	 * Imprime o menu de tipo de conta abaixo:
	 * <p>
	 * Selecione o tipo de conta que deseja criar:
	 * <p>
	 * 1 - Poupanca.
	 * <p>
	 * 2 - Especial.
	 */
	protected static void imprimirTipoConta() {
		System.out.println("Selecione o tipo de conta que deseja criar: ");
		System.out.println("1 - Poupanca.");
		System.out.println("2 - Especial.");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// VARIAVEIS DE CONTROLE
		boolean sair = false; // LACO PRINCIPAL

		// VARIAVEIS DE OPCAO
		int opcaoPrincipal; // MENU PRINCIPAL

		System.out.println("Bem-vindo ao nosso sistema!");

		// LACO PRINCIPAL
		while (!sair) {
			imprimirMenuPrincipal();
			opcaoPrincipal = sc.nextInt();

			switch (opcaoPrincipal) {
			case 1: // ACESSAR CONTA
				break;
			case 2: // CADASTRAR CONTA
				break;
			case 3: // SAIR
				sair = true;
				break;
			default:
				System.out.println("Opcao invalida!!");
			}

		}

		sc.close();
	}

}
