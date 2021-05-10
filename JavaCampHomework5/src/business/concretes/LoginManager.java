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
			System.out.println("kayýt baþarýsýz \n " + user.geteMail() + " bu e posta daha önce kullanýlmýþ. ");
			return;
		}
		 if (checkService.checkFirstName(user.getFirstName())) {
			 System.out.println("isiminiz doðrulandý. ");
		 }
		 else {
			 return;
		 }
		if (checkService.checkLastName(user.getLastName())) {
			System.out.println("soyadýnýz doðrulandý. ");
		}
		else {
			return;
		}
		if (checkService.checkEmail(user.geteMail())) {
			System.out.println("e posta adresiniz doðrulandý");
		}
		else {
			return;
		}
		if (checkService.checkPassword(user.getPassword())) {
			System.out.println(" þifreniz doðrulandý. ");
		}
		else {
			return;
		}
		
		emailService.clickToByData(user);
		emailService.getByEmail(user);
		userDao.add(user); 
		System.out.println(" kayýt baþarýlý! Hoþ Geldiniz: " + user.getFirstName() + "!" );
	}

	@Override
	public void login(String eMail, String password) {
		for (User user : userDao.getAll()) {
			if (eMail == user.geteMail() && password == user.getPassword()) {
				System.out.println("Giriþ baþarýlý! ");
				return;
			}
			System.out.println("Yanlýþ girildi. Tekrar Deneyiniz! ");
				
			
		}
		
	}

}
