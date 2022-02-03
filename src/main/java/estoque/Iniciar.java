package estoque;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import estoque.Compra.CompraServico;
import estoque.Compra.ICompraServico;
import estoque.Fornecedor.Fornecedor;
import estoque.Fornecedor.FornecedorServico;
import estoque.Fornecedor.IFornecedorServico;
import estoque.Item.IItemServico;
import estoque.Item.Item;
import estoque.Item.ItemServico;
import estoque.Relatorio.IRelatorioServico;
import estoque.Relatorio.RelatorioEstoqueServico;
import estoque.Relatorio.RelatorioOrdemCompraServico;
import estoque.Saida.ISaidaServico;
import estoque.Saida.SaidaServico;
import estoque.Usuario.IUsuarioServico;
import estoque.Usuario.Usuario;
import estoque.Usuario.UsuarioServico;

public class Iniciar {

	private Scanner scanner = new Scanner(System.in);
	private IFornecedorServico fornecedorServico = new FornecedorServico();
	private IUsuarioServico usuarioServico = new UsuarioServico();
	private IItemServico itemServico = new ItemServico();
	private Visualizar visualizar = new Visualizar();
	private IRelatorioServico relatorioServico;

	public void login() throws ParseException {
		
		Usuario usuarioLogin = visualizar.dadosUsuario();
		
		List<Usuario> usuarios = usuarioServico.buscarPorNome(usuarioLogin.getNome());
		
		System.out.println("Digite o c�digo do usu�rio para confirmar");
		
		for(Usuario u : usuarios) {
			System.out.println(u);
		}
		
		int id = scanner.nextInt();

		Usuario usuario = usuarioServico.selecionarUsuario(id);

		if (usuario != null && usuario.getSenha().equals(usuarioLogin.getSenha())) {
			menu();
		} else {
			System.out.println("Usuario ou senha inv�lidos!");
		}
	}

