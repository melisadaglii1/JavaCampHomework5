import business.abstracts.LoginService;
import business.abstracts.UserService;
import business.concretes.LoginManager;
import business.concretes.UserManager;
import core.GoogleManagerAdapter;
import core.concretes.CheckManager;
import core.concretes.EmailManager;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserManager(new LoginManager(new InMemoryUserDao(),
				new CheckManager(), new EmailManager()),
			new GoogleManagerAdapter());
		
		//new LoginManager( new InMemoryUserDao(), 
			//	new CheckManager(), new EmailManager()),
			//	new GoogleManagerAdapter());
		User user1 = new User(1, "melisa", "daðlý", "melisa.d@gmail.com", "7536");
		userService.register(user1);
		userService.login("melisa.d@gmail.com", "7536");
		
		System.out.println("Google simülasyonu");
		userService.registerWithGoogle(user1);
		
		
		System.out.println("------------------------------");
		
		User user2 = new User(1, "melisa", "daðlý", "melisa.d@gmail.com", "7536");
		userService.register(user2);
		userService.registerWithGoogle(user2);
		
		
		
		

	}

}

