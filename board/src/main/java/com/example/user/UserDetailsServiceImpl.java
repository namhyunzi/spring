package com.example.user;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> optional =  userRepository.findByUsername(username);
		/*
		 * Optional<T>의 orElseThrow() 메소드
		 * 		- Optional 객체의 T타입의 객체가 존재하면 그 객체를 반환한다.
		 * 		- Optional 객체의 T타입의 객체가 존재하지 않으면 예외를 던진다.
		 * 		- 사용예
		 * 			User user = optional.orElseThrow();
		 * 				+ Optional 객체에 User 객체가 존재하면 User 객체를 반환하고, 존재하지 않으면 NoSuchElementException 예외를 던진다.
		 * 
		 * 			User user = optional.orElseThrow(() -> 사용자정의 예외객체 );
		 * 				+ Optional 객체에 User 객체가 존재하면 User 객체를 반환하고, 존재하지 않으면 사용자정의예외객체 예외를 던진다.
		 * 
		 * 		- orElseThrow(supplier<? extends X> exceptionSupplier)
		 * 				+ Supplier객체를 매개변수로 전달해야한다. Supplier는 인터페이스다. 
		 * 				+ orElseThrow(new Supplier() {
		 * 					 public UsrnameNotFoundException get() {
		 * 						return new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		 * 					 }
		 * 				})
		 * 				+ orElseThrow(() -> 구현코드);
		 */
		User user = optional.orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
		
		UserDetailsImpl userDetails = new UserDetailsImpl();
		userDetails.setUsername(user.getUsername());
		userDetails.setPassword(user.getPassword());
		/*
		 * authorities는 Collection<? extends GrantedAuthority> 타입이다.
		 * 		+ List.of(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN"))와 같
		 */
		userDetails.setAuthorities(List.of(new SimpleGrantedAuthority(user.getUserRole().name())));
		
		return userDetails;
	}

	
}
