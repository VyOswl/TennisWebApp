package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BeanException;
import beans.Joueur;
import dao.JoueurDaoImpl;

/**
 * Servlet implementation class ListeJoueur
 */
@WebServlet("/ajouterJoueur")
public class ajouterJoueur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ajouterJoueur() {
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

		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterJoueur.jsp").forward(request, response);

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

		JoueurDaoImpl newJ = new JoueurDaoImpl();
		Joueur joueur = new Joueur();
		try {
			joueur.setNom(request.getParameter("txtNom"));
			joueur.setPrenom(request.getParameter("txtPrenom"));
			joueur.setSexe(request.getParameter("opSexe"));
			joueur.setId(0);
			newJ.ajouter(joueur);
		} catch (BeanException e) {
			request.setAttribute("erreur", e.getMessage());
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterJoueur.jsp").forward(request,
					response);
		}

		if (!joueur.getNom().equals("") || !joueur.getPrenom().equals("") || !joueur.getSexe().equals("")) {
			response.sendRedirect("/TennisWebApp/listeJoueur");
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterJoueur.jsp").forward(request,
					response);
		}
	}

}
