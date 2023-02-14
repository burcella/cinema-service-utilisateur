package cm.cti.cinema.cinemaserviceutilisateur.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cm.cti.cinema.cinemaserviceutilisateur.models.Client;
import cm.cti.cinema.cinemaserviceutilisateur.models.Client;
import cm.cti.cinema.cinemaserviceutilisateur.repositories.ClientRepository;

@RestController // pour marquer la classe comme gestionnaire de requete//
@RequestMapping(value = "api/client")
public class ClientControleur {
	@Autowired
	private ClientRepository clientRepository;
	 
	@PostMapping
	public Client create(@RequestBody Client client) {
		client.setId(null);
		client.isValid();
		if(client.getPersonne().getNom().length() < 4)
			return null;
		clientRepository.save(client);
		return client;
	}
	
	@GetMapping( "/{id}")
	public Client findbyId(
			@PathVariable("id") Long id)
	{
		return clientRepository.findById(id).get();
		
	}
	
	@DeleteMapping("/{id}" )
	public String delete(
			@PathVariable("id") Long id) {
		Client client = clientRepository.findById(id).get();
		clientRepository.delete(client);
		return "OK";
		
		}
	
	@PutMapping
	public Client update(
			@RequestBody Client Client) {
		if(Client.getPersonne().getNom().length() < 4) return null;
		Client client2 = clientRepository.findById(Client.getId()).get();
		client2.getPersonne().setNom(Client.getPersonne().getNom());
		client2.getPersonne().setPrenom(Client.getPersonne().getPrenom());
		client2.getPersonne().setEmail(Client.getPersonne().getEmail());
		client2.getPersonne().setTel(Client.getPersonne().getTel());
		
		clientRepository.save(client2);
		return client2;
	}
	@GetMapping("/valid/isValid")
	public List< Client> findByIsValid(
			@PathVariable("isValid") boolean isValid){
		return clientRepository.findByIsValid(isValid);
	}
}

