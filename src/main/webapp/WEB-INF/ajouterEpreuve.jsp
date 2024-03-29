<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!doctype html>
    <html lang="fr">

    <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
      <link rel="stylesheet" href="starter-template.css">
      <title>AJOUTER/LISTER</title>
    </head>

    <body style="cursor: url(cursor.svg), auto;">
      <%@ include file="menu.jsp" %>

        <main role="main" class="container">

          <div class="starter-template-menu">
            <img src="logobnw.svg" width="20%" />
            <h1>Ajouter une épreuve</h1>
            <p class="lead">
              <c:if test="${ !empty erreur }">
                <p style="color:red;">
                  <c:out value="${ erreur }" />
                </p>
              </c:if>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
              et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
              ex ea commodo consequat.
            </p>
          </div>
          <div style="width:40%;height:100%;margin:auto;">

            <form class="needs-validation " novalidate method="post" action="ajouterEpreuve">
              <div class="form-row">
                <div class="col-md-4 mb-3">
                  <label for="validationCustom01">Année</label>
                  <input type="text" class="form-control" style="width:400px;" id="validationCustom01" name="txtYear"
                    required>
                  <div class="valid-feedback">
                    Très bien!
                  </div>
                </div>
              </div>
              <div class="form-row">
                <div class="col-md-4 mb-3">
                  <label for="validationCustom02">Type d'épreuve</label>
                  <input type="text" class="form-control" style="width:400px;" id="validationCustom02" name="txtType"
                    required>
                  <div class="valid-feedback">
                    Très bien!
                  </div>
                </div>
              </div>
              <div class="form-row">
                <div class="col-md-4 mb-3">
                  <label for="validationCustom02">ID Tournoi</label>
                  <input type="text" class="form-control" style="width:400px;" id="validationCustom02" name="txtIdT"
                    required>
                  <div class="valid-feedback">
                    Très bien!
                  </div>
                </div>
              </div>

              <button class="btn btn-primary" type="submit">Submit form</button>
            </form>

            </div>

        </main><!-- /.container -->

        <script>
          // Example starter JavaScript for disabling form submissions if there are invalid fields
          (function () {
            'use strict';
            window.addEventListener('load', function () {
              // Fetch all the forms we want to apply custom Bootstrap validation styles to
              var forms = document.getElementsByClassName('needs-validation');
              // Loop over them and prevent submission
              var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                  if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                  }
                  form.classList.add('was-validated');
                }, false);
              });
            }, false);
          })();
        </script>


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