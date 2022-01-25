import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		ArrayList<Conta> listaDeContas = new ArrayList<>();

		Conta corrente = null;
		Conta poupanca = null;

		int opc = 0;

		do {
			System.out.println("======================================");
			System.out.println("***    GERENCIAMENTO DE CONTAS     ***");
			System.out.println("======================================");
			System.out.println("Escolha a opção desejada: ");
			System.out.println("1. Cadastrar Conta Corrente ou Poupança." + "\n2. Visualizar contas cadastradas."
					+ "\n3. Realizar depósito." + "\n4. Realizar saque." + "\n5. Realizar transferência."
					+ "\n6. Sair.");
			System.out.println("======================================");

			System.out.println("Escolha uma opção: ");
			opc = entrada.nextInt();

			switch (opc) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("          Dados da Conta         ");
				System.out.println("---------------------------------");

				Cliente cliente1 = new Cliente("Wanderley Siva", "123456789-00");
				Cliente cliente2 = new Cliente("José Siva", "789456987-62");

				corrente = new ContaCorrente(cliente1);
				poupanca = new ContaPoupanca(cliente2);

				listaDeContas.add(corrente);
				listaDeContas.add(poupanca);

				System.out.println("Contas cadastradas com sucesso!!");

				break;

			case 2:
				if (listaDeContas.size() == 0)
					System.out.println("Nenhuma conta cadastrada");
				else {
					for (Conta conta : listaDeContas) {
						conta.imprimirExtrato();
					}
				}
				break;

			case 3:
				if (corrente == null || poupanca == null) {
					System.out.println("Nenhuma conta cadastrada.");
					break;
				} else {
					corrente.depositar(500);
					poupanca.depositar(1000);
				}

				break;
			case 4:
				if (corrente == null || poupanca == null) {
					System.out.println("Nenhuma conta cadastrada.");
					break;
				} else {
					corrente.sacar(100);
					poupanca.sacar(200);
				}

				break;
			case 5:
				if (corrente == null) {
					System.out.println("Nenhuma conta cadastrada.");
					break;
				} else {
					corrente.transferir(200, poupanca);
				}

				break;
			case 6:
				System.out.println("Sistema encerrado.");
				break;
			default:
				System.out.println("Opção inválida.");
				
			}

		} while (opc != 6);

	}

}
