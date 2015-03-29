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

import edu.neu.db.objects.actor;

public class actorManager {

	DataSource ds;
	
	String read_all = "select * from actor";
	String read_actor = "select * from actor where actor_id = ?";
	String update_actor = "update actor set first_name = ?, last_name = ?, dob = ? where actor_id = ?";
	String delete_actor = "delete from actor where actor_id = ?";
	String add_actor = "INSERT INTO actor (actor_id, first_name, last_name, dob)"
			+ " VALUES (?,?,?,?);";
	
	public void updateActor(String actorId, actor a)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(update_actor);
			
			statement.setString(1, a.getFirst_name());
			statement.setString(2, a.getLast_name());
			statement.setString(3, a.getDob());
			statement.setString(4, actorId);
			statement.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteActor(String actorId){
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(delete_actor);
			statement.setString(1, actorId);	
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public actor readActor(String actorId)
	{
		actor a = new actor();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_actor);
			statement.setString(1, actorId);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				a = new actor (
						results.getString("actor_id"),
						results.getString("first_name"),
						results.getString("last_name"),
						results.getString("dob"));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public List<actor> readAllActor()
	{
		List<actor> m = new ArrayList<actor>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				actor a1 = new actor (
						results.getString("actor_id"),
						results.getString("first_name"),
						results.getString("last_name"),
						results.getString("dob"));
				m.add(a1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	
	public boolean  createActor(actor a)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(add_actor);
			statement.setString(1, a.getId());
			statement.setString(2, a.getFirst_name());
			statement.setString(3, a.getLast_name());
			statement.setString(4, a.getDob());
			statement.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public actorManager()
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
