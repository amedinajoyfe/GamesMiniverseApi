package joyfe.gamesMiniverse.errors;


public class CustomUserNotFound extends RuntimeException {

	public CustomUserNotFound(Long id) {
		super("No existe el usuario con id " + id); //Esto es para construir una excepción con el texto que elijamos
	}
}
