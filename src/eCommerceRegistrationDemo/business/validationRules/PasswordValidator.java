package eCommerceRegistrationDemo.business.validationRules;

public class PasswordValidator {
	public static boolean passwordValidate(String password)
	{
		if(password.length() < 6)
		{
			System.out.println("Min passwords length must be 6 characters");
			return false;
		}
		return true;
	}
}
