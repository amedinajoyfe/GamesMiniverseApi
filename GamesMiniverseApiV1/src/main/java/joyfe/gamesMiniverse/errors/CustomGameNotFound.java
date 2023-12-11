package joyfe.gamesMiniverse.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomGameNotFound extends RuntimeException {

	public CustomGameNotFound(long id) {
		super("No existe el juego con id " + id); // Esto es para construir una excepción con el texto que elijamos
	}
}
