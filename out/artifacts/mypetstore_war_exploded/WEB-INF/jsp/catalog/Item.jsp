<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/17
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
div#Catalog table tr
<%@ include file="../common/IncludeTop.jsp" %>
<div id="BackLink">
    <a href="viewProduct?productId=${sessionScope.product.productId}">
        Return to ${sessionScope.product.productId}
    </a>
</div>

<div id="Catalog">
    <table>
        <tr>
            <td>
                ${sessionScope.product.description}
            </td>
        </tr>
        <tr>
            <td>
                <b>${sessionScope.item.itemId}</b>
            </td>
        </tr>
        <tr>
            <td>
                <b><font size="4">
                    ${sessionScope.item.attribute1}
                    ${sessionScope.item.attribute2}
                        ${sessionScope.item.attribute3}
                        ${sessionScope.item.attribute4}
                        ${sessionScope.item.attribute5}


                </font></b>
            </td>
        </tr>
        <tr>
            <td>${sessionScope.product.name}</td>
        </tr>
        <tr>
            <td><c:if test="${sessionScope.item1<=0}">Back ordered</c:if>
            <c:if test="${sessionScope.item1>0}">${sessionScope.item1} in stock.</c:if>

            </td>
        </tr>
        <tr>
            <td>
                <fmt:formatNumber value="${sessionScope.item.listPrice}"
                pattern="$#,##0.00"/>
            </td>
        </tr>
        <tr>
            <td>
            <a class="Button" href="addItemToServlet?workingItemId=${item.itemId}">Add to Cart</a>
            </td>
        </tr>
    </table>

</div>
<%@include file="../common/IncludeBottom.jsp"%>