<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:maintemplate pagetitle="Hello the World!" tabtitle="HelloWorld">
    <style type="text/css">
       h1, em
       {
           color:<c:out value="${param.color}"/>;
       }
     </style>
     <div class="path">  <!-- Chemin de la page actuelle dans le site -->
         <a href="home">Accueil</a> > <a href="helloworld"> HelloWorld</a>
     </div>
     
     <aside id="menulocal">  <!-- Menu local -->
         <h2>Hello World</h2>
         <ul>
             <li>Visualisation</li>
             <ul>
                 <li><a href="helloworld">Version normale</a></li>
                 <li><a href="helloworld?color=grey">Version grise</a></li>
                 <li><a href="helloworld?color=magenta">Version magenta</a></li>
                 <li><a href="helloworld?color=yellow">Version jaune</a></li>
                 <li><a href="helloworld?color=green">Version verte</a></li>
             </ul>
         </ul>
     </aside>

     <section>
        <em>2 lignes en JavaEE</em><br/>
        <em>1 troisieme lignes en JavaEE</em><br/>
        <form method="post" action="helloworld"><label for="colortext">Entrer la couleur</label><input type="text" id="colortext" name="color"/><input type="submit"/></form>
        <hr/>
        <h2>Affichage des usagers en Forward</h2>
        <a href="userlist">Affichage des utilisateurs en forward</a>
     </section>
</t:maintemplate>
