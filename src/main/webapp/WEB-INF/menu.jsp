<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">  
  <img src="plogo.svg" style="width:35px;">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
 <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Ajouter</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="/TennisWebApp/ajouterJoueur">Ajouter un joueur</a>
          <a class="dropdown-item" href="/TennisWebApp/ajouterTournoi">Ajouter un tournoi</a>
          <a class="dropdown-item" href="/TennisWebApp/ajouterMatch">Ajouter un  match</a>
          <a class="dropdown-item" href="/TennisWebApp/ajouterEpreuve">Ajouter une épreuve</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Lister</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="listeJoueur">Lister les joueurs</a>
          <a class="dropdown-item" href="listeTournoi">Lister les tournois</a>
          <a class="dropdown-item" href="listeMatch">Lister les  matchs</a>
          <a class="dropdown-item" href="listeEpreuve">Lister les  épreuves</a>
        </div>
      </li>
	
       <li class="nav-item">
	    <form class="form-inline my-2 my-lg-0" action="listeJoueur" method="post">      
         <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="action1" value="Deconnexion">Deconnexion</button>
         </form>
      </li>
     
    </ul>
    <form class="form-inline my-2 my-lg-0" action="listeJoueur" method="post">
      <input value="${fn:escapeXml(param.txtsearch)}" class="form-control mr-sm-2" type="text" name="txtsearch" placeholder="Search" aria-label="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="action1" value="Rechercher">Rechercher</button>
    </form>
  </div>
</nav>
