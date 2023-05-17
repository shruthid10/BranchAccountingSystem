<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
    <title>Update Branch</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: url("https://c1.wallpaperflare.com/preview/62/23/801/university-boston-college-massachusetts.jpg") no-repeat center center fixed;
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
        <h1>Edit Branch</h1>
        <form:form method="POST" action="/AccountingSystem/editsave">  
            <table>  
                <tr>
                    <td></td>  
                    <td><form:hidden  path="branch_id" /></td>
                </tr> 
                <tr>  
                    <td>Branch_Name : </td> 
                    <td><form:input path="branch_name" oninput="validateInput(event)" /></td>
                </tr>  
                <tr>  
                    <td>Branch_Location :</td>  
                    <td><form:input path="branch_location" oninput="validateInput(event)" /></td>
                </tr> 
                <tr>  
                    <td>State :</td>  
                    <td><form:input path="state" oninput="validateInput(event)" /></td>
                </tr> 
                <tr>
                    <td colspan="2" style="text-align: center;">
                         <input type="submit" value="Edit Save" />
                        </td>
                    </tr>

                  
            </table>  
        </form:form>  
    </div>
</body>
</html>
