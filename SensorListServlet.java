package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import componenti.Sensore;
import exceptions.NullException;
import exceptions.ZeroException;
import utils.*;

@WebServlet(urlPatterns = { "/sensorList" })
public class SensorListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static int ids = 0;

	public SensorListServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = MyUtils.getStoredConnection(request);
		
		String id = (String) request.getParameter("ambID");
		
		String errorString = null;
		ArrayList<Sensore> sensori = null;
		
		try {
			
			sensori = DBUtils.querySensori(conn, id);
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			errorString = e.getMessage();
			
		} catch (ZeroException e) {
			
			e.printStackTrace();
			errorString = e.getMessage();
			
		} catch (NullException e) {
			
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		//Store info in request attribute, before forward to views
		request.setAttribute("errorString", errorString);
		request.setAttribute("sensorList", sensori);
		
		//Forward to /WEB-INF/views/sensorList.jsp
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/sensorList.jsp");
		
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ids = Integer.parseInt(request.getParameter("id"));
		doGet(request, response);
	}
}
