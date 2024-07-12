package com.unla.stocksystem.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unla.stocksystem.entity.User;
import com.unla.stocksystem.entity.UserRole;
import com.unla.stocksystem.repositories.IUserRepository;
@Service("UserService")
public class UserService {
	private IUserRepository userRepository;

	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findUsers() {
		List<User> users = new ArrayList<User>();
		users = (List<User>) userRepository.findUsers();
		return users;
	}

	public List<User> findAdmins() {
		List<User> admins = new ArrayList<User>();
		admins = (List<User>) userRepository.findAdmins();
		return admins;
	}

	public User findUserByUsername(String username) {
		User user = userRepository.findByUsernameAndFetchUserRolesEagerly(username);
		return user;
	}
	//ajustado para un Rol
	/*public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = userRepository.findByUsernameAndFetchUserRolesEagerly(username);
		return buildUser(user, buildGrantedAuthorities(user.getUserRole()));
	}

	private User buildUser(User user, List<GrantedAuthority> grantedAuthorities) {
		return new User(user.getUserName(), user.getPassword(), user.isEnabled(), true, true, true, grantedAuthorities);
	}

	private List<GrantedAuthority> buildGrantedAuthority(UserRole userRole) {
	    List<GrantedAuthority> authorities = new  ArrayList<>();
	    authorities.add(new SimpleGrantedAuthority(userRole.getNameRole()));
	    return authorities;
	}*/
}
