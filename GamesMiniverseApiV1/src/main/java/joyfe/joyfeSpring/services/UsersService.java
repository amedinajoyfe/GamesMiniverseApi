package joyfe.joyfeSpring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import joyfe.joyfeSpring.secondaryClasses.User;

@Service("subjectService")
public class UsersService {

	List<User> userList = new ArrayList<>();
	
	public List<User> getUserList() {
		return userList;
	}
	
	public boolean addUser(User newTask) {
		newTask.setId(generateIdUser());
		userList.add(newTask);
		return true;
	}
	public User getUserById(long id) {
		return userList.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
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
