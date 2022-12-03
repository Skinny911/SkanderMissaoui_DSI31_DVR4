package com.skander.docteurs;



import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skander.docteurs.entities.Hopital;
import com.skander.docteurs.entities.Docteur;
import com.skander.docteurs.repos.DocteurRepository;


@SpringBootTest
class DocteursApplicationTests {

	@Autowired
	private DocteurRepository docteurRepository;
	
	@Test
	public void testCreateDocteur() {
	Docteur doc = new Docteur("Skander ",1500.500,new Date());
	docteurRepository.save(doc);
	}
	
	@Test
	public void testFindDocteur()
	{
	Docteur d = docteurRepository.findById(1L).get();
	System.out.println(d);
	}
	
	@Test
	public void testUpdateDocteur()
	{
	Docteur d = docteurRepository.findById(1L).get();
	d.setSalaireDocteur(2000.0);
	docteurRepository.save(d);
	
	System.out.println(d);
	}
	
	@Test
	public void testDeleteDocteur()
	{
		docteurRepository.deleteById(3L);
	}
	
	@Test
	public void testFindAllDocteurs()
	{
		List<Docteur> docs = docteurRepository.findAll();
		
		for (Docteur p:docs)
			 System.out.println(p);
		
	}
	
	
	@Test
	public void testFindDocteurByNom()
	{
	List<Docteur> docs = docteurRepository.findByNomDocteur("PS 4");
	
	for (Docteur p:docs)
		 System.out.println(p);
	
	}
	
	@Test
	public void testFindDocteurByNomContains()
	{
	List<Docteur> docs = docteurRepository.findByNomDocteurContains("P");
	
	for (Docteur d:docs)
		 System.out.println(d);
	
	}
	
	@Test
	public void testfindByNomSalaire()
	{
	List<Docteur> docs = docteurRepository.findByNomSalaire("PS 4", 1000.0);
		for (Docteur d : docs)
			{
				System.out.println(d);
			}
	}
	
	
	@Test
	public void testfindByHopital()
	{
	Hopital hop = new Hopital();
	hop.setIdHop(1L);
	
	List<Docteur> docs = docteurRepository.findByHopital(hop);
	for (Docteur d : docs)
	{
		System.out.println(d);
	}
	}
	
	@Test
	public void findByHopitalIdHop()
	{
	List<Docteur> docs = docteurRepository.findByHopitalIdHop(1L);
	for (Docteur d : docs)
	{
		System.out.println(d);
	}
	}
	
	
	@Test
	public void testfindByOrderByNomDocteurAsc()
	{
	List<Docteur> docs =  docteurRepository.findByOrderByNomDocteurAsc();
	for (Docteur d : docs)
		{
			System.out.println(d);
		}
	}
	
	@Test
	public void testTrierDocteursNomsSalaire()
	{
	List<Docteur> docs = docteurRepository.trierDocteursNomsSalaire();
	for (Docteur d : docs)
	{
	System.out.println(d);
	}
	}
	
	
}
