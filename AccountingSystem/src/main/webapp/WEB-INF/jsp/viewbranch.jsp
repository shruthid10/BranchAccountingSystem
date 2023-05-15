    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Branch List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Branch_id</th><th>Branch_Name</th><th>Address</th><th>City</th><th>Update</th></tr>
    <c:forEach var="branch" items="${list}"> 
    <tr>
    <td>${branch.branch_id}</td>
    <td>${branch.branch_name}</td>
    <td>${branch.branch_location}</td>

    <td>${branch.state}</td>
    <td><a href="editbranch/${branch.branch_id}">Update</a></td>
   <%--  <td><a href="deletebranch/${branch.branch_id}">Delete</a></td> --%>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="branchform">Add New Branch</a>