package estoque.Item;

import java.util.List;

public abstract interface IItemServico {
	
	Item criarItem(Item item);
	Item editarItem(Item item); 		
	Item selecionarItem(String nome);	
	String deletarItem(Item item);
	List<Item> buscarTodos();
	Item buscarPorNome(String nome);
}
