<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Détails de l'Article</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Détails de l'Article</h1>
        <div class="card">
            <div class="card-body">
                <%
                    model.Article article = (model.Article) request.getAttribute("article");
                %>
                        <p class="card-text">
                            <strong>Référence:</strong> <%= article.getRef() %><br>
                            <strong>Marque:</strong> <%= article.getMarque() %><br>
                            <strong>Prix:</strong> <%= article.getPrix() %> euros<br>
                        </p>
                <a href="ListeArticle" class="btn btn-primary">Liste</a>
            </div>
        </div>
    </div>
</body>
</html>
