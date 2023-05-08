<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Payment</h1>
       <form:form method="POST" action="/AccountingSystem/editsavepayment">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="payment_id" /></td>
         </tr> 
         <tr>  
          <td>Student_Id: </td> 
          <td><form:input path="student_id"  /></td>
         </tr>  
         <tr>  
          <td>Payment_Date:</td>  
          <td><form:input path="payment_date" /></td>
         </tr> 
         <tr>  
          <td>Amount_Paid</td>  
          <td><form:input path="amount_paid" /></td>
         </tr>  
          <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  


