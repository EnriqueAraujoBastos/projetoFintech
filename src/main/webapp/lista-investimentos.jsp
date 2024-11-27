<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fintech - Investimentos</title>
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
                LISTA DE INVESTIMENTOS
            </div>
            <div class="card-body">
                <h5 class="card-title">Gestão de investimenos
                </h5>
                <p
                        class="card-text">Mantenha os dados das seus
                    investimentos sempre atualizados e acessíveis.
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
                        <th class="text-center">Data de Pagamento</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${investimentos}" var="investimento">
                        <tr>
                            <td>${investimento.descricao}</td>
                            <td class="text-end">
                                <fmt:formatNumber
                                        value="${investimento.valor}"/>
                            </td>
                            <td class="text-end">${investimento.categoria}</td>
                            <td class="text-center">${investimento.tipo}</td>
                            <td class="text-center">
                                <fmt:formatDate
                                        value="${investimento.data}"
                                        pattern="dd/MM/yyyy"/>
                            </td>

                            <td class="text-center">
                                <c:url value="investimentos" var="link">
                                    <c:param name="acao" value="abrir-form-edicao"/>
                                    <c:param name="id" value="${investimento.id}"/>
                                </c:url>
                                <a href="${link}" class="btn btn-primary">Editar</a>

                                <button
                                        type="button"
                                        class="btn btn-danger"
                                        data-bs-toggle="modal"
                                        data-bs-target="#excluirModal"
                                        onclick="idExcluir.value = ${investimento.id}"
                                >
                                    Excluir
                                </button>

                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a
                        href="cadastro-investimento.jsp"
                        class="btn btn-primary">Adicionar Investimento</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
