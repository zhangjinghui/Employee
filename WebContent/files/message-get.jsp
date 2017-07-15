<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>员工信息管理系统</title>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/morrisjs/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/center.jsp">员工信息管理系统</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="user-get"><i class="fa fa-user fa-fw"></i>
								${session.user.realname}</a></li>
						<li><a href="user-logout"><i class="fa fa-sign-out fa-fw"></i>
								退出</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">

						<!-- 个人管理 -->
						<li><a href="#"><i class="fa fa-user fa-fw"></i> 个人管理 <span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="user-get">个人信息查看</a></li>
								<li><a href="user-edit">个人信息修改</a></li>
							</ul> <!-- /.nav-second-level --></li>

						<!-- 消息管理 -->
						<li><a href="#"><i class="fa fa-envelope fa-fw"></i> 消息管理<span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="message-receiverList">发送消息</a></li>
								<li><a href="message-receiveMessageList">收件信息查看</a></li>
								<li><a href="message-sendMessageList">发件信息查看</a></li>
								
							</ul> <!-- /.nav-second-level --></li>

						<!-- 任务管理 -->
						<li><a href="#"><i class="fa fa-tasks fa-fw"></i> 任务管理<span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<s:if test="#session.user.type == 1 ">
									<li><a href="task-input">创建任务</a></li>
								</s:if>
								<li><a href="task-list?pageNum=1">任务信息查看</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<s:if test="#session.user.type == 1">
							<!-- 客户管理 -->
							<li><a href="#"><i class="fa fa-comments fa-fw"></i>
									客户管理<span class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<li><a href="customer-list?pageNum=1">客户信息查看</a></li>
								</ul> <!-- /.nav-second-level --></li>

							<!-- 人员管理 -->
							<li><a href="#"><i class="fa fa-male fa-fw"></i> 人员管理<span
									class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<li><a href="emp-list?pageNum=1">员工信息查看</a></li>
									<li><a href="dept-list?pageNum=1">部门信息查看</a></li>
								</ul> <!-- /.nav-second-level --></li>

							<!-- 薪资管理 -->
							<li><a href="#"><i class="fa fa-credit-card fa-fw"></i>
									薪资管理<span class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<li><a href="salgrade-list?pageNum=1">薪资类型查看</a></li>
									<li><a href="sal-list?pageNum=1">工资明细查看</a></li>
								</ul> <!-- /.nav-second-level --></li>
						</s:if>

					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<div id="page-wrapper">


			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">消息管理</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>


			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							发件信息查看
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="row">

								<div class="col-lg-6">
									<div class="form-group">
										<label>收件人</label>
										<s:textfield name="receiver" class="form-control"
											required="true" readonly="true"></s:textfield>
									</div>
									<div class="form-group">
										<label>发件人</label>
										<td><s:textfield name="sender" class="form-control"
												required="true" readonly="true"></s:textfield>
									</div>

									<div class="form-group">
											<label>消息标题</label>
											<s:textfield name="title" class="form-control"
												required="true" readonly="true"></s:textfield>
											
										</div>
								</div>
								<div class="row">
									<div class="col-lg-6">
										
										<div class="form-group">
										<label>消息内容</label>
										<s:textarea name="content" class="form-control"
											required="true" readonly="true" style="height:110px;resize:none" ></s:textarea>
									</div>
									<div class="form-group">
											<label>发送时间</label>
											<s:textfield name="createtime" class="form-control"
												required="true" readonly="true"></s:textfield>
											
										</div>
									</div>
									
								</div>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
			</div>



		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/raphael/raphael.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/morrisjs/morris.min.js"></script>
	<script src="${pageContext.request.contextPath}/data/morris-data.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

</body>

</html>
