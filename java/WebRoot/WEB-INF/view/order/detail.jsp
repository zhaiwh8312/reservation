<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta name="description" content="" />
		<meta name="author" content="" />
		
		<title></title>
	
		<link href="<%=request.getContextPath()%>/resource/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="<%=request.getContextPath()%>/resource/css/styles.css" rel="stylesheet" media="screen">
		
		<script src="<%=request.getContextPath()%>/resource/js/jquery-1.11.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/resource/js/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath()%>/resource/js/jquery.lazyload.min.js?v=1.9.3"></script>
		
		<style type="text/css">
			body {
			  	padding-top: 70px;
			}
			
			.navbar {
				margin-bottom: 20px;
			}
  		</style>
		
		<script type="text/javascript">
			function payOrder(detailId) {
				$.ajax({
					url : "<%=request.getContextPath() %>/order/pay.json",
					data : {
						detailId : detailId,
					},
					async : false,
					type : "post",
					success : function(data) {
						if (data != null && data != "") {
							window.location.reload();
						} else {
						}
					},
					error : function(err) {
						alert("error");
					},
					exception : function() {
						
					}
				});
			}
		
			function doneOrder(orderId) {
				$.ajax({
					url : "<%=request.getContextPath() %>/order/done.json",
					data : {
						orderId : orderId
					},
					async : false,
					type : "post",
					success : function(data) {
						if (data != null && data != "") {
							window.location.href="<%=request.getContextPath() %>/order/index";
						} else {
						}
					},
					error : function(err) {
						alert("error");
					},
					exception : function() {
						
					}
				});
			}
			
			$(document).ready(function() {
				refreshTopClass("#li_order");
			});
		</script>
	</head>

	<body>
		<jsp:include page="/WEB-INF/view/base/top.jsp" flush="true"/>
		<div class="container">
			<div class="jumbotron">
				<h1>${orderInfo.order_name }</h1>
				<p>
					${fn:substring(orderInfo.order_create_time, 0, 10)}
				</p>
				<p>
					总共 ：${fn:length(list)} 份
				</p>
				<p>
					<div class="input-group" style="width:200px">
  						<span class="input-group-addon">¥</span>
  						<input type="text" class="form-control" value="${orderInfo.order_amount }" disabled="disabled" />
  						<span class="input-group-addon">元</span>
					</div>
				</p>
				<p>
					<a class="btn btn-default" role="button" onclick="javascript:history.back()">Back</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn btn-info" role="button" onclick="javascript:window.location.reload()">Refresh</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn btn-primary btn-lg" role="button" onclick="javascript:doneOrder('${orderInfo.order_id}')">Done</a>
				</p>
			</div>
		
			<table class="table table-striped">
				<tr>
					<th>序号</th>
					<th>支付</th>
					<th>预定人</th>
					<th>数量</th>
					<th>预定时间</th>
					<th>要求</th>
				</tr>
				<c:forEach items="${list }" var="detail" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>
						<c:if test="${detail.is_pay == 0 }">
							<button type="button" class="btn btn-primary btn-xs" onclick="payOrder('${detail.detail_id }')"><span class="glyphicon glyphicon-usd"></span></button>
						</c:if>
					</td>
					<td>${detail.user_name }</td>
					<td><span class="label label-info">${detail.copy }</span></td>
					<td>${detail.book_time }</td>
					<td><span class="label label-primary">${detail.demand }</span></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="/WEB-INF/view/base/footer.jsp" />
	</body>
</html>