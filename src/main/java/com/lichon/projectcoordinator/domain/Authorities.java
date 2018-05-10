package com.lichon.projectcoordinator.domain;

import org.springframework.security.core.GrantedAuthority;

public class Authorities implements GrantedAuthority {

	private static final long serialVersionUID = 1541085641252592687L;
	private String username;
	private String authority;

	public String getAuthority() {
		return this.authority;
	}

	public String getUsername() {
		return username;
	}

}
