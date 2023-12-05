package joyfe.gamesMiniverse.secondaryClasses;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {
	long id;
	@NotNull(message = "El nombre de usuario no puede estar vacío")
	@Size(min = 6, max = 20, message = "El nombre de usuario debe tener entre 6 y 20 caracteres")
	String username;
	@Email
	String email;
	@NotNull(message = "La contraseña no puede estar vacía")
	String password;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
