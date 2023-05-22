<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Invoice</title>
    <style>
        .invoice-container {
            margin: 0 auto;
            max-width: 600px;
            padding: 20px;
            border: 1px solid #ccc;
            background-color:  #cce6ff;
        }

        .invoice-header {
            text-align: center;
            margin-bottom: 20px;
        }

        .invoice-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        .invoice-table th,
        .invoice-table td {
            border: 1px solid #ccc;
            padding: 8px;
        }

        .invoice-success-message {
            text-align: center;
            font-weight: bold;
            color: green;
        }
    </style>
</head>
<body>
    <div class="invoice-container">
        <div class="invoice-header">
            <h1>RK Institute Of Technology</h1>
        </div>

		<table class="invoice-table">
			<tr>
				<th>Payment ID:</th>
				<td>${payment.payment_id}</td>
			</tr>
			<tr>
				<th>Student ID:</th>
				<td>${payment.student.student_id}</td>
			</tr>
			<tr>
				<th>First Name:</th>
				<td>${payment.student.first_name}</td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td>${payment.student.last_name}</td>
			</tr>
			
			<tr>
				<th>Branch Name:</th>
				<td>${payment.branch.branch_name}</td>
			</tr>
			<tr>
				<th>Course ID:</th>
				<td>${payment.student.course_id}</td>
			</tr>
			<tr>
				<th>Course Name:</th>
				<td>${payment.student.course.name}</td>
			</tr>
			<tr>
				<th>Phone Number:</th>
				<td>${payment.student.phone_number}</td>
			</tr>
			<tr>
				<th>Address:</th>
				<td>${payment.student.address}</td>
			</tr>

			<tr>
				<th>Fees to be Paid:</th>
				<td>${payment.student.course.fees}</td>
			</tr>
			<tr>
				<th>Amount Paid:</th>
				<td>${payment.amount_paid}</td>
			</tr>
			<tr>
				<th>Due Amount:</th>
				<td>${payment.due_amount}</td>
			</tr>
			<tr>
				<th>Payment Date:</th>
				<td>${payment.payment_date}</td>
			</tr>

		</table>


	</div>
</body>
</html>
