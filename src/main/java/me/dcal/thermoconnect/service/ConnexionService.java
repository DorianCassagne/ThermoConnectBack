package me.dcal.thermoconnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dcal.thermoconnect.model.User;
import me.dcal.thermoconnect.repository.UserRepository;

@Service
public class ConnexionService {
	@Autowired
	UserRepository userRepository;
	
	public boolean existingUser(String username) {
		return userRepository.existsById(username);
	}
	
	public boolean validUser(String username,String password) {
		Optional<User> opUser = userRepository.findById(username);
		if(opUser.isPresent()) {
			return opUser.get().getPassword().equals(password);
		}
		else {
			return false;
		}
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
