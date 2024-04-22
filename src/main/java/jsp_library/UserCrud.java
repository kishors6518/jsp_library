package jsp_library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCrud {
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/jspdb";
		String user="root";
		String pass="root";
		
		Class.forName(className);
		return DriverManager.getConnection(url, user, pass);	
	}
	public int signup(User user) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		String sql="INSERT INTO USER(ID,NAME,PHONE,EMAIL,PASSWORD) VALUES(?,?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,user.getId());
		preparedStatement.setString(2,user.getName());
		preparedStatement.setLong(3,user.getPhone());
		preparedStatement.setString(4,user.getEmail());
		preparedStatement.setString(5,user.getPassword());
		
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	public String getPassword(String email)throws Exception
	{
		Connection  connection=getConnection();
		String pass="SELECT PASSWORD FROM USER WHERE EMAIL=?";
		PreparedStatement preparedStatement=connection.prepareStatement(pass);
		preparedStatement.setString(1, email);
		ResultSet set=preparedStatement.executeQuery();
		String password=null;
		while (set.next()) {
			password=set.getString("password");
		}
		connection.close();
		return password;		
	}

}
