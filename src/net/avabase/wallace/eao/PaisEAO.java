package net.avabase.wallace.eao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import net.avabase.wallace.eao.interfaces.PaisEAOLocal;
import net.avabase.wallace.entity.Pais;

@Stateless
public class PaisEAO implements PaisEAOLocal {
	@PersistenceContext(unitName = "wallace")
	private EntityManager entityManager;

	public void criar(int paiCod, String paiNom) {
		Pais pais = new Pais();
		pais.setPaiCod(paiCod);
		pais.setPaiNom(paiNom);
		entityManager.persist(pais);
		return;
	}

	public void atualizar(Pais pais) {
		entityManager.merge(pais);
	}

	public List<Pais> buscarPorPaiCod(int paiCod) {
		String queryString = "SELECT e FROM Pais e "
				+ "WHERE e.paiCod = :paiCod";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("paiCod", paiCod);
		@SuppressWarnings("unchecked")
		List<Pais> paises = query.getResultList();
		return paises;
	}

	public List<Pais> buscarPorPaiNom(String paiNom) {
		String queryString = "SELECT e FROM Pais e "
				+ "WHERE LOWER(e.paiNom) = :paiNom";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("paiNom", paiNom.toLowerCase());
		@SuppressWarnings("unchecked")
		List<Pais> paises = query.getResultList();
		return paises;
	}

}