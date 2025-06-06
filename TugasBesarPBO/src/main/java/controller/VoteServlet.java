package controller;

import dao.PollDAO;
import dao.VoteDAO;
import model.PollOption;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        int optionId = Integer.parseInt(request.getParameter("optionId"));

        VoteDAO dao = new VoteDAO();
        boolean success = dao.castVote(userId, optionId);

        if (success) {
            response.sendRedirect("hasilvote.jsp"); // Redirect ke halaman hasil vote
        } else {
            request.setAttribute("error", "Gagal melakukan vote.");
            request.getRequestDispatcher("vote.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PollDAO pollDAO = new PollDAO();

        String pollIdParam = request.getParameter("polling_id");

        if (pollIdParam != null) {
            // Mode: hanya 1 polling
            int pollingId = Integer.parseInt(pollIdParam);

            String question = pollDAO.getQuestionByPollId(pollingId);
            List<PollOption> options = pollDAO.getOptionsByPollId(pollingId);

            request.setAttribute("pollingId", pollingId);
            request.setAttribute("question", question);
            request.setAttribute("options", options);
            request.getRequestDispatcher("vote.jsp").forward(request, response);
        } else {
            // Mode: tampilkan semua polling sekaligus
            var pollsMap = pollDAO.getAllPollsWithOptions();

            request.setAttribute("pollsMap", pollsMap);
            request.getRequestDispatcher("vote.jsp").forward(request, response);
        }
    }
}
