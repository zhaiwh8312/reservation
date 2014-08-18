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
			$(document).ready(function() {
				refreshTopClass("#li_order");
				
				$("img.lazy").lazyload({
					effect : "fadeIn"
				});
			});
			
			function showDetail(id) {
				var afterLoginScript = "window.location.href = '<%=request.getContextPath() %>/order/" + id + "'";
				
				if (checkSession(afterLoginScript) == true) {
					window.location.href = "<%=request.getContextPath() %>/order/"+id;
				}
			}
			
			function createOrder() {
				$.ajax({
					url : "<%=request.getContextPath() %>/order/create.json",
					data : {
					},
					async : false,
					type : "POST",
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
		</script>
	</head>

	<body>
		<jsp:include page="/WEB-INF/view/base/top.jsp" flush="true"/>
		<div class="container">
			<div class="row">
			<a class="btn btn-info" role="button" onclick="javascript:window.location.reload()">Refresh</a>
			<a class="btn btn-warning" role="button" onclick="createOrder()">CreateOrder</a>
			</div>
			<br/>
			<div class="row">
				<c:forEach items="${list }" var="order" varStatus="status">
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img class="lazy" data-original="<%=request.getContextPath() %>${order.good_pic_url }" alt="..."/>
						<div class="caption">
							<h3>${order.order_name }</h3>
							<p>
								${order.good_description }
							</p>
							<p>
								${fn:substring(order.order_create_time, 0, 10)}
							</p>
							<p>
								<div class="input-group" style="width:200px">
  									<span class="input-group-addon">¥</span>
  									<input type="text" class="form-control" value="${order.order_amount }" disabled="disabled" />
  									<span class="input-group-addon">元</span>
								</div>
							</p>
							<p>
								<c:if test="${order.order_status == 0 }">
									<span class="label label-warning">停止接受预定</span>
								</c:if>
								<c:if test="${order.order_status == 1 }">
									<span class="label label-success">预定中</span>
								</c:if>
							</p>
							<p>
								<span name="deadline_zone"></span>
							</p>
							<p>
								<a href="javascript:void(0);" class="btn btn-default" role="button" onclick="showDetail('${order.order_id }')">Detail</a>
							</p>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
		<jsp:include page="/WEB-INF/view/base/footer.jsp" />
	</body>
</html>