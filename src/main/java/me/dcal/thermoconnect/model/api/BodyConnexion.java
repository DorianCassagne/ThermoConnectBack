package me.dcal.thermoconnect.model.api;

public class BodyConnexion {

	private String login;
	public String password;


	public BodyConnexion() {
	}
	public BodyConnexion(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}