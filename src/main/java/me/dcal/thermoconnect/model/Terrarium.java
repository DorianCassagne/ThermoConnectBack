package me.dcal.thermoconnect.model;

import java.sql.Time;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="terrarium", schema = "thermoconnect")
public class Terrarium {
	@Id
	@Column(name="idTerrarium", unique=true)
	int idTerrarium;
	@Column(name="temperatureMin")
	double temperatureMin;
	@Column(name="temperatureMax")
	double temperatureMax;
	@Column(name="nameTerrarium")
	String nameTerrarium;
	@Column(name="startLightTime")
	Time startLightTime;
	@Column(name="stopLightTime")
	Time stopLightTime;
	@ManyToOne
	@JoinColumn(name = "user")
	User user;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "idTerrarium")
	Set<TerrariumData> mesdatas;
	
	public Terrarium() {
		
	}
	public int getIdTerrarium() {
		return idTerrarium;
	}
	public void setIdTerrarium(int idTerrarium) {
		this.idTerrarium = idTerrarium;
	}
	public double getTemperatureMin() {
		return temperatureMin;
	}
	public void setTemperatureMin(double temperatureMin) {
		this.temperatureMin = temperatureMin;
	}
	public double getTemperatureMax() {
		return temperatureMax;
	}
	public void setTemperatureMax(double temperatureMax) {
		this.temperatureMax = temperatureMax;
	}
	public String getNameTerrarium() {
		return nameTerrarium;
	}
	public void setNameTerrarium(String nameTerrarium) {
		this.nameTerrarium = nameTerrarium;
	}
	public Time getStartLightTime() {
		return startLightTime;
	}
	public void setStartLightTime(Time startLightTime) {
		this.startLightTime = startLightTime;
	}
	public Time getStopLightTime() {
		return stopLightTime;
	}
	public void setStopLightTime(Time stopLightTime) {
		this.stopLightTime = stopLightTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTerrarium;
		result = prime * result + ((nameTerrarium == null) ? 0 : nameTerrarium.hashCode());
		result = prime * result + ((startLightTime == null) ? 0 : startLightTime.hashCode());
		result = prime * result + ((stopLightTime == null) ? 0 : stopLightTime.hashCode());
		long temp;
		temp = Double.doubleToLongBits(temperatureMax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(temperatureMin);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Terrarium other = (Terrarium) obj;
		if (idTerrarium != other.idTerrarium)
			return false;
		if (nameTerrarium == null) {
			if (other.nameTerrarium != null)
				return false;
		} else if (!nameTerrarium.equals(other.nameTerrarium))
			return false;
		if (startLightTime == null) {
			if (other.startLightTime != null)
				return false;
		} else if (!startLightTime.equals(other.startLightTime))
			return false;
		if (stopLightTime == null) {
			if (other.stopLightTime != null)
				return false;
		} else if (!stopLightTime.equals(other.stopLightTime))
			return false;
		if (Double.doubleToLongBits(temperatureMax) != Double.doubleToLongBits(other.temperatureMax))
			return false;
		if (Double.doubleToLongBits(temperatureMin) != Double.doubleToLongBits(other.temperatureMin))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	

}
