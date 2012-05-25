package net.avabase.wallace.eao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import net.avabase.wallace.eao.interfaces.UsuarioEAOLocal;
import net.avabase.wallace.entity.Usuario;

@Stateless
public class UsuarioEAO implements UsuarioEAOLocal {
	@PersistenceContext(unitName = "wallace")
	private EntityManager entityManager;

	public void criar(String usuCod, String usuNom) {
		Usuario empresa = new Usuario();
		empresa.setUsuCod(usuCod);
		empresa.setUsuNom(usuNom);
		entityManager.persist(empresa);
		return;
	}

	public void atualizar(Usuario empresa) {
		entityManager.merge(empresa);
	}

	public List<Usuario> buscarPorUsuCod(String usuCod) {
		String queryString = "SELECT u FROM Usuario u "
				+ "WHERE u.usuCod = :usuCod";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("usuCod", usuCod);
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}

	public List<Usuario> buscarPorUsuNom(String usuNom) {
		String queryString = "SELECT u FROM Usuario u " +
				"WHERE LOWER(e.usuNom) = :usuNom";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("usuNom", usuNom.toLowerCase());
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}

	public boolean buscarPorUsuNomUsuSen(String usuCod, String usuSen) {
		String queryString = "SELECT u FROM Usuario u " +
				"WHERE u.usuCod = :usuCod and LOWER(u.usuSen) = :usuSen";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("usuCod", usuCod);
		query.setParameter("usuSen", usuSen.toLowerCase());
		boolean resultado = !query.getResultList().isEmpty();
		return resultado;
	}

}