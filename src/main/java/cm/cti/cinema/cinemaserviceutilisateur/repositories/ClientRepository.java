package cm.cti.cinema.cinemaserviceutilisateur.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cm.cti.cinema.cinemaserviceutilisateur.models.Client;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long>{
       List<Client> findByIsValid(boolean isValid);
}
