
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Accountant Home</title>
    <style>
      /* Navigation bar styles */
      .navbar {
        overflow: hidden;
        background-color: #333;
        position: fixed;
        top: 0;
        width: 100%;
      }

      .navbar a {
        float: left;
        display: block;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-weight: bold;
      }

      .navbar a:hover {
        background-color: #ddd;
        color: black;
      }

      /* Main content styles */
      body {
        margin: 0;
        padding-top: 50px;
        /* Add space for the fixed navigation bar */
        background: url("https://wallpapers.com/images/hd/accounting-devices-grayscale-i47iikk1zxkdtffi.jpg") no-repeat center center fixed;
        background-size: cover;
      }

      .container {
        
        text-align: center;
        font-weight: bold;
        color: black;
        background-color: rgb(245, 245, 235); /* Set the background color to yellow */
        opacity: 0.7    ;
      }
    </style>
  </head>
  <body>
    <div class="navbar">
      <a href="studentform">Add New Student</a>
      <a href="viewstudentlist">View Student List</a>
      
      <a href="viewpaymentdetails">View Payment Details</a>
      <a href="searchstudent">Search</a>
      <a href="/AccountingSystem/">Logout</a>
    </div>
    <div class="container">
      <h1>Welcome ${username}</h1>
      <p>As an Accountant, You can add  and view students and update their payment status</p>
    </div>
  </body>
</html>
