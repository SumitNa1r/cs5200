package edu.neu.db.objects;

public class cast {
	private int id;
	private String movie_id;
	private String actor_id;
	private String character_name;
	public cast(int id, String movie_id, String actor_id, String character_name) {
		super();
		this.id = id;
		this.movie_id = movie_id;
		this.actor_id = actor_id;
		this.character_name = character_name;
	}
	public cast() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public String getActor_id() {
		return actor_id;
	}
	public void setActor_id(String actor_id) {
		this.actor_id = actor_id;
	}
	public String getCharacter_name() {
		return character_name;
	}
	public void setCharacter_name(String character_name) {
		this.character_name = character_name;
	}
	
	
}
