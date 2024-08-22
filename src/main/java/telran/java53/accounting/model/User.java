package telran.java53.accounting.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import telran.java53.post.model.Comment;
import telran.java53.post.model.Post;

@Getter
@EqualsAndHashCode(of = "login")
@NoArgsConstructor
@Document(collection = "users")
public class User {
	String login;
	@Setter
	String firstName;
	@Setter
	String lastName;
	@Singular
	Set<String> roles = new HashSet<>();
	
	public User(String firstName, String lastName, Set<String> roles) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
	}
	
	public boolean addRoles(String role) {
		return roles.add(role);
	}

	public boolean removeRoles(String role) {
		return roles.remove(role);
	}
	
	

}
