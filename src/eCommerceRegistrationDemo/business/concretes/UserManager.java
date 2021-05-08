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
	public void register(User user) {
		if(EmailValidator.emailValidate(user.getEmail())==true)
		{
			boolean checkNames = NameSurnameValidation.NameSurnameValidate(user.getFirstName(), user.getLastName());
			boolean checkPassword = PasswordValidator.passwordValidate(user.getPassword());
			if(checkNames == true && checkPassword == true)
			{
				boolean isGoogle = registerService.register(user.getEmail(), user.getPassword());
				if(isGoogle == true)
				{
					Scanner scan = new Scanner(System.in);
					Random random = new Random();
					int number = random.nextInt(999999);
					System.out.println("Please Enter This Verification Code : " + number);
					int verifyNumber = scan.nextInt();
					if(verifyNumber == number)
					{
						System.out.println("Congratulations! Your account has been created.");
						userDao.add(user);
						scan.close();
					}
					else {
						System.out.println("You entered the false verification code.");
						scan.close();
					}
				}

			}
		}
		else
		{
			System.out.println("Email not valid.");
		}
	}

	@Override
	public void login(User user) {
		userDao.getByEmailAndPassword(user.getEmail(), user.getPassword());
	}

}
