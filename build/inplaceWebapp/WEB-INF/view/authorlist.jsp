
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List authors</title>
</head>
<body>
<h2>Authors:</h2>
<div>
    <table>
        <tr>
            <th>Id</th>
            <th>Imie</th>
            <th>Nazwisko</th>
        </tr>
        <c:forEach var="author" items="${authors}">
            <c:url var="update" value="/authors/updateAuthorForm">
                <c:param name="autorId" value="${autors.id}"/>
            </c:url>

            <c:url var="delete" value="/autors/deleteAuthorForm">
                <c:param name="autorId" value="${author.id}"/>
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
</body>
</html>