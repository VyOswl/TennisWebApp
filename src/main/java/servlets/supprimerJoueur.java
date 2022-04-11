package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.JoueurDaoImpl;

/**
 * Servlet implementation class supprimerJoueur
 */
@WebServlet("/supprimerJoueur")
public class supprimerJoueur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int idJoueur;
	
    /**,response.sendRedirect("/TennisApp/login");
     * @see HttpServlet#HttpServlet()
     */
    public supprimerJoueur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}
		
		idJoueur = Integer.parseInt(request.getParameter("id"));
		//System.out.println(idJoueur);
		JoueurDaoImpl newJ = new JoueurDaoImpl();
		newJ.supprimer(idJoueur);
		
		response.sendRedirect("/TennisWebApp/listeJoueur");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}
		
		//this.getServletContext().getRequestDispatcher("/WEB-INF/listeJoueur.jsp").forward(request, response);
		response.sendRedirect("/TennisWebApp/listeJoueur");
	}

}
