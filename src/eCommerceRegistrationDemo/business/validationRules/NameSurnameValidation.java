package eCommerceRegistrationDemo.business.validationRules;

public class NameSurnameValidation {
	public static boolean NameSurnameValidate(String name,String surname)
	{
		if(name.length() < 2 || surname.length() < 2)
		{
			System.out.println("Name and Surname must include minimum 2 characters.");
			return false;
		}
		return true;
	}
}
