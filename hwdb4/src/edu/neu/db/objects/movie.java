package edu.neu.db.objects;

public class movie {
	private String id;
	private String title;
	private String poster;
	private String releaseDate;
	public movie(String id, String title, String poster, String release) {
		super();
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.releaseDate = release;
	}
	public movie() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String release) {
		this.releaseDate = release;
	}
	
	
}
