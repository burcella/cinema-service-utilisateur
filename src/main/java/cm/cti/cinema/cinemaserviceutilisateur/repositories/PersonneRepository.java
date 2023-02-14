package cm.cti.cinema.cinemaserviceutilisateur.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cm.cti.cinema.cinemaserviceutilisateur.models.Personne;

@RepositoryRestResource
public interface PersonneRepository extends JpaRepository<Personne, Long>{
	List<Personne> findByNom(String nom);
	List<Personne> findByEmail(String email);
	List<Personne> findByPrenom(String prenom);

}
