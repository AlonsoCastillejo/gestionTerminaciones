package pruebaWeb.webServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pruebaWeb.domain.Terminaciones;
import pruebaWeb.domain.User;
import pruebaWeb.service.pruebaService;
import pruebaWeb.service.pruebaServiceImpl;

@WebServlet("/terminaciones")
@MultipartConfig
public class terminacionesServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static pruebaService terminacionesService = new pruebaServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		List<Terminaciones> terminaciones = new ArrayList<>();;
		if(action != null) {
			switch (action) {
			case "mostrarTerminaciones":
				this.mostrarTerminaciones(request, response,terminaciones);
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
			case "anadirTerminacion":
				try {
					this.anadirTerminacion(request,response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			default:
				break;
			}
		}
	}
	
	private void mostrarTerminaciones(HttpServletRequest request, HttpServletResponse response, List<Terminaciones> t) 
		    throws ServletException, IOException {
		request.getRequestDispatcher("index2.jsp").forward(request, response);
//		    List<Terminaciones> terminaciones = new ArrayList<>(); // Inicializa la lista
//		    int numTerminaciones;
//
//		    try {
//		    	if(t.size() == 0) {
//		    		terminaciones = terminacionesService.allTerminaciones();
//			        numTerminaciones = terminaciones.size();
//		    	} else {
//		    		terminaciones = t;
//		    		numTerminaciones = t.size();
//		    	}
//		    	
//		        
//		    } catch (SQLException e) {
//		        // Maneja la excepción de forma adecuada
//		        e.printStackTrace();
//		        numTerminaciones = 0;
//		    }
//
//		    request.setAttribute("numTerminaciones", numTerminaciones);
//		    request.setAttribute("terminaciones", terminaciones);
//
//		    request.getRequestDispatcher("gestionTerminaciones.jsp").forward(request, response);
		}

	@SuppressWarnings("unchecked")
	protected void anadirTerminacion(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException, SQLException {
//	    String etiqueta = request.getParameter("etiqueta");
//	    String valor = request.getParameter("valor");
//
//	    List<Terminaciones> terminaciones = (List<Terminaciones>) request.getAttribute("terminaciones");
//
//	    try {
//	        int valorFinal = Integer.parseInt(valor);
//
//	        Terminaciones ter = new Terminaciones(etiqueta, valorFinal);
//
//	        if (terminaciones != null) {
//	            terminaciones.add(ter);
//	        } else {
//	            // Si la lista no existe, obtén los datos de la base de datos
//	            terminaciones = terminacionesService.allTerminaciones();
//	            terminaciones.add(ter);
//	        }
//
//	        request.setAttribute("terminaciones", terminaciones);
//
//	        mostrarTerminaciones(request, response, terminaciones);
//	    } catch (NumberFormatException e) {
//	        // Maneja la excepción de forma adecuada
//	        e.printStackTrace();
//	    }
//	}

	}

}
