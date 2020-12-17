<%--
  Created by IntelliJ IDEA.
  User: 25770
  Date: 2019-10-23
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
    <a href="main">Return to Main Menu</a>
</div>

<form action="signin" method="post">
    <div id="Sign">
<table align="center">
    <tr>

        <td>Username:</td>
        <td><input type="text" name="username" required="required"></td>

    </tr>         <br>
    <tr>
        <td >Password:</td>
        <td><input type="text" name = "password" required="required"></td>
    </tr>
    <tr>
       <td> Verification Code:</td>
        <td><input type="text" name="authCode" required></td>
    </tr>
    <tr>
       <td> <img id="myImage" name="myImage" src="authCode"></td>
        <td><a href="javascript:void(0)" onclick="myReload()">uncleary!change the image</a></td>
    </tr>
    <tr>
        <td><font color="red">${requestScope.msg}</font></td>
    </tr>
    <tr>
       <td> <input type="submit" value="Signin"></td>
    </tr>

    </table>
    </div>
</form>
<p align="center">
    Need a username and password?<a href="viewRegister">Resgister Now!</a>
</p>

<%@ include file="../common/IncludeBottom.jsp"%>
