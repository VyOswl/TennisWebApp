package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DaoFactory;
import dao.HashClass;
import dao.UserDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDaoImpl userDaoI;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {

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
		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String login = request.getParameter("txtLogin");
			String password = HashClass.get_SHA1(request.getParameter("txtPassword"), HashClass.getSalt());
			//int profil = Integer.parseInt(request.getParameter("txtProfil"));
			String createUser = userDaoI.register(login, password);		
			
			if(createUser.equals("SUCCESS")) {
	            request.getRequestDispatcher("/WEB-INF//login.jsp").forward(request, response);
	        } else {
	        	//String message = "Please try again";
	            request.setAttribute("errMessage", createUser);
	            request.getRequestDispatcher("/WEB-INF//signup.jsp").forward(request, response);
	         }
  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}