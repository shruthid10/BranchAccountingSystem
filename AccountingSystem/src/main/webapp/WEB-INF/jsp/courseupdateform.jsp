<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Course</h1>
       <form:form method="POST" action="/AccountingSystem/editsavebranch">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="course_id" /></td>
         </tr> 
         <tr>  
          <td>Course_Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
          <td>Course_Fees :</td>  
          <td><form:input path="fees" /></td>
         </tr> 
          
         <tr>  
          <td>Course_Duration:</td>  
          <td><form:input path="duration" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
