<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
</head>
<body>
    <h1>Add Book</h1>
    <form action="<c:url value='/books/add' />" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br>
        
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" required><br>
        
        <input type="submit" value="Add Book">
    </form>
    <br>
    <a href="/books/list">Back to Book List</a>
</body>
</html>
