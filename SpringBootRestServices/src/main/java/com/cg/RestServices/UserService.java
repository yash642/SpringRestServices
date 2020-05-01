package com.cg.RestServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	// private UserInmemoryRepository userRepos;
	@Autowired
	// @Qualifier(value="datajpa")
	private UserDao userRepos;

	public List<User> findAll() {
		System.out.println("inside findAll() of Service");
		return userRepos.findAll();
	}

	/*
	 * public User findOne(int id) { //commented due to UserJpaRepository
	 * System.out.println("inside findOne(id) of Service"); User user =
	 * userRepos.findById(id); return user;
	 * 
	 * //Optional<User> user = userRepos.findById(id);
	 * System.out.println("returning from findOne() of Service"); // return
	 * user.get();
	 * 
	 * User user = userRepos.findById(id); return user;
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	public User findOne(int id) {
        System.out.println("inside findOne(id) of Service");
        Optional<User> user = userRepos.findById(id);
        System.out.println("returning from findOne() of Service");
        return user.get();
    }

	public User Save(User user) {
		System.out.println("inside save() of Service");
		User u = userRepos.save(user);
		return u;
	}

	public void delete(int id) {
		System.out.println("inside delete() of service");
		userRepos.deleteById(id);
	}
}
