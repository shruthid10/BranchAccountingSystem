<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Admin Search Page</title>

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
        <a href="admin">Home</a>
    </header>

    <form action="/AccountingSystem/search" method="GET">
        <div class="radio-group">
            <input type="radio" name="searchOption" value="accountant"  onclick="updatePlaceholder('Enter branch name')" required>
            <label for="accountant">Search Accountants</label>
        </div>
        <div class="radio-group">
            <input type="radio" name="searchOption" value="student" onclick="updatePlaceholder('Enter course name')" required>
            <label for="student">Search Students</label>
        </div>
        <input type="text" name="searchCriteria" id="searchCriteria" placeholder="Enter branch name" required >
        <button type="submit">Search</button>
    </form>

    <script>
        function updatePlaceholder(placeholder) {
            document.getElementById('searchCriteria').placeholder = placeholder;
        }
    </script>

    <p class="error">${error}</p>
</body>

</html>
