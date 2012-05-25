package net.avabase.wallace.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
public class UF implements Serializable {

	@Id
	@Column
	private int uFCod;
	@Column
	private String uFNom;
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "pais_paicod", referencedColumnName="paicod")
	private Pais pais;
	
	public UF() {
		super();
	}

	public int getUFCod() {
		return this.uFCod;
	}

	public void setUFCod(int uFCod) {
		this.uFCod = uFCod;
	}

	public String getUFNom() {
		return this.uFNom;
	}

	public void setUFNom(String uFNom) {
		this.uFNom = uFNom;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
