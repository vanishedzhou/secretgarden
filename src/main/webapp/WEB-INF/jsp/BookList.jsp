<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Book List</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<h1>Book List</h1>
<a href="<c:url value="/book_input"/>">Add Book</a>
<table>
<tr>
    <th>Category</th>
    <th>Name</th>
    <th>Id</th>
    <th>Author</th>
    <th>&nbsp;</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${books}" var="book">
    <tr>
        <td>${book.category.name}</td>
        <td>${book.name}</td>
        <td>${book.id}</td>
        <td>${book.author}</td>
        <td><a href="book_edit/${book.id}">Edit</a></td>
        <td><a href="book_delete/${book.id}">Delete</a></td>
    </tr>
</c:forEach>
</table>
</div>
</body>
</html>
