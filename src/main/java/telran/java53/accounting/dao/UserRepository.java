package telran.java53.accounting.dao;


import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.java53.accounting.model.User;
import telran.java53.post.model.Post;

public interface UserRepository extends MongoRepository<User, String> {
	
	Stream<User> findByLoginIgnoreCase(String login);
	
	Stream<User> findByFirstNameIgnoreCase(String firstName);
	
	Stream<User> findByLastNameIgnoreCase(String lastName);
	
	Stream<Post> findByRolesInIgnoreCase(List<String> roles);

	

}
