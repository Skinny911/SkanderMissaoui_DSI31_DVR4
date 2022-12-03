package com.skander.docteurs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skander.docteurs.entities.Hopital;
import com.skander.docteurs.entities.Docteur;
import com.skander.docteurs.repos.DocteurRepository;


@Service
public class DocteurServiceImpl implements DocteurService{

	@Autowired
	DocteurRepository docteurRepository;
	
	@Override
	public Docteur saveDocteur(Docteur d) {
		return docteurRepository.save(d);
	}

	@Override
	public Docteur updateDocteur(Docteur d) {
		return docteurRepository.save(d);
	}

	@Override
	public void deleteDocteur(Docteur d) {
		docteurRepository.delete(d);
		
	}

	@Override
	public void deleteDocteurById(Long id) {
		docteurRepository.deleteById(id);
		
	}

	@Override
	public Docteur getDocteur(Long id) {
		return docteurRepository.findById(id).get();
	}

	@Override
	public List<Docteur> getAllDocteurs() {
		
		return docteurRepository.findAll();
	}

	@Override
	public List<Docteur> findByNomDocteur(String nom) {
		
		return docteurRepository.findByNomDocteur(nom);
	}

	@Override
	public List<Docteur> findByNomDocteurContains(String nom) {
		
		return docteurRepository.findByNomDocteurContains(nom);
	}

	@Override
	public List<Docteur> findByNomSalaire(String nom, Double salaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Docteur> findByHopital(Hopital hopital) {
		
		return docteurRepository.findByHopital(hopital);
	}

	@Override
	public List<Docteur> findByHopitalIdHop(Long id) {
	
		return docteurRepository.findByHopitalIdHop(id);
	}

	@Override
	public List<Docteur> findByOrderByNomDocteurAsc() {
		
		return docteurRepository.findByOrderByNomDocteurAsc();
	}

	@Override
	public List<Docteur> trierDocteursNomsSalaire() {
	
		return docteurRepository.trierDocteursNomsSalaire();
	}
	
	

}
