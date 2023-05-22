<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: flex-start;
            min-height: 100vh;
            background: url("https://img.freepik.com/free-photo/business-office-scene_1387-15.jpg") no-repeat center center fixed;
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
    <h1>Student Details with Payment</h1>
<body>
    
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
                <th>Amount_Paid</th>
                 <th>Due Amount</th>
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
                     <td>${student.due_amount}</td>
                    <td>${student.payment_date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
