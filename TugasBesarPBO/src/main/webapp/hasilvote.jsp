<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Poll" %>
<%@ page import="model.PollOption" %>
<%@ page import="dao.PollDAO" %>
<%@ page import="dao.VoteDAO" %>
<%
    VoteDAO voteDAO = new VoteDAO();
%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="dashboard_style.css">
    <title>Hasil Vote</title>
</head>
<body>
    <header class="header">
        <div class="header-text">
        <img src="img/logo.png">
        <h2>Voting<span>Yuk</span></h2>
        </div>
        <nav>
        	<a href="home.jsp">Home</a>
            <a href="create_poll.jsp">Buat Polling</a>
            <a href="vote">Voting</a>
            <a href="hasilvote.jsp" style="color: #0080ff; text-decoration: underline;">Hasil Voting</a>
            <a href="login.jsp" class="logout">Logout</a>
        </nav>
    </header>
    <main>
        <div>
        <h2 style="color: white; opacity: 0;
    animation: slideRight 1s ease forwards;">Hasil Vote</h2>
        <%
            PollDAO pollDAO = new PollDAO();
            List<Poll> polls = pollDAO.getAllPolls();
            for (Poll poll : polls) {
                List<PollOption> options = pollDAO.getOptionsByPollId(poll.getId());
                int totalVotes = voteDAO.getTotalVotesByPollId(poll.getId());
        %>
                <div class="poll-card">
                    <h3>Q: <%= poll.getQuestion() %></h3>
                    <%
                        for (PollOption option : options) {
                            int votes = voteDAO.getVotesByOptionId(option.getId());
                            double percentage = (totalVotes > 0) ? (votes * 100.0 / totalVotes) : 0;
                    %>
                        <div class="result">
                           • <%= option.getOptionText() %>: <%= String.format("%.2f", percentage) %>%
                        </div>
                    <%
                        }
                    %>
        </div>
        <%
            }
        %>
    </div>
    </main>

</body>
</html>