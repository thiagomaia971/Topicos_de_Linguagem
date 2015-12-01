package Main;

import Classes.Geladeira;
import Classes.Produto;
import Classes.Usuario;

public class MainProgram {

	public static void main(String[] args) {
		
		Geladeira g = new Geladeira();
		
		Usuario yuki = new Usuario(g);
		yuki.getGeladeira().adicionarProduto(new Produto("Batata Doce", 5, 5));
		yuki.getGeladeira().adicionarProduto(new Produto("Batata Doce", 2, 5));
		yuki.getGeladeira().adicionarProduto(new Produto("Limão", 3, 1));
		yuki.getGeladeira().adicionarProduto(new Produto("Limão", 3, 1));
		
		System.out.println(yuki.getGeladeira().pesquisarProduto("Batata Doce").getQuantidade());
		
		yuki.getGeladeira().removerProduto("Batata Doce");
		System.out.println(yuki.getGeladeira().pesquisarProduto("Batata Doce"));
	}

}
