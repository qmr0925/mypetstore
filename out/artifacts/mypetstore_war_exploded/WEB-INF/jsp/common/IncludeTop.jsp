<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css"
          media="screen" />

    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
    <title>JPetStore Demo</title>
    <meta content="text/html; charset=UTF-8"
          http-equiv="Content-Type" />
    <meta http-equiv="Cache-Control" content="max-age=0" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="Pragma" content="no-cache" />


    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="jqueryauto.js"></script>

    <script>
        $(function () {
            $("#button").click(function () {
                if ($("#email").val()) {
                    $.ajax({
                        type: "POST",
                        url: "SendVCodeServlet",
                        data: {
                            email: $("#email").val(),
                        },
                        success: function (data) {
                            alert("验证码发送成功，请注意查收。");
                        },
                    })
                } else {
                    alert("邮箱发送失败");
                }
            });
        });
    </script>

    <script>
        function myReload() {
            document.getElementById("myImage").src = "authCode?" + Math.random();
        }
    </script>

    <script>
        var xhr;
        function checkUsername() {
            var username = document.getElementById("username").value;
            xhr = new XMLHttpRequest();
            xhr.onreadystatechange = process;
            xhr.open("GET", "usernameIsExist?username="+username, true);
            xhr.send(null);
        }

        function process() {
            if(xhr.readyState === 4){
                if(xhr.status === 200){
                    var responseInfo = xhr.responseText;
                    var msg = document.getElementById("isExistInfo");
                    if(responseInfo === "Exist"){
                        msg.classList.add("errormsg");
                        msg.innerText = '用户名不可用';
                    }
                    else if(responseInfo === "Not Exist"){
                        msg.classList.remove("errormsg");
                        msg.classList.add("okmsg");
                        msg.innerText = '用户名可用';
                    }
                }
            }
        }
    </script>

    <script>
        var xhr;
        function updateItem(item) {
            xhr = new XMLHttpRequest();
            xhr.onreadystatechange = update;
            xhr.open("POST", "updateCartItem?itemId="+item.name+"&quantity="+item.value, true);
            xhr.send(null);
        }

        function update() {
            if(xhr.readyState === 4){
                if(xhr.status === 200){
                    var result = xhr.responseText;
                    var newItem = eval("("+result+")");
                    var isRemoved = newItem.isRemoved;
                    var m = document.getElementById("m");

                    if(isRemoved == "false"){
                        var item = document.getElementsByName(newItem.itemId);
                        item.innerText = newItem.quantity;
                        document.getElementById("itemtotalcost").innerHTML=newItem.html;
                    }
                    else if(isRemoved == "true"){
                        var row = document.getElementById(newItem.itemId);
                        document.getElementById("carttable").deleteRow(row.rowIndex);
                    }
                }
            }
        }
    </script>
</head>

<body>
<font color="#fffff0 ">
<div id="Header" style="background-color: darkseagreen" >

    <div id="Logo" style="background-color: darkseagreen">
        <div id="LogoContent">
            <a href="main"><img src="images/logo-topbar.gif" /></a>
        </div>
    </div>


    <div id="Menu" style="background-color: darkseagreen">
        <div id="MenuContent" style="background-color: darkseagreen">
            <a href="viewCart"><img align="middle" name="img_cart"
                                    src="images/cart.gif" /></a> <img align="middle"
                                                                         src="images/separator.gif" /> <a
                href="viewSignin">Sign In</a> <a href="signout">Sign
            Out</a> <img align="middle" src="images/separator.gif" /> <a
                href="viewMyAccount">My Account</a> <img align="middle"
                                             src="images/separator.gif" /> <a href="viewHelp">?</a>
        </div>
    </div>

    <div id="Search" style="background-color: darkseagreen">
        <div id="SearchContent">
            <form action="search" method="post">
                <input type="text" name="keyword" size="14" id="word"/>
                <input type="submit" name="searchProducts" value="Search" id="submit" />
                <div id="auto"></div>
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="viewCategory?categoryId=FISH"><img
                src="images/sm_fish.gif" />
        </a>
        <img src="images/separator.gif" />

        <a href="viewCategory?categoryId=DOGS">
            <img
                src="images/sm_dogs.gif" />
        </a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=REPTILES"><img
                src="images/sm_reptiles.gif" /></a>
        <img
            src="images/separator.gif" />
        <a href="viewCategory?categoryId=CATS"><img
            src="images/sm_cats.gif" /></a>

        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=BIRDS"><img
                src="images/sm_birds.gif" /></a>
    </div>

</div>
</font>
<div id="Content">
