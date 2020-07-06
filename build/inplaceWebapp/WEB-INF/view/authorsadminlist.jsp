
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <meta charset="utf-8">
    <title>Authors List</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">BookStore</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Authors<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/categories/admin/list">Categories</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/books/admin/list">Books</a>
            </li>
        </ul>
    </div>
</nav>
<h2>Authors:</h2>
<div>
    <table>
        <tr>
            <th>Id</th>
            <th>Imie</th>
            <th>Nazwisko</th>
        </tr>
        <c:forEach var="author" items="${authors}">

            <c:url var="update" value="/authors/admin/updateAuthorForm">
                <c:param name="authorId" value="${author.id}"/>
            </c:url>

            <c:url var="delete" value="/authors/admin/deleteAuthorForm">
                <c:param name="authorId" value="${author.id}"/>
            </c:url>
            <tr>
                <td>${author.id}</td>
                <td>${author.imie}</td>
                <td>${author.nazwisko}</td>
                <td><a href="${update}" >update</a> </td>

                <td><a href="${delete}" >delete</a> </td>

            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <input type="button" value="Add Author" onclick="window.location.href='formadd';return false;"/>
</div>
<form id="logout" action="<%=request.getContextPath()%>/logout" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="logout" />
</form>
</body>
</html>