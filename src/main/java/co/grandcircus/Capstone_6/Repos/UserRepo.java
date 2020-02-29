package co.grandcircus.Capstone_6.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import co.grandcircus.Capstone_6.Entities.User;

public interface UserRepo extends JpaRepository<User, Long>{

	User findByUsernameIgnoreCase(String username);
	
}
