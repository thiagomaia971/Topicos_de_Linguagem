package ClassLibary;

import java.util.ArrayList;

public class Estoque {
	private ArrayList<Produto> produtos;
	private int qtdeTotalProdutos;
	private Caixa caixa;

	public Estoque(Caixa caixa) {
		this.caixa = caixa;
		produtos = new ArrayList<Produto>();
		qtdeTotalProdutos = 0;
	}

	public int getQtdeTotalProdutos() {
		return qtdeTotalProdutos;
	}

	public void inserirProduto(Produto produto) {

		// Produto produtosAux = null;
		boolean repetido = false;
		int qtdeUnidades = 0;

		for (int i = 0; i < produto.getQtProduto(); i++) {
			if (caixa.Lucro() >= produto.getPrecoUnitario()) {
				qtdeUnidades++;
				caixa.retirarDinheiro((produto.getPrecoUnitario()));
			} else {
				System.out.println("Sem dinheiro no caixa!");
			}
		}

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getMarca().equals(produto.getMarca())) {
				repetido = true;
				this.produtos.set(
						i,
						new Produto(produto.getMarca(), (produtos.get(i)
								.getQtProduto() + qtdeUnidades), produto
								.getPrecoUnitario()));
			}
		}
		if (!repetido) {
			this.produtos.add(new Produto(produto.getMarca(), qtdeUnidades,
					produto.getPrecoUnitario()));
			qtdeTotalProdutos += qtdeUnidades;
		}

	}

	public void inserirProduto(ArrayList<Produto> produtos) {
		for (Produto produto : produtos) {
			inserirProduto(produto);
		}
	}

	public void venderProduto(String marca, int qt) {

		boolean vend = false;
		int pos = 0;
		for (int i = 0; i < produtos.size(); i++) {
			boolean vend2 = false;
			// int qtd = produtos.get(i).getQtProduto();
			if (produtos.get(i).getMarca().equals(marca)) {
				for (int j = 0; j < produtos.size(); j++) {
					if (qt >= produtos.get(i).getQtProduto()) {
						// qtd--;
						produtos.set(i, new Produto(marca, 0, produtos.get(i)
								.getPrecoUnitario()));
						vend2 = true;
					} else if (produtos.get(i).getQtProduto() >= qt
							&& produtos.get(i).getQtProduto() > 0) {
						vend = true;
						pos = i;
						caixa.receberDinheiro(produtos.get(i)
								.getPrecoUnitario());

					}
				}
				if (!vend2) {
					//qtdeTotalProdutos--;
				}

			}
		}
		if (vend) {
			//qtdeTotalProdutos--;
			produtos.set(pos,
					new Produto(marca, (produtos.get(pos).getQtProduto() - qt),
							produtos.get(pos).getPrecoUnitario()));
		}
		
		qtdeTotalProdutos -= qt;
	}

	public int verificarQtdeProduto(Produto produto) {
		return produto.getQtProduto();
	}

	public void exibirEstoqueTotal() {
		System.out
				.println("<--------------------------------------Estoque----------------------------------->");
		for (Produto produto : produtos) {
			System.out.printf("| Marca: %-50s  |  Quantidade: %-3d  |  \n",
					produto.getMarca(), produto.getQtProduto());
		}
		System.out.printf(
				"| Quantidade total de produtos no estoque: %-36d  |  \n\n\n",
				getQtdeTotalProdutos());
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

}
