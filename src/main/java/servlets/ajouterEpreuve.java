package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.Epreuve;
import dao.EpreuveDaoImpl;

/**
 * Servlet implementation class ListeEpreuve
 */
@WebServlet("/ajouterEpreuve")
public class ajouterEpreuve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ajouterEpreuve() {
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

		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterEpreuve.jsp").forward(request, response);

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

		EpreuveDaoImpl newE = new EpreuveDaoImpl();
		Epreuve epreuve = new Epreuve();
		epreuve.setAnnee(Integer.parseInt(request.getParameter("txtYear")));
		epreuve.setType(request.getParameter("txtType").charAt(0));
		epreuve.setIdTournoi(Integer.parseInt(request.getParameter("txtIdT")));
		epreuve.setId(0);
		newE.ajouter(epreuve);

		if (!String.valueOf(epreuve.getAnnee()).equals("") || !String.valueOf(epreuve.getType()).equals("") || !String.valueOf(epreuve.getIdTournoi()).equals("")) {
			response.sendRedirect("/TennisWebApp/listeEpreuve");
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterEpreuve.jsp").forward(request,
					response);
		}
	}

}