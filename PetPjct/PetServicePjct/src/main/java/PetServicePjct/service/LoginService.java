package PetServicePjct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PetServicePjct.Exception.UserDoesNotExist;
import PetServicePjct.entity.UserRegistration;
import PetServicePjct.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository repo;
	public String loginDtls(String email, String password) throws UserDoesNotExist {
		if(repo.findByEmail(email).isPresent())
		{
			UserRegistration user = repo.findByEmail(email).get();
			if(user.getPassword().equals(password))
			{
				return "Login Successful";
			}
			else
			{
				throw new UserDoesNotExist("Invalid  Password");
			}
		}
		else
		{
			throw new UserDoesNotExist("Invalid Email ");
		}
	}
	
}
