<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Add New Payment </title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: url("https://img.freepik.com/premium-photo/top-view-office-table-desk-workspace-with-calculator-black-pen-laptop-blue_101276-159.jpg") no-repeat center center fixed;
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

         p.error {
            color: red;
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="card">
        <h1>Add New Payment Details</h1>
        <form method="post" action="savepayment">
            <table>
                <tr>
                    <td>Student ID: </td> 
                    <td><input type="text" name="student_id" required /></td>
                </tr>  
                <tr>
                    <td>Payment Date:</td>  
                    <td><input type="date" name="payment_date" required/></td>
                </tr> 
                <tr>
                    <td>Amount Paid:</td>  
                    <td><input type="text" name="amount_paid" required/></td>
                </tr> 
                <tr>
                <td colspan="2" style="text-align: center;">
              <input type="submit" value="Save" /> </td>
</tr>
  
            </table>
            <p class="error">${error}</p>  
        </form>  
    </div>
</body>
</html>
