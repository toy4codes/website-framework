<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<meta name="description" content="">
<meta name="author" content="">

<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico">

<title>website-framework</title>

<!-- jquery -->
<script src="${pageContext.request.contextPath}/js/jquery/jquery-1.12.4.min.js"></script>

<!-- jquery ui -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bootstrap-3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-3.3.7/js/bootstrap.min.js"></script>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="${pageContext.request.contextPath}/js/bootstrap-3.3.7/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/bootstrap-3.3.7/js/ie10-viewport-bug-workaround.js"></script>

<!-- MetisMenu -->
<link href="${pageContext.request.contextPath}/js/startbootstrap-sb-admin-2-3.3.7/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/startbootstrap-sb-admin-2-3.3.7/metisMenu/dist/metisMenu.min.js"></script>

<!-- font-awesome -->
<link href="${pageContext.request.contextPath}/js/startbootstrap-sb-admin-2-3.3.7/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- bootstrap admin -->
<link href="${pageContext.request.contextPath}/js/startbootstrap-sb-admin-2-3.3.7/dist/css/sb-admin-2.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/startbootstrap-sb-admin-2-3.3.7/dist/js/sb-admin-2.js"></script>

<!--  timepicker is used in jui_filter_rules -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jQuery-Timepicker-Addon/jquery-ui-timepicker-addon.min.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery-Timepicker-Addon/jquery-ui-timepicker-addon.min.js"></script>

<!--  moment is used in jui_filter_rules -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/moment/min/moment.min.js"></script>

<!--  FILTERS plugin -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jui_filter_rules/minified/jquery.jui_filter_rules.bs.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jui_filter_rules/minified/jquery.jui_filter_rules.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jui_filter_rules/minified/localization/en.min.js"></script>

<!--  PAGINATION plugin -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bs_pagination/jquery.bs_pagination.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bs_pagination/jquery.bs_pagination.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bs_pagination/localization/en.min.js"></script>

<!--  DATAGRID plugin -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bs_grid/minified/jquery.bs_grid.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bs_grid/minified/jquery.bs_grid.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bs_grid/minified/localization/en.min.js"></script>

<!-- flot chart -->
<script src="${pageContext.request.contextPath}/js/flot/excanvas.js"></script>
<script src="${pageContext.request.contextPath}/js/flot/jquery.flot.js"></script>
<script src="${pageContext.request.contextPath}/js/flot/jquery.flot.pie.js"></script>
<script src="${pageContext.request.contextPath}/js/flot/jquery.flot.tooltip.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

</head>
<body>
