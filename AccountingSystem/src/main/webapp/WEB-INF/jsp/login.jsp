<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Form</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: url("https://media.istockphoto.com/id/1093588696/photo/businesswoman-working-in-her-office.jpg?s=612x612&w=0&k=20&c=STFmL8MEafDKUNfqcEfl3qBXUENiKVFR2VDkuGws824=");
            background-size: cover;
            background-position: center;
        }

        .card {
            width: 400px;
            padding: 20px;
            background-color: rgba(219, 211, 211, 0.8);
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }

        h1 {
            text-align: center;
        }

        .error {
            color: red;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 8px 16px;
            background-color: #000;
            border: none;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s;
            border-radius: 20px;
            box-shadow: 0 4px 0 0 #555;
            font-size: 14px;
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
        <h1>Login Form</h1>
        <form method="post" action="login">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Login">
            </div>
            <p class="error">${error}</p>
        </form>
    </div>
</body>
</html>
