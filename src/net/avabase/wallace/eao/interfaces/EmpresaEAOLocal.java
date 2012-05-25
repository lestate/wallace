package net.avabase.wallace.eao.interfaces;

import java.util.List;
import javax.ejb.Local;
import net.avabase.wallace.entity.Empresa;

@Local
public interface EmpresaEAOLocal {

	public abstract void criar(int empCod, String empNom);

	public abstract void atualizar(Empresa empresa);

	public abstract List<Empresa> buscarPorEmpCod(int empCod);

	public abstract List<Empresa> buscarPorEmpNom(String empNom);

}