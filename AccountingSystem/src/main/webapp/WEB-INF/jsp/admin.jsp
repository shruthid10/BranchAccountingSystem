<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>admin</title>
	<style>
		body {
			margin: 0;
			padding: 0;
			background-image: url('bg.jpg');
			background-size: cover;
		}

		.header {
			background-color: #333;
			overflow: hidden;
		}

		.header a {
			float: left;
			color: white;
			text-align: center;
			padding: 14px 16px;
			text-decoration: none;
			font-size: 17px;
		}

		.header a:hover {
			background-color: #ddd;
			color: black;
		}
        main {
      display: flex;
      justify-content:center;;
      align-items: center;
      flex-direction: column;
      margin-top: 0;
      height: 100vh;
      background-image: url('https://img.freepik.com/free-photo/business-office-scene_1387-15.jpg');
      background-size: cover;
      background-position: center;
    }
   
    .dummy-info {
      text-align: center;
      font-weight: bold; 
      color: black;
    }
	</style>
</head>
<body>

	<div class="header">
		<a href="#">Welcome admin</a>
		<a href="branchform">Add New Branch</a>
		<a href="viewbranch">View Branches</a>
		<a href="accountantform">Add New Accountant</a>
		<a href="viewaccountant">View Accountants</a>
		<a href="courseform">Add New Course</a>
		<a href="viewcourse">View Course Details</a>
		<a href="adminsearch">Search</a>
		<a href="/AccountingSystem">Logout</a>
	</div>
    <main>
        <div class="institute-photo"></div>
        <div class="dummy-info">
          <h2>Welcome ADMIN!</h2>
          <p>As a Admin you can add a new branch,Accountant,Course</p>
        </div>
      </main>

</body>
</html>
