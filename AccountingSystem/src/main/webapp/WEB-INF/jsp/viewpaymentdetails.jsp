    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
    <title>Payment Details</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: flex-start;
            min-height: 100vh;
            background: url("https://img.freepik.com/premium-photo/top-view-office-table-desk-workspace-with-calculator-black-pen-laptop-blue_101276-159.jpg") no-repeat center center fixed;
            background-size: 100% 100%;
            background-color: rgba(0, 0, 0, 0.6);
            backdrop-filter: blur(5px);
        }

        .container {
           text-align: center;
            width: 70%;
            margin-top: 50px;
            margin-left: 20px;
        }
          h1 {
            text-align: center;
            
        }
        table {
            width: 100%;
            border-collapse: collapse;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            background-color: rgba(255, 255, 255, 0.8);
           
        }
        tr { border-bottom: 2px solid black; }

        th, td {
            padding: 10px;
            text-align: left;
            vertical-align: middle;
            border-bottom: 2px solid #ddd;
        }

        th {
            background-color: #000;
            color: #fff;
            font-weight: bold;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .btn {
            display: inline-block;
            background-color: #fff;
            color: #000;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s;
            border-radius: 20px;
            box-shadow: 0 4px 0 0 #555;
            margin: 0 5px;
        }

        .btn:hover {
            background-color: #000;
            color: #fff;
            box-shadow: 0 6px 0 0 #555;
            border-bottom: 2px solid #000;
        }

        .btn:active {
            transform: scale(0.95);
        }
    </style>
</head>
<body>
    <div class="container">
	<h1>Payment Details List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>payment_id</th><th>student_id</th><th>payment_date</th><th>amount_paid</th><th>Update</th></tr>
    <c:forEach var="payment" items="${list}"> 
    <tr>
    <td>${payment.payment_id}</td>
    <td>${payment.student_id}</td>
  
    <td>${payment.payment_date}</td>
    <td>${payment.amount_paid}</td>
    
    <td><a href="editpayment/${payment.payment_id}"><button class="btn">Update</button></a></td>
  
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="paymentform">Add New Payment</a>
</div>
</body>
</html>