package eCommerceRegistrationDemo.business.concretes;

import java.util.Random;
import java.util.Scanner;

import eCommerceRegistrationDemo.business.abstracts.UserService;
import eCommerceRegistrationDemo.business.validationRules.EmailValidator;
import eCommerceRegistrationDemo.business.validationRules.NameSurnameValidation;
import eCommerceRegistrationDemo.business.validationRules.PasswordValidator;
import eCommerceRegistrationDemo.core.RegisterService;
import eCommerceRegistrationDemo.dataAccess.abstracts.UserDao;
import eCommerceRegistrationDemo.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private RegisterService registerService;
	public UserManager(UserDao userDao, RegisterService registerService) {
		this.userDao = userDao;
		this.registerService = registerService;
	}

	@Override
	public void register(User user,Scanner scan) {
		if(EmailValidator.emailValidate(user.getEmail())==true)
		{
			boolean checkNames = NameSurnameValidation.NameSurnameValidate(user.getFirstName(), user.getLastName());
			boolean checkPassword = PasswordValidator.passwordValidate(user.getPassword());
			if(checkNames == true && checkPassword == true)
			{
				boolean isGoogle = registerService.register(user.getEmail(), user.getPassword());
				if(isGoogle == true)
				{
					Random random = new Random();
					int number = random.nextInt(999999);
					String formatRandom = String.format("%06d", number);
					System.out.println("Please Enter This Verification Code : " + formatRandom);
					String verifyNumber = scan.next();
					if(verifyNumber.equals(formatRandom))
					{
						userDao.add(user);
						return;
					}
					else {
						System.out.println("You entered the false verification code.");
						return;
					}
				}

			}
		}
		else
		{
			System.out.println("Email not valid.");
			return;
		}
	}

	@Override
	public void login(User user) {
		userDao.getByEmailAndPassword(user.getEmail(), user.getPassword());
	}

}
