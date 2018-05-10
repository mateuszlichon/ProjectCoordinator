package com.lichon.projectcoordinator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import com.lichon.projectcoordinator.domain.Authorities;
import com.lichon.projectcoordinator.domain.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements UserDetailsService {

	  @Autowired
	  private DataSource dataSource;
	  private JdbcTemplate jdbcTemplate;
	  
		public UserDetails loadUserByUsername(String username)
	      throws UsernameNotFoundException
	  {
			String sql = "select * from users where username = ?";
			Users user = (Users)getJdbcTemplate().query(sql, new Object[] { username }, new RowMapper<Users>()
			{
				public Users mapRow(ResultSet rs, int rowNum) throws SQLException
	      {
					Users user = new Users();
					if (user.getUsername() == null)
					 user.setUsername(rs.getString("username"));
					if (user.getPassword() == null)
					  user.setPassword(rs.getString("password"));
					return user;
	      }
			});
			
			sql = "select authority from authorities where username = ?";
			List<String> authorities = getJdbcTemplate().queryForList(sql, new Object[] {username}, String.class);
			Set<Authorities> userAuths = new HashSet<Authorities>();
			for (String authority : authorities)
			{
				userAuths.add(new Authorities(username, authority));
			}
			user.setAuthorities(userAuths);
			return user;
	  }

		private JdbcTemplate getJdbcTemplate ()
		{
			if (this.jdbcTemplate == null)
				return new JdbcTemplate(dataSource);
			else 
				return jdbcTemplate;
		}
	}