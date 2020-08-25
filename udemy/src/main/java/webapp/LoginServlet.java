package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//begin get data from databse or other source
		  List<Empleado> list = new ArrayList<>();
		  Empleado model = new Empleado();
		  model.setId(101);
		  model.setNombre("Enamul Haque");
		  Empleado model2 = new Empleado();
		  model2.setId(101);
		  model2.setNombre("Enamul Haque");
		  list.add(model2);
		  list.add(model);
		  

		   //End get data from databse or other source
		try {

		    JsonArray ja = new JsonArray();
		    for (Empleado m : list) {
		        JsonObject jSONObject = new JsonObject();
		        jSONObject.addProperty("id", m.getId());
		        jSONObject.addProperty("name", m.getNombre());
		        ja.add(jSONObject);
		    }
		    System.out.println(" json ja = " + ja);
		    response.addHeader("Access-Control-Allow-Origin", "*");
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().print(ja.toString());
		   // response.getWriter().flush();
		   } catch (Exception e) {
		     e.printStackTrace();
		  }
		//request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mensaje = "";
		if (username.equals("admin") && password.equals("123")) {
			mensaje = "Bienvenido "+username;
		}else {
			mensaje = "Lo sentimos no es valido";
		}
		
		request.setAttribute("mensaje",  mensaje);
		doGet(request, response);
	}

}
