package fise3.info6.projetlu;

import fise3.info6.projetlu.model.User;

public interface UserService {
	public User findUserById(int id);
	public void saveUser(User user);
}

