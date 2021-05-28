package me.dcal.thermoconnect.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.Terrarium;

@Repository
public interface AnimalRepository  extends JpaRepository<Animal,Integer>{

	List<Animal> findAllByidTerrarium(Terrarium terrarium);
}
