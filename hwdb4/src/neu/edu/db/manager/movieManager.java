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

import edu.neu.db.objects.movie;

public class movieManager {
	DataSource ds;
	String read_all = "select * from movie";
	String read_movie = "select * from movie where movie_id = ?";
	String update_movie = "update movie set title = ?, poster = ?, releaseDate = ? where movie_id = ?";
	String delete_movie = "delete from movie where movie_id = ?";
	String add_movie = "INSERT INTO movie (movie_id, title, poster, releaseDate)"
			+ " VALUES (?,?,?,?);";
	
	public void updateMovie(String movieId, movie m)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(update_movie);
			
			statement.setString(1, m.getTitle());
			statement.setString(2, m.getPoster());
			statement.setString(3, m.getReleaseDate());
			statement.setString(4, movieId);
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteMovie(String movieId){
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(delete_movie);
			statement.setString(1, movieId);	
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public movie readMovie(String movieId)
	{
		movie m = new movie();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_movie);
			statement.setString(1, movieId);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				m = new movie (
						results.getString("movie_id"),
						results.getString("title"),
						results.getString("poster"),
						results.getString("releaseDate"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	
	public List<movie> readAllMovie()
	{
		List<movie> m = new ArrayList<movie>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				movie m1 = new movie (
						results.getString("movie_id"),
						results.getString("title"),
						results.getString("poster"),
						results.getString("releaseDate"));
				m.add(m1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	
	public boolean  createMovie(movie m)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(add_movie);
			statement.setString(1, m.getId());
			statement.setString(2, m.getTitle());
			statement.setString(3, m.getPoster());
			statement.setString(4, m.getReleaseDate());
			statement.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public movieManager()
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
