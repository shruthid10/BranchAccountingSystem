<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Add New Course</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: url("https://media.istockphoto.com/id/949118068/photo/books.jpg?s=612x612&w=0&k=20&c=1vbRHaA_aOl9tLIy6P2UANqQ27KQ_gSF-BH0sUjQ730=") no-repeat center center fixed;
            background-size: cover;
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
    <div class="card">
        <h1>Add New Course</h1>
        <form:form method="post" action="savecourse">
            <table>
                <tr>
                    <td>Course Name:</td>
                    <td><input type="text" name="name" oninput="validateInput(event)" required></td>
                </tr>
               <tr>
    <td>Course Fees:</td>
    <td><input type="number" name="fees"  required></td>
</tr>
                <tr>
                    <td>Duration:</td>
                    <td><input type="number" name="duration"  required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save"></td>
                </tr>
                <p class="error">${error}</p>
            </table>
        </form:form>
    </div>
</body>
</html>
