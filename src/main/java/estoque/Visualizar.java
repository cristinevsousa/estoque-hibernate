package estoque;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import estoque.Compra.Compra;
import estoque.Fornecedor.Fornecedor;
import estoque.Item.IItemServico;
import estoque.Item.Item;
import estoque.Item.ItemServico;
import estoque.Saida.ItemSaida;
import estoque.Usuario.Usuario;

public class Visualizar {
	
	IItemServico itemServico = new ItemServico();
	private Scanner scanner = new Scanner(System.in);
	
	public void menuPrincipal() {
		
		System.out.println("*********************************************");
		System.out.println("Escolha uma das opções a seguir:");
		System.out.println("(1) Gerenciar usuários");
		System.out.println("(2) Gerenciar itens");
		System.out.println("(3) Gerenciar fornecedores");
		System.out.println("(4) Gerenciar entradas de estoque");
		System.out.println("(5) Gerenciar saídas de estoque");
		System.out.println("(6) Gerar relatórios");
		System.out.println("(7) Gerar ordem de compra");
		System.out.println("(8) Sair");
		System.out.println("*********************************************");
	}
	
	public void menuCadastro() {
		
		System.out.println("*********************************************");
		System.out.println("Escolha uma das opções a seguir:");
		System.out.println("(1) Cadastrar/Registrar");
		System.out.println("(2) Editar");
		System.out.println("(3) Remover");
		System.out.println("(4) Voltar ao Menu principal");
		System.out.println("*********************************************");
	}
	
	public String solicitaNome() {
		
		System.out.println("Digite o nome de usuario");
		String nome = scanner.next();
		return nome;
	}
	
	public Usuario dadosUsuario() {
		
		System.out.println("Digite o nome de usuario e senha");
		String nome = scanner.next();
		String senha = scanner.next();
		return new Usuario(nome, senha, false);
	}
	
	public String solicitaFornecedor() {
		
		System.out.println("Digite o nome do fornecedor");
		String nome = scanner.next();
		return nome;
	}
	
	public Fornecedor dadosFornecedor() {
		
		System.out.println("Digite o nome do fornecedor: ");
		String nome = scanner.next();
		System.out.println("Digite o telefone de contato: ");
		String telefone = scanner.next();
		System.out.println("Digite o email: ");
		String email = scanner.next();
		System.out.println("Digite o site/loja virtual: ");
		String site = scanner.next();
		
		return new Fornecedor(nome, telefone, email, site);
	}
	
	public String solicitaItem() {
		
		System.out.println("Digite o nome do item");
		String nome = scanner.next();
		return nome;
	}
	
	public Item dadosItem() {
		
		System.out.println("Digite o nome do item: ");
		String nome = scanner.next();
		System.out.println("Digite a unidade de medida (und, kg, litro ou caixa): ");
		String undMedida = scanner.next();
		System.out.println("Digite a descrição: ");
		String desc = scanner.next();
		System.out.println("Digite o estoque mínimo: ");
		float qtdMinima = scanner.nextFloat();
		System.out.println("Digite o estoque máximo: ");
		float qtdMaxima = scanner.nextFloat();
		
		return new Item(undMedida, nome, desc, qtdMinima, qtdMaxima);
	}
	
	public Item itensCompra()  {
		
		System.out.println("*********************************************");
		System.out.println("              Entrada de itens");
		System.out.println("*********************************************");
		
		System.out.println("Para entrada de itens digite (1), para sair digite (0): ");
		int opcao = scanner.nextInt();
		
		if (opcao == 0) {
			return null;
		}
		
		System.out.println("*Digite a seguir os itens da compra com o mesmo fornecedor*");
		
		System.out.println("Informe o nome: ");
		String nome = scanner.next();
		System.out.println("Informe a quantidade: ");
		float qtd = scanner.nextFloat();
		System.out.println("Informe o valor do produto: ");
		float valor = scanner.nextFloat();
		
		Item item = new Item(nome);

		item.setQtdCompra(qtd);
		item.setValor(valor);
		return item;
		
	}
	
	public Compra fornecedorCompra() throws ParseException {
		
		System.out.println("Informe o fornecedor da compra: ");
		String fornecedor = scanner.next();
		
		System.out.println("Informe a data da compra: (dd/MM/aaaa)");
		String dataEntrada = scanner.next();
		Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEntrada);
		
		return new Compra(fornecedor, data);
	}
	
	public void msgErro() {
		
		System.out.println("Objeto não encontrado!");
	}
	
	public ItemSaida itensSaida()  {
		
		System.out.println("*********************************************");
		System.out.println("              Saída de itens");
		System.out.println("*********************************************");
		
		System.out.println("Para saída de itens digite (1), para sair digite (0): ");
		int opcao = scanner.nextInt();
		
		if (opcao == 0) {
			return null;
		}
		
		System.out.println("*Digite a seguir os itens retirados do estoque*");		
		
		System.out.println("Informe o nome: ");
		String nome = scanner.next();
		System.out.println("Informe a quantidade: ");
		float qtd = scanner.nextFloat();
		
		ItemSaida itemSaida = new ItemSaida(nome);

		itemSaida.setQtdSaida(qtd);
		return itemSaida;		
	}
	
	public Date dataSaida() throws ParseException {
		
		System.out.println("Informe a data da venda/saída: (dd/MM/aaaa)");
		String dataEntrada = scanner.next();
		Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEntrada);
		
		return data;
	}

}
