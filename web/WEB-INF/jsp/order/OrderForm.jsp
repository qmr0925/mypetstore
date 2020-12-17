<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/5/2
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">

    <form action="confirmOrder" method="post">

    <table>
        <tr>
            <th colspan=2>Payment Details</th>
        </tr>
        <tr>
            <td>Card Type:</td>
            <td>
                <select name="cardType">
                    <c:forEach items="${sessionScope.creditCardTypes}" var="cardType">
                        <option value="${cardType}">
                                ${cardType}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Card Number:</td>
            <td>
                <input type="text" name="creditCard" value="${sessionScope.order.creditCard}">
                 * Use a fake number!
            </td>
        </tr>
        <tr>
            <td>Expiry Date (MM/YYYY):</td>
            <td>
                <input type="text" name="expiryDate" value="${sessionScope.order.expiryDate}">
            </td>
        </tr>
        <tr>
            <th colspan=2>Billing Address</th>
        </tr>

        <tr>
            <td>First name:</td>
            <td>
                <input type="text" name="firstName" value="${sessionScope.order.billToFirstName}">
            </td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td>
                <input type="text" name="lastName" value="${sessionScope.order.billToLastName}">
            </td>
        </tr>
        <tr>
            <td>Address 1:</td>
            <td>
                <input type="text" name="address1" value="${sessionScope.order.billAddress1}">
            </td>
        </tr>
        <tr>
            <td>Address 2:</td>
            <td>
                <input type="text" name="address2" value="${sessionScope.order.billAddress2}">
            </td>
        </tr>
        <tr>
            <td>City:</td>
            <td>
                <input type="text" name="city" value="${sessionScope.order.billCity}">
            </td>
        </tr>
        <tr>
            <td>State:</td>
            <td>
                <input type="text" name="state" value="${sessionScope.order.billState}">
            </td>
        </tr>
        <tr>
            <td>Zip:</td>
            <td>
                <input type="text" name="zip" value="${sessionScope.order.billZip}">
            </td>
        </tr>
        <tr>
            <td>Country:</td>
            <td>
                <input type="text" name="country" value="${sessionScope.order.billCountry}">
            </td>
        </tr>


            <tr>
                <th colspan=2>Shipping Address</th>
            </tr>
            <tr>
                <td>First name:</td>
                <td><input type="text" name="shipToFirstName" value="${sessionScope.order.shipToFirstName}"/></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><input type="text" name="shipToLastName" value="${sessionScope.order.shipToLastName}"/></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><input type="text" size="40" name="shipAddress1" value="${sessionScope.order.shipAddress1}"/></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><input type="text" size="40" name="shipAddress2" value="${sessionScope.order.shipAddress2}"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" name="shipCity" value="${sessionScope.order.shipCity}"/></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input type="text" size="4" name="shipState" value="${sessionScope.order.shipState}"/></td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td><input type="text" size="10" name="shipZip" value="${sessionScope.order.shipZip}"/></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" size="15" name="shipCountry" value="${sessionScope.order.shipCountry}"/></td>
            </tr>


        <tr>
            <td colspan=2>
                <input type="checkbox" name="shippingAddressRequired" value="shippingAddressRequired">
                Ship to different address...
            </td>
        </tr>

    </table>

    <input type="submit" value="Continue">

    </form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>