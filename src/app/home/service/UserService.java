package app.home.service;

import java.util.List;

import app.home.model.FindCookOrder;
import app.home.model.User;

public interface UserService {

	List<User> select();
	
	User find(String uid);
	
	Integer save(User info);

	List<User> getAll2();

	List<User> getAll3();
	
	int remove(int uid);
	
	User loginSelect(User user);

}
