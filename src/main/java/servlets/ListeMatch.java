package servlets;

import java.io.IOException;
<<<<<<< Updated upstream
=======
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
>>>>>>> Stashed changes
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

<<<<<<< Updated upstream
import dao.JoueurDaoImpl;
=======
import beans.Joueur;
import beans.Match;
import dao.MatchDaoImpl;
>>>>>>> Stashed changes

/**
 * Servlet implementation class ListeMatch
 */
@WebServlet("/listeMatch")
public class ListeMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< Updated upstream
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeMatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
=======
	
	public List<Match> list;
	public List<Joueur> result;
	
	
	public void setList(List<Match> list) {
		this.list = list;
	}


	public void setResultList(List<Joueur> resultList) {
		this.result = resultList;
	}


	public List<Joueur> getResultList() {
		return result;
	}


	public List<Match> getList() {
		return list;
	}


	public ListeMatch() {
		super();
		// TODO Auto-generated constructor stub
	}

	
>>>>>>> Stashed changes
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}
<<<<<<< Updated upstream
		
		JoueurDaoImpl joueurs = new JoueurDaoImpl();
		
		request.setAttribute("list", joueurs.lister());
		
=======

		MatchDaoImpl match = new MatchDaoImpl();
		list = match.lister();
		request.setAttribute("list", list);

>>>>>>> Stashed changes
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeMatch.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< Updated upstream
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
=======
		HttpSession session=request.getSession(true);
		String action = request.getParameter("action1");
		String query;
		MatchDaoImpl newMD = new MatchDaoImpl();
		List<Joueur> result = new ArrayList<Joueur>();
		
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/TennisWebApp/login");
			return;
		}

		if ("Rechercher".equals(action)) {
			String txt = request.getParameter("txtsearch");
			String nomChecked = request.getParameter("cbNom");
			String prenomChecked = request.getParameter("cbPrenom");
			//System.out.println(txt);
				if (nomChecked != null && prenomChecked == null) {
					query = "SELECT * FROM MATCH_TENNIS WHERE ID_VAINQUEUR IN (SELECT ID FROM JOUEUR WHERE NOM LIKE '%"
	                        + txt + "%') OR ID_FINALISTE IN (SELECT ID FROM JOUEUR WHERE NOM LIKE '%"
	                        + txt + "%');";
				} else if (prenomChecked != null && nomChecked == null) {
					query = "SELECT * FROM MATCH_TENNIS WHERE ID_VAINQUEUR IN (SELECT ID FROM JOUEUR WHERE PRENOM LIKE '%"
	                        + txt + "%') OR ID_FINALISTE IN (SELECT ID FROM JOUEUR WHERE PRENOM LIKE '%"
	                        + txt + "%');";
				} else {
					query = "SELECT * FROM MATCH_TENNIS WHERE ID_VAINQUEUR IN (SELECT ID FROM JOUEUR WHERE NOM LIKE '%"
	                        + txt + "%' OR PRENOM LIKE '%" + txt + "%') OR ID_FINALISTE IN (SELECT ID FROM JOUEUR WHERE NOM LIKE '%"
	                        + txt + "%' OR PRENOM LIKE '%" + txt + "%');";
				}
				list = newMD.chercher(txt,query);
			    request.setAttribute("list", list);
			    this.getServletContext().getRequestDispatcher("/WEB-INF/listeMatch.jsp").forward(request, response);
			    
		} else if ("Deconnexion".equals(action)) {
			if (session != null) {
				session.removeAttribute("connectedUser");
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
		        dispatcher.forward(request, response);
	        return;
			}
		} else if ("Finaliste".equals(action)) {
				for (Match m: list) {
					int id = m.getIdFinaliste();
					//System.out.println(id);
					result.add(newMD.searchFvsV(id));
				}
				//System.out.println(result);
				request.setAttribute("list", list);
				request.setAttribute("result", result);
				this.getServletContext().getRequestDispatcher("/WEB-INF/listeMatch.jsp").forward(request, response);
				
		} else {
				for (Match m: list) {
					int id = m.getIdVainqueur();
					//System.out.println(id);
					result.add(newMD.searchFvsV(id));
				}
				//System.out.println(result);
				request.setAttribute("list", list);
				request.setAttribute("result", result);
				this.getServletContext().getRequestDispatcher("/WEB-INF/listeMatch.jsp").forward(request, response);
		}
	}
}
>>>>>>> Stashed changes
