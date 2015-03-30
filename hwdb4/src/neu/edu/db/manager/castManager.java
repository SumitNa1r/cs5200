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

import edu.neu.db.objects.cast;

public class castManager {
	
	DataSource ds;
	String add_cast = "INSERT INTO cast (actor_id, movie_id, character_name)"
			+ " VALUES (?,?,?);";
	String read_all = "select * from cast";
	String read_for_actor = "select * from cast where actor_id = ?;";
	String read_for_movie = "select * from cast where movie_id = ?;";
	String read_for_id = "select * from cast where id = ?;";
	String update_cast = "update cast set actor_id = ?, movie_id = ?, character_name = ? where id = ?";
	String delete_cast = "delete from cast where id = ?";
	
	public void updateComment(int cid, cast c)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(update_cast);
			
			statement.setString(1, c.getMovie_id());
			statement.setString(2, c.getActor_id());
			statement.setString(3, c.getCharacter_name());
			statement.setInt(4, cid);
			statement.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteComment(int cid) {
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(delete_cast);
			statement.setInt(1, cid);	
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<cast> readIdCast(int id)
	{
		List<cast> c = new ArrayList<cast>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_for_id);
			statement.setInt(1, id);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				cast c1 = new cast (
						results.getInt("id"),
						results.getString("movie_id"),
						results.getString("actor_id"),
						results.getString("character_name"));
				c.add(c1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public List<cast> readMovieCast(String mid)
	{
		List<cast> c = new ArrayList<cast>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_for_movie);
			statement.setString(1, mid);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				cast c1 = new cast (
						results.getInt("id"),
						results.getString("movie_id"),
						results.getString("actor_id"),
						results.getString("character_name"));
				c.add(c1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public List<cast> readActorCast(String aid)
	{
		List<cast> c = new ArrayList<cast>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_for_actor);
			statement.setString(1, aid);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				cast c1 = new cast (
						results.getInt("id"),
						results.getString("movie_id"),
						results.getString("actor_id"),
						results.getString("character_name"));
				c.add(c1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public List<cast> readAllCast()
	{
		List<cast> c = new ArrayList<cast>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				cast c1 = new cast (
						results.getInt("id"),
						results.getString("movie_id"),
						results.getString("actor_id"),
						results.getString("character_name"));
				c.add(c1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public boolean  createCast(cast c)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(add_cast);
			statement.setString(1, c.getActor_id());
			statement.setString(2, c.getMovie_id());
			statement.setString(3, c.getCharacter_name());
			statement.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public castManager()
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
