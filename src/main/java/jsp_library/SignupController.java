package jsp_library;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long phone=Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setPhone(phone);
		user.setEmail(email);
		user.setPassword(pass);
		
		UserCrud crud=new UserCrud();
		try {
			int result=crud.signup(user);
			if(result!=0)
			{
				req.setAttribute("message", "Singup successful!!! Please login");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
