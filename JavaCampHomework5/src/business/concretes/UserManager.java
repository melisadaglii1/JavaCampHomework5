package business.concretes;

import business.abstracts.LoginService;
import business.abstracts.UserService;
import core.GoogleManagerAdapter;
import core.abstracts.GoogleService;
import entities.concretes.User;

public class UserManager implements UserService {
	private LoginService loginService;
	private GoogleService googleService;
	
public UserManager(LoginService loginService, 
		GoogleService googleService) {
	this.googleService = googleService;
	this.loginService = loginService;
	
}

@Override
public void register(User user) {
	loginService.register(user);
	
}

@Override
public void login(String eMail, String password) {
	loginService.login(eMail, password);
	
}

@Override
public void registerWithGoogle(User user) {
	googleService.registerToSystem();
	
}


}
	
	

	


	


