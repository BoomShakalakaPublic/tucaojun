<%-- 
    Document   : signup.jsp
    Created on : Jul 14, 2016, 9:39:10 PM
    Author     : gao
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up </title>
    </head>
    <body>
        <form:form modelAttribute="user">
            <table>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="email"/></td>
                    <td><form:errors path="email"/></td>
                </tr>
                <tr>
                    <td>username:</td>
                    <td><form:input path="username"/></td>
                    <td><form:errors path="username"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password"/></td>
                    <td><form:errors path="password"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Sign Up"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
