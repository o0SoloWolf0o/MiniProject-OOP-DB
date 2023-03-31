package com.miniproject.miniproject;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	private User user;

	public CustomUserDetails(User user) {
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return authorities;
	}

	public boolean hasRole(String roleName) {
		return this.user.hasRole(roleName);
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	public String getTelphone() {
	    return user.getTelphone();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

	public String getFullName() {
		return user.getFirstname() + " " + user.getLastname();
	}

	public void setFirstname(String firstname) {
		user.setFirstname(firstname);
	}

	public void setLastname(String lastname) {
		user.setLastname(lastname);
	}

}
