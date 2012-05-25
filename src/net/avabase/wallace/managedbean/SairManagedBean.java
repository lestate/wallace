package net.avabase.wallace.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "sairManagedBean")
@SessionScoped
public class SairManagedBean {

	public String efetuaLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "principal?faces-redirect=true";
	}
}