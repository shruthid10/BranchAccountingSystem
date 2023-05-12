<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Student</h1>
       <form:form method="POST" action="/AccountingSystem/editsavestudent">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="student_id" /></td>
         </tr> 
         <tr>  
          <td>First_Name : </td> 
          <td><form:input path="first_name"  /></td>
         </tr>  
         <tr>  
          <td>Last_Name:</td>  
          <td><form:input path="last_name" /></td>
         </tr> 
         <tr>  
          <td>Email:</td>  
          <td><form:input path="email" /></td>
         </tr> 
          <tr>  
          <td>Address:</td>  
          <td><form:input path="address" /></td>
         </tr> 
           <tr>  
          <td>City:</td>  
          <td><form:input path="city" /></td>
         </tr>
           <tr>  
          <td>State:</td>  
          <td><form:input path="state" /></td>
         </tr>
           <tr>  
          <td>Phone_Number:</td>  
          <td><form:input path="phone_number" /></td>
         </tr>
           <tr>  
          <td>Course_id:</td>  
          <td><form:input path="course_id" /></td>
         </tr>
          <tr>  
          <td>Branch_Id:</td>  
          <td><form:input path="branch_id" /></td>
         </tr>
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  


