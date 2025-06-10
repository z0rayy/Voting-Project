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
		<h2 style="opacity: 0;
    animation: slideRight 1s ease forwards;">Daftar Akun</h2>
		<h3 style="opacity: 0;
    animation: slideRight 1s ease forwards;">Polling dan Voting Sederhana</h3>
		<img class="profileimage" src="img/9176947.jpg" alt="" style="opacity: 0;
    animation: slideRight 1s ease forwards;">
		<form class="form" action="register" method="post">
			<div class="textbox" style="opacity: 0;
    animation: slideTop 1s ease forwards;">
				<input required type="text" name="username"/>
				<label>Username</label>
			</div>
			<div class="textbox" style="opacity: 0;
    animation: slideTop 1s ease forwards;">
				<input required type="password" name="password"/>
				<label>Password</label>
			</div>
			<div class="textbox" style="opacity: 0;
    animation: slideTop 1s ease forwards;">
				<input required type="password" name="password2"/>
				<label>Konfirmasi Password</label>
			</div>
			<button type="submit" style="opacity: 0;
    animation: slideTop 1s ease forwards;">
				<p>Confirm</p>
			</button>
		</form>
		<p class="sign-up" style="opacity: 0;
    animation: slideTop 1s ease forwards;">Sudah punya akun? <a href="login.jsp">Login!</a>
		</p>
	</div>
</body>
</html>