<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Cadastro de despesas</title>
  <meta name="viewport"
        content="width=device-width, initial-scale=1.0"
  >
  <link
          rel="stylesheet"
          href="./resources/css/bootstrap.css"
  >
  <link rel="stylesheet" href="resources/css/stylecadastrodespesa.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
  <div class="mt-5 ms-5 me-5">
    <div class="card mb-3">
      <div class="card-header">
        EDIÇÃO DE DESPESA
      </div>

      <c:if test="${not empty mensagem}">
        <div
                class="alert alert-success ms-2 me-2 m-auto mt-2">${mensagem}
        </div>
      </c:if>

      <c:if test="${not empty erro}">
        <div
                class="alert alert-danger ms-2 me-2 m-auto mt-2">${erro}
        </div>
      </c:if>

      <div class="card-body">
        <form
                action="despesas?"
                method="post">

          <input
                  type="hidden"
                  value="editar"
                  name="acao"
          >
          <input
                  type="hidden"
                  value="${despesa.id}"
                  name="id"
          >

          <div class="form-group">
            <label
                    for="id-descricao">Descricao
            </label>
            <input
                    type="text"
                    name="descricao"
                    id="id-descricao"
                    class="form-control"
                    value="${despesa.descricao}"
            >
          </div>
          <div class="form-group">
            <label
                    for="id-valor">Valor
            </label>
            <input
                    type="text"
                    name="valor"
                    id="id-valor"
                    class="form-control"
                    value="${despesa.valor}"
            >
          </div>
          <div class="form-group">
            <label
                    for="id-categoria">Categoria
            </label>
            <input
                    type="text"
                    name="categoria"
                    id="id-categoria"
                    class="form-control"
                    value="${despesa.categoria}"
            >
          </div>
          <div class="form-group">
            <label
                    for="id-tipo">Tipo
            </label>
            <input
                    type="text"
                    name="tipo"
                    id="id-tipo"
                    class="form-control"
                    value="${despesa.tipo}"
            >
          </div>
          <div class="form-group">
            <label
                    for="id-origem">Origem
            </label>
            <input
                    type="text"
                    name="origem"
                    id="id-origem"
                    class="form-control"
                    value="${despesa.origem}"
            >
          </div>
          <div class="form-group">
            <label
                    for="id-pagamento">Data de Pagamento
            </label>
            <input
                    type="date"
                    name="pagamento"
                    id="id-pagamento"
                    class="form-control"
                    value="${despesa.data}"
            >
          </div>
          <input
                  type="submit"
                  value="Salvar"
                  class="btn btn-primary mt-3">
          <a
                  href="despesas?acao=listar"
                  class="btn btn-warning mt-3">Cancelar
          </a>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp" %>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>