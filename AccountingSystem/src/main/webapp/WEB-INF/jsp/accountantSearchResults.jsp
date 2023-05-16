<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Branch List</title>
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
            color:white;
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
    <h1>Accountants</h1>
    
    <table border="2" width="70%" cellpadding="2">
        <c:if test="${not empty error}">
            <tr>
                <td colspan="6">${error}</td>
            </tr>
        </c:if>
        <tr>
            <th>Accountant ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Salary</th>
            <th>Branch Name</th>
        </tr>
        <c:forEach var="accountant" items="${accountants}">
            <tr>
                <td>${accountant.accountant_id}</td>
                <td>${accountant.first_name}</td>
                <td>${accountant.last_name}</td>
                <td>${accountant.email}</td>
                <td>${accountant.salary}</td>
                <td>${accountant.branch_name}</td>
            </tr>
        </c:forEach>
    </table>
   
    </div>
</body>
</html>