<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>员工管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 



</script>
<link href="css/style1.css" rel='stylesheet' type='text/css' />
<script src="js/jquery-1.4.1.min.js"></script>
</head>
<body>
	<script>
		$(document).ready(function(c) {
			$('.close').on('click', function(c) {
				$('.login-form').fadeOut('slow', function(c) {
					$('.login-form').remove();
				});
			});
		});
	</script>
	<!--SIGN UP-->
	<h1>员工管理系统登录页</h1>
	<div class="login-form">
		<div class="close"></div>
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<img src="images/avtar.png" />
		</div>
		<form action="user-login" method="post">
			<input name="username" type="text" class="text" value="Username"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Username';}">
			<div class="key">
				<input name="password" type="password" value="Password"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Password';}">
			</div>
			<div class="signin">
				<input type="submit" value="Login">
			</div>
		</form>
	</div>

</body>
</html>