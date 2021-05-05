package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sample.entities.UserDB;
import sample.repositories.UserRepository;

import java.util.function.Supplier;

@Service
public class JpaUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Supplier<UsernameNotFoundException> s =
				() -> new UsernameNotFoundException(
						"Problem during authentication!"
				);


		UserDB u = userRepository.findUserById(username).orElseThrow(s);
		return User.withUsername(u.getName())
				.password(u.getPassword())
				.roles(u.getRole()).build();
		//return new CustomUserDetails(u);
	}
}
