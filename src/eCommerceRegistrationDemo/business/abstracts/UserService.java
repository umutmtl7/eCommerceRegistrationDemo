package eCommerceRegistrationDemo.business.abstracts;

import eCommerceRegistrationDemo.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(User user);
}
