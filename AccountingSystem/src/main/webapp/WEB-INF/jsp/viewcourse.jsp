    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Course List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Course_id</th><th>Course_Name</th><th>Course_Fees</th><th>Duration</th><th>Update</th></tr>
    <c:forEach var="course" items="${list}"> 
    <tr>
    <td>${course.course_id}</td>
    <td>${course.name}</td>
    <td>${course.fees}</td>
    <td>${course.duration}</td>
    <td><a href="editcourse/${course.course_id}">Update</a></td>
    
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="courseform">Add New Course</a>