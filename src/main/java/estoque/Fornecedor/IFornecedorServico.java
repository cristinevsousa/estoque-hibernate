package estoque.Fornecedor;

import java.util.List;

public interface IFornecedorServico {

	Fornecedor criarFornecedor(Fornecedor fornecedor);
	Fornecedor editarFornecedor(Fornecedor fornecedor); 		
	Fornecedor selecionarFornecedor(int id);	
	//String deletarFornecedor(Fornecedor fornecedor);
	List<Fornecedor> buscarTodos();
	List<Fornecedor> buscarPorNome(String nome);
	boolean deletarFornecedor(int id);
}
