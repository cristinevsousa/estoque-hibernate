package estoque.Item;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ItemServico implements IItemServico {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-jpa");
	EntityManager em = emf.createEntityManager();
	
	Item item = new Item();

	@Override
	public Item criarItem(Item item) {
		
		if (item != null) {
			em.getTransaction().begin();
			em.persist(item);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return item;
		}
		
		return null;
	}
	
	@Override
	public Item editarItem(Item item) {
		
		if (item != null) {
			
			em.getTransaction().begin();
			item = em.merge(item);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return item;
		}
		
		return null;
	}
	
	@Override
	public Item selecionarItem(String nome) {
		
		Item item = buscarPorNome(nome);
		
		if (item.getNome().equals(nome)) {
			
			return item;
		}

		return null;
	}
	
	@Override
	public String deletarItem(Item item) {
		
		if (item != null) {
			String nomeItem = item.getNome();
			em.getTransaction().begin();
			em.remove(item);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return nomeItem;
		}
		
		return null;
	}

	@Override
	public List<Item> buscarTodos() {
		
		TypedQuery<Item> query = em.createQuery("select item from Item item", Item.class);

		List<Item> itens = query.getResultList();
		
		return itens;
	}
	
	@Override
	public Item buscarPorNome(String nome) {
		
		TypedQuery<Item> query = em.createQuery("select item from Item item where item.nome=:nome", Item.class);
	    query.setParameter("nome", nome);
	    Item item = query.getSingleResult();
		
		return item;
	}
       	
}
	
		
			
		
	
	