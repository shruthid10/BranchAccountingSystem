    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Payment Details List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>payment_id</th><th>student_id</th><th>payment_date</th><th>amount_paid</th><th>Update</th><th>Delete</th></tr>
    <c:forEach var="payment" items="${list}"> 
    <tr>
    <td>${payment.payment_id}</td>
    <td>${payment.student_id}</td>
  
    <td>${payment.payment_date}</td>
    <td>${payment.amount_paid}</td>
    
    <td><a href="editpayment/${payment.payment_id}">Update</a></td>
    <td><a href="deletepayment/${payment.payment_id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="paymentform">Add New Payment</a>
