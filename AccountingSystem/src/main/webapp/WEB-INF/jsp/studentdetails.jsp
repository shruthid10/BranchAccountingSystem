<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details with Payment</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        
        th, td {
            border: 1px solid black;
            padding: 8px;
        }
        
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Student Details with Payment</h1>
    <c:if test="${not empty errorMessage}">
        <p>${errorMessage}</p>
    </c:if>
   
    <table>
        <thead>
            <tr>
                <th>Student ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Phone Number</th>
                <th>Course ID</th>
           
                <th>Branch ID</th>
                <th>Payment Status</th>
                <th>Payment Amount</th>
                <th>Payment Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.student_id}</td>
                    <td>${student.first_name}</td>
                    <td>${student.last_name}</td>
                    <td>${student.email}</td>
                    <td>${student.address}</td>
                    <td>${student.city}</td>
                    <td>${student.state}</td>
                    <td>${student.phone_number}</td>
                    <td>${student.course_id}</td>
                    <td>${student.branch_id}</td>
                    <td>${student.payment_status}</td>
                    <td>${student.amount_paid}</td>
                    <td>${student.payment_date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
