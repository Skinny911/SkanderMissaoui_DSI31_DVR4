package com.skander.docteurs.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomDoc", types = { Docteur.class })
public interface DocteurProjection {
	public String getNomDocteur();

}
