package estoque.Relatorio;

import java.text.MessageFormat;
import java.util.Scanner;

import estoque.Compra.Compra;
import estoque.Compra.CompraServico;
import estoque.Compra.ItemCompra;
import estoque.Item.Item;
import estoque.Item.ItemServico;

public class RelatorioEstoqueServico implements IRelatorioServico {

	private Scanner scanner = new Scanner(System.in);
	ItemServico itemServico = new ItemServico();
	CompraServico compraServico = new CompraServico();
	ItemCompra itemCompra = new ItemCompra();
	Compra compra = new Compra();
	
	
	@Override
	public void visualizar() {
		
		System.out.println("*********************************************");
		System.out.println("              Relatório de Estoque");
		System.out.println("*********************************************");
		
		for (Item item : itemServico.buscarTodos()) {
			
			int codigo = item.getCodigo();
			String nome = item.getNome();
			float estoqueMinimo = item.getQtdMinima();
			float estoqueMaximo = item.getQtdMaxima();
			float quantidadeEstoque = item.getQtdEstoque();
			String unidadeMedida = item.getUndMedida();	
			float valor = item.getValor();				
			
			String mensagem = MessageFormat.format("Código: {0} - Nome: {1} - Estoque máximo: {2} - "
					+ "Estoque mínimo: {3} - Quantidade em estoque: {4} - Unidade de medida: {5} - "
					+ "Valor: {6}", codigo, nome, estoqueMaximo,
					estoqueMinimo, quantidadeEstoque, unidadeMedida, valor);
			
			System.out.println(mensagem);
		}
	
		System.out.println("Digite qualquer tecla para voltar ao menu");
		scanner.next();
	
	}

}
