package eCommerceRegistrationDemo.dataAccess.concretes;

import java.util.List;

import eCommerceRegistrationDemo.dataAccess.abstracts.UserDao;
import eCommerceRegistrationDemo.entities.concretes.User;

public class InMemoryUserDao implements UserDao{

	List<User> users;
	
	public InMemoryUserDao(List<User> users)
	{
		this.users = users;
	}
	
	@Override
	public void add(User user) {
		boolean mailAlreadyExist = false;
		for (User userInList : users) {
			if(userInList.getEmail().equals(user.getEmail())) {
				mailAlreadyExist = true;
				System.out.println("This email address is already in use.");
				return;
				}
		}
		if(!mailAlreadyExist)
		users.add(user);
		System.out.println(user.getEmail() + " added.");
		}
		

	@Override
	public void update(User user) {

		
	}

	@Override
	public void delete(int id) {
		boolean inList = false;
		for (User user : users) {
			if(user.getId() == id) {
				inList = true;
				System.out.println(user.getEmail() + " deleted successfully.");	
				return;
		}
		}
		if(!inList)
		{
			System.out.println("There is no such an account with this id in list : " + id);
		}
	}

	@Override
	public User getByEmailAndPassword(String email,String password) {
		for (User user : users) {
			if(user.getEmail() == email && user.getPassword() == password)
			{
				System.out.println("You logged in " + email);
				return user;
			}
		}
		System.out.println("There is no such an account with this email and password");
		return null;
	}

}
