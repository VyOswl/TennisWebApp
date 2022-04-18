package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TournoiDaoImpl;

/**
 * Servlet implementation class supprimerJoueur
 */
@WebServlet("/supprimerTournoi")
public class supprimerTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int idTournoi;
	
    
    public supprimerTournoi() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}
		
		idTournoi = Integer.parseInt(request.getParameter("id"));
		TournoiDaoImpl newJ = new TournoiDaoImpl();
		newJ.supprimerT(idTournoi);
		
		response.sendRedirect("/TennisWebApp/listeTournoi");
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
		response.sendRedirect("/TennisWebApp/listeTournoi");
	}

}
