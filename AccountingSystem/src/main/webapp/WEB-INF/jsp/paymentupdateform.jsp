<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
    <title>Update Payment Details</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: url("https://img.freepik.com/premium-photo/top-view-office-table-desk-workspace-with-calculator-black-pen-laptop-blue_101276-159.jpg") no-repeat center center fixed;
            background-size: 100% 100%;
        }

        .card {
            width: 400px;
            background-color: rgba(255, 255, 255, 0.8);
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            padding: 20px;
        }

        h1 {
            text-align: center;
        }

        table {
            width: 100%;
        }

        td {
            padding: 10px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #000;
            border: none;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s;
            border-radius: 20px;
            box-shadow: 0 4px 0 0 #555;
        }

        input[type="submit"]:hover {
            background-color: #fff;
            color: #000;
            box-shadow: 0 6px 0 0 #555;
        }

        input[type="submit"]:active {
            transform: scale(0.95);
        }
    </style>
</head>
<body>
    <div class="card">
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
  </div>
</body>
</html>
