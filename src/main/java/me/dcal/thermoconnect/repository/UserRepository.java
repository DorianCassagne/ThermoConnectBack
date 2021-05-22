package me.dcal.thermoconnect.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dcal.thermoconnect.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface  UserRepository extends JpaRepository<User,String>
{
	Optional<User> findById(String username);
	List<User> findAll();
}
