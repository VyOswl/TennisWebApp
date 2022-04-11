package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;

import dao.UserDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl userDaoI;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
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
		response.sendRedirect(request.getContextPath() + "/TennisWebApp/login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/WEB-INF/login.jsp").include(request, response); 
		HttpSession session=request.getSession();  
        session.invalidate();  
        response.sendRedirect(request.getContextPath() + "/TennisWebApp/login");
        
        /*
		HttpSession session=request.getSession();  
        session.invalidate();
        session.removeAttribute("list");
        session.removeAttribute("user");
        */
	}
}