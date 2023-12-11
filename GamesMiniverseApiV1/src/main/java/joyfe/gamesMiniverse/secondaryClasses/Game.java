package joyfe.gamesMiniverse.secondaryClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Game {
	long id;

	@NotNull(message = "El nombre del juego no puede estar vacío")
	@Size(min = 6, max = 20, message = "El nombre del juego debe tener entre 6 y 20 caracteres")
	String name;
	List<HighScore> highScores = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HighScore addHighScore(long _userId, long _score) {
		HighScore previousScore = highScores.stream().filter(x -> x.getUserId() == _userId).findFirst().orElse(null);
		HighScore newScore;
		if (previousScore == null) {
			newScore = new HighScore(id, _userId, _score);
			highScores.add(newScore);
			highScores.sort(Comparator.comparingLong(HighScore::getScore)); // Esto es una cosa muy compleja que todavía
																			// no estoy seguro de como funciona
			Collections.reverse(highScores);
			highScores = highScores.subList(0, highScores.size() < 5 ? highScores.size() : 5); // Guarda solo los 5
																								// primeros
			return newScore;
		} else {
			if (previousScore.getScore() < _score)
				previousScore.setScore(_score);

		}
		return previousScore;
	}

	public List<HighScore> getHighScores() {
		return highScores;
	}
}