package business.abstracts;

import entities.concretes.User;

public interface UserService {
	void  register (User user);
	void login (String eMail, String password);
	void registerWithGoogle (User user);
	
	
	
	
	
}
  


