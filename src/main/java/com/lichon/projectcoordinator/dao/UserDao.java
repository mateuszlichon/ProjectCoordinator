package com.lichon.projectcoordinator.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lichon.projectcoordinator.domain.Users;

public class UserDao implements UserDetailsService {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate template;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String sql = "select * from users where username = ?";
		Users users = getJdbcTemplate().queryForObject(sql, new Object[] {username}, Users.class);
		return users;
	}
	
	private JdbcTemplate getJdbcTemplate() {
		if (template == null) {
			return new JdbcTemplate(dataSource);
		} else {
			return this.template;
		}
	}

}
