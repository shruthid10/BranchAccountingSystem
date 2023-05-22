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
            background: url("https://c1.wallpaperflare.com/preview/62/23/801/university-boston-college-massachusetts.jpg") no-repeat center center fixed;
            background-size: 100% 100%;
        }
 .back-link {
  color: #FFF; /* White text color */
  text-decoration: none;
  position: fixed;
  top: 10px;
  left: 10px;
  font-weight: bold;
}

.back-link:hover {
  color: #808080; /* Grey hover color */
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
         p.error {
            color: red;
            margin-top: 20px;
            text-align: center;
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

<a href="admin" class="back-link">Back</a>
    <div class="card">
        <h1>Add New Branch</h1>
        <form method="post" action="save">
            <table>
                <tr>
                    <td>Branch Name:</td>
                    <td><input type="text" name="branch_name" oninput="validateInput(event)" required></td>
                </tr>
                <tr>
                    <td>Branch Location:</td>
                    <td><input type="text" name="branch_location" oninput="validateInput(event)" required></td>
                </tr>
                <tr>
                    <td>State:</td>
                    <td><input type="text" name="state"  oninput="validateInput(event)" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save"></td>
                    <p class="error">${error }</p>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
