package joyfe.gamesMiniverse.secondaryClasses;

import jakarta.validation.constraints.NotNull;

public class HighScore {

	private long gameId;
	private long userId;

	@NotNull(message = "La puntuación no puede ser inválida")
	private long score;

	public HighScore(long _gameId, long _userId, long _score) {
		this.gameId = _gameId;
		this.userId = _userId;
		this.score = _score;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}
}
