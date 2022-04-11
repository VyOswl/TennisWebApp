package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.JoueurDaoImpl;

/**
 * Servlet implementation class ListeJoueur
 */
@WebServlet("/listeJoueur")
public class ListeJoueur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public int idJoueur;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeJoueur() {

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
		
		JoueurDaoImpl joueurs = new JoueurDaoImpl();
		
		request.setAttribute("list", joueurs.lister());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeJoueur.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true); 
		
		String action = request.getParameter("action1");
		
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}

		if ("Rechercher".equals(action)) {
			JoueurDaoImpl newJD = new JoueurDaoImpl();
			String txt = request.getParameter("txtsearch");
			System.out.println(txt);
			if (!txt.equals("")) {
			    request.setAttribute("list", newJD.chercher(txt));
			    this.getServletContext().getRequestDispatcher("/WEB-INF/listeJoueur.jsp").forward(request, response);
			} else {
				System.out.println("Champs de recherche est vide");
			}
			
		} else {
			//HttpSession session=request.getSession(false);  
	        //session.invalidate();
			if (session != null) {
				session.removeAttribute("connectedUser");
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
		        dispatcher.forward(request, response);
	        //session.setAttribute("connectedUser", null);
	        //response.sendRedirect("/TennisApp/login");
	        return;
			}
		}
	}
}
