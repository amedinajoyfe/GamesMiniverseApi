package joyfe.gamesMiniverse.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomHighScoreNotFound extends RuntimeException {

	public CustomHighScoreNotFound(long userId, long gameId) {
		super("El jugador con la id " + userId + " no tiene puntuación más alta en el juego con id " + gameId);
	}
}
