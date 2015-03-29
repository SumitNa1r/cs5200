<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="neu.edu.db.manager.*" import="edu.neu.db.objects.*" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
 	<h1>Hello World</h1>
<% 
    
 	actorManager am = new actorManager();

    ///*
    //add user
	actor a = new actor();
	a.setId("Act1");
	a.setFirst_name("Tom");
	a.setLast_name("Cruise");
	a.setDob("1990-02-02");
	am.createActor(a);
	
	actor a1 = new actor();
	a1.setId("Act2");
	a1.setFirst_name("Brad");
	a1.setLast_name("Pitt");
	a1.setDob("2000-02-02");
	am.createActor(a1);
	//*/
	
	///*
	//read all user
	List<actor> a2 = am.readAllActor();
	
	for(int i=0; i<a2.size(); i++)
	{
		System.out.println(a2.get(i).getId());
	}
	//*/
	
	//*
	//read single user
	actor a3 = am.readActor("Act1");
	System.out.println(a3.getId());
	//*/
	
	//*
	//update user
	actor a4 = new actor();
	a4.setId("Act2");
	a4.setFirst_name("Braddddd");
	a4.setLast_name("Pittttt");
	a4.setDob("1960-01-02");
	am.updateActor("Act2", a4);
	//*/
	
	//delete from user
	am.deleteActor("Act1");
%>
 
</body>
</html>