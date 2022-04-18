package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.BeanException;
import beans.Tournoi;
import dao.TournoiDaoImpl;

/**
 * Servlet implementation class modifierJoueur
 */
@WebServlet("/modifierTournoi")
public class modifierTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int idTournoi;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifierTournoi() {
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
		
		idTournoi = Integer.parseInt(request.getParameter("id"));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierTournoi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/*protected void supprimerJoueur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JoueurDaoImpl newJ = new JoueurDaoImpl();
		newJ.supprimer(idJoueur);
		response.sendRedirect("/TennisApp/listeJoueur");
	}*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}
			
		TournoiDaoImpl newT = new TournoiDaoImpl();
		Tournoi tournoi = new Tournoi();
		tournoi.setNom(request.getParameter("txtNom"));
		tournoi.setCode(request.getParameter("txtCode"));
		tournoi.setId(idTournoi);
		newT.modifierT(tournoi);
		
		if (!tournoi.getNom().equals("") || !tournoi.getCode().equals("")) {
			response.sendRedirect("/TennisWebApp/listeTournoi");
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierTournoi.jsp").forward(request, response);	
		}
	}
}
