package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	
	public List<User> Users = new ArrayList<User>();

	@Override
	public void add(User user) {
		this.Users.add(user);
		System.out.println("Kullanýcý veritabanýna eklendi. Kullanýcý :  " + user.getFirstName());
		
	}

	@Override
	public void delete(User user) {
		this.Users.remove(user);
		System.out.println("Kullanýcý veritabanýndan silindi. Kullanýcý :  " + user.getFirstName());
		
		
	}

	@Override
	public List<User> getAll() {
		
	    return this.Users;
	}

	@Override
	public boolean eMailExits(User user) {
		for (User person : Users)
			if(person.geteMail() == user.geteMail()) {
				return false;
			}
			
		return true;
	}

}
