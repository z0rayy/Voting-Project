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

	    HttpSession session = request.getSession();
	    Integer userId = (Integer) session.getAttribute("userId");

	    if (userId == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }

	    String optionIdParam = request.getParameter("optionId");

	    if (optionIdParam == null) {
	        request.setAttribute("error", "Anda belum memilih opsi.");
	        request.getRequestDispatcher("vote.jsp").forward(request, response);
	        return;
	    }

	    try {
	        int optionId = Integer.parseInt(optionIdParam);
	        VoteDAO voteDAO = new VoteDAO();

	        boolean success = voteDAO.castVote(userId, optionId);

	        if (success) {
	            response.sendRedirect("hasilvote.jsp");
	        } else {
	            request.setAttribute("error", "Gagal menyimpan vote.");
	            request.getRequestDispatcher("vote.jsp").forward(request, response);
	        }

	    } catch (NumberFormatException e) {
	        request.setAttribute("error", "Opsi tidak valid.");
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
            var pollsMap = pollDAO.getAllPollsWithOptions();

            request.setAttribute("pollsMap", pollsMap);
            request.getRequestDispatcher("vote.jsp").forward(request, response);
        }
    }
}
