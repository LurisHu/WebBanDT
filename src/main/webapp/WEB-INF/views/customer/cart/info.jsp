<%@ page pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
${sessionScope['scopedTarget.cartService'].count} items
x
${sessionScope['scopedTarget.cartService'].amount} USD

<a href="/cart/view">View Cart</a>