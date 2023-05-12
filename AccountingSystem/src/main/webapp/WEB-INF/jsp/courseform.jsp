<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Course</h1>
       <form:form method="post" action="savecourse">  
      	<table >  
         <tr>  
          <td>Course_Name: </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
          <td>Course_Fees:</td>  
          <td><form:input path="fees" /></td>
         </tr> 
         
          <tr>  
          <td>Duration:</td>  
          <td><form:input path="duration" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
