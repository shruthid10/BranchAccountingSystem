<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
    <title>Add New Student</title>
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
     <script>
    function validateInput(event) {
      var input = event.target;
      var inputValue = input.value;
      var pattern = /^[a-zA-Z\s\W]+$/; // Only allows letters and special characters
      
      if (!pattern.test(inputValue)) {
        // Invalid input, clear the field
        input.value = '';
        alert('Only letters and special characters are allowed.');
      }
    }
  </script>
</head>
<body>
    <div class="card">
		<h1>Add New Student</h1>
       <form:form method="post" action="savestudent">  
      	<table >  
        <tr>  
  <td>First_Name: </td> 
  <td><input  name="first_name" oninput="validateInput(event)" required/></td>
</tr>
 
         <tr>  
          <td>Last_Name:</td>  
          <td><input name="last_name" oninput="validateInput(event)" required /></td>
         </tr> 
         <tr>  
          <td>Email:</td>  
          <td><input name="email" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" title="Eg:abc@gmail.com" required/></td>
         </tr> 
          <tr>  
          <td>Address:</td>  
          <td><input name="address" oninput="validateInput(event)" required /></td>
         </tr> 
           <tr>  
          <td>City:</td>  
          <td><input name="city"  oninput="validateInput(event)" required/></td>
         </tr>
           <tr>  
          <td>State:</td>  
          <td><input name="state" oninput="validateInput(event)" required/></td>
         </tr>
           <tr>  
          <td>Phone_Number:</td>  
          <td><input name="phone_number" minlength="10" maxlength="10" pattern="[0-9]+" title="Please enter only digits (0-9)" required /></td>
         </tr>
       <tr>
    <td>Course:</td>
    <td>
        <form:select path="course_id">
            <form:option value="" label="--- Select Course ---"/>
            <form:options items="${courses}" itemValue="course_id" itemLabel="name"/>
        </form:select>
    </td>
</tr>
		<tr>

<td><form:input type="hidden" path="payment_status" value="false" /></td>
</tr>

		<tr>
            <td>Branch:</td>
            <td>
                <form:select path="branch_id">
                    <form:option value="" label="--- Select Branch ---"/>
                    <form:options items="${branches}" itemValue="branch_id" itemLabel="branch_name"/>
                </form:select>
            </td>
        </tr>
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save Student" /></td>  
         </tr>  
        </table>  
       </form:form>  
</div>
</body>
</html>
       