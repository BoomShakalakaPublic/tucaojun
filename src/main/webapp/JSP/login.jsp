<%-- 
    Document   : login
    Created on : Jul 13, 2016, 3:44:58 PM
    Author     : gao
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href=" http://getbootstrap.com/favicon.ico">
        <title>Log In </title>
            <!-- Bootstrap core CSS -->
  
            <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="<c:url value="/resources/css/ie10-viewport-bug-workaround.css" />" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
  
        <script src="<c:url value="/resources/js/ie-emulation-modes-warning.js" />" ></script>
        
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
      <style id="style-1-cropbar-clipper">/* Copyright 2014 Evernote Corporation. All rights reserved. */
    .en-markup-crop-options {
        top: 18px !important;
        left: 50% !important;
        margin-left: -100px !important;
        width: 200px !important;
        border: 2px rgba(255,255,255,.38) solid !important;
        border-radius: 4px !important;
    }

    .en-markup-crop-options div div:first-of-type {
        margin-left: 0px !important;
    }
    </style>
    </head>
    <body>
        <div class="container ">
        <c:if test="${error!=null}">
            
            <div class="alert alert-danger ">
                ${error}
              </div>
        </c:if>
      <form:form modelAttribute="user" class="form-signin">
        <h2 class="form-signin-heading">Please log in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <form:errors path="email"/>
        <form:input path="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus=""/>
        <label for="inputPassword" class="sr-only">Password</label>
        <form:errors path="password" /> 
        <form:input path="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required=""/>
               
        <form:button  class="btn btn-lg btn-primary btn-block" type="submit">Log In</form:button>
       </form:form>
        <div class="text-info text-center" >
            Need an account ?
        <a class ="btn btn-default btn-group-lg btn-link " href="<c:url value="/signup"/>">Sign up</a>
        </div>
    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src=" <c:url value="/resources/js/ie10-viewport-bug-workaround.js" />" ></script>
     
    </body>
</html>
