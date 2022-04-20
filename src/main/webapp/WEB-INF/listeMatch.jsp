<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!doctype html>
    <html lang="fr">

    <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
      <link rel="stylesheet" href="starter-template.css">
      <title>Liste des Matchs</title>
      
      <style type="text/css">
	    #btnVainqueur {
	    	background-image: url("btnVainqueur.svg");
	    	border-radius: 8%;
		    width: 100px;
		    height: 45px;
		    cursor: pointer;
		}

		#btnFinaliste {
			background-image: url("btnFinaliste.svg");
			border-radius: 8%;
		    width: 100px;
		    height: 45px;
		    cursor: pointer;
		}
		
		* {
		  box-sizing: border-box;
		}
		
		.row {
		  margin-left:5px;
		  margin-right:5px;
		}
		  
		.column {
		  float: left;
		  width: 50%;
		  padding: 5px;
		}
		
		/* Clearfix (clear floats) */
		.row::after {
		  content: "";
		  clear: both;
		}
		
		table {
		  border-collapse: collapse;
		  border-spacing: 0;
		  width: 100%;
		  border: 1px solid #ddd;
		}
		
		th, td {
		  text-align: left;
		  padding: 16px;
		}
      </style>
      
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
              <form class="form-inline my-2 my-lg-0" action="listeMatch" method="post">
                <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="action1"
                  value="Deconnexion">Deconnexion</button>
              </form>
            </li>
          </ul>
          <form class="form-inline" action="listeMatch" method="post">
            <div style="margin:3px;"><input type="checkbox" name="cbNom" value="cbNom" ${param.cbNom == 'cbNom' ? 'checked' : ''}> Nom </div>
            <div style="margin:3px;"><input type="checkbox" name="cbPrenom" value="cbPrenom" ${param.cbPrenom == 'cbPrenom' ? 'checked' : ''}> Prenom</div>
            <input value="${fn:escapeXml(param.txtsearch)}" class="form-control mr-sm-2" type="text" name="txtsearch" placeholder="Search" aria-label="Search">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="action1" value="Rechercher">Rechercher</button>
          </form>
        </div>
      </nav>

	<div class="center">
		<div class="ball"></div>
		<div class="shadow"></div>
	</div>

      <main role="main" class="container">

        <div class="starter-template">
          <h1>Liste des matchs</h1>
          <h4 class="lead">Bienvenue  <span style="color: #3792A9;"><c:out value="${connectedUser.getLogin().toUpperCase()}"/>
		  </span></h4>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
            dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex
            ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolor.</p>
        </div>

      </main><!-- /.container -->
      <div class="container">

        <div style="display:block;padding: 1.5rem;margin-right: 0;margin-left: 0;margin-bottom:30px;border-width:.2rem;">
          <a style="float:left;" class="btn btn-warning" href="/TennisWebApp/ajouterMatch" role="button">Ajouter un match</a>
          
          <form style="float:right;margin-right:0"class="form-inline" action="listeMatch" method="post">
			<button class="btn btn-primary" type="submit" name="action1" value="Refresh">Refresh</button>
		  </form>
          	  <form style="float:right;margin-right:170px"class="form-inline" action="listeMatch" method="post">
	            <button id="btnFinaliste" type="submit" name="action1" value="Finaliste"></button>
	          </form>
	          <form style="float:right;margin-right:70px;"class="form-inline" action="listeMatch" method="post">
	            <button id="btnVainqueur" type="submit" name="action1" value="Vainqueur"></button>
	          </form>
	          
        </div>
        </div>
        
    <div class="row">
    <div class="column">
       <table class="table" style="color: white;">
          <thead>
            <tr>
              <th scope="col" style="width:10%">#</th>
              <th scope="col" style="width:10%">ID Epreuve</th>
              <th scope="col" style="width:15%">ID Vainqueur</th>
              <th scope="col" style="width:15%">ID Finaliste</th>
            </tr>
          </thead>
          <tbody>
            <c:if test="${list.size() == 0}">Aucune occurrence trouvée</c:if>
            <c:if test="${list.size() != 0}">
              <c:forEach items="${list}" var="match">
                <!-- form action="modifierJoueur" method="get"-->
                <tr>
                  <th scope="row">
                    <c:out value="${match.id}" />
                  </th>
                  <td>
                    <c:out value="${match.idEpreuve}" />
                  </td>
                  <td>
                    <c:out value="${match.idVainqueur}" />
                  </td>
                  <td>
                    <c:out value="${match.idFinaliste}" />
                  </td>
                </tr>
                <!--/form-->
              </c:forEach>
            </c:if>
          </tbody>
        </table>
       </div>

		<div class="column">
        <table class="table" style="color: white;">
          <thead>
            <tr>
              <th scope="col" style="width:15%">Nom</th>
              <th scope="col" style="width:25%">Prenom</th>
              <th scope="col" style="width:10%">Sexe</th>
            </tr>
          </thead>
          <tbody>
            <c:if test="${result.size() == 0}">Aucune occurrence trouvée</c:if>
            <c:if test="${result.size() != 0}">
              <c:forEach items="${result}" var="joueur">
                <!-- form action="modifierJoueur" method="get"-->
                <tr>
                  <th scope="row">
                    <c:out value="${joueur.nom}" />
                  </th>
                  <td>
                    <c:out value="${joueur.prenom}" />
                  </td>
                  <td>
                    <c:out value="${joueur.sexe}" />
                  </td>
                </tr>
              </c:forEach>
            </c:if>
          </tbody>
        </table>
        </div>
	</div>

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
