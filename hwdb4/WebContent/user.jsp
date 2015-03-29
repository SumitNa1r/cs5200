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
    
 	userManager um = new userManager();

    /*
    //add user
	user u = new user();
	u.setUsername("user2");
	u.setPassword("12345");
	u.setFname("fname2");
	u.setLname("lname2");
	u.setEmail("email@2.com");
	u.setDob("1990-02-02");
	um.createUser(u);
	*/
	
	/*
	//read all user
	List<user> u1 = um.readAllUsers();
	
	for(int i=0; i<u1.size(); i++)
	{
		System.out.println(u1.get(i).getEmail());
	}
	*/
	
	/*
	//read single user
	user u2 = um.readUser("user2");
	System.out.println(u2.getEmail());
	*/
	
	/*
	//update user
	user u = new user();
	u.setUsername("user3");
	u.setPassword("123456");
	u.setFname("fname3");
	u.setLname("lname2");
	u.setEmail("email@2.com");
	u.setDob("1990-02-02");
	um.updateUser("user2", u);
	*/
	
	//delete from user
	um.deleteUser("user2");
%>
</body>
</html>