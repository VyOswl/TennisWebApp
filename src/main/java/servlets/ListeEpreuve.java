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

import beans.Epreuve;
import dao.EpreuveDaoImpl;

/**
 * Servlet implementation class ListeMatch
 */
@WebServlet("/listeEpreuve")
public class ListeEpreuve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public List<Epreuve> list;
	
	public ListeEpreuve() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}

		EpreuveDaoImpl epreuve = new EpreuveDaoImpl();
		list = epreuve.lister();
		request.setAttribute("list", list);

		this.getServletContext().getRequestDispatcher("/WEB-INF/listeEpreuve.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action1");
		EpreuveDaoImpl newED = new EpreuveDaoImpl();
		HttpSession session=request.getSession(true);
		
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}

		if ("Rechercher".equals(action)) {
			int year = Integer.parseInt(request.getParameter("txtYear"));
			//char type = request.getParameter("txtType").charAt(0);
			String type = request.getParameter("txtType");
			//System.out.println(year);
			//System.out.println(type);
			if (!request.getParameter("txtYear").equals("") && !request.getParameter("txtType").equals("")) {
				request.setAttribute("list", newED.chercherE(year, type));
				request.setAttribute("result", newED.chercher(year, type));
			    this.getServletContext().getRequestDispatcher("/WEB-INF/listeEpreuve.jsp").forward(request, response);
			} else {
				System.out.println("Champs de recherche est vide");
			}
			
		} else if ("Refresh".equals(action)){
			//list = newED.lister();
			request.setAttribute("list", list);
			this.getServletContext().getRequestDispatcher("/WEB-INF/listeEpreuve.jsp").forward(request, response);
			
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