package joyfe.gamesMiniverse.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomUserNotFound extends RuntimeException {

	public CustomUserNotFound(Long id) {
		super("No existe el usuario con id " + id); //Esto es para construir una excepción con el texto que elijamos
	}
}
