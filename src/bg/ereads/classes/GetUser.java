package bg.ereads.classes;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.ereads.dao.UserDao;


@WebServlet("/GetUser")
public class GetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String image = request.getParameter("image");
		UserDao dao = new UserDao();
		User user = null;
		try {
			user = dao.getUser(image);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("person", user);
		response.sendRedirect("./UserProfile.jsp");
		
	}

}
