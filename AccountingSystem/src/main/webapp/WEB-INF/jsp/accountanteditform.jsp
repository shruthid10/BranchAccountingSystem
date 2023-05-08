<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Accountant</h1>
       <form:form method="POST" action="/AccountingSystem/editsaveaccountant">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="accountant_id" /></td>
         </tr> 
         <tr>  
          <td>First Name : </td> 
          <td><form:input path="first_name"  /></td>
         </tr>  
         <tr>  
          <td>Last Name :</td>  
          <td><form:input path="last_name" /></td>
         </tr> 
         <tr>  
          <td>Email :</td>  
          <td><form:input path="email" /></td>
         </tr> 
         <tr>  
          <td>Salary :</td>  
          <td><form:input path="salary" /></td>
         </tr> 
          <tr>  
          <td>Branch Id :</td>  
          <td><form:input path="branch_id" /></td>
         </tr>
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
