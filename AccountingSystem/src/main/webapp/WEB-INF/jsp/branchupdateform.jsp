<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Branch</h1>
       <form:form method="POST" action="/AccountingSystem/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="branch_id" /></td>
         </tr> 
         <tr>  
          <td>Branch_Name : </td> 
          <td><form:input path="branch_name"  /></td>
         </tr>  
         <tr>  
          <td>Address :</td>  
          <td><form:input path="address" /></td>
         </tr> 
         <tr>  
          <td>City :</td>  
          <td><form:input path="city" /></td>
         </tr> 
         <tr>  
          <td>State :</td>  
          <td><form:input path="state" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
