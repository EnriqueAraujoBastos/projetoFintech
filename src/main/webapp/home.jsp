<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>FINTECH - Home</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./resources/css/bootstrap.css">
  <link rel="stylesheet" href="./resources/css/stylehome.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
  <c:if test="${empty user}">
    <h1 class="mt-3">Você não está autenticado!</h1>
    <h5>Para acessar o sistema, identifique-se!</h5>
  </c:if>
  <c:if test="${not empty user}">
    <h1 class="mt-3">Bem-vindo a FINTECH!</h1>
    <h5>Seu login foi efetuado com sucesso!</h5>
  </c:if>
</div>

<h1 class="titulo">
  Home
</h1>


</nav>




<div class="container mt-5">
  <h2 class="text-center">Seu Painel Financeiro</h2>
  <div class="row mt-4">
    <div class="col-md-4">
      <div class="card text-center p-3">
        <h5 class="card-title">Cadastro de despesa</h5>
        <p>Gerencie suas despesas.</p>
        <a href="cadastro-despesa.jsp" class="btn btn-outline-light">cadsatrar</a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="card text-center p-3">
        <h5 class="card-title">Editar despesas</h5>
        <p>Edite todas suas despesas.</p>
        <a href="editar-despesa.jsp" class="btn btn-outline-light">Editar</a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="card text-center p-3">
        <h5 class="card-title">Listar Despesas</h5>
        <p>Liste e acompanhe todas suas despesas</p>
        <a href="lista-despesa.jsp" class="btn btn-outline-light">Listar</a>
      </div>
    </div>
  </div>
</div>
</div>
</div>


<div class="row mt-4">
  <div class="col-md-4">
    <div class="card text-center p-3">
      <h5 class="card-title">Cadastro de receitas</h5>
      <p>Gerencie suas receitas.</p>
      <a href="cadastro-receita.jsp" class="btn btn-outline-light">Cadastrar</a>
    </div>
  </div>
  <div class="col-md-4">
    <div class="card text-center p-3">
      <h5 class="card-title">Editar receitas</h5>
      <p>Edite todas suas receitas.</p>
      <a href="editar-receita.jsp" class="btn btn-outline-light">Editar</a>
    </div>
  </div>
  <div class="col-md-4">
    <div class="card text-center p-3">
      <h5 class="card-title">Listar receitas</h5>
      <p>Liste e acompanhe todas suas receitas.</p>
      <a href="lista-receita.jsp" class="btn btn-outline-light">Listar</a>
    </div>
  </div>
</div>
</div>



<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>