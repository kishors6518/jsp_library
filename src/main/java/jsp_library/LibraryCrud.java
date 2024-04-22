package jsp_library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryCrud {
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/jspdb";
		String user="root";
		String pass="root";

		Class.forName(className);
		return DriverManager.getConnection(url, user, pass);
	}
	
	public int addBook(Library library) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		String sql="INSERT INTO BOOKS(ID,NAME,AUTHOR,GENRE) VALUES(?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,library.getId());
		preparedStatement.setString(2,library.getName());
		preparedStatement.setString(3,library.getAuthor());
		preparedStatement.setString(4,library.getGenre());		
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	public List<Library> getBooks() throws Exception{
		Connection connection=getConnection();
		String all="SELECT * FROM BOOKS";
		PreparedStatement preparedStatement=connection.prepareStatement(all);
		ResultSet resultSet=preparedStatement.executeQuery();
		List<Library> list=new ArrayList<Library>();
		while(resultSet.next())
		{
			Library library=new Library();
			library.setId(resultSet.getInt("id"));
			library.setName(resultSet.getString("name"));
			library.setAuthor(resultSet.getString("author"));
			library.setGenre(resultSet.getString("genre"));
			list.add(library);
		}
		connection.close();
		return list;
	}
	public int doDelete(int id) throws Exception {
		Connection connection=getConnection();
		String delete="DELETE FROM BOOKS WHERE ID=?";
		PreparedStatement preparedStatement=connection.prepareStatement(delete);
		preparedStatement.setInt(1, id);
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;	
	}
	public int doUpdate(Library library) throws Exception
	{
		Connection connection=getConnection();
		String update="UPDATE BOOKS SET NAME=?, AUTHOR=?, GENRE=? WHERE ID=?";
		PreparedStatement preparedStatement=connection.prepareStatement(update);
		preparedStatement.setString(1,library.getName());
		preparedStatement.setString(2,library.getAuthor());
		preparedStatement.setString(3,library.getGenre());
		preparedStatement.setInt(4,library.getId());
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	public Library bookDetail(int id) throws Exception
	{
		Connection connection=getConnection();
		String select="SELECT * FROM BOOKS WHERE ID=?";
		PreparedStatement preparedStatement=connection.prepareStatement(select);
		preparedStatement.setInt(1, id);
		ResultSet set=preparedStatement.executeQuery();
		Library library=new Library();
		while(set.next())
		{
			library.setId(set.getInt("id"));
			library.setName(set.getString("name"));
			library.setAuthor(set.getString("author"));
			library.setGenre(set.getString("genre"));
		}
		connection.close();
		return library;
	}
}
