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
    <title>Liste des Tournois</title>
  </head>
  <body style="cursor: url(cursor.svg), auto;background-image:linear-gradient(to right,black,#14213D,#213C56,#43553D);color:white;">
<%@ include file="menu.jsp" %>
<main role="main" class="container">

  <div class="starter-template">
    <h1>Liste des Tournois</h1>
    <h4 class="lead">Bienvenue .... <c:out value="${connectedUser.getLogin()}"/>

    </h4>
     <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolor.</p>
  </div>

</main><!-- /.container -->
<div class="container">

<div style="    padding: 1.5rem;    margin-right: 0;    margin-left: 0;    border-width: .2rem;">
<a class="btn btn-primary" href="/TennisWebApp/ajouterTournoi" role="button">Ajouter un tournoi</a>
</div>

<table class="table" style="color: white;">
  <thead>
    <tr>
      <th scope="col" style="width:10%">#</th>
      <th scope="col" style="width:25%">Nom</th>
      <th scope="col" style="width:20%">Code</th>
	  <th scope="col" style="width:20%"></th>
    </tr>
  </thead>
  <tbody>
   <c:if test="${list.size() == 0}" >Aucune occurrence trouvée</c:if>     
   <c:if test="${list.size() != 0}" >
		<c:forEach items="${list}" var="tournoi">
	   		<!-- form action="modifierJoueur" method="get"-->
		   		<tr>
			      <th scope="row"> <c:out value="${tournoi.id}" /> </th>
			      <td> <c:out value="${tournoi.nom}" /> </td>
			      <td> <c:out value="${tournoi.code}" /> </td>
				  <td>
				    <a style="width:100px;" type="button" class="btn btn-outline-primary" href="/TennisWebApp/modifierTournoi?id=${tournoi.id}" role="button">Modifier</a>
					<a style="width:100px;" type="submit" class="btn btn-outline-warning" href="/TennisWebApp/supprimerTournoi?id=${tournoi.id}"role="button">Supprimer</a>
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


<<<<<<< Updated upstream
=======
    <html lang="fr">

    <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
      <link rel="stylesheet" href="starter-template.css">
      <title>Liste des Tournois</title>
    </head>

    <body
      style="cursor: url(cursor.svg), auto;background-image:linear-gradient(to right,black,#14213D,#213C56,#43553D);color:white;">

      <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
          <img src="plogo.svg" style="width:35px;">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">Ajouter</a>
              <div class="dropdown-menu" aria-labelledby="dropdown01">
                <a class="dropdown-item" href="/TennisWebApp/ajouterJoueur">Ajouter un joueur</a>
                <a class="dropdown-item" href="/TennisWebApp/ajouterTournoi">Ajouter un tournoi</a>
                <a class="dropdown-item" href="/TennisWebApp/ajouterMatch">Ajouter un match</a>
                <a class="dropdown-item" href="/TennisWebApp/ajouterEpreuve">Ajouter une épreuve</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">Lister</a>
              <div class="dropdown-menu" aria-labelledby="dropdown01">
                <a class="dropdown-item" href="listeJoueur">Lister les joueurs</a>
                <a class="dropdown-item" href="listeTournoi">Lister les tournois</a>
                <a class="dropdown-item" href="listeMatch">Lister les matchs</a>
                <a class="dropdown-item" href="listeEpreuve">Lister les épreuves</a>
              </div>
            </li>

            <li class="nav-item">
              <form class="form-inline my-2 my-lg-0" action="listeTournoi" method="post">
                <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="action1"
                  value="Deconnexion">Deconnexion</button>
              </form>
            </li>

          </ul>
          <form class="form-inline my-2 my-lg-0" action="listeTournoi" method="post">
            <input class="form-control mr-sm-2" type="text" name="txtsearch" placeholder="Search" aria-label="Search">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="action1"
              value="Rechercher">Rechercher</button>
          </form>
        </div>
      </nav>

      <main role="main" class="container">

        <div class="starter-template">
          <h1>Liste des Tournois</h1>
          <h4 class="lead">Bienvenue
            <c:out value="${connectedUser.getLogin()}" />

          </h4>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
            dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex
            ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolor.</p>
        </div>

      </main><!-- /.container -->
      <div class="container">

        <div style="    padding: 1.5rem;    margin-right: 0;    margin-left: 0;    border-width: .2rem;">
          <a class="btn btn-primary" href="ajouterTournoi" role="button">Ajouter un tournoi</a>
        </div>

        <table class="table" style="color: white;">
          <thead>
            <tr>
              <th scope="col" style="width:10%">#</th>
              <th scope="col" style="width:25%">Nom</th>
              <th scope="col" style="width:20%">Code</th>
              <th scope="col" style="width:20%"></th>
            </tr>
          </thead>
          <tbody>
            <c:if test="${list.size() == 0}"> Aucune occurrence trouvée</c:if>
            <c:if test="${list.size() != 0}">
              <c:forEach items="${list}" var="tournoi">
                <!-- form action="modifierJoueur" method="get"-->
                <tr>
                  <th scope="row">
                    <c:out value="${tournoi.id}" />
                  </th>
                  <td>
                    <c:out value="${tournoi.nom}" />
                  </td>
                  <td>
                    <c:out value="${tournoi.code}" />
                  </td>
                  <td>
                    <a style="width:100px;" type="button" class="btn btn-outline-primary"
                      href="modifierTournoi?id=${tournoi.id}" role="button">Modifier</a>
                    <a style="width:100px;" type="submit" class="btn btn-warning""
                      href="supprimerTournoi?id=${tournoi.id}" role="button">Supprimer</a>
                  </td>
                </tr>
                <!--/form-->
              </c:forEach>
            </c:if>
          </tbody>
        </table>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
          integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
          crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
          integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
          crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
          integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
          crossorigin="anonymous"></script>
    </body>

    </html>
>>>>>>> Stashed changes
