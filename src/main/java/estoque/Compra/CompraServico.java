
package estoque.Compra;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import estoque.Visualizar;
import estoque.Fornecedor.Fornecedor;
import estoque.Item.Item;
import estoque.Item.ItemServico;

public class CompraServico implements ICompraServico {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-jpa");
	EntityManager em = emf.createEntityManager();

	private Visualizar visualizar = new Visualizar();
	private ItemServico itemServico = new ItemServico();
	private Compra compra = new Compra();

	@Override
	public void compra() throws ParseException {
		
		if (compraItens() != null) {
			
			Compra compra = visualizar.fornecedorCompra();

			Fornecedor fornecedor = compra.getFornecedor();
			Date dataEntrada = compra.getDataCompra();

			compra.setDataCompra(dataEntrada);
			compra.setFornecedor(fornecedor);
			
			criarCompra(compra);
			
		}else {
			System.out.println("Falha ao registrar compra");
		}
		
	}
	
	public List<Item> compraItens() {
		
		while (true) {

			Item item = visualizar.itensCompra();
			if (item == null) {
				break;
			}

			String nomeItem = item.getNome();

			System.out.println("Nome do item: " + nomeItem);

			float qtd = item.getQtdCompra();
			float valor = item.getValor();
			
			// busca o item cadastrado
			item = itemServico.selecionarItem(nomeItem);

			if (item != null) {

				item.setValor(valor);
				item.setQtdCompra(qtd);
				
				float soma = item.getQtdEstoque() + qtd;
				
				item.setQtdEstoque(soma);

				itemServico.editarItem(item);
				
				List<Item> itens = new ArrayList<Item>();
				
				itens.add(item);
				
				return itens;

			} else if (item == null) {
				visualizar.msgErro();
				visualizar.itensCompra();
			}
		}
		
		return null;
	}

	@Override
	public Compra criarCompra(Compra compra) {
		if (compra != null) {
			em.getTransaction().begin();
			em.persist(compra);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return compra;
		}

		return null;
	}

	@Override
	public Compra editarCompra(Compra compra) {
		if (compra != null) {
			em.getTransaction().begin();
			compra = em.merge(compra);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return compra;
		}

		return null;
	}

	@Override
	public Compra selecionarCompra(int id) {

		if (compra.getCodigo() == id) {

			return compra;
		}

		return null;
	}

	@Override
	public String deletarCompra(Compra compra) {

		if (compra != null) {
			String nomeFornecedor = compra.getFornecedor().getNome();
			em.getTransaction().begin();
			em.remove(compra);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return nomeFornecedor;
		}

		return null;
	}

	@Override
	public List<Compra> buscarTodos() {

		TypedQuery<Compra> query = em.createQuery("select compra from Compra compra", Compra.class);

		List<Compra> compras = query.getResultList();

		return compras;
	}

	@Override
	public List<Compra> buscarPorFornecedor(Fornecedor nome) {

		TypedQuery<Compra> query = em.createQuery("select compra from Compra compra innerjoin fornecedor where fornecedor.nome=:nome",
				Compra.class);
		query.setParameter("nome", nome);
		List<Compra> compras = query.getResultList();

		return compras;
	}

}
