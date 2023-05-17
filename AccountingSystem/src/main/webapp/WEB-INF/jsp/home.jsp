<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="ISO-8859-1">

    <title>RK Institute</title>

    <style>

        /* Style for the header and navigation bar */

        header {
            background-color: #383636;
            color: #fff;
            padding: 10px;
        
        }

        nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            
        }

        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: flex-end;
        }

        nav ul li {
            margin: 0 10px;
        }

        nav ul li a {
            color: hsl(0, 10%, 94%);
            text-decoration: none;
        }

        /* Style for the main content area */

        main {
            display: flex;
            justify-content: flex-start;
            align-items: center;
            flex-direction: column;
            margin-top: 0; /* Set margin-top to 0 */
            height: 80vh;
            background-image: url('https://rare-gallery.com/uploads/posts/519127-academic-baltimore.jpg');
            background-size: cover;
            background-position: center;
            padding-top: 60px;
        }

        .dummy-info {
            text-align: center;
            font-weight: bold; /* Apply bold to the text */ /* Apply bold to the text */
    background-color: rgb(245, 245, 235); /* Set the background color to yellow */
    opacity: 0.7    ;
        }

    </style>

</head>

<body>

    <header>
        <nav>
            <p>RK Institute</p>
            <ul>
                <li><a href="login">Login</a></li>
                <li><a href="register">Register</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <div class="institute-photo"></div>
        <div class="dummy-info">
            <h2>Welcome to RK Institute</h2>
            <p>The RK Institutes of Technology  are prestigious  government owned public technical institutes located across India. Known for their excellence in education, they are under the ownership of the Ministry of Education of the Government of India.</p>
        </div>
    </main>

</body>

</html>
