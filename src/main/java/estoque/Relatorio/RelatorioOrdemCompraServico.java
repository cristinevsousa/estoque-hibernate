package estoque.Relatorio;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Scanner;

import estoque.Item.Item;
import estoque.Item.ItemServico;

public class RelatorioOrdemCompraServico implements IRelatorioServico{
	
	private Scanner scanner = new Scanner(System.in);
	ItemServico itemServico = new ItemServico();

	@Override
	public void visualizar() {
		
		System.out.println("*********************************************");
		System.out.println("              Ordem de Compra");
		System.out.println("*********************************************");
		
		for (Item item : itemServico.buscarTodos()) {
			
			int codigo = item.getCodigo();
			String nome = item.getNome();
			float estoqueMinimo = item.getQtdMinima();
			float estoqueMaximo = item.getQtdMaxima();
			float quantidadeEstoque = item.getQtdEstoque();
			String unidadeMedida = item.getUndMedida();			
			Date ultimaCompra = item.getCriadoEm();
			
			if (estoqueMinimo >= quantidadeEstoque) {
				
				float qtdCompra = estoqueMaximo - quantidadeEstoque;
				String mensagem = MessageFormat.format("Código: {0} - Nome: {1} - Estoque máximo: {2} - "
						+ "Estoque mínimo: {3} - Quantidade em estoque: {4} - Unidade de medida: {5} - "
						+ "Valor: {6} - Quantidade de compra sugerida: {7}", codigo, nome, estoqueMaximo,
						estoqueMinimo, quantidadeEstoque, unidadeMedida, ultimaCompra, qtdCompra);
				
				System.out.println(mensagem);
			}
			
		}
		
		System.out.println("Digite qualquer tecla para voltar ao menu");
		scanner.next();
	}

}
