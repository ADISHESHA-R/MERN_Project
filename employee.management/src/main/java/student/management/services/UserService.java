package student.management.services;

import student.management.entities.User;

public interface UserService {

	void addUser(User user);

	boolean userExists(String username, String email);

	boolean validateUser(String username, String password);

}
