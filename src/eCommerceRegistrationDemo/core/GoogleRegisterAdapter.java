package eCommerceRegistrationDemo.core;

import eCommerceRegistrationDemo.googleAccount.GoogleRegisterManager;

public class GoogleRegisterAdapter implements RegisterService {

	@Override
	public boolean register(String email, String password) {
		GoogleRegisterManager googleRegisterManager = new GoogleRegisterManager();
		if(googleRegisterManager.register(email, password) == true)
		{
			return true;
		}
		else
		{
			System.out.println("This google account is not real.");
			return false;
		}
		
	}

}
