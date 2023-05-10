<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Payment Details</h1>
       <form:form method="post" action="savepayment">  
      	<table >  
         <tr>  
          <td>Student_id: </td> 
          <td><form:input path="student_id"  /></td>
         </tr>  
         <tr>  
          <td>Payment_Date:</td>  
          <td><form:input type="date" path="payment_date" /></td>
         </tr> 
         <tr>  
          <td>Amount_paid:</td>  
          <td><form:input path="amount_paid" /></td>
         </tr> 
         
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
