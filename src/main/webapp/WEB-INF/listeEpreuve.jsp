<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>

<html lang="fr">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta  http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="starter-template.css">
    <title>Liste des preuves</title>
  </head>
  <body style="cursor: url(cursor.svg), auto;background-image:linear-gradient(to right,black,#14213D,#213C56,#43553D);color:white;">
<%@ include file="menu.jsp" %>
<main role="main" class="container">

  <div class="starter-template">
    <h1>Liste des Épreuves</h1>
    <h4 class="lead">Bienvenue .... <c:out value="${connectedUser.getLogin()}"/>

    </h4>
     <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolor.</p>
  </div>

</main><!-- /.container -->
<div class="container">

<div style="    padding: 1.5rem;    margin-right: 0;    margin-left: 0;    border-width: .2rem;">
<a style="width:100px;" class="btn btn-primary" href="/TennisWebApp/ajouterTournoi" role="button">Ajouter un tournoi</a>
</div>

<table class="table" style="color: white;">
  <thead>
    <tr>
      <th scope="col" style="width:10%">#</th>
      <th scope="col" style="width:25%">Année</th>
      <th scope="col" style="width:20%">Type d'épreuve</th>
      <th scope="col" style="width:20%">ID Tournoi</th>
	  <th scope="col" style="width:20%"></th>
    </tr>
  </thead>
  <tbody>
   <c:if test="${list.size() == 0}" >Aucune occurrence trouvée</c:if>     
   <c:if test="${list.size() != 0}" >
		<c:forEach items="${list}" var="epreuve">
	   		<!-- form action="modifierJoueur" method="get"-->
		   		<tr>
			      <th scope="row"> <c:out value="${epreuve.id}" /> </th>
			      <td> <c:out value="${epreuve.annee}" /> </td>
			      <td> <c:out value="${epreuve.type}" /> </td>
			      <td> <c:out value="${epreuve.idTournoi}" /> </td>
				  <td>
				    <a type="button" class="btn btn-outline-primary" href="/TennisWebApp/modifierEpreuve?id=${epreuve.id}" role="button">Modifier</a>
					<a type="submit" class="btn btn-outline-warning" href="/TennisWebApp/supprimerEpreuve?id=${epreuve.id}"role="button">Supprimer</a>
				  </td>
			  	</tr>
		  	<!--/form-->
		</c:forEach>
	</c:if>
  </tbody>
</table>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>


