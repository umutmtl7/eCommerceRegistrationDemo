package eCommerceRegistrationDemo.googleAccount;

public class GoogleRegisterManager {
	public boolean register(String email,String password)
	{
		if(email.contains("@gmail.com") && password.length() > 5)
		{
			return true;
		}
		return false;
	}
}
