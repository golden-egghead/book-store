<%-- 
    Document   : search
    Created on : Feb 20, 2023, 2:24:03 PM
    Author     : Tin
--%>

<%@page import="tinnt.registration.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>

    <body>
        <font color="red">
        Welcome, ${sessionScope.USER.fullName}

        </font>

        <form action="searchController">
            Search Value <input type="text" name="txtSearchValue"
                                value="${param.txtSearchValue}" /> <br/>
            <input type="submit" value="Search" name="btAction" /> <br/>
            <c:url var="urlRewriting" value="logoutController">
                <%--<c:param name="btAction" value="Logout"></c:param>--%>
            </c:url>
            <a href="${urlRewriting}">Logout</a>
        </form>
        <br/>
        <c:set var="searchValue" value="${param.txtSearchValue}" />
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}" />
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Full Name</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}"
                                   varStatus="counter">
                        <form action="updateController">
                            <tr>
                                <td>
                                    ${counter.count}
                                    .</td>
                                <td>
                                    ${dto.username}
                                    <input type="hidden" name="txtUsername" 
                                           value="${dto.username}" />
                                </td>
                                <td>
                                    <input type="text" name="txtPassword"  
                                           value="${dto.password}" />
                                </td>
                                <td>
                                    ${dto.fullName}
                                </td>
                                <td>
                                    <input type="checkbox" name="checkRole" 
                                           value="ADMIN" 
                                           <c:if test="${dto.role}">
                                               checked="checked"
                                           </c:if>
                                           />
                                </td>
                                <td>
                                    <c:url var="urlRewriting" value="deleteController">
                                        <c:param name="btAction" value="delete"></c:param>
                                        <c:param name="pk" value="${dto.username}"></c:param>
                                        <c:param name="lastSearchValue" value="${searchValue}"></c:param>
                                    </c:url>
                                    <a href="${urlRewriting}">Delete</a>
                                </td>
                                <td>
                                    <input type="hidden" name="lastSearchValue" 
                                           value="${searchValue}" />
                                    <input type="submit" value="Update" name="btAction" />
                                </td>
                            </tr>
                        </form>

                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:if test="${empty result}">
            <h2>No record is matched!!!</h2>
        </c:if>
    </c:if>
    <%--u
    <font color="red">
    <%
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String username = "";

                for (Cookie cookie : cookies) {
                    String tempUsernameForCheck = cookie.getName();
                    if (!tempUsernameForCheck.equals("JSESSIONID")) {
                        username = tempUsernameForCheck;
                    }
                }
        %>
        Welcome, <%= username%>
        <%
            }
        %>
        </font>
        <h1>Search Page</h1>
        <form action="DispatcherServlet">
            Search Value <input type="text" name="txtSearchValue" 
                                value="<%= request.getParameter("txtSearchValue")%>" /> <br/>
            <input type="submit" value="Search" name="btAction" />
        </form>
        <%
            String searchValue = request.getParameter("txtSearchValue");

            if (searchValue != null) {
                List<RegistrationDTO> result
                        = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");
                if (result != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Full name</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (RegistrationDTO dto : result) {
                        String urlRewriting = "DispatcherServlet?"
                                + "btAction=delete"
                                + "&pk=" + dto.getUsername()
                                + "&lastSearchValue=" + searchValue;
                %>
            <form action="DispatcherServlet">
                <tr>
                    <td>
                        <%= ++count%>
                        .</td>
                    <td>
                        <%= dto.getUsername()%>
                        <input type="hidden" name="txtUsername"
                               value="<%= dto.getUsername()%>" />
                    </td>
                    <td>
                        <input type="text" name="txtPassword"
                               value="<%= dto.getPassword()%>" />
                    </td>
                    <td>
                        <%= dto.getFullName()%>
                    </td>
                    <td>
                        <input type="checkbox" name="checkRole" value="ADMIN"
                               <%
                                   if (dto.isRole()) {
                               %>
                               checked="checked"
                               <%
                                   }
                               %>
                               />
                    </td>
                    <td>
                        <a href="<%= urlRewriting%>">Delete</a>
                    </td>
                    <td>
                        <input type="hidden" name="lastSearchValue"
                               value="<%=  searchValue%>" />
                        <input type="submit" value="Update" name="btAction" />
                    </td>
                </tr>
            </form>

            <%
                } // end for traversing dto
            %>
        </tbody>
    </table>

    <%
    } else {
    %>
    <h2>
        No record is matched!!!
    </h2>
    <%
            }
        } //check first time for searchValue
    %>
    --%>
</body>
</html>
