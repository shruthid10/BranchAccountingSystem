    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Accountant List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Accountant_id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Salary</th><th>Branch_Id</th><th>Update</th><th>Delete</th></tr>
    <c:forEach var="accountant" items="${list}"> 
    <tr>
    <td>${accountant.accountant_id}</td>
    <td>${accountant.first_name}</td>
    <td>${accountant.last_name}</td>
    <td>${accountant.email}</td>
    <td>${accountant.salary}</td>
    <td>${accountant.branch_id}</td>
    
    <td><a href="editaccountant/${accountant.accountant_id}">Update</a></td>
    <td><a href="deleteaccountant/${accountant.accountant_id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="accountantform">Add New Accountant</a>