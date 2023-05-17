<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
    <title>Update Student</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: url("https://media.istockphoto.com/id/1094302626/photo/hand-raised-for-vote-and-asking-at-conference-seminar-meeting-room.jpg?s=612x612&w=0&k=20&c=r60nXw6xfHRoNPrTiyImBGsXNS5XjtoOQfKYPrIdKe8=") no-repeat center center fixed;
            background-size: 100% 100%;
        }

        .card {
            width: 400px;
            background-color: rgba(255, 255, 255, 0.8);
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            padding: 20px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
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
        td:last-child {
  text-align: center;
}

        input[type="submit"] {
            display: block;
            margin: 0 auto;
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
		<h1>Edit Student</h1>
       <form:form method="POST" action="/AccountingSystem/editsavestudent">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="student_id" /></td>
         </tr> 
         <tr>  
          <td>First_Name : </td> 
          <td><form:input path="first_name"  /></td>
         </tr>  
         <tr>  
          <td>Last_Name:</td>  
          <td><form:input path="last_name" /></td>
         </tr> 
         <tr>  
          <td>Email:</td>  
          <td><form:input path="email" /></td>
         </tr> 
          <tr>  
          <td>Address:</td>  
          <td><form:input path="address" /></td>
         </tr> 
           <tr>  
          <td>City:</td>  
          <td><form:input path="city" /></td>
         </tr>
           <tr>  
          <td>State:</td>  
          <td><form:input path="state" /></td>
         </tr>
           <tr>  
          <td>Phone_Number:</td>  
          <td><form:input path="phone_number" /></td>
         </tr>
           <tr>  
          <td>Course_id:</td>  
          <td><form:input path="course_id" /></td>
         </tr>
          <tr>  
          <td>Branch_Id:</td>  
          <td><form:input path="branch_id" /></td>
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


