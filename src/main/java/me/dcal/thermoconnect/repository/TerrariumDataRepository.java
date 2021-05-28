package me.dcal.thermoconnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.dcal.thermoconnect.id.TerrariumDataId;
import me.dcal.thermoconnect.model.AnimalData;
import me.dcal.thermoconnect.model.TerrariumData;

@Repository
public interface TerrariumDataRepository extends JpaRepository<TerrariumData,TerrariumDataId>{
	Optional<TerrariumData> findById(TerrariumDataId terrariumDataId);
	List<TerrariumData> findAll();
	
	@Query(value = "select * from thermoconnect.terrarium_data where id_terrarium = ?1 order by time desc limit 1 ",nativeQuery = true)
	TerrariumData findFirst1FilterByIdTerrariumOrderByDate(Integer integer);
}