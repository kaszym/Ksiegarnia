<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <meta charset="utf-8">
    <title>Books list</title>
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
                <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/authors/list">Authors</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/categories/list">Categories</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Books<span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>
<h2>Books:</h2>

<form:select path="c">
  <form:options var="category" items="${categories}" itemValue="id" itemLabel="nazwa"/>
</form:select>
<c:url var="filtr" value="/books/list/byCategory">
   <c:param name="category" value="${c.id}"/>
</c:url>
<td><a href="${filtr}" >filtr</a> </td>

<div>
    <table>
        <tr>
            <th>Name</th>
            <th>Publisher</th>
            <th>Price</th>
            <th>Category</th>
            <th>Authors</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.nazwa}</td>
                <td>${book.wydawnictwo}</td>
                <td>${book.cena}</td>
                <td>${book.kategoria.nazwa}</td>
                <c:forEach var="author" items="${book.autorzy}">
                    <td>${author.imie} ${author.nazwisko}  </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
</div>
<form id="logout" action="<%=request.getContextPath()%>/logout" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="logout" />
</form>
</body>
</html>