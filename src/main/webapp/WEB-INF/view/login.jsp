<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <meta charset="utf-8">
    <title>Log in</title>
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
                <a class="nav-link" href="${pageContext.request.contextPath}/books/list">Books</a>
            </li>
            <li class="nav-item">
                             <a class="nav-link" href="${pageContext.request.contextPath}/register">Registration</a>
                         </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Log in<span class="sr-only">(current)</span></a>
             </li>
        </ul>
    </div>
</nav>
<h3>Log in</h3>
<c:if test="${(param.error != null) && (not empty SPRING_SECURITY_LAST_EXCEPTION)}">
    <p><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></p>
</c:if>
<form:form method="post">
    <table>
        <tbody>
        <tr>
            <td><label for="username">Username:</label></td>
            <td><input type="text" id="username" name="username" class="form-control"/></td>
        </tr>
        <tr>
            <td><label for="password">Password:</label></td>
            <td><input type="password" id="password" name="password" class="form-control"/></td>
        </tr>
        <tr>
            <td>
                <button type="submit" >Log in</button>
            </td>
        </tr>
        </tbody>
    </table>
</form:form>

</body>
</html>
