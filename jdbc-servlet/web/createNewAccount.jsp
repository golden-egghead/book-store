<%-- 
    Document   : createNewAccount.jsp
    Created on : Mar 12, 2023, 7:43:22 PM
    Author     : Tin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Account</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="createNewAccountController" method="POST">
            Username* <input type="text" name ="txtUsername" value=""/> (6 - 20 characters) <br/>
            <font color="red">
            <c:set var="errors" value="${requestScope.ERROR}" />
            <c:if test="${not empty errors}">
                <c:if test="${not empty errors.usernameLengthError}">
                    ${errors.usernameLengthError} <br/>
                </c:if>
            </c:if>
            </font>
            Password* <input type="text" name ="txtPassword" value=""/> (6 - 30 characters) <br/>
            <font color="red">
            <c:set var="errors" value="${requestScope.ERROR}" />
            <c:if test="${not empty errors}">
                <c:if test="${not empty errors.passwordLengError}">
                    ${errors.passwordLengError} <br/>
                </c:if>
            </c:if>
            </font>
            Confirm* <input type="text" name ="txtConfirm" value=""/> <br/>
            <font color="red">
            <c:set var="errors" value="${requestScope.ERROR}" />
            <c:if test="${not empty errors}">
                <c:if test="${not empty errors.confirmError}">
                    ${errors.confirmError} <br/>
                </c:if>
            </c:if>
            </font>
            Full name <input type="text" name ="txtFullName" value=""/> (2 - 50 characters) <br/>
            <font color="red">
            <c:set var="errors" value="${requestScope.ERROR}" />
            <c:if test="${not empty errors}">
                <c:if test="${not empty errors.fullNameLengthError}">
                    ${errors.fullNameLengthError} <br/>
                </c:if>
            </c:if>
            </font>
            <input type="submit" value="Create New Account" name ="btAction" />
            <input type="reset" value="Reset" />
        </form> <br/>
        <font color="red">
        <c:set var="errors" value="${requestScope.ERROR}" />
        <c:if test="${not empty errors}">
            <c:if test="${not empty errors.existedUsernameError}">
                ${errors.existedUsernameError} <br/>
            </c:if>
        </c:if>
        </font>
    </body>
</html>
