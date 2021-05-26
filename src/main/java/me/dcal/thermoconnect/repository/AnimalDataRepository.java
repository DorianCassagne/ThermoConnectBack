package me.dcal.thermoconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dcal.thermoconnect.id.AnimalDataId;
import me.dcal.thermoconnect.model.AnimalData;

public interface AnimalDataRepository  extends JpaRepository<AnimalData,AnimalDataId>{
	

}
