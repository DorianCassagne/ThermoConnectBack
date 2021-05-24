package me.dcal.thermoconnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.Terrarium;
import me.dcal.thermoconnect.model.User;

@Repository
public interface AnimalRepository  extends JpaRepository<Animal,Integer>{
//	@Modifying
//	@Query("insert into thermoconnect.animal ")
//	@Query("select * from thermoconnect.animal_picture where id_animal like '?'")
	List<Animal> findAllByidTerrarium(Terrarium terrarium);
}
