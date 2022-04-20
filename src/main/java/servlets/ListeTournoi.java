package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Tournoi;
import dao.JoueurDaoImpl;
import dao.TournoiDaoImpl;


@WebServlet("/listeTournoi")
public class ListeTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public List<Tournoi> list;
	
	
    public ListeTournoi() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}
		
		TournoiDaoImpl tournois = new TournoiDaoImpl();
		list = tournois.listerT();
		request.setAttribute("list", list);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeTournoi.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action1");
		TournoiDaoImpl newJD = new TournoiDaoImpl();
		String txt = request.getParameter("txtsearch");
		
		HttpSession session = request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}

		if ("Rechercher".equals(action)) {
			//System.out.println(txt);
			if (!txt.equals("")) {
				request.setAttribute("list", newJD.chercherT(txt));
				this.getServletContext().getRequestDispatcher("/WEB-INF/listeTournoi.jsp").forward(request,
						response);
			} else {
				System.out.println("Champs de recherche est vide");
			}
		
		} else if ("Refresh".equals(action)){
			request.setAttribute("list", list);
			this.getServletContext().getRequestDispatcher("/WEB-INF/listeTournoi.jsp").forward(request, response);
		
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
