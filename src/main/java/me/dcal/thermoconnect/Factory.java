package me.dcal.thermoconnect;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dcal.thermoconnect.id.AnimalDataId;
import me.dcal.thermoconnect.id.TerrariumDataId;
import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.AnimalData;
import me.dcal.thermoconnect.model.AnimalPicture;
import me.dcal.thermoconnect.model.Species;
import me.dcal.thermoconnect.model.Terrarium;
import me.dcal.thermoconnect.model.TerrariumData;
import me.dcal.thermoconnect.model.api.BodyAnimal;
import me.dcal.thermoconnect.model.api.BodyAnimalData;
import me.dcal.thermoconnect.model.api.BodyConnexion;
import me.dcal.thermoconnect.model.api.BodySpecies;
import me.dcal.thermoconnect.model.api.BodyTerrarium;
import me.dcal.thermoconnect.model.api.BodyTerrariumData;
import me.dcal.thermoconnect.repository.AnimalDataRepository;
import me.dcal.thermoconnect.repository.AnimalRepository;
import me.dcal.thermoconnect.repository.SpeciesRepository;
import me.dcal.thermoconnect.repository.TerrariumRepository;
import me.dcal.thermoconnect.repository.UserRepository;

@Service
public class Factory {

	@Autowired
	UserRepository userRepository;
	@Autowired
	AnimalRepository animalRepository;
	@Autowired
	SpeciesRepository speciesRepository;
	@Autowired
	TerrariumRepository terrariumRepository;
	@Autowired
	AnimalDataRepository animalDataRepository;

	@Autowired
	Factory factory;

	public Factory() {
	}

