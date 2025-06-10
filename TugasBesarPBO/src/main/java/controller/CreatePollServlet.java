package controller;

import dao.PollDAO;
import model.Poll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/CreatePollServlet")
public class CreatePollServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String question = request.getParameter("question");
        String[] optionArray = request.getParameterValues("options");

        if (question == null || optionArray == null) {
            response.sendRedirect("create_poll.jsp?error=invalid_input");
            return;
        }

        List<String> options = Arrays.stream(optionArray)
                                     .filter(opt -> opt != null && !opt.trim().isEmpty())
                                     .collect(Collectors.toList());

        Poll poll = new Poll();
        poll.setUserId(1);
        poll.setQuestion(question);

        PollDAO dao = new PollDAO();
        int pollId = dao.createPoll(poll, options);

        if (pollId > 0) {
            response.sendRedirect("vote");
        } else {
            response.sendRedirect("create_poll.jsp?error=db_error");
        }
    }
}
