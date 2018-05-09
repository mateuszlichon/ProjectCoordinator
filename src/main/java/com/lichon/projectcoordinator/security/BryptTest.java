package com.lichon.projectcoordinator.security;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BryptTest {

	@Test
	public void bcryptTest() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode("a");
		System.out.println(encodedPassword);
	}
}