	private Date stringToDate(String date) {
		try {
			return new Date( new SimpleDateFormat("dd/MM/yyyy").parse(date).getTime());
		} catch (Exception e) {
			System.out.println("Bad date value : "+ date);
			return null;
		}
	}	
	private String dateToString(Date date) {
		if(date == null)
			return null;
		return date.toString();
	}
	private Timestamp stringToTimeStamp(String time) {
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		    Date parsedDate = (Date) dateFormat.parse(time);
		    return  new java.sql.Timestamp(parsedDate.getTime());
		} catch(Exception e) { 
		    System.out.println("TimeStamp non valide");
		    return null;
		}
	}
	
	private Time stringToTime(String time) {
		return java.sql.Time.valueOf(time);
	}
	private String timeToString(Time time) {
		if(time == null)
			return null;
		return time.toString();
	}	
	private String timestampToString(Timestamp time) {
		if(time == null)
			return null;
		return time.toString();
	}
	
	public TerrariumData toEntity(BodyTerrariumData btd) {
		TerrariumData td = new  TerrariumData();
		TerrariumDataId tdi = new TerrariumDataId();
		
		tdi.setIdTerrarium(btd.idTerrarium);
		tdi.setTime(stringToTimeStamp(btd.date)); //TODO: time
		td.setHumidity(btd.humidity);
		td.setTemperature(btd.temperature);
		return td;
	}
	
	public AnimalData toEntity(BodyAnimalData bad) {
		AnimalData ad = new  AnimalData();
		AnimalDataId adi = new AnimalDataId();
		adi.setIdAnimal(bad.idAnimal);
		adi.setDateAnimalData(stringToDate(bad.dateAnimalData));
		ad.setAnimalDataId(adi);
		ad.setWeight(bad.weight);
		return ad;
	}
	public BodyAnimalData toBody(AnimalData ad) {
		BodyAnimalData ba = new BodyAnimalData();
		ba.weight = ad.getWeight();
		ba.dateAnimalData = dateToString(ad.getAnimalDataId().getDateAnimalData());
		ba.idAnimal = ad.getAnimalDataId().getIdAnimal();
		return ba;
		
	}
	public Animal toEntity(BodyAnimal ba) {
		Animal a = new Animal(); 
		a.setDateOfBirth(stringToDate(ba.dateOfBirth));
		a.setDescription(ba.description);
		if(speciesRepository.findById(ba.species.getSpeciesName()).isPresent())
			a.setSpecies(speciesRepository.findById(ba.species.getSpeciesName()).get());
		else {
			throw new RuntimeException("specsie non trouvé : " +ba.species);
		}
		a.setIdTerrarium(terrariumRepository.findById(ba.terrarium).get());
		a.setNameAnimal(ba.name);
		a.setSex(ba.sex);
		a.setFood(ba.food);
		return a;

	}
	public BodyAnimal toEntity(Animal a) {
		BodyAnimal ba = new BodyAnimal(new BodyConnexion(), 
				a.getIdTerrarium().getIdTerrarium(),
				toBody(speciesRepository.findById(a.getSpecies().getSpeciesName()).get()),
				a.getNameAnimal(), a.getSex(), dateToString(a.getDateOfBirth()),
				a.getDescription(),
				a.getFood(), a.getIdAnimal());
		
		for(AnimalPicture ad :a.getAnimalPictures()) {
			ba.getDocuments().add(ad.getAnimalPictureId().getNamePicture());
//			getDocuments
//			this.toBody(ad)
		}
//		ba.getDocuments().addAll(a.getAnimalDatas());	
		return ba;
	}

	public BodySpecies toBody(Species s) {
		return new BodySpecies(s.getSpeciesName(),s.getDescription(),s.getHumiditySpecies(),s.getTemperatureMinSpecies(),s.getTemperatureMaxSpecies());
	}
	public Species toEntity(BodySpecies bs) {
		Species s = new Species();
		s.setSpeciesName(bs.getSpeciesName());
		s.setDescription(bs.getDescription());
		s.setHumiditySpecies(bs.getHumidity());
		s.setTemperatureMaxSpecies(bs.getTempMax());
		s.setTemperatureMinSpecies(bs.getTempMin());
		return s;
	}

	public BodyTerrarium toBody(Terrarium t) {
		BodyTerrarium bt = new BodyTerrarium();
		bt.nameTerrarium=t.getNameTerrarium();
		bt.sizeTerrarium=t.getSizeTerrarium();
		bt.startLightTime=timeToString(t.getStartLightTime());
		bt.stopLightTime=timeToString(t.getStopLightTime());
		bt.temperatureMax=t.getTemperatureMax();
		bt.temperatureMin=t.getTemperatureMin();
		bt.idTerrarium=t.getIdTerrarium();
		bt.humidityTerrarium=t.getHumidityTerrarium();
		return bt;
	}
	public Terrarium toEntity(BodyTerrarium bt) {
		Terrarium t = new Terrarium();
		if(bt.idTerrarium != null && bt.idTerrarium!= 0)
			t.setIdTerrarium(bt.idTerrarium);
		t.setUsername(userRepository.getOne(bt.bodyConnexion.getLogin()));
		t.setNameTerrarium(bt.nameTerrarium);
		t.setSizeTerrarium(bt.sizeTerrarium);
		if(bt.startLightTime!=null)
			t.setStartLightTime(stringToTime(bt.startLightTime));
		if(bt.stopLightTime!=null)
			t.setStopLightTime(stringToTime(bt.stopLightTime));
		t.setTemperatureMax(bt.temperatureMax);
		t.setTemperatureMin(bt.temperatureMin);
		t.setHumidityTerrarium(bt.humidityTerrarium);

		return t;
	}

	public BodyTerrariumData toBody(TerrariumData td) {
		BodyTerrariumData btd = new BodyTerrariumData();
		if(td == null) {
			System.out.println("terrariumData est null");
			return null;
		}
		btd.date = timestampToString(td.getTime());
		btd.humidity = td.getHumidity();
		btd.temperature = td.getTemperature();
		btd.idTerrarium = td.getIdTerrarium();
		return btd;
	}

	



}
