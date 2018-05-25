<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>IFrame Pollings</title>

<!-- jquery -->
<script src="${pageContext.request.contextPath}/js/jquery/jquery-1.12.4.min.js"></script>

<script type="text/javascript">
	$(function() {
		window.setInterval(function(){
			var url = "${pageContext.request.contextPath}/communication/user/ajax.mvc?timed=" + new Date().getTime();
			var $iframe = $('<iframe id="frame" name="polling" style="display: none;" src="' + url + '"></iframe>');
			$("body").append($iframe);
			$iframe.load(function () {
				$("#logs").append("[data: " + $($iframe.get(0).contentDocument).find("body").text() + " ]<br/>");
				$iframe.remove();
			});
		}, 5000);
	});
</script>

</head>
<body>
	<iframe id="frame" name="polling" style="display: none;"></iframe>
	<div id="logs"></div>
</body>
</html>