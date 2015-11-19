package MainClasse;

import java.util.ArrayList;
import java.util.Scanner;

import ClassLibary.Caixa;
import ClassLibary.Cliente_;
import ClassLibary.Empresa;
import ClassLibary.Estoque;
import ClassLibary.Produto;

public class MainClass {

	public static void main(String[] args) {
		Caixa caixa = new Caixa(50);
		int menuDigita;
		Scanner scanner = new Scanner(System.in);

		// Instanciando
		Empresa empresa = new Empresa("Nome da Loja", "Rua UNIFOR, 0273",
				"4956");
		Estoque estoque = new Estoque(caixa);
		Cliente_ cliente = new Cliente_(estoque, "Yuki", "1561561.65",
				"24/12/1997");
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto("Indaia", 1, 9.5));
		produtos.add(new Produto("Santa_Sophia", 2, 2.5));
		produtos.add(new Produto("Santa_Elena", 0, 3.80));
		produtos.add(new Produto("Natuagua", 1, 9.5));
		estoque.inserirProduto(produtos);

		do {
			System.out
					.println("<----------------------------------- MENU PRINCIPAL -------------------------------->");
			System.out
					.println("1-Mostrar Empresa\n2-Mostrar Estoque\n3-Adicionar produto\n4-Comprar produto para o estoque\n5-Lucro\n6-Cliente\n7-Sair\n\nInforme a Opção: ");
			menuDigita = scanner.nextInt();
			switch (menuDigita) {
			case 1:
				limparConsole();
				empresa.exibirEmpresa();
				break;

			case 2:
				limparConsole();
				estoque.exibirEstoqueTotal();
				break;

			case 3:
				limparConsole();
				System.out.println("Informe a marca do produto: ");
				String marcaProduto = scanner.next();
				System.out.println("Informe a quantidade do produto: ");
				int qtdeProduto = scanner.nextInt();
				System.out.println("Preço Unitario");
				double precoUnitario = scanner.nextDouble();

				produtos.add(new Produto(marcaProduto, qtdeProduto,
						precoUnitario));
				break;

			case 4:
				limparConsole();
				System.out.println("Insira a marca do produto: ");
				String marca = scanner.next();
				System.out.println("Insira a quantidade do produto: ");
				int qtdeProdutoInsert = scanner.nextInt();
				double precoInsert = 0;
				System.out.println();
				
				for (Produto produto : produtos) {
					if (produto.getMarca().equals(marca)) {
						//estoque.inserirProduto(produto);
						precoInsert = produto.getPrecoUnitario();
					}
				}
				 Produto produtoInsert = new Produto(marca, qtdeProdutoInsert,
				 precoInsert);
				 estoque.inserirProduto(produtoInsert);
				break;

			case 5:
				limparConsole();
				System.out.println("Lucro: " + caixa.Lucro());
				break;

			case 6:
				limparConsole();
				int teclado = 0;
				do {
					System.out.println("<-------------------------------MENU Cliente------------------------------------->\n");
					System.out.println("1:Cadastrar\n2:Comprar produto\n3:Voltar");
					System.out.println("\nInforme a Opção: ");
					teclado = scanner.nextInt();
					switch (teclado) {
					case 1:
						
						break;

					case 2:
						estoque.exibirEstoqueTotal();
						System.out.println("\n\n\n\n\n\n\nInforme a Marca: ");
						String marca2 = scanner.next();
						System.out.println("Informe a quantidade: ");
						int qt = scanner.nextInt();
						cliente.comprarProduto(marca2, qt);
						break;
						
					
					default:
						limparConsole();
						break;
					}
				} while (teclado > 0 && teclado < 2);
				break;
			default:
				break;
			}
		} while (menuDigita > 0 && menuDigita < 7);
		scanner.close();
	}

	public static void limparConsole() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

}
