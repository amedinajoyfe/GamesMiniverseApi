package joyfe.gamesMiniverse.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import joyfe.gamesMiniverse.errors.CustomUserNotFound;
import joyfe.gamesMiniverse.secondaryClasses.Achievement;
import joyfe.gamesMiniverse.secondaryClasses.HighScore;
import joyfe.gamesMiniverse.secondaryClasses.User;

@Service("usersService")
public class UsersService {

	List<User> userList = new ArrayList<>();

	public List<User> getUserList() {
		return userList;
	}

	public void addUser(User newUser) {
		newUser.setId(generateIdUser());
		userList.add(newUser);
	}

	public User getUserById(long id) {
		return userList.stream().filter(x -> x.getId() == id).findFirst().orElseThrow(() -> new CustomUserNotFound(id));
	}

	public boolean updateUser(long id, User newUser) {
		if (userList == null || id > userList.size() || id < 1)
			return false;
		newUser.setId(id);
		userList.set((int) (id - 1), newUser);
		return true;
	}

	public boolean deleteUser(long id) {
		if (userList == null || id > userList.size() || id < 1)
			return false;
		userList.set((int) (id - 1), null);
		return true;
	}

	private long generateIdUser() {
		return userList == null ? 0 : userList.size() + 1;
	}
	
	public HighScore insertNewScore(long _gameId, long _userId, long _score) {
		User userSearched = userList.stream().filter(x -> x.getId() == _userId).findFirst()
				.orElseThrow(() -> new CustomUserNotFound(_userId));
		return userSearched.addHighScore(_gameId, _score);
	}

	public HighScore getHighScore(long _gameId, long _userId) {
		User userSearched = userList.stream().filter(x -> x.getId() == _userId).findFirst()
				.orElseThrow(() -> new CustomUserNotFound(_userId));
		HighScore searchedHighScore = userSearched.getHighScore(_gameId);
		return searchedHighScore;
	}
	
	public Achievement insertAchievement(long _userId, Achievement _achievement) {
		User userSearched = userList.stream().filter(x -> x.getId() == _userId).findFirst()
				.orElseThrow(() -> new CustomUserNotFound(_userId));
		if (!userSearched.getAchievements().contains(_achievement.getId()));
		return userSearched.addAchievement(_achievement);
	}
}