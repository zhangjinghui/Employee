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

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("#dept-input").click(function() {
			location.href = "dept-input";
		});

		// 点击 delete 时，弹出 确定要删除 xx 的信息吗？若确定，执行删除，若不确定，则取消
		$(".delete").click(function() {
			var $tr = $(this).parent().parent();
			var ename = $tr.children("td").eq(1).html();
			var flag = confirm("确定要删除" + ename + "的信息吗？");
			if (flag) {
				flag = confirm("注意：删除操作会同时删除该部门的所有员工，确定要删除吗？")
			}
			if (flag) {
				// 删除，使用 ajax 的方式
				var url = this.href;
				var args = {
					"time" : new Date()
				};
				$.post(url, args, function(data) {
					if (data == "1") {
						alert("删除成功!");
						$tr.remove();
					} else {
						alert("删除失败!");
					}
				});

			}
			return false;
		});

	})
</script>

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
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/center.jsp">员工信息管理系统</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="user-get"><i class="fa fa-user fa-fw"></i>
								${session.user.realname }</a></li>
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
								<li><a href="task-input">创建任务</a></li>
								<li><a href="task-list?pageNum=1">任务信息查看</a></li>
							</ul> <!-- /.nav-second-level --></li>

						<!-- 客户管理 -->
						<li><a href="#"><i class="fa fa-comments fa-fw"></i> 客户管理<span
								class="fa arrow"></span></a>
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

					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<div id="page-wrapper">


			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">部门管理</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>


			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">部门信息查看</div>
						<!-- /.panel-heading -->
						<div class="panel-body">

							<div class="table-responsive">
								<form action="dept-list" name="fom" id="fom" method="post">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>唯一编号</th>
												<th>部门名称</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="#request.departments">
												<tr>
													<td>${deptno }</td>
													<td>${dname }</td>
													<td><a
														href="dept-getEmployee?deptno=${deptno }&pageNum=1">查看该部门所有员工</a>&nbsp;|&nbsp;<a
														href="dept-input?deptno=${deptno }">编辑</a>&nbsp;|&nbsp;<a
														class="delete" href="dept-delete?deptno=${deptno }">删除</a></td>
												</tr>
											</s:iterator>
										</tbody>
									</table>

									<table width="100%" border="0" align="center" cellpadding="0"
										cellspacing="0" class="right-font08">
										<tr>
											<td width="50%">共 <span class="right-text09">${maxPage }</span>
												页 | 第 <span class="right-text09">${pageNum }</span> 页
											</td>
											<td width="49%" align="right">[<a
												href="dept-list?pageNum=1" class="right-font08">首页</a> | <a
												href="<s:if test="pageNum == 1">#</s:if><s:else>dept-list?pageNum=${pageNum-1 }</s:else>"
												class="right-font08">上一页</a> | <a
												href="<s:if test="pageNum == #request.maxPage">#</s:if><s:else>dept-list?pageNum=${pageNum+1 }</s:else>"
												class="right-font08">下一页</a> | <a
												href="dept-list?pageNum=${maxPage }" class="right-font08">末页</a>]
												转至：
											</td>
											<td width="1%">
												<table width="20" border="0" cellspacing="0" cellpadding="0">
													<tr>
														<td width="1%"><s:textfield name="pageNum"
																theme="simple" size="1" /></td>
														<td width="87%"><input name="Submit23222"
															type="submit" class="btn btn-info" value="Go" /></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<input name="Submit" id="dept-input" type="button"
										class="btn btn-outline btn-success" value="添加部门信息" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>



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
