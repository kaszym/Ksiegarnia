<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <meta charset="utf-8">
<title>Categories List</title>
</head>
<html>
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
                <a class="nav-link" href="${pageContext.request.contextPath}/authors/admin/list">Authors</a>
            </li>
            <li class="nav-item">
                 <a class="nav-link" href="#">Categories<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/books/admin/list">Books</a>
            </li>
        </ul>
    </div>
</nav>
<h2>Categories:</h2>
    <table>
        <thead >
        <tr>
            <th>Name</th>
            <th>Edit</th>
            <th>Remove</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categories}">
            <c:url var="update" value="/categories/admin/updateCategoryForm">
                <c:param name="categoryId" value="${category.id}"/>
            </c:url>
            <c:url var="delete" value="/categories/admin/deleteCategoryForm">
                <c:param name="categoryId" value="${category.id}"/>
            </c:url>
            <tr>
                <td><c:out value="${category.nazwa}"/></td>
                <td><a href="${update}">edit</a></td>
                <td><a href="${delete}">remove</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div>
    <a href="${pageContext.request.contextPath}/categories/admin/formadd" >Add category</a>
</div>
<form id="logout" action="<%=request.getContextPath()%>/logout" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="logout" />
</form>
</body>
</html>