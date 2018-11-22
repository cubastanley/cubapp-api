<%-- 
    Document   : signup
    Created on : Nov 22, 2018, 3:45:49 AM
    Author     : cubsy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="css/signup.css"%></style>
        <title>Sign Up</title>
    </head>
    <body>
        <form id="signupForm" action="webapi/users/newuser" method="POST">
            <div class="imgcontainer">
                <img src="https://drive.google.com/uc?id=1iFH9HTsozXNa52tykKcbdM6lPNAwW8oj" alt="Avatar" class="avatar">
            </div>

            <div class="container">
                <label for="uname"><b>Username:</b></label>
                <input type="text" placeholder="Enter Username" name="username" required>

                <label for="fname"><b>First Name:</b></label>
                <input type="text" placeholder="Enter First Name" name="firstname" required>

                <label for="lname"><b>Last Name:</b></label>
                <input type="text" placeholder="Enter Last Name" name="lastname" required>

                <button type="submit">Sign Up!</button>
            </div>
                <span class="sis">
                    Already a user?<br>
                    <a href="#">Sign In</a>
                </span>
        </form>
    </body>
</html>
