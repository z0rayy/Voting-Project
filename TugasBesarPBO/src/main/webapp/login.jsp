<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Login</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="login">
    <h2 style="opacity: 0;
    animation: slideRight 1s ease forwards;">Selamat datang di Website</h2>
	<h3 style="opacity: 0;
    animation: slideRight 1s ease forwards;">Polling dan Voting Sederhana</h3>
	<img class="profileimage" src="img/9176947.jpg" alt="" style="opacity: 0;
    animation: slideRight 1s ease forwards;">
    <form method="post" action="LoginServlet">
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
			<button type="submit" style="opacity: 0;
    animation: slideTop 1s ease forwards;">
				<p>Login</p>
			</button>
    </form>
    <p class="sign-up" style="opacity: 0;
    animation: slideTop 1s ease forwards;">Tidak punya akun? <a href="register.jsp">Daftar!</a>
		</p>
		</div>
</body>
</html>
