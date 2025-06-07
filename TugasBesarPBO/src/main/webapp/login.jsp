<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Login</title></head>
<link rel="stylesheet" href="style.css">
<body>
<div class="login">
    <h2>Selamat datang di Website</h2>
	<h3>Polling dan Voting Sederhana</h3>
	<img class="profileimage" src="img/9176947.jpg" alt="">
    <form method="post" action="LoginServlet">
        <div class="textbox">
				<input required type="text" name="username"/>
				<label>Email</label>
			</div>
			<div class="textbox">
				<input required type="password" name="password"/>
				<label>Password</label>
			</div>
			<button type="submit">
				<p>Login</p>
			</button>
    </form>
    <p class="sign-up">Tidak punya akun? <a href="register.jsp">Daftar!</a>
		</p>
		</div>
</body>
</html>
