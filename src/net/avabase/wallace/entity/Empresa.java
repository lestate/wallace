package net.avabase.wallace.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
public class Empresa implements Serializable {

	@Id
	@Column
	private int empCod;
	@Column
	private String empNom;
	private static final long serialVersionUID = 1L;

	public Empresa() {
		super();
	}

	public int getEmpCod() {
		return this.empCod;
	}

	public void setEmpCod(int empCod) {
		this.empCod = empCod;
	}

	public String getEmpNom() {
		return this.empNom;
	}

	public void setEmpNom(String empNom) {
		this.empNom = empNom;
	}

}
