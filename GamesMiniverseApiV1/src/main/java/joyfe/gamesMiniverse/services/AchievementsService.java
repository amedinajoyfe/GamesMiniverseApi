package joyfe.gamesMiniverse.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import joyfe.gamesMiniverse.errors.CustomAchievementNotFound;
import joyfe.gamesMiniverse.secondaryClasses.Achievement;

@Service("achievementsService")
public class AchievementsService {
	
	List<Achievement> achievementList = new ArrayList<>();

	public List<Achievement> getAchievementList() {
		return achievementList;
	}

	public void addAchievement(Achievement newAchievement) {
		newAchievement.setId(generateIdAchievement());
		achievementList.add(newAchievement);
	}
	
	private long generateIdAchievement() {
		return achievementList == null ? 0 : achievementList.size() + 1;
	}
	
	public Achievement getAchievementById(long id) {
		return achievementList.stream().filter(x -> x.getId() == id).findFirst().orElseThrow(() -> new CustomAchievementNotFound(id));
	}

	public boolean updateAchievement(long id, Achievement newAchievement) {
		if (achievementList == null || id > achievementList.size() || id < 1)
			return false;
		newAchievement.setId(id);
		achievementList.set((int) (id - 1), newAchievement);
		return true;
	}

	public boolean deleteAchievement(long id) {
		if (achievementList == null || id > achievementList.size() || id < 1)
			return false;
		achievementList.set((int) (id - 1), null);
		return true;
	}
}
