package joyfe.gamesMiniverse.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import joyfe.gamesMiniverse.errors.CustomUserNotFound;
import joyfe.gamesMiniverse.secondaryClasses.User;

@Service("subjectService")
public class UsersService{

	List<User> userList = new ArrayList<>();
	
	public List<User> getUserList() {
		return userList;
	}
	
	public void addUser(User newTask) {
		newTask.setId(generateIdUser());
		userList.add(newTask);
	}
	public User getUserById(long id) {
		return userList.stream().filter(task -> task.getId() == id).findFirst().orElseThrow(() -> new CustomUserNotFound(id));
	}
	public boolean updateUser(long id, User newTask) {
		if(userList == null || id > userList.size() || id < 1)
			return false;
		newTask.setId(id);
		userList.set((int)(id - 1), newTask);
		return true;
	}
	public boolean deleteUser(long id) {
		if(userList == null || id > userList.size() || id < 1)
			return false;
		userList.set((int)(id - 1), new User());
		return true;
	}
	
	private long generateIdUser() {
		return userList == null? 0:userList.size() + 1;
	}
}
