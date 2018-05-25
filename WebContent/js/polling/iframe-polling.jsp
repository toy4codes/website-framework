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
			$("#logs").append("[data: " + $($("#frame").get(0).contentDocument).find("body").text() + " ]<br/>");
            $("#frame").attr("src", "${pageContext.request.contextPath}/communication/user/ajax.mvc?timed=" + new Date().getTime());
            window.setTimeout(function () {
                window.frames["polling"].location.reload();
            }, 1000);
		}, 5000);
	});
</script>

</head>
<body>
	<iframe id="frame" name="polling" style="display: none;"></iframe>
	<div id="logs"></div>
</body>
</html>