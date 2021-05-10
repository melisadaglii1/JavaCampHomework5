package core.abstracts;

import entities.concretes.User;

public interface EmailService {
	void getByEmail(User user);
	void clickToByData(User user);

}
