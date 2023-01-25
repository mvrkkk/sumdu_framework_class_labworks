<%-- 
    Document   : statistic
    Created on : 5 січ. 2023, 13:14:39
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Statistics</h1>
        <table>
            <tbody>
                <tr>
                    <td><label>Mean Age:</label></td>
                    <td>${stat.getMeanAge()}</td>
                </tr>
                <tr>
                    <td><label>Popular mail domain:</label></td>
                    <td>${stat.getPopularMail()}</td>
                </tr>
                <tr>
                    <td><label>Min Age:</label></td>
                    <td>${stat.getMinAge()}</td>
                </tr>
                <tr>
                    <td><label>Max Age:</label></td>
                    <td>${stat.getMaxAge()}</td>
                </tr>
                <tr>
                    <td><label>Sumdu Mails:</label></td>
                    <td>${stat.getSumduMails()}</td>
                </tr>
                <tr>
                    <td><label>Groups:</label></td>
                    <td>${stat.getGroups()}</td>
                </tr>
                <tr>
                    <td><label>Faculty</label></td>
                    <td>Students</td>
                </tr>
                <c:forEach items="${stat.getFaculty()}" var="faculty">
                    <tr>
                        <td><label>${faculty.key}</label></td>
                        <td>${faculty.value}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
