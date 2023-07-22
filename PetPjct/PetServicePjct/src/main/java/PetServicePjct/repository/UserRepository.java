package PetServicePjct.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PetServicePjct.entity.UserRegistration;

@Repository
public interface UserRepository extends JpaRepository<UserRegistration, Long> {

	Optional<UserRegistration> findByEmail(String email);

	Optional<UserRegistration> findByMobile(Long mobile);

	UserRegistration findByPassword(String password);


	

	

}
