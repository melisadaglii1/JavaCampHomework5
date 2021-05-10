package business.concretes;

import business.abstracts.LoginService;
import core.abstracts.CheckService;
import core.abstracts.EmailService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class LoginManager implements LoginService{
	private EmailService emailService;
	private CheckService checkService;
	private UserDao userDao;
	
	public LoginManager (UserDao userDao, CheckService checkService, EmailService emailService) {
		super();
		this.checkService = checkService;
		this .emailService = emailService;
		this.userDao = userDao;
	}
	

	@Override
	public void register(User user) {
		if (userDao.eMailExits(user)) {
			System.out.println("kay�t ba�ar�s�z \n " + user.geteMail() + " bu e posta daha �nce kullan�lm��. ");
			return;
		}
		 if (checkService.checkFirstName(user.getFirstName())) {
			 System.out.println("isiminiz do�ruland�. ");
		 }
		 else {
			 return;
		 }
		if (checkService.checkLastName(user.getLastName())) {
			System.out.println("soyad�n�z do�ruland�. ");
		}
		else {
			return;
		}
		if (checkService.checkEmail(user.geteMail())) {
			System.out.println("e posta adresiniz do�ruland�");
		}
		else {
			return;
		}
		if (checkService.checkPassword(user.getPassword())) {
			System.out.println(" �ifreniz do�ruland�. ");
		}
		else {
			return;
		}
		
		emailService.clickToByData(user);
		emailService.getByEmail(user);
		userDao.add(user); 
		System.out.println(" kay�t ba�ar�l�! Ho� Geldiniz: " + user.getFirstName() + "!" );
	}

	@Override
	public void login(String eMail, String password) {
		for (User user : userDao.getAll()) {
			if (eMail == user.geteMail() && password == user.getPassword()) {
				System.out.println("Giri� ba�ar�l�! ");
				return;
			}
			System.out.println("Yanl�� girildi. Tekrar Deneyiniz! ");
				
			
		}
		
	}

}
