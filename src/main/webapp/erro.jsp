<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erro - Fintech</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="bg-light">
<nav class="navbar navbar-dark navbar-expand-lg bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Fintech</a>
    </div>
</nav>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="alert alert-danger text-center" role="alert">
                <h4 class="alert-heading">Erro!</h4>
                <p><strong>${erro}</strong></p>
                <hr>
                <p class="mb-0">Algo deu errado. Por favor, tente novamente mais tarde ou entre em contato com o suporte.</p>
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
