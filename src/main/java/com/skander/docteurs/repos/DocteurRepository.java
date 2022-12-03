package com.skander.docteurs.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.skander.docteurs.entities.Hopital;
import com.skander.docteurs.entities.Docteur;

@RepositoryRestResource(path = "rest")
public interface DocteurRepository extends JpaRepository<Docteur, Long> {
	
	List<Docteur> findByNomDocteur(String nom);
	List<Docteur> findByNomDocteurContains(String nom);
	
	@Query("select p from Docteur p where p.nomDocteur like %:nom and p.salaireDocteur > :salaire")
	List<Docteur> findByNomSalaire (@Param("nom") String nom,@Param("salaire") Double salaire);

	@Query("select p from Docteur p where p.hopital = ?1")
	List<Docteur> findByHopital (Hopital hopital);
	
	List<Docteur> findByHopitalIdHop(Long id);
	
	List<Docteur> findByOrderByNomDocteurAsc();
	
	@Query("select p from Docteur p order by p.nomDocteur ASC, p.salaireDocteur DESC")
	List<Docteur> trierDocteursNomsSalaire ();

}
