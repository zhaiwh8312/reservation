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
				refreshTopClass("#li_home");
				
				$("img.lazy").lazyload({
					effect : "fadeIn"
				});
			});
			
			function showBookModal(order) {
				var afterLoginScript = "showBookModal('" + order + "')";
				
				if (checkSession(afterLoginScript) == true){
					$("#book_form")[0].reset();
					
					$("#orderId").val(order);
					$("#error_msg_book").hide();
					$("#bookMode").modal();
				}
			}
			
			function showDetail() {
				alert("Wait for next version!");
			}
		</script>
	</head>

	<body>
		<jsp:include page="/WEB-INF/view/base/top.jsp" flush="true"/>
		<div class="container">
			<div class="row">
				<c:forEach items="${list }" var="order" varStatus="status">
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img class="lazy" data-original="<%=request.getContextPath() %>${order.good_pic_url }" alt="${order.order_name }"/>
						<div class="caption">
							<h3>${order.order_name }</h3>
							<p>
								${order.good_description }
							</p>
							<p>
								${fn:substring(order.order_create_time, 0, 10)}
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
								<a href="javascript:void();" class="btn btn-primary" role="button" onclick="showBookModal('${order.order_id}')">Book</a> 
								<a href="javascript:void();" class="btn btn-default" role="button" onclick="showDetail()">Detail</a>
							</p>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
		<jsp:include page="/WEB-INF/view/base/footer.jsp" />
		<jsp:include page="/WEB-INF/view/reservation/book.jsp" />
	</body>
</html>