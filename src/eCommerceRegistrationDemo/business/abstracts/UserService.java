package eCommerceRegistrationDemo.business.abstracts;

import java.util.Scanner;

import eCommerceRegistrationDemo.entities.concretes.User;

public interface UserService {
	void register(User user,Scanner scan);
	void login(User user);
}
