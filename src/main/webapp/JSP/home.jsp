<%-- 
    Document   : home
    Created on : Jul 14, 2016, 3:26:52 PM
    Author     : gao
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="X-UA-Compatible" content="IE=edge">
         <meta name="viewport" content="width=device-width, initial-scale=1">
       

        <!-- Bootstrap Core CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="<c:url value="/resources/css/clean-blog.css" />">

        <!-- Custom Fonts -->
        <link href="<c:url value="/resources/css/work-sans.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/resources/css/yrsa.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
        <meta name="msapplication-TileColor" content="#da532c">
        <meta name="msapplication-TileImage" content="/favicons/mstile-144x144.png">
        <meta name="theme-color" content="#ffffff">
        <title>Home</title>
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
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-custom navbar-fixed-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                        <a class="navbar-brand" href="<c:url value="home"/> ">${user.username}</a>
    
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">

                        <li>
                            <a href="<c:url value="logout"/> ">Log out</a>
                        </li>

                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

                        
 <!-- Page Header -->
        <header class="intro-header" style="background-image: url(&#39;<c:url value="/resources/images/tang.jpg" />&#39;)">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                        <div class="site-heading">
                            <h1>北美吐槽君</h1>

                        </div>
                    </div>
                </div>
            </div>
        </header>
        

        <!-- Main Content -->
        <div class="container">
                <div class="row">
                        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                            
                            
        <c:forEach items="${post}" var="item">
                    <div class="post-preview">
                        <a href="<c:url value="/p/${item.gossip.id}"/>">
                            <h4 class="post-title">   ${item.gossip.text} 
                            </h4>

                        </a>
                        <div class="container  post-meta">
                            <div class="row">
                                <div class="col-sm-3">
                                    <span class="glyphicon glyphicon-share"></span>  ${item.gossip.forwardNum} 
                                    <span class="glyphicon glyphicon-edit"></span>   ${item.gossip.commentsNum}  
                                    <span class="glyphicon glyphicon-thumbs-up"></span>  ${item.gossip.upNum}
                                </div>
                                <div class="col-sm-6">
                                       ${item.gossip.timeRetrieved}</p>
                                </div>
                            </div>
                        </div>        
                            
                    </div>
                    <hr>
            
      
        </c:forEach>                    



       


        <!-- Pager -->
<!--
        <ul class="pager">

            <li class="previous">
                <a href="https://blog.union.io/">← Newer Posts</a>
            </li>


        </ul>


                        </div>
                </div>
        </div>
-->
        <hr>
        
        <!-- jQuery -->
        <script async="" src="<c:url value="/resources/js/analytics.js" />"></script>
        <script src="<c:url value="/resources/js/jquery.min.js" />"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

        <!-- Custom Theme JavaScript -->
        <script src="<c:url value="/resources/js/clean-blog.min.js" />"></script>

        <!-- Syntax highlighting -->


        <!-- google analytics -->
        <script>
          (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
          (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
          m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
          })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

          ga('create', 'UA-38381799-1', 'auto');
          ga('send', 'pageview');

        </script>
       
        
    </body>    
</html>
