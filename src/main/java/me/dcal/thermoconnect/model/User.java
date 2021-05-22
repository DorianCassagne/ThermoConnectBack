package me.dcal.thermoconnect.model;
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
@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
Set<Terrarium> mesTerrariums;

public User() {

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
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((mesTerrariums == null) ? 0 : mesTerrariums.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
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
	User other = (User) obj;
	if (mesTerrariums == null) {
		if (other.mesTerrariums != null)
			return false;
	} else if (!mesTerrariums.equals(other.mesTerrariums))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}


}
