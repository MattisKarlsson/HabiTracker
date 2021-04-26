package com.services;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailService {

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		final Optional<User> optionalUser = userRepository.findByUsername(username);
		
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			throw new UsernameNotFoundException(MessageFormat.format("User {0} cannot be found.", username));
		}
	}
}
