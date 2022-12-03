package com.skander.docteurs.service;

import java.util.List;

import com.skander.docteurs.entities.Hopital;
import com.skander.docteurs.entities.Docteur;

public interface DocteurService {
	Docteur saveDocteur(Docteur d);
	Docteur updateDocteur(Docteur d);
	void deleteDocteur(Docteur d);
	void deleteDocteurById(Long id);
	Docteur getDocteur(Long id);
	List<Docteur> getAllDocteurs();
	List<Docteur> findByNomDocteur(String nom);
	List<Docteur> findByNomDocteurContains(String nom);
	List<Docteur> findByNomSalaire (String nom, Double salaire);
	List<Docteur> findByHopital (Hopital hopital);
	List<Docteur> findByHopitalIdHop(Long id);
	List<Docteur> findByOrderByNomDocteurAsc();
	List<Docteur> trierDocteursNomsSalaire();

}
