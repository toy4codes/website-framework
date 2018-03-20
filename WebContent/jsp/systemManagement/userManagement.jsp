<jsp:include page="/jsp/common/header.jsp" />

<script src="${pageContext.request.contextPath}/js/modules/systemManagement/userManagement.js"></script>

<div id="wrapper">

	<jsp:include page="/jsp/common/navigation.jsp" />

	<div id="page-wrapper">
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">User Management</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						User Table
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">

						<div id="datagrid"></div>
						
						<!-- Modal -->
						<div class="modal fade" id="userModal" tabindex="-1" role="dialog">
						    <div class="modal-dialog">
						        <div class="modal-content">
						            <div class="modal-header">
						                <button type="button" class="close" data-dismiss="modal">&times;</button>
						                <h4 class="modal-title" id="userModalLabel"></h4>
						            </div>
						            <div class="modal-body">
						                <form class="form-horizontal" method="post">
						                	<div class="form-group" hidden>
											    <label for="inputId" class="col-sm-2 control-label">Id</label>
											    <div class="col-sm-10">
											    	<input type="text" class="form-control" id="inputId" name="user.id">
											    </div>
											</div>
						                	<div class="form-group">
											    <label for="inputUsername" class="col-sm-2 control-label">Username</label>
											    <div class="col-sm-10">
											    	<input type="text" class="form-control" id="inputUsername" name="user.username">
											    </div>
											</div>
							                <div class="form-group">
											    <label for="inputEmail" class="col-sm-2 control-label">Email</label>
											    <div class="col-sm-10">
											    	<input type="email" class="form-control" id="inputEmail" name="user.email">
											    </div>
											</div>
											<div class="form-group">
											    <label for="inputPassword" class="col-sm-2 control-label">Password</label>
											    <div class="col-sm-10">
											    	<input type="password" class="form-control" id="inputPassword" name="user.password">
											    </div>
											</div>
											<div class="form-group">
												<div role="toolbar" class="col-sm-offset-2 col-sm-10 btn-toolbar pull-right">
													<div role="group" class="btn-group pull-right">
														<button type="submit" class="btn btn-success">Submit</button>
													</div>
													<div role="group" class="btn-group pull-right">
														<button type="reset" class="btn btn-default" data-dismiss="modal">Cancle</button> 
													</div>
												</div>
											</div>
						                </form>
						            </div>
						        </div>
						        <!-- /.modal-content -->
						    </div>
						    <!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->
						
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