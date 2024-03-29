<html lang="fr">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="signin.css">

  <title>Connexion</title>
</head>

<body style="cursor: url(cursor.svg), auto;background-image:linear-gradient(to right,black,#14213D,#213C56,#43553D);text-align: center;">

  <form class="form-signin" method="post" action="login">
    <img class="mb-4" src="logo.png" width="90%">
    <h1 class="h3 mb-3 font-weight-normal" style="color:#FFF;">Please sign in</h1>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="text" id="inputEmail" name="txtLogin" class="form-control" placeholder="Addresse mail" required
      autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" name="txtPassword" class="form-control" placeholder="Mot de passe"
      required>
    <div class="checkbox mb-3" style="color:#FFF ;"></div>
    <button class="btn btn-lg btn-primary btn-block" style="background-color:#C49650; border-color:#FFF;"
      type="submit">Sign in</button>

    <p style="margin-top:40px;" class="text-inverse text-center"><a href="signup" data-abc="true">Register a new account?</a></p>
  </form>





  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>

</html>