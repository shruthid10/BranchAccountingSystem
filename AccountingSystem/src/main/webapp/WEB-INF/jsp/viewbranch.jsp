    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<html>
<head>
    <title>Branch List</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: flex-start;
            min-height: 100vh;
            background: url("https://media.istockphoto.com/id/949118068/photo/books.jpg?s=612x612&w=0&k=20&c=1vbRHaA_aOl9tLIy6P2UANqQ27KQ_gSF-BH0sUjQ730=") no-repeat center center fixed;
            background-size: 100% 100%;
            background-color: rgba(0, 0, 0, 0.6);
            backdrop-filter: blur(5px);
        }
  /* Link styles */
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

        .container {
           text-align: center;
            width: 70%;
            margin-top: 50px;
            margin-left: 20px;
        }
          h1 {
            text-align: center;
            color:white;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            background-color: rgba(255, 255, 255, 0.8);
           
        }
        tr { border-bottom: 2px solid black; }

        th, td {
            padding: 10px;
            text-align: left;
            vertical-align: middle;
            border-bottom: 2px solid #ddd;
        }

        th {
            background-color: #000;
            color: #fff;
            font-weight: bold;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .btn {
            display: inline-block;
            background-color: #fff;
            color: #000;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s;
            border-radius: 20px;
            box-shadow: 0 4px 0 0 #555;
            margin: 0 5px;
        }

        .btn:hover {
            background-color: #000;
            color: #fff;
            box-shadow: 0 6px 0 0 #555;
            border-bottom: 2px solid #000;
        }

        .btn:active {
            transform: scale(0.95);
        }
    </style>
</head>
<body>
<a href="admin" class="back-link">Back</a>
    <div class="container">
        <h1>Branch List</h1>
        <table>
            <thead>
                <tr>
                    <th>Branch_id</th>
                    <th>Branch_Name</th>
                    <th>Branch_Location</th>
                    <th>State</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="branch" items="${list}">
                    <tr>
                        <td>${branch.branch_id}</td>
                        <td>${branch.branch_name}</td>
                        <td>${branch.branch_location}</td>
                        <td>${branch.state}</td>
                        <td>
                            <a href="editbranch/${branch.branch_id}">
                                <button class="btn">Update</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br/>
        <a href="branchform">Add New Branch</a>
    </div>
</body>
</html>
