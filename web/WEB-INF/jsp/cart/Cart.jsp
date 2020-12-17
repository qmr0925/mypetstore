<%--
  Created by IntelliJ IDEA.
  User: 25770
  Date: 2019-10-22
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>

<div id = "BackLink">
    <a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">

    <div id="Cart">
        <h2>Shopping Cart</h2>
        <form action="updateCart" method="post">
          <table id="carttable">
              <tr>
                  <th><b>Item ID</b></th>
                  <th><b>Product ID</b></th>
                  <th><b>Description</b></th>
                  <th><b>In Stock?</b></th>
                  <th><b>Quantity</b></th>
                  <th><b>List Price</b></th>
                  <th><b>Total Cost</b></th>
                  <th><b>&nbsp;</b></th>
              </tr>

              <c:if test="${sessionScope.cart.size() == 0}">
                  <tr>
                      <td colspan="8"><b>Your cart is empty.</b></td>
                  </tr>
              </c:if>

              <c:forEach var="cartItem" items="${sessionScope.cart}">
                  <tr id="${cartItem.item.itemId}">
                      <td>
                          <a href="viewItem?itemId=${cartItem.item.itemId}">${cartItem.item.itemId}</a>
                      </td>
                      <td>
                          ${cartItem.item.product.productId}
                      </td>
                      <td>
                          ${cartItem.item.attribute1} ${cartItem.item.attribute2}
                          ${cartItem.item.attribute3} ${cartItem.item.attribute4}
                          ${cartItem.item.attribute5} ${cartItem.item.product.name}
                      </td>
                      <td>
                          ${cartItem.inStock}
                      </td>
                      <td>
                          <input type="text" name="${cartItem.item.itemId}" value="${cartItem.quantity}" onblur="updateItem(this);"/>
                      </td>
                      <td>
                          <fmt:formatNumber value="${cartItem.item.listPrice}" pattern="$#,##0.00"/>
                      </td>
                      <td>
                          <div id="itemtotalcost">
                              <fmt:formatNumber value="${cartItem.total}" pattern="$#,##0.00" />
                          </div>
                      </td>
                      <td>
                          <a href="removeItemFromCart?workingItemId=${cartItem.item.itemId}" class="Button">Remove</a>
                      </td>

                  </tr>
              </c:forEach>
              <tr>
                  <td colspan="7">
                     <input type="submit" value="Update Cart">
                  </td>
                  <td>&nbsp;</td>
              </tr>

          </table>
        </form>

        <c:if test="${sessionScope.cart.size() > 0}">
            <a href="viewOrderForm" class="Button">Proceed to Checkout</a>
        </c:if>

    </div>

    <div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
