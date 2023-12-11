package joyfe.gamesMiniverse.secondaryClasses;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import joyfe.gamesMiniverse.errors.CustomHighScoreNotFound;

public class User {
	long id;
	@NotNull(message = "El nombre de usuario no puede estar vacío")
	@Size(min = 6, max = 20, message = "El nombre de usuario debe tener entre 6 y 20 caracteres")
	String username;
	@Email
	String email;
	@NotNull(message = "La contraseña no puede estar vacía")
	String password;
	List<HighScore> highScores = new ArrayList<>();;

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

	public HighScore addHighScore(long _gameId, long _score) {
		HighScore previousScore = highScores.stream().filter(x -> x.getGameId() == _gameId).findFirst().orElse(null);
		if (previousScore == null) {
			HighScore newScore = new HighScore(_gameId, id, _score);
			highScores.add(newScore);
			return newScore;
		}
		else {
			if(previousScore.getScore() < _score)
				previousScore.setScore(_score);
		}
		return previousScore;
	}

	public HighScore getHighScore(long _gameId) {
		return highScores.stream().filter(x -> x.getGameId() == _gameId).findFirst().orElseThrow(() -> new CustomHighScoreNotFound(id, _gameId));
	}

}
