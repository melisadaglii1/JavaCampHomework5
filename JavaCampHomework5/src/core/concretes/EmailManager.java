package core.concretes;

import core.abstracts.EmailService;
import entities.concretes.User;

public class EmailManager implements EmailService {

	@Override
	public void getByEmail(User user) {
		System.out.println("Doðrulama epostanýz adrese gönderildi. " + user.geteMail());
		
	}

	@Override
	public void clickToByData(User user) {
		System.out.println("Kaydýnýzý doðrulamak için baðlantýya týklayýnýz. " + user.getFirstName());
		
	}

}
