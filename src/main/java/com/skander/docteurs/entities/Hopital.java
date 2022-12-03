package com.skander.docteurs.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hopital {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idHop;
	
	private String nomHop;
	private String descriptionHop;
	
	
	@OneToMany (mappedBy = "hopital")
	@JsonIgnore
	private List<Docteur> docteurs;
	
	
}
