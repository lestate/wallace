package net.avabase.wallace.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import net.avabase.wallace.eao.interfaces.UsuarioEAOLocal;
import javax.ejb.EJB;

@ManagedBean(name = "entrarManagedBean")
@SessionScoped
public class EntrarManagedBean {
	@EJB
	private UsuarioEAOLocal usuarioEAOLocal;
	private String usuCod;
	private String usuSen;

	public String getUsuCod() {
		return usuCod;
	}

	public void setUsuCod(String usuCod) {
		this.usuCod = usuCod;
	}

	public String getUsuSen() {
		return usuSen;
	}

	public void setUsuSen(String usuSen) {
		this.usuSen = usuSen;
	}

	public String efetuaLogin() {
		boolean loginValido = usuarioEAOLocal.buscarPorUsuNomUsuSen(usuCod,
				usuSen);
		if (loginValido) {
			return "modelocliente?faces-redirect=true";
		} else {
			return "principal?faces-redirect=true";
		}
	}
}