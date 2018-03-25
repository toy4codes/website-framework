<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        	<span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">Website Framework</a>
	</div>
    <!-- /.navbar-header -->
	
	<ul class="nav navbar-top-links navbar-right">
		<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
            	<i class="fa fa-user fa-fw"></i>
            	<i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li>
					<a href="${pageContext.request.contextPath}/jsp/login.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                </li>
			</ul>
            <!-- /.dropdown-user -->
		</li>
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->
	
	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li>
					<a href="#"><i class="fa fa-cog fa-fw"></i> System Management<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                    	<li>
                        	<a href="${pageContext.request.contextPath}/jsp/systemManagement/userManagement.jsp"">User Management</a>
                        </li>
					</ul>
                    <!-- /.nav-second-level -->
                </li>
				<li>
					<a href="#"><i class="fa fa-sitemap fa-fw"></i> WiresharkPacket<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li>
							<a href="${pageContext.request.contextPath}/jsp/wiresharkPacket/tables.jsp">Tables</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/jsp/wiresharkPacket/charts.jsp">Charts</a>
						</li>
					</ul>
					<!-- /.nav-second-level -->
				</li>
				<li>
					<a href="#"><i class="fa fa-cloud fa-fw"></i> PM2.5<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                    	<li>
                        	<a href="${pageContext.request.contextPath}/jsp/pm2.5/pm2.5.jsp">PM2.5</a>
                        </li>
					</ul>
                    <!-- /.nav-second-level -->
                </li>
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>
