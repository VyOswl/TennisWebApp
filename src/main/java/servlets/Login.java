package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.User;
import dao.DaoFactory;
import dao.HashClass;
import dao.UserDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDaoImpl userDaoI;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init() throws ServletException {
		super.init();
		DaoFactory df = DaoFactory.instanceDaoF();
		userDaoI = new UserDaoImpl(df);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String login = request.getParameter("txtLogin");
			String password = HashClass.get_SHA1(request.getParameter("txtPassword"), HashClass.getSalt());
			User connectedUser = userDaoI.isValidLogin(login, password);
			String destPage = "/WEB-INF/login.jsp";
			
			if (connectedUser != null) {
				HttpSession session = request.getSession();
				System.out.println("Logged in");
				session.setAttribute("connectedUser", connectedUser);
				destPage = "/WEB-INF/listeJoueur.jsp";
				response.sendRedirect("/TennisWebApp/listeJoueur");
			} else {
				String message = "Invalid email/password";
	            request.setAttribute("message", message);
	            this.getServletContext().getRequestDispatcher(destPage).forward(request, response);
			}
			//this.getServletContext().getRequestDispatcher("/WEB-INF/listeJoueur.jsp").forward(request, response);	
  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}