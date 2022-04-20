package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.Tournoi;
import dao.TournoiDaoImpl;

/**
 * Servlet implementation class Listetournoi
 */
@WebServlet("/ajouterTournoi")
public class ajouterTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ajouterTournoi() {
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

		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterTournoi.jsp").forward(request, response);

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

		TournoiDaoImpl newT = new TournoiDaoImpl();
		Tournoi tournoi = new Tournoi();
		tournoi.setNom(request.getParameter("txtNom"));
		tournoi.setCode(request.getParameter("txtCode"));
		tournoi.setId(0);
		newT.ajouterT(tournoi);

		if (!tournoi.getNom().equals("") || !tournoi.getCode().equals("")) {
			response.sendRedirect("/TennisWebApp/listeTournoi");
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterTournoi.jsp").forward(request,
					response);
		}
	}
}