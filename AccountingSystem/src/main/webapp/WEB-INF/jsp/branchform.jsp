<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Branch</h1>
       <form:form method="post" action="save">  
      	<table >  
         <tr>  
          <td>Branch_Name: </td> 
          <td><form:input path="branch_name"  /></td>
         </tr>  
         <tr>  
          <td>Branch_Location:</td>  
          <td><form:input path="branch_location" /></td>
         </tr> 
         
          <tr>  
          <td>State:</td>  
          <td><form:input path="state" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
