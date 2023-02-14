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

import cm.cti.cinema.cinemaserviceutilisateur.models.Administrateur;
import cm.cti.cinema.cinemaserviceutilisateur.models.Personne;
import cm.cti.cinema.cinemaserviceutilisateur.repositories.AdministrateurRepository;
import cm.cti.cinema.cinemaserviceutilisateur.repositories.PersonneRepository;

@RestController
@RequestMapping(value = "api/administrateur")
public class AdministrateurControleur {
	
	@Autowired
	private AdministrateurRepository administrateurRepository;
	
	@Autowired
	private PersonneRepository personneRepository;
	
	@GetMapping
	 public List<Administrateur> findAllAdmin(){
		return administrateurRepository.findAll();
	}
	@GetMapping( "/all")
	public List<Administrateur> findAllAdmin2(){
		return administrateurRepository.findAll();
	}
	@PostMapping
	public Administrateur create(@RequestBody Administrateur administrateur) {
		administrateur.setId(null);
		if(administrateur.getPersonne().getNom().length() < 4)
			return null;
		if(personneRepository.findByEmail(administrateur.getPersonne().getEmail()).size() > 0) 
			return null;
		administrateurRepository.save(administrateur);
		return administrateur;
	}
	@GetMapping( "/{id}" )
	public Administrateur findbyId(
			@PathVariable("id") Long id)
	{
		return administrateurRepository.findById(id).get();
		
	}
	@DeleteMapping("/{id}" )
	public String delete(
			@PathVariable("id") Long id) {
		Administrateur administrateur = administrateurRepository.findById(id).get();
		administrateurRepository.delete(administrateur);
		return "OK";
		
		}
	@PutMapping
	public Administrateur update(
			@RequestBody Administrateur administrateur) {
		if(administrateur.getPersonne().getNom().length() < 4) return null;
		Administrateur administrateur2 = administrateurRepository.findById(administrateur.getId()).get();
		administrateur2.getPersonne().setNom(administrateur.getPersonne().getNom());
		administrateur2.getPersonne().setPrenom(administrateur.getPersonne().getPrenom());
		administrateur2.getPersonne().setEmail(administrateur.getPersonne().getEmail());
		administrateur2.getPersonne().setTel(administrateur.getPersonne().getTel());
		
		administrateurRepository.save(administrateur2);
		return administrateur2;
	   
	} 
	@PostMapping
	public Personne login(
			@RequestBody Administrateur administrateur) {
		if(PersonneRepository.findByEmail(personne.getEmail()).size(0) > 0)
		Personn	personne2 = personne.findByEmail().get(0);
		else
			return null;
	}
	
	
	
}
