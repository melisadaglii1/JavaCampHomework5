package core.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import core.abstracts.CheckService;

public class CheckManager implements CheckService{
	public static String regex = "[// q -_ . +] * [ \\q - _ \\\\ .] \\\\ @ ([ \\ q] + \\ .) + [ \\ q ] + [ \\ q] $";

	@Override
	public boolean checkPassword(String password) {
		if (password.length() < 6) {
			System.out.println("paralo en az 6 karakterli olmalýdýr.");
			return false;
		}
	
	return true;
	}


	@Override
	public boolean checkEmail(String email) {
		
		Pattern pattern = Pattern.compile(regex);
		pattern.matcher(email); {
		  System.out.println("uygun e postayý normal ifade biçiminde girmediniz. ");
		return false;
	}
		
	}
	@Override
	public boolean checkFirstName(String fristName) {
		if (fristName.length() < 2) {
			System.out.println("Adýnýz en az 2 karakterli olmalýdýr. ");
		return false;
	}
	return true;
	}

	@Override
	public boolean checkLastName(String lastName) {
		if (lastName.length() <2 ) {
			System.out.println("Soyadýnýz en az 2 karakterli olmalýdýr. ");
		  return false;
	}
	return true;
	}
}


