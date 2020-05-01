package com.cg.RestServices;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository(value = "inmemory")
@Profile("dev")
public class UserInmemoryRepository implements UserDao {

	public UserInmemoryRepository() {
		System.out.println("in constructor of UserInmemoryRepository");
	}

	private static List<User> users = new ArrayList<User>();
	private static int userCount = 3;

	static {
		users.add(new User(10, "Amit", new Date()));
		users.add(new User(11, "Sumit", new Date()));
		users.add(new User(12, "Rahul", new Date()));
	}

	public List<User> findAll() { // select *from
		System.out.println("inside findAll() of In-Memory Repository");
		return users;
	}

	/*
	 * public User findById(int id) {
	 * System.out.println("inside findById() of In-Memory Repository"); for(User
	 * user : users) { if(user.getId() == id) return user; } return null; }
	 */

	public Optional<User> findById(int id) {
		User user = users.stream().filter(a -> a.getId() == id).findAny().orElse(null);
		Optional<User> opt = Optional.ofNullable(user);
		return opt;
	}

	public User save(User user) {
		System.out.println("inside save() of In-Memory Repository");
		users.add(user);
		System.out.println(users);
		return user;
	}

	/*
	 * public User deletebyID(User user) {
	 * System.out.println("inside save() of In-Memory Repository");
	 * users.remove(user); System.out.println(users); return user; }
	 */

	public User deleteById(int id) {
		// use Iterator to delete in between
		Iterator<User> iter = users.iterator();
		while (iter.hasNext()) {
			User user = iter.next();
			if (user.getId() == id) {
				iter.remove();
				return user;
			}
		}
		return null;
	}
}
