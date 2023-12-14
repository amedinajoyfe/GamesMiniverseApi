package joyfe.gamesMiniverse.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomUserNotFound extends RuntimeException {

	public CustomUserNotFound(long id) {
		super("No existe el usuario que ha buscado");
	}
}
