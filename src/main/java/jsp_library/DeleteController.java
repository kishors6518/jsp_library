package jsp_library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LibraryCrud crud=new LibraryCrud();
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			int result=crud.doDelete(id);
			if(result!=0)
			{
				req.setAttribute("message", "Book deleted successfully!!!");
				req.setAttribute("list", crud.getBooks());
				req.getRequestDispatcher("book.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
