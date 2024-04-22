package jsp_library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		LibraryCrud crud=new LibraryCrud();
		try {
			 Library library = crud.bookDetail(id);
			if(library!=null)
			{
				req.setAttribute("emp", library);
				req.getRequestDispatcher("updatebook.jsp").forward(req, resp);
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String author=req.getParameter("author");
		String genre=req.getParameter("genre");
		
		Library library=new Library();
		library.setId(id);
		library.setName(name);
		library.setAuthor(author);
		library.setGenre(genre);
		
		LibraryCrud crud=new LibraryCrud();
		try {
			int result=crud.doUpdate(library);
			if(result!=0)
			{
				req.setAttribute("list", crud.getBooks());
				req.getRequestDispatcher("book.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
