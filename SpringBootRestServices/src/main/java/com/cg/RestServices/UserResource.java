package com.cg.RestServices;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserService service;

	//@RequestMapping(method = RequestMethod.GET,value = "/users")
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers() {
		System.out.println("inside retrieveAllUsers() of Controller");
		return service.findAll();
	}

	/*
	 * @GetMapping(path="/users/{id}") public User findbyid(int id) {
	 * System.out.println("inside findbyid() of controller"); 
	 * User user=service.findOne(id);
	 * return user;
	 * }
	 */
	
	@GetMapping(path="/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        System.out.println("inside retrieveUser() of Controller" );
        User user = service.findOne(id);
        System.out.println("returned user " + user);
       
        if(user == null) {
            System.out.println("going to throw an Exception");
            throw new UserNotFound("id-" + id);  }
        return user;
    }
	
	@PostMapping(path="/users")
    public void createUser(@Valid@RequestBody User user) {
        System.out.println("inside createUser() of Controller" );
        User savedUser = service.Save(user);
    }
	
	@DeleteMapping(path="/users/{id}")
    public void deleteUser(@PathVariable int id) {
            service.delete(id); }
}
