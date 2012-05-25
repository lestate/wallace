package net.avabase.wallace.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
public class Usuario implements Serializable {

	@Id
	@Column
	private String usuCod;
	@Column
	private String usuNom;
	@Column
	private String usuSen;
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}

	public String getUsuCod() {
		return this.usuCod;
	}

	public void setUsuCod(String usuCod) {
		this.usuCod = usuCod;
	}

	public String getUsuNom() {
		return this.usuNom;
	}

	public void setUsuNom(String usuNom) {
		this.usuNom = usuNom;
	}

	public String getUsuSen() {
		return usuSen;
	}

	public void setUsuSen(String usuSen) {
		this.usuSen = usuSen;
	}

}
