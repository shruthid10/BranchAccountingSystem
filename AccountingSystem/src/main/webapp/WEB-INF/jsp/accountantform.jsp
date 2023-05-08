<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Accontant</h1>
       <form:form method="post" action="saveaccountant">  
      	<table >  
         <tr>  
          <td>First_Name: </td> 
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
          <td>Salary:</td>  
          <td><form:input path="salary" /></td>
         </tr> 
         <tr> 
         <tr>  
          <td>Branch_id:</td>  
          <td><form:input path="branch_id" /></td>
         </tr> 
         <tr>
          
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
