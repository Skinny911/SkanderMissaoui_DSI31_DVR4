package com.skander.docteurs.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Docteur {	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idDocteur;
	private String nomDocteur;
	private Double salaireDocteur;
	private Date dateNaiss;
	
	@ManyToOne
	private Hopital hopital;

	public Docteur() {
		super();
	}
	
	
	public Docteur(String nomDocteur, Double salaireDocteur, Date dateNaiss) {
		super();
		this.nomDocteur = nomDocteur;
		this.salaireDocteur = salaireDocteur;
		this.dateNaiss = dateNaiss;
	}


	public Long getIdDocteur() {
		return idDocteur;
	}
	public void setIdDocteur(Long idDocteur) {
		this.idDocteur = idDocteur;
	}
	public String getNomDocteur() {
		return nomDocteur;
	}
	public void setNomDocteur(String nomDocteur) {
		this.nomDocteur = nomDocteur;
	}
	public Double getSalaireDocteur() {
		return salaireDocteur;
	}
	public void setSalaireDocteur(Double salaireDocteur) {
		this.salaireDocteur = salaireDocteur;
	}
	public Date getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}


	@Override
	public String toString() {
		return "Docteur [idDocteur=" + idDocteur + ", nomDocteur=" + nomDocteur + ", salaireDocteur=" + salaireDocteur
				+ ", dateNaiss=" + dateNaiss + "]";
	}


	public Hopital getHopital() {
		return hopital;
	}


	public void setHopital(Hopital hopital) {
		this.hopital = hopital;
	}
	
	

}
