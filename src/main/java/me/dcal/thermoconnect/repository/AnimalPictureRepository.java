package me.dcal.thermoconnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.dcal.thermoconnect.id.AnimalPictureId;
import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.AnimalPicture;
import me.dcal.thermoconnect.model.Terrarium;

@Repository
public interface AnimalPictureRepository extends JpaRepository<AnimalPicture,AnimalPictureId>{

//	@Query(value = "select * from AnimalPicture where id_animal like stringIdAnimal")
//	List<AnimalPicture> findAllByanimalPictureId(String stringIdAnimal); 
}
