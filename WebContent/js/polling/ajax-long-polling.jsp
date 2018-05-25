<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>Ajax Long Polling</title>

<!-- jquery -->
<script src="${pageContext.request.contextPath}/js/jquery/jquery-1.12.4.min.js"></script>

<script type="text/javascript">

	$(function(){
		(function ajaxLongPolling(){
			$.ajax({
				url: "${pageContext.request.contextPath}/websocket/communication/ajaxLongPolling",
	            data: {"timed": new Date().getTime()},
	            dataType: "text",
	            success: function(data, textStatus){
					$("#logs").append("[state: " + textStatus + ", data: { " + data + "} ]<br/>");
                    if (textStatus == "success") {
                    	ajaxLongPolling();
                    }
	            }
			});
		})();
	});
	
</script>

</head>
<body>
	<div id="logs"></div>
</body>
</html>