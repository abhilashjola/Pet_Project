package PetServicePjct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PetServicePjct.Exception.PasswordNotMatched;
import PetServicePjct.Exception.UserExistException;
import PetServicePjct.dto.UserRequest;
import PetServicePjct.entity.UserRegistration;
import PetServicePjct.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public UserRegistration saveDtls(UserRequest userRequest ) throws  UserExistException,PasswordNotMatched {
			UserRegistration user=new UserRegistration();
			if(repo.findByEmail(userRequest.getEmail()).isPresent()||repo.findByMobile(userRequest.getMobile()).isPresent())
			{
				throw new UserExistException("your already registered with us");
			}
			else
			{	
				if(userRequest.getPassword().equals(userRequest.getConfirmPassword()))
				{
					user.setEmail(userRequest.getEmail());
					user.setFirstName(userRequest.getFirstName());
					user.setLastName(userRequest.getLastName());
					user.setMobile(userRequest.getMobile());
					user.setPassword(userRequest.getPassword());
					return repo.save(user);
				}
				else
				{
					throw new PasswordNotMatched("password and confirmpassword must be same");
				}
			}
	}

	
	
	
}

	