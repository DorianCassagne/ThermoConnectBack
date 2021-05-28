package me.dcal.thermoconnect.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import me.dcal.thermoconnect.id.AnimalDataId;
import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.AnimalData;
import me.dcal.thermoconnect.model.Terrarium;

public interface AnimalDataRepository  extends JpaRepository<AnimalData,AnimalDataId>{
	
//	@Query(value = "select animalData from animalData where id_animal = ?1 and date_animal_data  > '?2'",nativeQuery = true)
//	List<AnimalData> findAllDataAfter(int idAnimal, Date dateDebut);
//	List<AnimalData> findAllBy(int idAnimal);
	
//	List<AnimalData> findAllByIdAnimal(Optional<Integer> idAnimal);
	@Query(value = "select * from thermoconnect.animal_data where id_animal = ?1 order by date_animal_data desc limit 1",nativeQuery = true)
	AnimalData findFirst1FilterByIdAnimalOrderByDate(Integer integer);
}
