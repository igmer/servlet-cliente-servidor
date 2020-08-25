package webapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

/**
 * Servlet implementation class cliente
 */
@WebServlet(urlPatterns = "/cliente.do")
public class cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpGet requesthttp = new HttpGet("http://localhost:8080/udemy/");
		requesthttp.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
		 PrintWriter out   = response.getWriter();
	        try {
	        	URL url = new URL("http://localhost:8080/udemy/");
	        	HttpURLConnection connection = (HttpURLConnection)url.openConnection();
	        	connection.setRequestMethod("GET");
	        	connection.connect();
	        	
	        	//Get Response  
	            InputStream is = connection.getInputStream();
	            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	            StringBuilder responseio = new StringBuilder(); // or StringBuffer if Java version 5+
	            String line;
	            while ((line = rd.readLine()) != null) {
	            	responseio.append(line);
	            	responseio.append('\r');
	            }
	            rd.close();
	            out.println(responseio);
	            }catch(Exception e) {
	            	e.printStackTrace();
	            }

	        
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
