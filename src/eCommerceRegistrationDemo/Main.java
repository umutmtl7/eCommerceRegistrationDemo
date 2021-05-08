package eCommerceRegistrationDemo;

import java.util.ArrayList;

import eCommerceRegistrationDemo.business.concretes.UserManager;
import eCommerceRegistrationDemo.core.GoogleRegisterAdapter;
import eCommerceRegistrationDemo.dataAccess.concretes.InMemoryUserDao;
import eCommerceRegistrationDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(1,"Umut","Mtl","umutmtl_74869@gmail.com","4595763");
		User user1 = new User(2,"Ahmet","Yýlmaz","ahmt@hotmail.com","45864asdh");
		ArrayList<User> users = new ArrayList<User>();
		UserManager userManager = new UserManager(new InMemoryUserDao(users),new GoogleRegisterAdapter());
		userManager.register(user);
	}

}
