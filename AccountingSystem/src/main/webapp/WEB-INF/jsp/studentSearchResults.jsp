<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Students List</title>
    <style>
      body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background: url("https://media.istockphoto.com/id/1094302626/photo/hand-raised-for-vote-and-asking-at-conference-seminar-meeting-room.jpg?s=612x612&w=0&k=20&c=r60nXw6xfHRoNPrTiyImBGsXNS5XjtoOQfKYPrIdKe8=") no-repeat center center fixed;
        background-size: cover;
        backdrop-filter: blur(10px);
      }

      .container {
        
        text-align: center;
        margin-top: 50px;
      }

      table {
        border-collapse: collapse;
        width: 70%;
        background-color: rgba(255, 255, 255, 0.8);
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
      }

      th,
      td {
        border: 1px solid #ccc;
        padding: 8px;
        text-align: left;
      }

      th {
        background-color: #f2f2f2;
      }

      a {
        color: #000;
        text-decoration: none;
        font-weight: bold;
      }

      h1 {
        text-align: center;
        
      }
    </style>
  </head>
  <body>
    <div class="container">
    <h1>Students List</h1>
    <table border="2" width="70%" cellpadding="2">
      <c:if test="${not empty error}">
        <p>${error}</p>
      </c:if>
      <tr>
        <th>Student_Id</th>
        <th>First_Name</th>
        <th>Last_Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Phone_Number</th>
        <th>Course_Id</th>
        <th>Payment_Status</th>
        <th>Branch_Id</th>
        <th>Course_Name</th>
        <th>Branch_Name</th>
      </tr>
      <c:forEach var="student" items="${students}">
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
          <td>${student.payment_status}</td>
          <td>${student.branch_id}</td>
          <td>${student.name}</td>
          <td>${student.branch_name}</td>
        </tr>
      </c:forEach>
    </table>
    <br />
  <!--   <a href="studentform">Add New Student</a> -->
    </div>
  </body>
</html>