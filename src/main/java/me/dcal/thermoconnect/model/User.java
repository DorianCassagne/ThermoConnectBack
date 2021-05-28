package me.dcal.thermoconnect.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="user", schema = "thermoconnect")
public class User {
	@Id
	@Column(name="username", unique=true)
	String username;
	@Column(name="password")
	String password;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "username")
	Set<Terrarium> mesTerrariums;

	public User() {

	}
	public User(String username, String password) {
		this.username=username;
		this.password=password;
		mesTerrariums = new HashSet<Terrarium>();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}


}
