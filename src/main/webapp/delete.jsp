<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Supprimer un Article</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Supprimer un Article</h1>
        <form action="DeleteArticle" method="post">
            <div class="mb-3">
                <label for="ref" class="form-label">Référence</label>
                <input type="text" class="form-control" id="ref" name="ref" required>
            </div>
            <button type="submit" class="btn btn-danger">Supprimer</button>
        </form>
    </div>
</body>
</html>
