package me.dcal.thermoconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import me.dcal.thermoconnect.id.AnimalDataId;
import me.dcal.thermoconnect.model.AnimalData;

public interface AnimalDataRepository  extends JpaRepository<AnimalData,AnimalDataId>{
	
	@Query(value = "select * from thermoconnect.animal_data where id_animal = ?1 order by date_animal_data desc limit 1",nativeQuery = true)
	AnimalData findFirst1FilterByIdAnimalOrderByDate(Integer integer);
}
