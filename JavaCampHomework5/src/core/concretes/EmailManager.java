package core.concretes;

import core.abstracts.EmailService;
import entities.concretes.User;

public class EmailManager implements EmailService {

	@Override
	public void getByEmail(User user) {
		System.out.println("Do�rulama epostan�z adrese g�nderildi. " + user.geteMail());
		
	}

	@Override
	public void clickToByData(User user) {
		System.out.println("Kayd�n�z� do�rulamak i�in ba�lant�ya t�klay�n�z. " + user.getFirstName());
		
	}

}
