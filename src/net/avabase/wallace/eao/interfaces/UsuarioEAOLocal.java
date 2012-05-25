package net.avabase.wallace.eao.interfaces;

import java.util.List;
import javax.ejb.Local;
import net.avabase.wallace.entity.Usuario;

@Local
public interface UsuarioEAOLocal {

	public abstract void criar(String usuCod, String usuNom);

	public abstract void atualizar(Usuario usuario);

	public abstract List<Usuario> buscarPorUsuCod(String usuCod);

	public abstract List<Usuario> buscarPorUsuNom(String usuNom);
	
	public abstract boolean buscarPorUsuNomUsuSen(String usuCod, String usuSen);

}