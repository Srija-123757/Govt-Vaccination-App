  package project.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.springboot.exception.ResourceNotFoundException;
import project.springboot.model.User;  
import project.springboot.repository.AdminRepository;


@RestController
@CrossOrigin(origins="http://localhost:62062/")
@RequestMapping //standard version of api
public class AdminController {
 
	@Autowired
	private AdminRepository adminRepository;
	
	//get all users
	@GetMapping("/users")

	public List<User> getAllUsers(){
		
		return adminRepository.findAll();
	}
	
	
	
	//create user rest api
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return adminRepository.save(user);
	}
	
	
	//get employee by id
	@GetMapping("/users/{id}")
	public ResponseEntity<User>getUserById(@PathVariable Long id)
	{
		User user=adminRepository.findById(id).orElseThrow(()->
		   new ResourceNotFoundException("Employee not exists with id:"+id));
		return  ResponseEntity.ok(user);
	}
	
	
	
	//edit user rest api
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User userDetails){
		User user=adminRepository.findById(id).orElseThrow(()->
		   new ResourceNotFoundException("User not exists with id:"+id));
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmailid(userDetails.getEmailid());
		
		User updatedUser =adminRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	
	//delete employee rest api
	@DeleteMapping("/users/{id}")
	public ResponseEntity <Map<String,Boolean>> delUser(@PathVariable Long id)
	{	
		User user=adminRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("User not exists with id:"+id));
		
		adminRepository.delete(user);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return  ResponseEntity.ok(response);
	}
}
