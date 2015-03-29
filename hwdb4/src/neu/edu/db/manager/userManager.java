package neu.edu.db.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;







import edu.neu.db.objects.user;

public class userManager {
	DataSource ds;
	
	
	String add_user = "INSERT INTO user (username, password, first_name, last_name, email, dob )"
			+ " VALUES (?,?,?,?,?,?);";
	
	String read_all = "select * from user";
	String read_user = "select * from user where username = ?";
	String update_user = "update user set password = ?, first_name = ?, last_name = ?, email = ?, dob = ? where username = ?";
	String delete_user = "delete from user where username = ?";
	
	public userManager()
	{
		try {
			Context jndi = new InitialContext();
			ds = (DataSource) jndi.lookup("java:comp/env/jdbc/dbhw4db");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean  createUser(user u)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(add_user);
			statement.setString(1, u.getUsername());
			statement.setString(2, u.getPassword());
			statement.setString(3, u.getFname());
			statement.setString(4, u.getLname());
			statement.setString(5, u.getEmail());
			statement.setString(6, u.getDob());
			statement.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<user> readAllUsers()
	{
		List<user> u = new ArrayList<user>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				user u1 = new user (
						results.getInt("id"),
						results.getString("username"),
						results.getString("password"),
						results.getString("first_name"),
						results.getString("last_name"),
						results.getString("email"),
						results.getString("dob")
						);
				u.add(u1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	
	public user readUser(String uname)
	{
		user u1 = new user();
		try{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_user);
			statement.setString(1, uname);
			ResultSet results = statement.executeQuery();
			if(results.next())
			{
				u1 = new user (
						results.getInt("id"),
						results.getString("username"),
						results.getString("password"),
						results.getString("first_name"),
						results.getString("last_name"),
						results.getString("email"),
						results.getString("dob")
						);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u1;
	}
	
	public void updateUser(String uname, user u)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(update_user);
			
			statement.setString(1, u.getPassword());
			statement.setString(2, u.getFname());
			statement.setString(3, u.getLname());
			statement.setString(4, u.getEmail());
			statement.setString(5, u.getDob());
			statement.setString(6, uname);
			
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String uname){
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(delete_user);
			statement.setString(1, uname);	
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
