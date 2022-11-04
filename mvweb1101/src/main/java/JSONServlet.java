

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import model.User;

/**
 * Servlet implementation class JSONServlet
 */
@WebServlet("/JSONServlet")
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONServlet() {
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
		//從user.html抓出name為「mydata」的資料
		String mydata=request.getParameter("mydata");
		//新增一個GSON物件(by Google)
		Gson gson=new Gson();
		//新增一個User物件
		//透過GSON的方法，把「JSON格式」轉成「User物件」
		User user=gson.fromJson(mydata, User.class);
		//在網頁上顯示轉換過的User物件
		response.getWriter().append("Server response: "+user);
	}

}
