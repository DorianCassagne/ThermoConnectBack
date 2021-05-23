package me.dcal.thermoconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dcal.thermoconnect.model.Animal;

@Repository
public interface AnimalRepository  extends JpaRepository<Animal,String>{

}
