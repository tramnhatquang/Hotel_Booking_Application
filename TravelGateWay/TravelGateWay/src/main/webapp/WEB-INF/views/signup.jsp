<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <script
            src="https://code.jquery.com/jquery-2.2.4.min.js"
            integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <title>User Sign-up Page</title>
</head>
<body>
    <div align="center">
        <h1>Sign Up Page</h1>
        <form action="/register" method="POST">
            <div class="sign-up-form">
                <label for="userEmailAddress">Email address: </label>
                <input type="email" name="email-address" id="userEmailAddress" required>
            </div>
            <div class="sign-up-form">
                <label for="userName">Username: </label>
                <input type="text" name="userName" id="userName" required>
            </div>
            <div class="sign-up-form">
                <label for="userPassword">Password: </label>
                <input type="password" name="userPassword" id="userPassword" required>
            </div>
            <div class="sign-up-form">
                <input type="submit" value="Sign Up">
            </div>
        </form>
    </div>


</body>
</html>