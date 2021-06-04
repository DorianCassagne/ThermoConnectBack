package me.dcal.thermoconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.dcal.thermoconnect.id.AnimalPictureId;
import me.dcal.thermoconnect.model.AnimalPicture;
import me.dcal.thermoconnect.model.TerrariumData;

@Repository
public interface AnimalPictureRepository extends JpaRepository<AnimalPicture,AnimalPictureId>{
	@Query(value = "select * from thermoconnect.animal_picture where id_animal = ?1 ",nativeQuery = true)
	List<AnimalPicture> findPictureByIdAnimal(Integer integer);
}