	public void menu() throws ParseException {
		
		visualizar.menuPrincipal();
		int opcao = scanner.nextInt();
		switch (opcao) {
		case 1: // menu de usu�rio
			
			visualizar.menuCadastro();
			int opcao1 = scanner.nextInt();
			
			// cria usu�rio
			if (opcao1 == 1) {
				Usuario usuario = visualizar.dadosUsuario();
				Usuario retorno = usuarioServico.criarUsuario(usuario);
				
				if (retorno != null) {
					System.out.println("Usu�rio " + retorno.getNome() + " cadastrado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel cadastrar o usu�rio");
				}
				
			// edita usu�rio
			} else if (opcao1 == 2) {
				String nome = visualizar.solicitaNome();
				Usuario usuarioEditar = visualizar.dadosUsuario();

				List<Usuario> usuarios = usuarioServico.buscarPorNome(nome);
				
				System.out.println("Digite o c�digo do usu�rio para confirmar");
				
				for(Usuario u : usuarios) {
					System.out.println(u);
				}
				
				int id = scanner.nextInt();
				
				Usuario usuario = usuarioServico.selecionarUsuario(id);

				usuario.setNome(usuarioEditar.getNome());
				usuario.setSenha(usuarioEditar.getSenha());

				Usuario retorno = usuarioServico.editarUsuario(usuario);

				if (retorno != null) {
					System.out.println("Usu�rio " + retorno.getNome() + " editado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel editar o usu�rio");
				}
				
			// remove usu�rio
			} else if (opcao1 == 3) {
				String nome = visualizar.solicitaNome();

				List<Usuario> usuarios = usuarioServico.buscarPorNome(nome);
				
				System.out.println("Digite o c�digo do usu�rio para confirmar");
				
				for(Usuario u : usuarios) {
					System.out.println(u);
				}
				
				int id = scanner.nextInt();
				
				Usuario usuario = usuarioServico.selecionarUsuario(id);

				String retorno = usuarioServico.deletarUsuario(usuario);

				if (retorno != null) {
					System.out.println("Usu�rio " + retorno + " removido com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel remover o usu�rio");
				}
				
			// volta ao menu principal
			} else if (opcao1 == 4) {
				visualizar.menuPrincipal();
				
			//retorna ao menu de usu�rio
			} else {
				System.out.println("Op��o inv�lida!");
				visualizar.menuCadastro();
			}
			break;
			
		case 2: //menu item
			
			visualizar.menuCadastro();
			int opcao2 = scanner.nextInt();
			
			// cria item
			if (opcao2 == 1) {
				Item item = visualizar.dadosItem();
				
				Item retorno = itemServico.criarItem(item);

				if (item != null) {
					System.out.println("Item " + retorno.getNome() + " cadastrado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel cadastrar o item!");
				}
				
			// edita item
			} else if (opcao2 == 2) {
				String nome = visualizar.solicitaItem();

				Item item = itemServico.selecionarItem(nome);

				Item itemEditar = visualizar.dadosItem();

				item.setUndMedida(itemEditar.getUndMedida());
				item.setNome(itemEditar.getNome());
				item.setDesc(itemEditar.getDesc());
				item.setQtdMinima(itemEditar.getQtdMinima());
				item.setQtdMaxima(itemEditar.getQtdMaxima());

				Item retorno = itemServico.editarItem(item);

				if (retorno != null) {
					System.out.println("Item " + retorno.getNome() + " editado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel editar o Item");
				}
				
			// remove item
			} else if (opcao2 == 3) {
				String nome = visualizar.solicitaItem();

				Item item = itemServico.selecionarItem(nome);

				String retorno = itemServico.deletarItem(item);

				if (retorno != null) {
					System.out.println("Item " + retorno + " removido com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel remover o item");
				}
				
			// volta ao menu anterior
			} else if (opcao2 == 4) {
				visualizar.menuPrincipal();

			} else {
				System.out.println("Op��o inv�lida!");
				visualizar.menuCadastro();
			}
			break;
			
		case 3: // menu de fornecedor
			
			visualizar.menuCadastro();
			int opcao3 = scanner.nextInt();
			
			// cria fornecedor
			if (opcao3 == 1) {
				Fornecedor fornecedor = visualizar.dadosFornecedor();
				Fornecedor retorno = fornecedorServico.criarFornecedor(fornecedor);
				if (retorno != null) {
					System.out.println("Fornecedor " + retorno.getNome() + " cadastrado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel cadastrar o fornecedor");
				}
				
			// edita fornecedor
			} else if (opcao3 == 2) {
				String nome = visualizar.solicitaFornecedor();
				
				List<Fornecedor> listaFornecedor = fornecedorServico.buscarPorNome(nome);
				
				System.out.println("Digite o c�digo do fornecedor para confirmar");
				
				for(Fornecedor f : listaFornecedor) {
					System.out.println(f);
				}
				
				int id = scanner.nextInt();

				Fornecedor fornecedor = fornecedorServico.selecionarFornecedor(id);
				
				Fornecedor fornecedorEditar = visualizar.dadosFornecedor();

				fornecedor.setNome(fornecedorEditar.getNome());
				fornecedor.setTelefone(fornecedorEditar.getTelefone());
				fornecedor.setEmail(fornecedorEditar.getEmail());
				fornecedor.setLojaVirtual(fornecedorEditar.getLojaVirtual());

				Fornecedor retorno = fornecedorServico.editarFornecedor(fornecedor);

				if (retorno != null) {
					System.out.println("Fornecedor " + retorno.getNome() + " editado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel editar o fornecedor");
				}
				
			// remove fornecedor
			} else if (opcao3 == 3) {
				String nome = visualizar.solicitaFornecedor();

				List<Fornecedor> listaFornecedor = fornecedorServico.buscarPorNome(nome);
				
				System.out.println("Digite o c�digo do fornecedor para confirmar");
				
				for(Fornecedor f : listaFornecedor) {
					System.out.println(f);
				}
				
				int id = scanner.nextInt();

				boolean retorno = fornecedorServico.deletarFornecedor(id);

				if (retorno != false) {
					System.out.println("Fornecedor removido com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel remover o fornecedor");
				}
				
			// volta ao menu principal
			} else if (opcao3 == 4) {
				visualizar.menuPrincipal();
				
			//retorna ao menu de fornecedor
			} else {
				System.out.println("Op��o inv�lida!");
				visualizar.menuCadastro();
			}
			break;
			
		case 4: //menu de registro da compra
			
			ICompraServico compra = new CompraServico();
			compra.compra();
			break;
			
		case 5: // saida de itens
			
			ISaidaServico saida = new SaidaServico();
			saida.saida();
			break;
			
		case 6: // Relatorio
			
			relatorioServico = new RelatorioEstoqueServico();
			relatorioServico.visualizar();
			break;
			
		case 7: // ordem de compra
			
			relatorioServico = new RelatorioOrdemCompraServico();
			relatorioServico.visualizar();
			break;
			
		case 8:
			System.out.println("Programa encerrado!");
			break;
		default:
			System.out.println("Op��o inv�lida!");
		}

		menu();
	}
}
