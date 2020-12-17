<%--
  Created by IntelliJ IDEA.
  User: 25770
  Date: 2019-10-23
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp" %>
<%@ page session="false"%>

<div id="BackLink">
    <a href="main">Return to Main Menu</a>
</div>
<form action="register" method="post">
    <h1 align="center">User Information</h1>
    <table align="center">
        <tr>
    <td>
        Username:
    </td>
            <td>
                <input type="text" id="username" name = "username" onblur="checkUsername();" required>
            </td>
            <td> <span id="isExistInfo"></span></td>
        </tr>


    <tr>
       <td> New Password:  </td>
        <td><input type="password" name="password" required>
        </td>
    </tr>

    <tr>
       <td>Email:  </td>
        <td>  <input type="email" name="email" id = "email" required></td>
    </tr>
    <tr>
        <td >Verification Code:
        </td>
        <td><input type="text" name="vcode" id = "vcode" required>
        </td>
        <td ><input type="button" name="button" id="button" value="send code"></td>
    </tr>

    <tr>
       <td > <font color="red">${requestScope.reminder}</font></td>
    </tr>
    <tr>
        <td><input type="submit" value="Save"></td>
    </tr>
    </table>
</form>

<%@ include file="../common/IncludeBottom.jsp"%>
