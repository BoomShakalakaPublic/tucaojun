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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello ${user.username}! </h1>
        <input type="button" onclick="location.href='logout'" value="Log out">
        
        <table>
            <c:forEach items="${post}" var="item">
              <tr>
                  <td><a href="<c:url value="/p/${item.postId}"/>"> ${item.text}</a></td>
              </tr>
            </c:forEach>
        </table>
</html>
