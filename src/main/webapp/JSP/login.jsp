<%-- 
    Document   : login
    Created on : Jul 13, 2016, 3:44:58 PM
    Author     : gao
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In </title>
    </head>
    <body>
        <form:form modelAttribute="user">
            <div>${error}</div>
            <table>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="email"/></td>
                    <td><form:errors path="email"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password"/></td>
                    <td><form:errors path="password"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Login"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
