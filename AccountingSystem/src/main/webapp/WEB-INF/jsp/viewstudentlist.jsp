    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Students List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Student_Id</th><th>First_Name</th><th>Last_Name</th><th>Email</th><th>Address</th><th>City</th><th>State</th><th>Phone_Number</th><th>Course_Name</th><th>Payment_Status</th><th>Branch_Id</th><th>Update</th><th>Delete</th></tr>
    <c:forEach var="student" items="${list}"> 
    <tr>
    <td>${student.student_id}</td>
    <td>${student.first_name}</td>
    <td>${student.last_name}</td>
    <td>${student.email}</td>
    <td>${student.address}</td>
    <td>${student.city}</td>
    <td>${student.state}</td>
    <td>${student.phone_number}</td>
    <td>${student.course_id}</td>
    <td>${student.payment_status}</td> 
    <td>${student.branch_id}</td>
    <td><a href="editstudent/${student.student_id}">Update</a></td>
    <td><a href="deletestudent/${student.student_id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="studentform">Add New Student</a>
