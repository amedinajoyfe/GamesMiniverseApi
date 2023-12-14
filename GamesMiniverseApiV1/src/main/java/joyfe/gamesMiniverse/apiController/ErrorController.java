package joyfe.gamesMiniverse.apiController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import joyfe.gamesMiniverse.errors.CustomAchievementNotFound;
import joyfe.gamesMiniverse.errors.CustomErrorMessage;
import joyfe.gamesMiniverse.errors.CustomGameNotFound;
import joyfe.gamesMiniverse.errors.CustomHighScoreNotFound;
import joyfe.gamesMiniverse.errors.CustomInvalidLogin;
import joyfe.gamesMiniverse.errors.CustomUserNotFound;

@RestControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomUserNotFound.class)
	ResponseEntity<CustomErrorMessage> handleUserNotFound(CustomUserNotFound ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new CustomErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage()));
	}

	@ExceptionHandler(CustomGameNotFound.class)
	ResponseEntity<CustomErrorMessage> handleGameNotFound(CustomGameNotFound ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new CustomErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage()));
	}
	
	@ExceptionHandler(CustomHighScoreNotFound.class)
	ResponseEntity<CustomErrorMessage> handleHighScoreNotFound(CustomHighScoreNotFound ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new CustomErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage()));
	}
	
	@ExceptionHandler(CustomAchievementNotFound.class)
	ResponseEntity<CustomErrorMessage> handleAchievementNotFound(CustomAchievementNotFound ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new CustomErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage()));
	}
	
	@ExceptionHandler(CustomInvalidLogin.class)
	ResponseEntity<CustomErrorMessage> handleInvalidLogin(CustomInvalidLogin ex) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				.body(new CustomErrorMessage(HttpStatus.UNAUTHORIZED, ex.getMessage()));
	}
}