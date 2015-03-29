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

import edu.neu.db.objects.comment;

public class commentManager {

	DataSource ds;
	
	String add_comment = "INSERT INTO actor (username, movie_id, commnet, date)"
			+ " VALUES (?,?,?,?);";
	String read_all = "select * from comment";
	String read_for_user = "select * from comment where username = ?;";
	String read_for_movie = "select * from comment where movie_id = ?;";
	String read_for_id = "select * from comment where id = ?;";
	String update_comment = "update comment set username = ?, movie_id = ?, comment = ?, dob = ? where id = ?";
	String delete_comment = "delete from comment where id = ?";
	
	
	public void updateComment(int cid, comment c)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(update_comment);
			
			statement.setString(1, c.getUsername());
			statement.setString(2, c.getMovie_id());
			statement.setString(3, c.getComment());
			statement.setString(4, c.getDate());
			statement.setInt(5, cid);
			statement.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteComment(int cid) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(delete_comment);
			statement.setInt(1, cid);	
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<comment> readIdComment(int cid)
	{
		List<comment> c = new ArrayList<comment>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_for_id);
			statement.setInt(1, cid);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				comment c1 = new comment (
						results.getInt("id"),
						results.getString("username"),
						results.getString("movie_id"),
						results.getString("comment"),
						results.getString("date"));
				c.add(c1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public List<comment> readMovieComment(String mid)
	{
		List<comment> c = new ArrayList<comment>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_for_movie);
			statement.setString(1, mid);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				comment c1 = new comment (
						results.getInt("id"),
						results.getString("username"),
						results.getString("movie_id"),
						results.getString("comment"),
						results.getString("date"));
				c.add(c1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public List<comment> readUserComment(String uname)
	{
		List<comment> c = new ArrayList<comment>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_for_user);
			statement.setString(1, uname);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				comment c1 = new comment (
						results.getInt("id"),
						results.getString("username"),
						results.getString("movie_id"),
						results.getString("comment"),
						results.getString("date"));
				c.add(c1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public List<comment> readAllComment()
	{
		List<comment> c = new ArrayList<comment>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				comment c1 = new comment (
						results.getInt("id"),
						results.getString("username"),
						results.getString("movie_id"),
						results.getString("comment"),
						results.getString("date"));
				c.add(c1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public boolean  createComment(comment c)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(add_comment);
			statement.setString(1, c.getUsername());
			statement.setString(2, c.getMovie_id());
			statement.setString(3, c.getComment());
			statement.setString(4, c.getDate());
			statement.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public commentManager()
	{
		try {
			Context jndi = new InitialContext();
			ds = (DataSource) jndi.lookup("java:comp/env/jdbc/dbhw4db");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
