package com.swag.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swag.test.domain.Users;
import com.swag.test.repository.UserJPARepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired private UserJPARepository userJpaRepository;
	
	
	  @RequestMapping(value = "/all", method = RequestMethod.GET)
	    public List<Users> all() {
	        return userJpaRepository.findAll();
	    }

	  @RequestMapping(value = "/{givenName}", method = RequestMethod.GET)
	    public Users byName(@PathVariable final
	    		  String givenName) {
	        return userJpaRepository.findByName(givenName);
	    }
	  
		 @PostMapping(value = "/load") public Users load( final Users users) {
			 userJpaRepository.save(users); return
			 userJpaRepository.findByName(users.getName()); }
			
	 
}
