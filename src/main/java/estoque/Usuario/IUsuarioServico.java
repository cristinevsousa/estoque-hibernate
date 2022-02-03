package estoque.Usuario;

import java.util.List;


public interface IUsuarioServico {
	
	Usuario criarUsuario(Usuario usuario);
	Usuario editarUsuario(Usuario usuario);
	Usuario selecionarUsuario(int id);
	String deletarUsuario(Usuario usuario);
	List<Usuario> buscarTodos();
	List<Usuario> buscarPorNome(String nome);

}
