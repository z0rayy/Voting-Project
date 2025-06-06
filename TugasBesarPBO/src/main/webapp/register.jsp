<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="login">
		<h2>Daftar Akun</h2>
		<h3>Polling dan Voting Sederhana</h3>
		<img class="profileimage" src="img/9176947.jpg" alt="">
		<form class="form" action="register" method="post">
			<div class="textbox">
				<input required type="text" name="username"/>
				<label>Email</label>
			</div>
			<div class="textbox">
				<input required type="password" name="password"/>
				<label>Password</label>
			</div>
			<div class="textbox">
				<input required type="password" name="password2"/>
				<label>Konfirmasi Password</label>
			</div>
			<button type="submit">
				<p>Confirm</p>
			</button>
		</form>
		<p class="sign-up">Sudah punya akun? <a href="login.jsp">Login!</a>
		</p>
	</div>
</body>
</html>