package eCommerceRegistrationDemo.business.validationRules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	public static boolean emailValidate(String email)
	{
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(regex);
		return matcher.matches();
	}
}
