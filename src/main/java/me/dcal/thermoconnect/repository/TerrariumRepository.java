package me.dcal.thermoconnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dcal.thermoconnect.model.Terrarium;
import me.dcal.thermoconnect.model.User;

@Repository
public interface TerrariumRepository extends JpaRepository<Terrarium,Integer>{
	Optional<Terrarium> findById(Integer idTerrarium);
	List<Terrarium> findAll();
	List<Terrarium> findAllByUsername(Optional<User> optional);
	List<Terrarium> findAllByUsernameAndNameTerrarium(User optional,String nameTerrarium);
	
}
