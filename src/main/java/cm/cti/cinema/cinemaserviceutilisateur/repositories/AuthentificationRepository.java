package cm.cti.cinema.cinemaserviceutilisateur.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cm.cti.cinema.cinemaserviceutilisateur.models.Authentification;

@RepositoryRestResource
public interface AuthentificationRepository extends JpaRepository<Authentification, Long>{

}
