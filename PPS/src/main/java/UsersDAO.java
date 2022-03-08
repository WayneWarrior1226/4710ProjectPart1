import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
*
*Servlet implementation class connect
*
*/


public class UsersDAO{
	private static Connection connect = null;
	private static PreparedStatement preparedstatement= null;



public UsersDAO(){
	
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

//inserts new user into database
public boolean insertUser(Users users) throws SQLException {
    
    connect();
    String sql = "insert into user(userid,pass,fname,lname,birthday,streetnum,"
    		+ "street,city,state,zip) values (?,?,?)";
    PreparedStatement statement = connect.prepareStatement(sql);
    preparedstatement = (PreparedStatement) connect.prepareStatement(sql);
	preparedstatement.setString(1, users.userid);
	preparedstatement.setString(2,users.password);
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