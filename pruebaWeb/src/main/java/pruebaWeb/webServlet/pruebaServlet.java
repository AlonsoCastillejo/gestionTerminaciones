package pruebaWeb.webServlet;

import java.io.IOException;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pruebaWeb.dao.UserDao;
import pruebaWeb.dao.UserDaoImpl;
import pruebaWeb.domain.User;
import pruebaWeb.service.pruebaService;
import pruebaWeb.service.pruebaServiceImpl;


@WebServlet("/info")
@MultipartConfig
public class pruebaServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static pruebaService userService = new pruebaServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			switch (action) {
			case "navigate":
				this.navigate(request, response);
				break;
			case "signUp":
				this.signUp(request, response);
				break;
			case "logout":
				this.logout(request, response);
				break;

			default:
				break;
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			switch (action) {
			case "login":
				this.login(request,response);
				break;

			default:
				break;
			}
		}
	}
	
	private void navigate(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException{
		request.getRequestDispatcher("signUp.jsp").forward(request, response);
	}
	
	private void signUp(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String direction = "signUp.jsp";
		 HttpSession session = request.getSession();
		 if (session.getAttribute("username") != null && session.getAttribute("username").equals("admin")) {
			    direction = "user.jsp";
			}
		request.getRequestDispatcher(direction).forward(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    
	    

	    if (username.equals("admin") && password.equals("1234")) {
	        HttpSession session = request.getSession();
	        session.setAttribute("username", username);
	        List<User> users;
//			try {
//				//users = userService.allUsers();
//				request.setAttribute("users", users);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	       
	        request.getRequestDispatcher("user.jsp").forward(request, response);
	    } else {
	    	request.getRequestDispatcher("signUp.jsp").forward(request, response);
	    }
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    session.invalidate();
	    response.sendRedirect("index.jsp");
	}


}





