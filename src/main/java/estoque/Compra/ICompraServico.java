package estoque.Compra;

import java.text.ParseException;
import java.util.List;

import estoque.Fornecedor.Fornecedor;

public interface ICompraServico {

	Compra criarCompra(Compra compra);
	Compra editarCompra(Compra compra); 		
	Compra selecionarCompra(int id);	
	String deletarCompra(Compra compra);
	List<Compra> buscarTodos();
	List<Compra> buscarPorFornecedor(Fornecedor nome);
	void compra() throws ParseException;
}
