package com.seedbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="INDICE")
public class Indice {

	public Indice () {
		super ();
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="ChampA")
	private String ChampA;
	
	@Column (name="ChampB")
	private String ChampB;
	
	@Column (name="ChampC")
	private String ChampC;
	public Indice(Long id, String champA, String champB, String champC, String champD, String indicateur1,
			String modif1, String indicateur2, String modif2) {
		super();
		this.id = id;
		ChampA = champA;
		ChampB = champB;
		ChampC = champC;
		ChampD = champD;
		this.indicateur1 = indicateur1;
		Modif1 = modif1;
		this.indicateur2 = indicateur2;
		Modif2 = modif2;
	}

	@Column (name="ChampD")
	private String ChampD;

	@Column (name="indicateur1")
	private String indicateur1;
	
	@Column (name="Modif1")
	private String Modif1;
	
	@Column (name="indicateur2")	
	private String indicateur2;
	
	@Column (name="Modif2")
	private String Modif2;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getChampA() {
		return ChampA;
	}
	public void setChampA(String champA) {
		ChampA = champA;
	}
	public String getChampB() {
		return ChampB;
	}
	public void setChampB(String champB) {
		ChampB = champB;
	}
	public String getChampC() {
		return ChampC;
	}
	public void setChampC(String champC) {
		ChampC = champC;
	}
	public String getChampD() {
		return ChampD;
	}
	public void setChampD(String champD) {
		ChampD = champD;
	}
	public String getIndicateur1() {
		return indicateur1;
	}
	public void setIndicateur1(String indicateur1) {
		this.indicateur1 = indicateur1;
	}
	public String getModif1() {
		return Modif1;
	}
	public void setModif1(String modif1) {
		Modif1 = modif1;
	}
	public String getIndicateur2() {
		return indicateur2;
	}
	public void setIndicateur2(String indicateur2) {
		this.indicateur2 = indicateur2;
	}
	public String getModif2() {
		return Modif2;
	}
	public void setModif2(String modif2) {
		Modif2 = modif2;
	}
	@Override
	public String toString() {
		return "Indicateur :  \n id = " + id + ",\n  ChampA =" + ChampA + ",\n ChampB=" + ChampB + ",\n ChampC=" + ChampC + ",\n ChampD="
				+ ChampD + ",\n indicateur1=" + indicateur1 + ",\n Modif1=" + Modif1 + ",\n indicateur2=" + indicateur2
				+ ",\n Modif2=" + Modif2 + "]";
	}

}
