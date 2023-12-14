package joyfe.gamesMiniverse.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class CustomInvalidLogin extends RuntimeException {

	public CustomInvalidLogin() {
		super("El nombre de usuario y/o contraseña son inválidos");
	}
}
