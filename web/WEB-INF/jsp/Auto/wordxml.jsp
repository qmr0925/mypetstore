<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/24
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String word=(String)request.getAttribute("word");
%>
<words>
    <%if ("Amazon Parrot".startsWith(word)){%>
    <word>Amazon Parrot</word>
<%}%>

    <%if ("Finch".startsWith(word)){%>
    <word>Finch</word>
    <%}%>
    <%if ("Koi".startsWith(word)){%>
    <word>Koi</word

    <%}%>

    <%if ("Goldfish".startsWith(word)){%>
    <word>Goldfish</word>
    <%}%>

    <%if ("Angelfish".startsWith(word)){%>
    <word>Angelfish</word>
    <%}%>

    <%if ("Tiger Shark".startsWith(word)){%>
    <word>Tiger Shark</word>
    <%}%>
    <%if ("Persian".startsWith(word)){%>
    <word>Persian</word>
    <%}%>

    <%if ("Manx".startsWith(word)){%>
    <word>Manx</word>
    <%}%>

    <%if ("Bulldog".startsWith(word)){%>
    <word>Bulldog</word>
    <%}%>

    <%if ("Chihuahua".startsWith(word)){%>
    <word>Chihuahua</word>
    <%}%>
    <%if ("Dalmation".startsWith(word)){%>
    <word>Dalmation</word>
    <%}%>

    <%if ("Poodle".startsWith(word)){%>
    <word>Poodle</word>
    <%}%>


    <%if ("Golden Retriever".startsWith(word)){%>
    <word>Golden Retriever</word>
    <%}%>

    <%if ("Labrador Retriever".startsWith(word)){%>
    <word>Labrador Retriever</word>
    <%}%>
    <%if ("lguana".startsWith(word)){%>
    <word>lguana</word>
    <%}%>

    <%if ("Rattlesnake".startsWith(word)){%>
    <word>Rattlesnake</word>
    <%}%>

</words>