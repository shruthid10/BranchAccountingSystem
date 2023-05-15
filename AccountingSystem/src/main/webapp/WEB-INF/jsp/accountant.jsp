<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    
<form action="/AccountingSystem/search" method="GET">
    <input type="radio" name="searchOption" value="accountant" checked onclick="updatePlaceholder('Enter branch name')">
    Search Accountants
    <input type="radio" name="searchOption" value="student" onclick="updatePlaceholder('Enter course name')">
    Search Students
    <input type="text" name="searchCriteria" id="searchCriteria" placeholder="Enter branch name">
    <button type="submit">Search</button>
</form>

<script>
    function updatePlaceholder(placeholder) {
        document.getElementById('searchCriteria').placeholder = placeholder;
    }
</script>

   
   
              
</body>
</html>
