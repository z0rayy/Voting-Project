<!--<%@ page import="java.util.List" %>
<%@ page import="model.PollOption" %>
<%
    // List<PollOption> options = (List<PollOption>) request.getAttribute("options");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="dashboard_style.css">
</head>
		<body>
		    <header class="main-header">
		        <div class="header-text"><h2>Voting<span>Yuk</span></h2></div>
		        <nav>
		            <a href="create_poll.jsp">Buat Polling</a>
		            <a href="vote.jsp">Voting</a>
		            <a href="hasilvote.jsp">Hasil Voting</a>
		            <a href="login.jsp">Logout</a>
		        </nav>
		    </header>
		    
		    <main>
    <h2>Pilih Salah Satu Opsi</h2>
    <form action="vote" method="post">
        <div class="option-group">
            <label><input type="radio" name="optionId" value="1"> Opsi 1</label>
        </div>
        <div class="option-group">
            <label><input type="radio" name="optionId" value="2"> Opsi 2</label>
        </div>
        <!-- Tambahkan opsi lainnya sesuai data 
        <button type="submit">Vote</button>
    </form>
</main>
		
	</body>
</html> -->


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Poll" %>
<%@ page import="model.PollOption" %>
<%@ page import="dao.PollDAO" %>
<%@ page import="dao.VoteDAO" %>
<%@ page import="util.DBUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
VoteDAO voteDAO = new VoteDAO();
%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="dashboard_style.css">
    <title>Voting</title>
</head>
<body>
		    <header class="header">
		        <div class="header-text"><h2>Voting<span>Yuk</span></h2></div>
		        <nav>
		            <a href="create_poll.jsp">Buat Polling</a>
		            <a href="vote" style="color: #0080ff; text-decoration: underline;">Voting</a>
		            <a href="hasilvote.jsp">Hasil Voting</a>
		            <a href="login.jsp" class="logout">Logout</a>
		        </nav>
		    </header>
<main>
	<h2>Daftar Voting</h2>
    <c:forEach var="poll" items="${pollsMap.keySet()}">
        <div class="poll-card">
            <form action="vote" method="post">
                <h3>${poll.question}</h3>
                <input type="hidden" name="pollingId" value="${poll.id}" />
                
                <c:forEach var="opt" items="${pollsMap[poll]}">
                    <div class="option-group">
                        <label>
                            <input type="radio" name="optionId" value="${opt.id}" required />
                            ${opt.optionText}
                        </label>
                    </div>
                </c:forEach>

                <button type="submit">Vote</button>
            </form>
        </div>
    </c:forEach>
</main>
 
</body>
</html>