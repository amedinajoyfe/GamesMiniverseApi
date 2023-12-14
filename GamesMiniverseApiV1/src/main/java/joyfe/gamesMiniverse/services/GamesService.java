package joyfe.gamesMiniverse.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import joyfe.gamesMiniverse.errors.CustomGameNotFound;
import joyfe.gamesMiniverse.errors.CustomUserNotFound;
import joyfe.gamesMiniverse.secondaryClasses.Game;
import joyfe.gamesMiniverse.secondaryClasses.HighScore;

@Service("gamesService")
public class GamesService {

	List<Game> gameList = new ArrayList<>();

	public List<Game> getGameList() {
		return gameList;
	}

	public void addGame(Game newGame) {
		newGame.setId(generateIdGame());
		gameList.add(newGame);
	}

	public Game getGameById(long id) throws CustomGameNotFound {
		return gameList.stream().filter(x -> x.getId() == id).findFirst().orElseThrow(() -> new CustomGameNotFound(id));
	}

	public boolean updateGame(long id, Game newGame) {
		if (gameList == null || id > gameList.size() || id < 1)
			return false;
		newGame.setId(id);
		gameList.set((int) (id - 1), newGame);
		return true;
	}

	public boolean deleteGame(long id) {
		if (gameList == null || id > gameList.size() || id < 1)
			return false;
		gameList.set((int) (id - 1), null);
		return true;
	}

	private long generateIdGame() {
		return gameList == null ? 0 : gameList.size() + 1;
	}

	public HighScore insertNewScore(long _gameId, long _userId, long _score) throws CustomGameNotFound {
		Game gameSearched = gameList.stream().filter(x -> x.getId() == _gameId).findFirst()
				.orElseThrow(() -> new CustomGameNotFound(_gameId));
		return gameSearched.addHighScore(_userId, _score);
	}

	public Map<Long, Long> getHighScores(long _gameId) throws CustomGameNotFound {
		Game gameSearched = gameList.stream().filter(x -> x.getId() == _gameId).findFirst()
				.orElseThrow(() -> new CustomGameNotFound(_gameId));
		Map<Long, Long> responseData = new HashMap<>();
		for (HighScore score : gameSearched.getHighScores()) {
			responseData.put(score.getUserId(), score.getScore());
		}
		return responseData;
	}
}