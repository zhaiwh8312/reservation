<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<!-- 预定框 -->
		<div class="modal fade" id="bookMode" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  	<div class="modal-dialog">
			    <div class="modal-content">
			      	<div class="modal-header">
			        	<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			        	<h4 class="modal-title">Book</h4>
			      	</div>
			      	<div class="modal-body">
			      		<form id="book_form" role="form">
			      			<input type="hidden" id="orderId" value="" />
			      			<div id="error_msg_book" class="alert alert-danger" role="alert" style="display:none"></div>
				      		<div class="input-group" style="width:200px">
				      			<!-- 
				      			<span class="input-group-addon"><i class="glyphicon glyphicon-plus"></i></span>
				      			 -->
				      			<select id="copy" class="form-control">
  									<option value="1" selected>1</option>
  									<option value="2">2</option>
  									<option value="3">3</option>
  									<option value="4">4</option>
  									<option value="5">5</option>
								</select>
								<!-- 
				      			<span class="input-group-addon">份</span>
				      			 -->
				      		</div>
				      		<br/>
				      		<input type="text" class="form-control" id="demand" name="demand" style="width:200px" maxlength="10" placeholder="demand">
			      		</form>
			      	</div>
			      	<div class="modal-footer">
			        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        	<button type="button" class="btn btn-primary" onclick="booking()">Book</button>
			      	</div>
			    </div><!-- /.modal-content -->
		  	</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
		<script type="text/javascript">
			function booking() {
				$.ajax({
					url : "<%=request.getContextPath() %>/book/booking.json",
					data : {
						orderId : $("#orderId").val(),
						copy : $("#copy").val(),
						demand : $("#demand").val()
					},
					async : true,
					type : "POST",
					success : function(data) {
						//var dataObject = eval('(' + data + ')');
						if (data == 'SUCCESS') {
							$("#bookMode").modal('hide');
							
							alert("Success!\nPay the money to xingyunyun!");
							
							window.location.reload();
						} else {
							//$("#error_msg_book").text(dataObject.msg);
							//$("#error_msg_book").show();
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
