<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accountants</title>
</head>
<body>
    <h1>Accountants</h1>
    
    
    <table>
    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>Accountant ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Salary</th>
            <th>Branch_Name</th>
        </tr>
        <c:forEach var="accountant" items="${accountants}" >
            <tr>
                <td>${accountant.accountant_id}</td>
                <td>${accountant.first_name}</td>
                <td>${accountant.last_name}</td>
                <td>${accountant.email}</td>
                <td>${accountant.salary}</td>
                <td>${accountant.branch_name}</td>
            </tr>
        </c:forEach>
    </table>
   
</body>
</html>
