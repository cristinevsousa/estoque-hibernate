package estoque.Fornecedor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class FornecedorServico implements IFornecedorServico{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-jpa");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public Fornecedor criarFornecedor(Fornecedor fornecedor) {
		if (fornecedor != null) {
			em.getTransaction().begin();
			em.persist(fornecedor);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return fornecedor;
		}
		
		return null;
	}

	@Override
	public Fornecedor editarFornecedor(Fornecedor fornecedor) {
		if (fornecedor != null) {
			em.getTransaction().begin();
			fornecedor = em.merge(fornecedor);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return fornecedor;
		}
		
		return null;
	}

	@Override
	public Fornecedor selecionarFornecedor(int id) {
		
		try {
			
			Fornecedor fornecedor = em.find(Fornecedor.class, id);
			
			return fornecedor;
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar Id :" +e.getMessage());
		}
		return null;
	}

	@Override
	public boolean deletarFornecedor(int id) {
		
		if (id != 0) {
			em.getTransaction().begin();
			
			Query query = em.createQuery("update Fornecedor set Fornecedor.esta_ativo = 0, Fornecedor.deletado_em = CURRENT_TIMESTAMP where Fornecedor.id = :id")
				.setParameter( "id", id);
			query.executeUpdate();
			
			//em.remove(fornecedor);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return true;
		}
		
		return false;
	}
	
	@Override
	public List<Fornecedor> buscarPorNome(String nome) {
		try {
						
			TypedQuery<Fornecedor> query = em.createQuery("select fornecedor from Fornecedor fornecedor where fornecedor.nome=:nome", Fornecedor.class);
		    query.setParameter("nome", "%"+nome+"%");
		    List<Fornecedor> fornecedores = query.getResultList();
		   			
			return fornecedores;
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar :" +e.getMessage());
		}
		
		return null;
	}
	
	@Override
	public List<Fornecedor> buscarTodos() {
		
		TypedQuery<Fornecedor> query = em.createQuery("select fornecedor from Fornecedor fornecedor", Fornecedor.class);

		List<Fornecedor> fornecedores = query.getResultList();
		
		return fornecedores;
	}

	
}
