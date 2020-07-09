<%--
  Created by IntelliJ IDEA.
  User: Gasana.NHonore
  Date: 08/07/2020
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details work</title>
</head>
<body>
<h1>Descriptif de l'oeuvre</h1>
<p>Titre: ${work.getTitle()}</p>
<p>Année: ${work.getAnnee()}</p>
<p>Genre: ${work.getGenre()}</p>
<p>Nom Artiste: ${work.getMainArtist().getName()}</p>
<p>Résumé: ${work.getSummary()}</p>
<form action="addToCart" method="post">
    <input type="hidden" name="identifiant" value=${id}>
    <input type="submit" value="Ajouter au caddie">
</form>
</body>
</html>
