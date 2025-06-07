<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buat Polling</title>
    <link rel="stylesheet" href="dashboard_style.css">
</head>
<body>
	<header class="header">
        <div class="header-text"><h2>Voting<span>Yuk</span></h2></div>
        <nav>
            <a href="create_poll.jsp" style="color: #0080ff; text-decoration: underline;">Buat Polling</a>
            <a href="vote">Voting</a>
            <a href="hasilvote.jsp">Hasil Voting</a>
            <a href="login.jsp" class="logout">Logout</a>
        </nav>
    </header>
    <main>
	    <form action="CreatePollServlet" method="post">
	        <label>Pertanyaan:</label><br>
	        <input type="text" name="question" required><br><br>
	
	        <label>Opsi Pilihan:</label><br>
	        <input type="text" name="options" required><br>
	        <input type="text" name="options" required><br>
	        <input type="text" name="options"><br>
	        <input type="text" name="options"><br>
	
	        <input type="submit" value="Buat Polling">
	    </form>    
    </main>
</body>
</html>
