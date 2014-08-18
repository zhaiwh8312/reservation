<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<style type="text/css">
			.form-signin {
			  max-width: 330px;
			  padding: 15px;
			  margin: 0 auto;
			}
			.form-signin .form-control {
			  height: auto;
			  -webkit-box-sizing: border-box;
			     -moz-box-sizing: border-box;
			          box-sizing: border-box;
			  padding: 10px;
			  font-size: 16px;
			}
		</style>
		<!-- 导航条 -->
		<div class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Reservation</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul id="topMenu" class="nav navbar-nav">
						<li id="li_home" class="active"><a href="javascript:void(0);" onclick="goHome()">Home</a></li>
						<li id="li_records"><a href="javascript:void(0);" onclick="goMyRecords()">MyRecords</a></li>
						<c:if test="${sessionScope.user.user_id == 'xingyunyun@meiti.com' }">
						<li id="li_order"><a href="javascript:void(0);" onclick="goOrder()">Order</a></li>
						</c:if>
						<li id="li_about"><a href="javascript:void(0);" onclick="showAboutModal()">About</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:if test="${sessionScope.user != null }">
						<li id="user_span" class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
								${sessionScope.user.user_name }
								<span class="caret"></span>
							</a>
							<input type="hidden" name="loginUserId" value="${sessionScope.user.user_id }" />
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">profile</a></li>
								<li class="divider"></li>
								<li><a href="javascript:void(0);" onclick="signout()">Sign out</a></li>
							</ul>
						</li>
						</c:if>
						<c:if test="${sessionScope.user == null }">
						<li id="user_span"><a href="javascript:void(0);" onclick="showLoginModal()">Sign In</a></li>
						</c:if>
						<li><a href="javascript:void(0);" id="timezone" style="width:200px">${formated_now }</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
		<!-- 导航条 -->
		<!-- 登录框 -->
		<div class="modal fade" id="loginMode" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  	<div class="modal-dialog">
			    <div class="modal-content">
			      	<div class="modal-header">
			        	<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			        	<h4 class="modal-title">Sign In</h4>
			      	</div>
			      	<div class="modal-body">
			      		<form id="sign_form" class="form-signin" role="form">
			      			<div id="error_msg" class="alert alert-danger" role="alert" style="display:none"></div>
				      		<div class="input-group">
				      			<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				      			<input type="email" id="email" class="form-control" placeholder="Email address" required="" autofocus="">
				      		</div>
	        				<div class="input-group">
				      			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				      			<input type="password" id="password" class="form-control" placeholder="Password" required="">
				      		</div>
			      		</form>
			      	</div>
			      	<div class="modal-footer">
			        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        	<button type="button" class="btn btn-primary" onclick="signin()">Sign In</button>
			      	</div>
			      	<input type="hidden" id="afterLoginScript" name="afterLoginScript" value=""/>
			    </div><!-- /.modal-content -->
		  	</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		<!-- 登录框 -->
		
		<!-- 关于框 -->
		<jsp:include page="/WEB-INF/view/base/about.jsp"></jsp:include>
		
		<script src="<%=request.getContextPath()%>/resource/js/md5.js"></script>
		<script type="text/javascript">
			function refreshTopClass(id) {
				$("#topMenu li").each(function(index, item) {
					$(this).removeClass("active");
				});
				
				$(id).addClass("active");
			}
			
			function goHome() {
				window.location.href='<%=request.getContextPath() %>';
			}
			
			function goMyRecords() {
				alert("Wait for next version!");
			}
			
			function goOrder() {
				var afterLoginScript = "window.location.href='<%=request.getContextPath() %>/order/index';";
				
				if (checkSession(afterLoginScript) == true) {
					window.location.href='<%=request.getContextPath() %>/order/index';
				}
			}
			
			function checkSession(afterLoginScript) {
				var flag = false;
				
				$("#afterLoginScript").val("");
				
				$.ajax({
					url : "<%=request.getContextPath() %>/auth/session.json",
					data : {
					},
					async : false,
					type : "POST",
					success : function(data) {
						if (data == "") {
							showLoginModal();
							
							$("#afterLoginScript").val(afterLoginScript);
							
							flag = false;
						} else {
							flag = true;
						}
					},
					error : function(err) {
						alert("error");
					},
					exception : function() {
						
					}
				});
				
				return flag;
			}
		
			function showLoginModal() {
				$("#sign_form")[0].reset();
				$("#error_msg").hide();
				$("#loginMode").modal();
				$("#email").focus();
			}
			
			function showAboutModal() {
				$("#aboutMode").modal();
			}
			
			function dynamicTime() {
				setInterval("showTime()", 1000);
			}
			
			function showTime() {
				var time = new Date();
				
				var Year = time.getFullYear();//ie火狐下都可以
				var Month = time.getMonth()+1;
				var Day = time.getDate();
				var Hour = time.getHours();
				var Minute = time.getMinutes();
				var Second = time.getSeconds();
				
				if (Month < 10) {
					Month = "0" + Month;
				}
				if (Day < 10) {
					Day = "0" + Day;
				}
				if (Hour < 10) {
					Hour = "0" + Hour;
				}
				if (Minute < 10) {
					Minute = "0" + Minute;
				}
				if (Second < 10) {
					Second = "0" + Second;
				}
				
				$("#timezone").text(Year + "-" + Month + "-" +  Day + " " + Hour + ":" + Minute + ":" + Second);
			}
			
			function signin() {
				$.ajax({
					url : "<%=request.getContextPath() %>/auth/signin.json",
					data : {
						loginName : $("#email").val(),
						password : hex_md5($("#password").val())
					},
					async : true,
					type : "POST",
					success : function(data) {
						var dataObject = eval('(' + data + ')');
						
						if (dataObject.result == 'success') {
							var str = '<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">';
							str += dataObject.obj.user_name;
							str += '<span class="caret"></span></a>';
							str += '<input type="hidden" name="loginUserId" value="' + dataObject.obj.user_id + '" />';
							str += '<ul class="dropdown-menu" role="menu">';
							str += '<li><a href="#">profile</a></li>';
							str += '<li class="divider"></li>';
							str += '<li><a href="javascript:void(0);" onclick="signout()">Sign out</a></li>';
							str += '</ul>';
							
							$("#user_span").html(str);
							$("#loginMode").modal('hide');
							
							var script = $("#afterLoginScript").val();
							$("#afterLoginScript").val("");
							
							if (script != "") {
								setTimeout(script, 500);
							} else {
								window.location.reload();
							}
						} else {
							$("#error_msg").text(dataObject.msg);
							$("#error_msg").show();
						}
					},
					error : function(err) {
						alert("error");
					},
					exception : function() {
						
					}
				});
			}
			
			function signout() {
				$.ajax({
					url : "<%=request.getContextPath() %>/auth/signout.json",
					data : {
					},
					async : true,
					type : "POST",
					success : function(data) {
						if (data == 'success') {
							//var str = '<a href="javascript:void();" onclick="showLoginModal()">Sign In</a>';
							
							//$("#user_span").html(str);
							
							window.location.reload();
						}
					},
					error : function(err) {
						alert("error");
					},
					exception : function() {
						
					}
				});
			}
			
			$(document).ready(function () {
				//dynamicTime();
			});
		</script>
