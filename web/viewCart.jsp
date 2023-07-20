<%-- 
    Document   : viewCart
    Created on : Feb 27, 2023, 8:34:24 AM
    Author     : Tin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Map"%>
<%@page import="tinnt.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
    </head>
    <body>
        <h1>Book Store</h1>
        <!--1. Customer goes to his/her cart place-->
        <c:if test="${not empty sessionScope}">
            <!--2. Customer takes his/her cart-->
            <c:set var="cart" value="${sessionScope.CART}" />
            <c:if test="${not empty cart}">
                <!--3. Customer get all items-->
                <c:set var="items" value="${cart.items}" />
                <c:if test="${not empty items}">
                    <!--4. Show-->
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Name</th>
                                <th>Quantity</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <form action="removeItemFromCartController">
                            <c:forEach var="item" items="${items}"
                                       varStatus="counter">
                                <tr>
                                    <td>
                                        ${counter.count}
                                        .</td>
                                    <td>
                                        ${item.key}
                                    </td>
                                    <td>
                                        ${item.value}
                                    </td>
                                    <td>
                                        <input type="checkbox" name="checkItem"
                                               value ="${item.key}" />
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="3">
                                    <a href="shoppingPage">Add More</a>    
                                </td>
                                <td>
                                    <input type="submit" value="Remove" name="btAction" />
                                </td>
                            </tr>
                        </form>

                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty items}">
                <h3>
                    No Book In Store
                </h3>
                <a href="shoppingPage">Add More</a> 
            </c:if>

        </c:if>

    </c:if>
    <%--
    <%
        //1. Customer goes to his/her cart place
        if (session != null) {
            //2. Customer takes his/her cart
            CartObj cart = (CartObj) session.getAttribute("CART");
            if (cart != null) {
                //3. Customer get all items
                Map<String, Integer> items = cart.getItems();
                if (items != null) {
                    //4. show 
    %> 
    <table border="1">
        <thead>
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <form action="DispatcherServlet">
            <%
                int count = 0;
                for (String id : items.keySet()) {
            %>
            <tr>
                <td>
                    <%= ++count%>
                    .</td>
                <td>
                    <%= id%>
                </td>
                <td>
                    <%= items.get(id)%>
                </td>
                <td>
                    <input type="checkbox" name="checkItem"
                           value ="<%= id%>" />
                </td>
            </tr>

                <%
                    }// end traverse items based on id
                %>
                <tr>
                    <td colspan="3">
                        <a href="shopping.html">Add More</a>    
                    </td>
                    <td>
                        <input type="submit" value="Remove" name="btAction" />
                    </td>
                </tr>
            </form>

        </tbody>
    </table>
    <%
            return;
        }
    }// cart has existed
    else {
    %> 
    <h3>
        No Book In Store
    </h3>
    <%
            }
        } // end view is excuted when cart had existed
%>
    --%>
</body>
</html>
