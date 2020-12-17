<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/19
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>


<div id="BackLink">

    <a href="main">Return to Main Menu</a>
</div>

    <div id="Catalog">

        <table>
            <tr>
                <th>&nbsp;</th>
                <th>Product ID</th>
                <th>Name</th>
            </tr>
            <c:forEach var="product" items="${sessionScope.productList}">
                <tr>
                    <td>
                        <a href="viewProduct?productId=${product.productId}">${product.description}</a>
                    </td>
                    <td>
                        <a href="viewProduct?productId=${product.productId}">${product.productId}</a>
                    </td>
                    <td>${product.name}</td>
                </tr>
            </c:forEach>

        </table>

    </div>





<%@ include file="../common/IncludeBottom.jsp"%>