<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="dashboard_style.css">
<style>
	.but-home{
	display: inline-block;
    padding: 12px 28px;
    gap: 5px;
    background: white;
    border-radius: 40px;
    margin-top: 25px;
    font-size: 16px;
    color: rgb(0, 64, 128);
    letter-spacing: 1px;
    text-decoration: none;
    font-weight: 600;
    z-index: 2;
	transition: all 0.5s ease-out;    
}
	
	.but-home:hover{
	box-shadow: 0 0 8px cyan;
	padding: 20px;
}
</style>
</head>
<body>
	<header class="header">
        <div class="header-text">
        <img src="img/logo.png">
        <h2>Voting<span>Yuk</span></h2>
        </div>
        <nav>
        	<a href="home.jsp" style="color: #0080ff; text-decoration: underline;">Home</a>
            <a href="create_poll.jsp">Buat Polling</a>
            <a href="vote">Voting</a>
            <a href="hasilvote.jsp">Hasil Voting</a>
            <a href="login.jsp" class="logout">Logout</a>
        </nav>
    </header>
    <section>
        <div class="home-content">
            <img class="profileimage" src="img/img-home.jpg" alt="">
            <div class="intro-text">
                <%
				    String username = (String) session.getAttribute("username");
				%>
                <h1 style="color: white; opacity: 0;
    	animation: slideRight 1.5s ease forwards; font-size: 46px;">Hallo, <span style="color: cyan; opacity: 0;
    	animation: slideRight 1.5s ease forwards;"><%= username %>!</span></h1>
                <br>
                <h3 style="color: white; opacity: 0;
    	animation: slideRight 1.5s ease forwards;">Selamat datang di sistem voting kami. <br>
					Buat polling, ikut voting, dan lihat hasilnya secara real-time! <br>
					Yuk, mulai berpartisipasi sekarang! </h3>
                <a href="create_poll.jsp" class="but-home" style="opacity: 0;
    	animation: slideTop 1.5s ease forwards;">Buat Polling Sekarang</a>
                <a href="vote" class="but-home" style="opacity: 0;
    	animation: slideTop 1.5s ease forwards;">Voting Sekarang</a>
            </div>
        </div>
     </section>   
</body>
</html>