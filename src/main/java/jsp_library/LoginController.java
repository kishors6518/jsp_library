package jsp_library;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")

public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		LibraryCrud lcrud=new LibraryCrud();
		UserCrud crud=new UserCrud();
		try {
			String dbpass=crud.getPassword(email);
			if(dbpass!=null) {
				if(dbpass.equals(password))
				{
					req.setAttribute("message", "Login Successful!!!");
					req.setAttribute("list", lcrud.getBooks());
					RequestDispatcher dispatcher=req.getRequestDispatcher("book.jsp");
					dispatcher.include(req, resp);
				}
				else
				{
					req.setAttribute("message", "Please enter valid credentials");
					RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
					dispatcher.include(req, resp);
				}
				
			}else
			{
				req.setAttribute("message", "You are not registered!!! Please Register");
				resp.sendRedirect("signup.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
