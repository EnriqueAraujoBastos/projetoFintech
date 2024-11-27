<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erro 404 - Página Não Encontrada</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="bg-light">
<nav class="navbar navbar-dark navbar-expand-lg bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">FINTECH</a>
    </div>
</nav>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="alert alert-warning text-center" role="alert">
                <h4 class="alert-heading">Erro 404 - Página Não Encontrada!</h4>
                <p><strong>A página que você está procurando não foi encontrada.</strong></p>
                <hr>
                <p class="mb-0">Certifique-se de que o URL está correto ou <a href="index.jsp" class="alert-link">volte para a página inicial</a>.</p>
            </div>
        </div>
    </div>
    <div class="row justify-content-center mt-4">
        <div class="col-md-4">
            <a href="index.jsp" class="btn btn-primary w-100">Voltar para a página inicial</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
