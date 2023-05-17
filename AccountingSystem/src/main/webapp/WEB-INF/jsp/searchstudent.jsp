<!DOCTYPE html>
<html>

<head>
    <title>Search Page</title>

    <style>
        /* Header styles */
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            background-color: #333;
            color: #fff;
            width: 100%;
            height: 50px;
        }

        header a {
            color: #fff;
            text-decoration: none;
        }

        /* Form styles */
        form {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            margin-top: 50px;
        }

        .radio-group {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
        }

        .radio-group input[type="radio"] {
            margin-right: 5px;
        }
     h1 {
            text-align: center;
            
        }
        input[type="text"],
        button[type="submit"] {
            margin: 10px;
            padding: 10px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
        }

        input[type="text"] {
            width: 300px;
        }

        button[type="submit"] {
            background-color: #333;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button[type="submit"]:hover {
            background-color: #555;
        }

        p.error {
            color: red;
            margin-top: 20px;
            text-align: center;
        }
        body {
            background-image: url("https://media.istockphoto.com/id/1271072224/photo/hand-using-laptop-and-press-screen-to-search-browsing-on-the-internet-online.jpg?b=1&s=170667a&w=0&k=20&c=gi9voKg0NOGaS3qK7MdPCfszCl8agfVgTp5RWtGaRD4=");
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
</head>

<body>
    <header>
        <a href="accountanthome">Home</a>
    </header>




    <h1>Search Student</h1>
    <form action="/AccountingSystem/student" method="GET">
        <input type="text" name="student_id" placeholder="Enter Student ID" required>
        <input type="submit" value="Search">
    </form>
    <p class="error"> ${error}</p>
    
</body>
</html>
