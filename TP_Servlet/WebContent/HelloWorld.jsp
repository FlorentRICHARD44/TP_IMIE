<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="CSS/tpservlet.css"/>
		<style type="text/css">
		  h1, em
		  {
		      color:<%= request.getParameter("color")%>;
		  }
		</style>
		<title>HelloWorld</title>
	</head>
	<body>
	   <h1>HELLO THE WORLD!</h1>
	   <jsp:include page="menu.jsp" />
	   <em>2 lignes en JavaEE</em><br/>
	   <em>1 troisieme lignes en JavaEE</em><br/>
	   <a href="HelloWorld.jsp">Same page in normal color</a><br/>
	   <a href="HelloWorld.jsp?color=grey" style="color:grey">Same page in grey</a><br/>
	   <a href="HelloWorld.jsp?color=magenta" style="color:magenta">Same page in magenta</a><br/>
       <a href="HelloWorld.jsp?color=yellow" style="color:yellow">Same page in yellow</a><br/>
       <a href="HelloWorld.jsp?color=green" style="color:green">Same page in gree</a><br/>
       <a href="HelloWorld.jsp?color=%231C325B" style="color:#1C325B">Same page in cyberbase color</a><br/>
       <form method="get" action="HelloWorld.jsp"><label for="colortext">Entrer la couleur</label><input type="text" id="colortext" name="color"/><input type="submit"/></form>
       <hr/>
       <h2>Affichage des usagers en Forward</h2>
       <a href="/TP_Servlet/UserListGetterServlet">Affichage des utilisateurs en forward</a>
    </body>
</html>
