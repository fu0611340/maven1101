

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.User;

/**
 * Servlet implementation class JSONServlet2
 */
@WebServlet("/JSONServlet2")
public class JSONServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream in = request.getInputStream();
		InputStreamReader sr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(sr);
		String line = null;
		String mydata="";
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			mydata=mydata+line;
		}
		Gson g = new Gson();
		User user = g.fromJson(mydata, User.class);
		response.getWriter().append("<h1>Server response: " + user + "</h1>");
	}

}
