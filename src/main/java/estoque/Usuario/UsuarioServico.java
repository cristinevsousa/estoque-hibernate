package estoque.Usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class UsuarioServico implements IUsuarioServico {

	public UsuarioServico() {
		// Cria o primeiro usuário como admin
		if (buscarTodos().isEmpty()) {
			Usuario usuarioAdmin = new Usuario("admin", "admin", true);
			criarUsuario(usuarioAdmin);
		}
	}

	@Override
	public Usuario criarUsuario(Usuario usuario) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-jpa");
		EntityManager em = emf.createEntityManager();

		if (usuario != null) {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return usuario;
		}
		
		return null;
	}

	@Override
	public Usuario editarUsuario(Usuario usuario) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-jpa");
		EntityManager em = emf.createEntityManager();
		
			em.getTransaction().begin();
			usuario = em.merge(usuario);
			em.getTransaction().commit();
			em.close();
			emf.close();
			
			return usuario;
			
	}

	@Override
	public Usuario selecionarUsuario(int id) {
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-jpa");
			EntityManager em = emf.createEntityManager();
			
			Usuario usuario = em.find(Usuario.class, id);
			
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
			em.close();
			emf.close();
			
			return usuario;
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar Id :" +e.getMessage());
		}
		return null;
	}

	@Override
	public String deletarUsuario(Usuario usuario) {
		
			String nomeUsuario = usuario.getNome();
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-jpa");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
			em.close();
			emf.close();
			
			return nomeUsuario;
	}

	@Override
	public List<Usuario> buscarTodos() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		TypedQuery<Usuario> query = em.createQuery("select usuario from Usuario usuario", Usuario.class);

		List<Usuario> usuarios = query.getResultList();
		
		if (usuarios != null) {
			
			return usuarios;
		}
		
		return null;
	}
	
	@Override
	public List<Usuario> buscarPorNome(String nome) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<Usuario> query = em.createQuery("select usuario from Usuario usuario where usuario.nome=:nome", Usuario.class);
	    query.setParameter("nome", "%"+nome+"%");
	    List<Usuario> usuarios = query.getResultList();
	    
	    em.getTransaction().commit();
		em.close();
		emf.close();
		
		if (usuarios != null) {
			
			return usuarios;
		}
		
		return null;
	}
}
