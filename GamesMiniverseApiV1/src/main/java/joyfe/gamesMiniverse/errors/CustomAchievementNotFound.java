package joyfe.gamesMiniverse.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomAchievementNotFound extends RuntimeException {
	
	public CustomAchievementNotFound(long id) {
		super("No existe el logro con id " + id);
	}
}
