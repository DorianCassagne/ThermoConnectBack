package me.dcal.thermoconnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.Terrarium;
import me.dcal.thermoconnect.model.User;
import me.dcal.thermoconnect.model.api.BodyConnexion;
import me.dcal.thermoconnect.repository.AnimalRepository;
import me.dcal.thermoconnect.repository.TerrariumRepository;
import me.dcal.thermoconnect.repository.UserRepository;

@Service
public class ConnexionService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	TerrariumRepository terrariumRepository;
	@Autowired
	AnimalRepository animalRepository;
	
	public boolean existingUser(String username) {
		return userRepository.existsById(username);
	}
	public boolean validUser(BodyConnexion bc) {
		if(bc == null || bc.getLogin() == null || bc.getPassword() == null) {
			System.out.println("Body Connexion non remplie/exitant");
			return false;
		}
			
		return validUser(bc.getLogin(),bc.getPassword());
	}
	private boolean validUser(String username,String password) {
		Optional<User> opUser = userRepository.findById(username);
		if(opUser.isPresent()) {
			return opUser.get().getPassword().equals(password);
		}
		else {
			return false;
		}
	}
	public boolean isTerrariumUser(String userName,Integer idTerrarium) {
		try {
		Terrarium t = terrariumRepository.findById(idTerrarium).get();
		return t.getUsername().getUsername().equals(userName);
		}catch (Exception e) {
			System.out.println("terrarium inexistant: "+ idTerrarium);
			return false;
		}
	}
	
	public boolean isAnimalUser(String userName,Integer idAnimal) {
		Optional<Animal> o =  animalRepository.findById(idAnimal);
		if(o.isEmpty())
			return false;
		Animal a = o.get();
		return a.getIdTerrarium().getUsername().getUsername().equals(userName);
	}
	
	public boolean changePassword(String username, String password) {
		User user = new User(username,password);
		userRepository.save(user);
		return true;
	}
	
	public boolean deleteUser(String username) {
		if(!existingUser(username))
			return false;
		userRepository.deleteById(username);
		return false;
		
	}
	
	public boolean createUser(String username, String password) {
		if(existingUser(username))
			return false;
		User user = new User(username,password);
		userRepository.save(user);
		return true;
	}
}
