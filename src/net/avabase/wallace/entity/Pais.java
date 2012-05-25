package net.avabase.wallace.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Pais implements Serializable {

	@Id
	@Column
	private int paiCod;
	@Column
	private String paiNom;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "pais")
	private final List<UF> members = new ArrayList<UF>();

	public Pais() {
		super();
	}

	public int getPaiCod() {
		return this.paiCod;
	}

	public void setPaiCod(int paiCod) {
		this.paiCod = paiCod;
	}

	public String getPaiNom() {
		return this.paiNom;
	}

	public void setPaiNom(String paiNom) {
		this.paiNom = paiNom;
	}

	public List<UF> getMembers() {
		return members;
	}

}
