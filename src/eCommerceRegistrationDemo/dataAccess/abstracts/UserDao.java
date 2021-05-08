package eCommerceRegistrationDemo.dataAccess.abstracts;

import eCommerceRegistrationDemo.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(int id);
	User getByEmailAndPassword(String email,String password);
}
