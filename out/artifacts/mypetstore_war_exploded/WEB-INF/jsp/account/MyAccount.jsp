<%--
  Created by IntelliJ IDEA.
  User: 25770
  Date: 2019-10-23
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp" %>
<div id="BackLink">
    <a href="main">Return to Main Menu</a>
</div>

<h1 align="center">User Information</h1>
<form action="saveAccount" method="post">
    <table>
        <tr>
            <td>
                Username:
            </td>
            <td>
                <input type="text" name="username" id="username" value="${sessionScope.user.username}">
            </td>
        </tr>
        <tr>
            <td>
                New Password:
            </td>
            <td>
                <input type="password" name="password" id="password" value="${sessionScope.user.password}">
            </td>
        </tr>
        <tr>
            <td>
                Repeat Password:
            </td>
            <td>
                <input type="password" name="repeatpwd" id="repeatpwd" value="${sessionScope.user.password}">
            </td>
        </tr>
        <tr>
            <td>
                <h1 align="center">Account Information</h1>
            </td>
        </tr>
        <tr>
            <td>
                First Name:
            </td>
            <td>
                <input type="text" name="firstname" id="firstname" value="${sessionScope.user.firstname}">
            </td>
        </tr>
        <tr>
            <td>
                Last Name:
            </td>
            <td>
                <input type="text" name="lastname" id="lastname" value="${sessionScope.user.lastname}">
            </td>
        </tr>
        <tr>
            <td>
                Email:
            </td>
            <td>
                <input type="email" name="email" id="email" value="${sessionScope.user.email}">
            </td>
        </tr>
        <tr>
            <td>
                Phone:
            </td>
            <td>
                <input type="text" name="phone" id="phone" value="${sessionScope.user.phone}">
            </td>
        </tr>
        <tr>
            <td>
                Address1:
            </td>
            <td>
                <input type="text" name="address1" id="address1" value="${sessionScope.user.address1}">
            </td>
        </tr>
        <tr>
            <td>
                Address2:
            </td>
            <td>
                <input type="text" name="address2" id="address2" value="${sessionScope.user.address2}">
            </td>
        </tr>
        <tr>
            <td>
                City:
            </td>
            <td>
                <input type="text" name="city" id="city" value="${sessionScope.user.city}">
            </td>
        </tr>
        <tr>
            <td>
                Stste:
            </td>
            <td>
                <input type="text" name="state" id="state" value="${sessionScope.user.state}">
            </td>
        </tr>
        <tr>
            <td>
                Zip:
            </td>
            <td>
                <input type="text" name="zip" id="zip" value="${sessionScope.user.zip}">
            </td>
        </tr>
        <tr>
            <td>
                Country:
            </td>
            <td>
                <input type="text" name="country" id="country" value="${sessionScope.user.country}">
            </td>
        </tr>
        <tr>
            <td>
                <h1 align="center">Profile Information</h1>
            </td>
        </tr>
        <tr>
            <td>
                Language Preference:
            </td>
            <td>
                <select name="account.languagePreference">
                    <c:choose>
                        <c:when test="${sessionScope.user.languagepre.equals('English')}">
                            <option selected="selected" value="English">English</option>
                            <option value="Janpenese">Janpenese</option>
                        </c:when>
                        <c:when test="${sessionScope.user.languagepre.equals('Janpenese')}">
                            <option value="English">English</option>
                            <option selected="selected" value="Janpenese">Janpenese</option>
                        </c:when>
                        <c:otherwise>
                            <option value="English">English</option>
                            <option value="Janpenese">Janpenese</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                Favorite Catagory:
            </td>
            <td>
                <select name="account.favoriteCatagoryId">
                    <c:choose>
                    <c:when test="${sessionScope.user.favoritecata == 'FISH'}">
                        <option selected="selected" value="FISH">FISH</option>
                        <option value="DOGS">DOGS</option>
                        <option value="REPTILES">REPTILES</option>
                        <option value="CATS">CATS</option>
                        <option value="BIRDS">BIRDS</option>
                    </c:when>
                    <c:when test="${sessionScope.user.favoritecata == 'DOGS'}">
                        <option value="FISH">FISH</option>
                        <option selected="selected" value="DOGS">DOGS</option>
                        <option value="REPTILES">REPTILES</option>
                        <option value="CATS">CATS</option>
                        <option value="BIRDS">BIRDS</option>
                    </c:when>
                    <c:when test="${sessionScope.user.favoritecata == 'REPTILES'}">
                    <option value="FISH">FISH</option>
                    <option value="DOGS">DOGS</option>
                    <option selected="selected" value="REPTILES">REPTILES</option>
                    <option value="CATS">CATS</option>
                    <option value="BIRDS">BIRDS</option>
                </select>
                </c:when>
                <c:when test="${sessionScope.user.favoritecata == 'CATS'}">
                    <option value="FISH">FISH</option>
                    <option value="DOGS">DOGS</option>
                    <option value="REPTILES">REPTILES</option>
                    <option selected="selected" value="CATS">CATS</option>
                    <option value="BIRDS">BIRDS</option>
                </c:when>
                <c:when test="${sessionScope.user.favoritecata == 'BIRDS'}">
                    <option value="FISH">FISH</option>
                    <option value="DOGS">DOGS</option>
                    <option value="REPTILES">REPTILES</option>
                    <option value="CATS">CATS</option>
                    <option selected="selected" value="BIRDS">BIRDS</option>
                </c:when>
                </c:choose>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                Enable MyList:
            </td>
            <td>
                <c:choose>
                    <c:when test="${sessionScope.user.iflist == '1'}">
                        <input name="account.listOption" value="1" type="checkbox" checked="checked">
                    </c:when>
                    <c:otherwise>
                        <input name="account.listOption" value="0" type="checkbox">
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

        <tr>
            <td>
                Enable MyBanner:
            </td>
            <td>
                <c:choose>
                    <c:when test="${sessionScope.user.ifbanner == '1'}">
                        <input name="account.bannerOption" value="1" type="checkbox" checked="checked">
                    </c:when>
                    <c:otherwise>
                        <input name="account.bannerOption" value="0" type="checkbox">
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td>
                <input name="editAccount" type="submit" value="Save Account Information">
            </td>

        </tr>
    </table>
</form>
<font color="red">${requestScope.message}</font>

<%@ include file="../common/IncludeBottom.jsp"%>

