package joyfe.gamesMiniverse.apiController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import joyfe.gamesMiniverse.errors.CustomErrorMessage;
import joyfe.gamesMiniverse.errors.CustomUserNotFound;

@RestControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CustomUserNotFound.class)
	ResponseEntity<CustomErrorMessage> handleUserNotFound(CustomUserNotFound ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage()));
	}
}