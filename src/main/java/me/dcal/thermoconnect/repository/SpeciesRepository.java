package me.dcal.thermoconnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dcal.thermoconnect.model.Species;
import me.dcal.thermoconnect.model.Terrarium;

@Repository
public interface SpeciesRepository extends JpaRepository<Species,String>{
	Optional<Species> findById(String speciesName);
	List<Species> findAll();
}
