package com.cg.RestServices;

import java.util.List;
import java.util.Optional;

public interface UserDao {

	public List<User> findAll();

	public Optional<User> findById(int id);
	//public User findById(int id);

	public User save(User user);

	public User deleteById(int id);
}
