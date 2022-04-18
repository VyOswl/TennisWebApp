package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Joueur;
import beans.Match;
import dao.JoueurDaoImpl;

/**
 * Servlet implementation class ListeJoueur
 */
@WebServlet("/listeJoueur")
public class ListeJoueur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public int idJoueur;
	public List<Joueur> list;
	public List<Joueur> result;
	
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
		list = joueurs.lister();
		request.setAttribute("list", list);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeJoueur.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action1");
		String sexe = "";
		JoueurDaoImpl newJD = new JoueurDaoImpl();
		result = new ArrayList<Joueur>();
		
		HttpSession session=request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}

		
		if ("Rechercher".equals(action)) {
			String txt = request.getParameter("txtsearch");
			System.out.println(txt);
			if (!txt.equals("")) {
				list = newJD.chercher(txt);
			    request.setAttribute("list", list);
			    this.getServletContext().getRequestDispatcher("/WEB-INF/listeJoueur.jsp").forward(request, response);
			} else {
				System.out.println("Champs de recherche est vide");
			}
			
		} else if ("Femme".equals(action)) {
			for (Joueur j: list) {
				sexe = j.getSexe();
				if (sexe.equals("F")) {
					idJoueur = j.getId();
					result.add(newJD.searchFvsH(idJoueur));
				} else {
					continue;
				}
			}
			//System.out.println(result);
			request.setAttribute("list", result);
			this.getServletContext().getRequestDispatcher("/WEB-INF/listeJoueur.jsp").forward(request, response);
			
		} else if ("Homme".equals(action)) {
			for (Joueur j: list) {
				sexe = j.getSexe();
				if (sexe.equals("H")) {
					idJoueur = j.getId();
					result.add(newJD.searchFvsH(idJoueur));
				} else {
					continue;
				}
			}
			//System.out.println(result);
			request.setAttribute("list", result);
			this.getServletContext().getRequestDispatcher("/WEB-INF/listeJoueur.jsp").forward(request, response);
				
		} else {
			if (session != null) {
				session.removeAttribute("connectedUser");
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
		        dispatcher.forward(request, response);
	        return;
			}
		}
	}
}
