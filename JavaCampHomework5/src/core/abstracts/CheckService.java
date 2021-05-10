package core.abstracts;

public interface CheckService {
	boolean checkPassword (String password);
	boolean checkEmail (String email);
	boolean checkFirstName (String fristName);
	boolean checkLastName (String lastName);

}
