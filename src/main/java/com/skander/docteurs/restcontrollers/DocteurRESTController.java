package com.skander.docteurs.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skander.docteurs.entities.Docteur;
import com.skander.docteurs.service.DocteurService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DocteurRESTController {
	
	@Autowired
	DocteurService docteurService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Docteur> getAllDocteurs()
	{
		return docteurService.getAllDocteurs();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Docteur getDocteurById(@PathVariable("id") Long id) {
		return docteurService.getDocteur(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Docteur createDocteur(@RequestBody Docteur docteur) {
			return docteurService.saveDocteur(docteur);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Docteur updateDocteur(@RequestBody Docteur docteur) {
		return docteurService.updateDocteur(docteur);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteDocteur(@PathVariable("id") Long id)
	{
			docteurService.deleteDocteurById(id);
	}
	
	@RequestMapping(value="/docshop/{idHosp}",method = RequestMethod.GET)
	public List<Docteur> getDocteursByHospId(@PathVariable("idHosp") Long idHosp) {
		return docteurService.findByHopitalIdHop(idHosp);
	}

	
	
	


}
