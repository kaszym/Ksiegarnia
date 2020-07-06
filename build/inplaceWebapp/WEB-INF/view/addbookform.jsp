<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Book</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <meta charset="utf-8">
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
                <a class="nav-link" href="${pageContext.request.contextPath}/authors/admin/list">Authors</a>
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
<form:form action="saveBook" modelAttribute="book" method="POST">
    <table>
        <tbody>
        <tr>
            <td><label>name:</label></td>
            <td><form:input path="nazwa"/></td>
        </tr>
        <tr>
            <td><label>publisher:</label></td>
            <td><form:input path="wydawnictwo"/></td>
        </tr>
        <tr>
            <td><label>price:</label></td>
            <td><form:input path="cena"/></td>
        </tr>
        <tr><td><label>catagory:</label></td>
            <td>
                    <form:select path="kategoria">
                    <form:options items="${categories}" itemValue="id" itemLabel="nazwa"/>
                    </form:select>
            </td>
        </tr>
                <tr><td><label>authors :</label></td>
                    <td>
                    <c:forEach var="autor" items="${authors}">
                      <form:select path="autorzy" value="${autor.id}"/> ${autor.imie} ${autor.nazwisko}
                    </c:forEach>

                    </td>
                </tr>

                <tr>
                    <td><form:hidden path="id"/></td>
                </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save"/></td>
        </tr>

        </tbody>
    </table>
</form:form>
<!-- -wracamy do listy bez zapisu-->
<p>
    <a href="${pageContext.request.contextPath}/books/admin/list "> return </a>
</p>
<form id="logout" action="<%=request.getContextPath()%>/logout" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="logout" />
</form>
</body>
</html>