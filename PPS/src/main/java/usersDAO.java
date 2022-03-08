import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
*
*Servlet implementation class connect
*implements CRUD OPERATIONS for each table
*/

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;



@WebServlet("/usersDAO")
public class usersDAO{
	private static Connection connect = null;
	private static PreparedStatement preparedstatement= null;



public usersDAO(){
	
}

protected void connect() throws SQLException{
	if (connect == null || connect.isClosed()) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new SQLException(e);
		}
		connect = (Connection)DriverManager
				.getConnection("mysql://localhost:3306/pps"
						+"useSSL=false&user=root&password=pass1234");
		System.out.println(connect);
	}
}

public boolean insert (users users) throws SQLException{
	connect();
	String sql = "insert into user(userid,pass,fname,lname,birthday,streetnum,street,city,state,zip) values (?,?,?)";
	preparedstatement = (PreparedStatement) connect.prepareStatement(sql);
	preparedstatement.setString(1, users.userid);
	preparedstatement.setString(2,users.pass);
	preparedstatement.setString(3,users.fname);
	preparedstatement.setString(4,users.lname);
	preparedstatement.setInt(5,users.birthday);
	preparedstatement.setInt(6,users.streetnum);
	preparedstatement.setString(7,users.street);
	preparedstatement.setString(8,users.city);
	preparedstatement.setInt(9,users.zip);
	preparedstatement.executeUpdate();

	boolean rowInserted = preparedstatement.executeUpdate() > 0;
	preparedstatement.close();
	
	return rowInserted;
}



}