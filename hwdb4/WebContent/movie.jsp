<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="neu.edu.db.manager.*" import="edu.neu.db.objects.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello World</h1>
<% 
    
 	movieManager mm = new movieManager();

    ///*
    //add user
	movie m = new movie();
	m.setId("Mov1");
	m.setTitle("Titanic");
	m.setPoster("www.titanic.com");
	m.setReleaseDate("1990-02-02");
	mm.createMovie(m);
	
	movie m1 = new movie();
	m1.setId("Mov2");
	m1.setTitle("SAW");
	m1.setPoster("www.saw.com");
	m1.setReleaseDate("1990-01-02");
	mm.createMovie(m1);
	//*/
	
	///*
	//read all user
	List<movie> m2 = mm.readAllMovie();
	
	for(int i=0; i<m2.size(); i++)
	{
		System.out.println(m2.get(i).getId());
	}
	//*/
	
	//*
	//read single user
	movie m3 = mm.readMovie("Mov1");
	System.out.println(m3.getId());
	//*/
	
	//*
	//update user
	movie m4 = new movie();
	m4.setId("Mov2");
	m4.setTitle("SAW2");
	m4.setPoster("www.saw2.com");
	m4.setReleaseDate("1992-01-02");
	mm.updateMovie("Mov2", m4);
	//*/
	
	//delete from user
	mm.deleteMovie("Mov1");
%>
</body>
</html>