package net.avabase.wallace.eao.interfaces;

import java.util.List;
import javax.ejb.Local;
import net.avabase.wallace.entity.Pais;

@Local
public interface PaisEAOLocal {

	public abstract void criar(int paiCod, String paiNom);

	public abstract void atualizar(Pais pais);

	public abstract List<Pais> buscarPorPaiCod(int paiCod);

	public abstract List<Pais> buscarPorPaiNom(String paiNom);

}