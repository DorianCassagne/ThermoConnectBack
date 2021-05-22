package me.dcal.thermoconnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dcal.thermoconnect.id.TerrariumDataId;
import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.Species;
import me.dcal.thermoconnect.model.TerrariumData;

//@Repository
//public interface TerrariumDataRepository extends JpaRepository<TerrariumData,TerrariumDataId>{
//	Optional<TerrariumData> findById(String speciesName);
//	List<TerrariumData> findAll();
//}