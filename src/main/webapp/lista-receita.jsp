<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fintech</title>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0"
    >
    <link
            rel="stylesheet"
            href="./resources/css/bootstrap.css"
    >
    <link rel="stylesheet" href="resources/css/stylecadastro.css">
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div class="mt-5 ms-5 me-5">

        <div class="card mb-3">
            <div class="card-header">
                LISTA DE RECEITAS
            </div>
            <div class="card-body">
                <h5 class="card-title">Gestão de receitas
                </h5>
                <p
                        class="card-text">Mantenha os dados das suas
                    receitas sempre atualizados e acessíveis.
                </p>

                <c:if test="${not empty msg }">
                    <div class="alert alert-success">${msg}</div>
                </c:if>
                <c:if test="${not empty erro }">
                    <div class="alert alert-danger">${erro}</div>
                </c:if>

                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Descrição</th>
                        <th class="text-end">Valor</th>
                        <th class="text-end">Categoria</th>
                        <th class="text-center">Tipo</th>
                        <th class="text-center">Origem</th>
                        <th class="text-center">Data de Recebimento</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${receitas}" var="receita">
                        <tr>
                            <td>${receita.descricao}</td>
                            <td class="text-end">
                                <fmt:formatNumber
                                        value="${receita.valor}"/>
                            </td>
                            <td class="text-end">${receita.categoria}</td>
                            <td class="text-center">${receita.tipo}</td>
                            <td class="text-center">${receita.origem}</td>
                            <td class="text-center">
                                <fmt:formatDate
                                        value="${receita.data}"
                                        pattern="dd/MM/yyyy"/>
                            </td>

                            <td class="text-center">
                                <c:url value="receitas" var="link">
                                    <c:param name="acao" value="abrir-form-edicao"/>
                                    <c:param name="id" value="${receita.id}"/>
                                </c:url>
                                <a href="${link}" class="btn btn-primary">Editar</a>

                                <button
                                        type="button"
                                        class="btn btn-danger"
                                        data-bs-toggle="modal"
                                        data-bs-target="#excluirModal"
                                        onclick="idExcluir.value = ${receita.id}"
                                >
                                    Excluir
                                </button>

                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a
                        href="cadastro-receita.jsp"
                        class="btn btn-primary">Adicionar Receita</a>
            </div>
        </div>
    </div>
</div>

<div

        class="modal fade"
        id="excluirModal"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true">
    <div class ="modal-dialog">
        <div class ="modal-content">
            <div class ="modal-header">
                <h1
                        class="modal-title fs-5"
                        id="exampleModalLabel">
                    Confirmar Exclusão
                </h1>
                <button
                        type="button"
                        class="btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close">
                </button>
            </div>
            <div class="modal-body">
                <h4>Você confirma a exclusão desta receita?</h4>
                <p><strong>Atenção!</strong> Esta ação é irreversível.</p>
            </div>
            <div class="modal-footer">

                <form action="receitas" method="post">
                    <input
                            type="hidden"
                            name="acao"
                            value="excluir">
                    <input
                            type="hidden"
                            name="idExcluir"
                            id="idExcluir">
                    <button
                            type="button"
                            class="btn btn-secondary"
                            data-bs-dismiss="modal">
                        Não
                    </button>
                    <button
                            type="submit"
                            class="btn btn-danger">
                        Sim
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>