package com.lichon.projectcoordinator.domain;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Users implements UserDetails {

	private static final long serialVersionUID = -3090950600086804816L;
	private String username;
	private String password;
	private Set<Authorities> authorities;

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}

}
