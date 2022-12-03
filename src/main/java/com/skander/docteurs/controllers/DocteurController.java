package com.skander.docteurs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skander.docteurs.entities.Docteur;
import com.skander.docteurs.service.DocteurService;

@Controller
public class DocteurController {
	
	
	@Autowired
	DocteurService docteurService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createDocteur";
	}
	
	@RequestMapping("/saveDocteur")
	public String saveDocteur(@ModelAttribute("docteur") Docteur docteur,
							  @RequestParam("date") String date,
	                          ModelMap modelMap) throws 	ParseException
	{
		//Date conversion
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateNaiss = dateformat.parse(String.valueOf(date));
	docteur.setDateNaiss(dateNaiss);
	
	Docteur saveDocteur = docteurService.saveDocteur(docteur);
	String msg ="docteur enregistré avec Id "+saveDocteur.getIdDocteur();
	modelMap.addAttribute("msg", msg);
	return "createDocteur";
	}
	
	@RequestMapping("/ListeDocteurs")
	public String listeDocteurs(ModelMap modelMap)
	{
		List<Docteur> docs = docteurService.getAllDocteurs();
		modelMap.addAttribute("docteurs", docs);
		return "listeDocteurs";
	}
	
	@RequestMapping("/supprimerDocteur")
	public String supprimerDocteur(@RequestParam("id") Long id,
	ModelMap modelMap)
	{
		docteurService.deleteDocteurById(id);
		List<Docteur> docs = docteurService.getAllDocteurs();
		modelMap.addAttribute("docteurs", docs);
	return "listeDocteurs";
	}
	
	@RequestMapping("/modifierDocteur")
	public String editerDocteur(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Docteur p= docteurService.getDocteur(id);
	modelMap.addAttribute("docteur", p);
	return "editerDocteur";
	}
	
	@RequestMapping("/updateDocteur")
	public String updateDocteur(@ModelAttribute("docteur") Docteur docteur,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//Date conversion
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateNaiss = dateformat.parse(String.valueOf(date));
	docteur.setDateNaiss(dateNaiss);
	docteurService.updateDocteur(docteur);
	List<Docteur> docs = docteurService.getAllDocteurs();
	modelMap.addAttribute("docteurs", docs);
	return "listeDocteurs";
	}
	


}
