<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delivery by CJC</title>
    <link href="<c:url value='/static/css/bootstrap_test.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<style type="text/css">
    h4.shadowed {
        text-shadow: grey 1px 1px 0px;
    }
</style>
<div class="generic-container">
    <div class="well lead"><b>Welcome to Delivery Service</b> designed by Crazy Junior Corp.</div>
    <h4 class="shadowed" align="left" style="color: springgreen"><i>We're getting everything anywhere you want it to be.<br>
        As quick, as a wind blows!</i></h4>
    <span class="well floatRight">
				<a href="<c:url value='/customer/newCustomer' />">Add new Customer</a>
			</span>
    <span class="well floatRight">
				<a href="<c:url value='/order/newOrder' />">Place new Order</a>
			</span>
</div>

</body>
</html>
