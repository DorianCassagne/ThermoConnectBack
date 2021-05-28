package me.dcal.thermoconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dcal.thermoconnect.id.AnimalPictureId;
import me.dcal.thermoconnect.model.AnimalPicture;

@Repository
public interface AnimalPictureRepository extends JpaRepository<AnimalPicture,AnimalPictureId>{

}
