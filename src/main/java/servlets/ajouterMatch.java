package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Match;
import dao.MatchDaoImpl;

/**
 * Servlet implementation class ListeJoueur
 */
@WebServlet("/ajouterMatch")
public class ajouterMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ajouterMatch() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterMatch.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}

		MatchDaoImpl newM = new MatchDaoImpl();
		Match match = new Match();
		match.setIdEpreuve(Integer.parseInt(request.getParameter("txtIdE")));
		match.setIdVainqueur(Integer.parseInt(request.getParameter("txtIdV")));
		match.setIdFinaliste(Integer.parseInt(request.getParameter("txtIdF")));
		match.setId(0);
		newM.ajouter(match);

		if (!String.valueOf(match.getIdEpreuve()).equals("") || !String.valueOf(match.getIdVainqueur()).equals("") || !String.valueOf(match.getIdFinaliste()).equals("")) {
			response.sendRedirect("/TennisWebApp/listeMatch");
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterMatch.jsp").forward(request,response);
		}
	}

}