<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
    <title>Add New Branch</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: url("https://img.freepik.com/free-photo/business-office-scene_1387-15.jpg") no-repeat center center fixed;
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
      

		<h1>Add New Accountant</h1>
		
       <form:form method="post" action="saveaccountant" modelAttribute="accountant">  
      	<table >  
         <tr>  
          <td>First_Name: </td> 
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
          <td>Salary:</td>  
          <td><form:input  path="salary"  /></td>
         </tr> 
         <tr> 
         <tr>
                <td>Branch:</td>
                <td>
                    <form:select path="branch_id">
                        <form:options items="${branches}" itemValue="branch_id" itemLabel="branch_name" />
                    </form:select>
                </td>
            </tr>
         <%-- <tr>  
          <td>Branch_id:</td>  
          <td><form:input path="branch_id" /></td>
         </tr> --%> 
         <tr>
          
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>
           <p class="error">${error2}</p>
        </table>  
       </form:form>  
</div>
</body>
</html>