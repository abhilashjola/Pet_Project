package PetServicePjct.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import PetServicePjct.Exception.PasswordNotMatched;
import PetServicePjct.Exception.UserDoesNotExist;
import PetServicePjct.Exception.UserExistException;
import PetServicePjct.dto.UserRequest;
import PetServicePjct.entity.UserRegistration;
import PetServicePjct.service.LoginService;
import PetServicePjct.service.UserService;
import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService us;

	@Autowired
	private LoginService ls;

	
	/* Registration Controller*/
	
	@PostMapping("/save")
	public ResponseEntity<UserRegistration> insert(@RequestBody @Valid UserRequest userRequest)throws UserExistException, PasswordNotMatched{
		
		return new ResponseEntity<>(us.saveDtls(userRequest),HttpStatus.NOT_FOUND);
		
	}

	
	
	
	/* login controller*/
	
	@PostMapping("/loginSave")
	public ResponseEntity<String> loginDtls(@RequestParam String email,@RequestParam String password)throws UserDoesNotExist{
		 
		return new ResponseEntity<>(ls.loginDtls(email, password),HttpStatus.BAD_REQUEST); 
	}

}
	

