package net.avabase.wallace.eao;

import net.avabase.wallace.eao.interfaces.EmpresaEAOLocal;
import net.avabase.wallace.entity.Empresa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class EmpresaEAO implements EmpresaEAOLocal {
	@PersistenceContext(unitName = "wallace")
	private EntityManager entityManager;

	public void criar(int empCod, String empNom) {
		Empresa empresa = new Empresa();
		empresa.setEmpCod(empCod);
		empresa.setEmpNom(empNom);
		entityManager.persist(empresa);
		return;
	}

	public void atualizar(Empresa empresa) {
		entityManager.merge(empresa);
	}

	public List<Empresa> buscarPorEmpCod(int empCod) {
		String queryString = "SELECT e FROM Empresa e "
				+ "WHERE e.empCod = :empCod";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("empCod", empCod);
		@SuppressWarnings("unchecked")
		List<Empresa> empresas = query.getResultList();
		return empresas;
	}

	public List<Empresa> buscarPorEmpNom(String empNom) {
		String queryString = "SELECT e FROM Empresa e "
				+ "WHERE LOWER(e.empNom) = :empNom";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("empNom", empNom.toLowerCase());
		@SuppressWarnings("unchecked")
		List<Empresa> empresas = query.getResultList();
		return empresas;
	}

}