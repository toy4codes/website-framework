<jsp:include page="/jsp/common/header.jsp" />

<script src="${pageContext.request.contextPath}/js/modules/pm25.js"></script>

<div id="wrapper">

	<jsp:include page="/jsp/common/navigation.jsp" />

	<div id="page-wrapper">
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">PM2.5</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						PM2.5 Table
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div id="datagrid"></div>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	
	</div>
	<!-- /#page-wrapper -->

</div>

<jsp:include page="/jsp/common/footer.jsp" />