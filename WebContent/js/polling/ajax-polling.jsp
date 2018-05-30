<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>Ajax Polling</title>

<!-- jquery -->
<script src="${pageContext.request.contextPath}/js/jquery/jquery-1.12.4.min.js"></script>

<script type="text/javascript">

	$(function() {
		window.setInterval(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/websocket/communication/ajaxPolling",
	            data: {"requestTime": new Date().getTime()},
	            dataType: "json",
	            success: function(data, textStatus){
	            	if(data.bussinessData == undefined){
	            		$("#logs").append("[state: " + textStatus + ", data: " + JSON.stringify(data) + " ]<br/>");
	            	} else if(data.bussinessData){
	            		$("#logs").append("[state: " + textStatus + ", data: " + JSON.stringify(data) + " ]<br/>");
	            	}
	            }
			});
		}, 5000);
	});
	
</script>

</head>
<body>
	<div id="logs"></div>
</body>
</html>