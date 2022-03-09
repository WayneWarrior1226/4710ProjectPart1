
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class controllerServlet
 */
@WebServlet(name = "/controllerServlet", urlPatterns = {"/controllerServlet"})
public class controllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Statement statement = null;
	private static Connection connect = null;
	private static ResultSet resultSet = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerServlet() {
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
		// TODO Auto-generated method stub
		
		
		
		String userid=request.getParameter("userid");
		String pass=request.getParameter("pass");
		
		//check for root when logging in
		if(userid.equals("root")&&pass.equals("pass1234"))
		{
			request.getRequestDispatcher("initialize.jsp").forward(request, response);
			response.sendRedirect("initialize.jsp");
			
		}
		else 
		{
			response.sendRedirect("error.jsp");
		}
	
		try {
			
			Class.forName("sql.mysql.jdbc.Driver");
			//Setup connection for database
			String URL = "jdbc::mysql://localhost/pps";
			Connection connect = DriverManager.getConnection(URL, "root","pass1234");
			
			//DROP ALL TABLES
			String sql1 = "DROP TABLE IF EXISTS users";
			String sql2 = "DROP TABLE IF EXISTS followers";
			String sql3 = "DROP TABLE IF EXISTS followees";
			String sql4 = "DROP TABLE IF EXISTS cuurentppsprice";
			
			//CREATE TABLES
			String sql5 = "CREATE TABLE user" + "(userid VARCHAR(30))" + "pass VARCHAR(30)"
					+ "fname VARCHAR(30)" + "lname VARCHAR(30)" + "birthday VARCHAR(10)"
					+ "streetnum VARCHAR(10)" + "street VARCHAR(10)" + "city VARCHAR(10)"
					+ "state CHAR(2)" + "zip VARCHAR(10) + ppsbal DOUBLE + dollarbal DOUBLE)";
					
			String sql6 = "CREATE TABLE followers" + "(userid VARCHAR(30)" + "followerid VARCHAR(30)" +"PRIMARY KEY(userid, followerid)" +
					"FOREIGN KEY(follwerid)";
			
			String sql7 = "CREATE TABLE currentppsprice" + "(currentppsprice)";
					
					
			String sql8 = "CREATE TABLE transaction" + "(transactionid INT not NULL  AUTO_INCREMENT)"
					+"transactiontype VARCHAR(10)" + "transtime DATETIME" + "ppsbal DOUBLE" +
					"dollarbal DOUBLE" + "fromtransaction VARCHAR(30)"+ "totransaction VARCHAR(30)"+
					"PRIMARY KEY(transactionid)" + "FOREIGN KEY(fromtransaction) REFERENCES user(userid)+"
							+ "FOREIGN KEY(totransaction) REFERENCES user(userid)";
			

					
			//INSERT data into user table
			
			String sql9 = "INSERT INTO user (userid,fname,lname, birthday ,streetnum,street,city,state,zip,ppsbal,dollarbal) VALUES('root','pass1234',null,null,null,null,null,null,1000000000,0,)";
			String sql10 = " INSERT INTO user VALUES('ann45@gmail.com','2s6950',Ann,Bell,7,45,Feather St,Maxtown,MI,48324,1000,0,)";
			String sql11 = " INSERT INTO user VALUES('ben90@gmail.com','oe6l2t',Ben,Ham,7,4545,Canvas St,Howel,MI,48376,1000,0,)";
			String sql12 = " INSERT INTO user VALUES('sam490@gmail.com','w8qbgd',Sam,Cup,7,565,Low St,Canton,MI,48397,1000,0,)";
			String sql13 = " INSERT INTO user VALUES('letty490@gmail.com','ep52zt',Letty,Sue,7,45,Apple st,Depot,MI,48354,1000,0,)";
			String sql14 = " INSERT INTO user VALUES('susan39@gmail.com','od81h3',Susan,Can,7,45,Book st,Bar,MI,35324,1000,0,)";
			String sql15 = " INSERT INTO user VALUES('mike93@gmail.com','7tybpz',Mike,Ilitch,7,45,Carnival st,Yogurt,MI,48327,1000,0,)";
			String sql16 = " INSERT INTO user VALUES('ronnie23@gmail.com','2oa4nr',Ronnie,Cadlim,7,45,Mellow st,Less,MI,47524,1000,0,)";
			String sql17 = " INSERT INTO user VALUES('howard9033@gmail.com','j7t2nj',Howard,Stern,7,45,Easy st,Sugar,MI,42324,1000,0,)";
			String sql18 = " INSERT INTO user VALUES('robin32@gmail.com','5yh0cp',Robin,Quivers,7,45,Camper st,Cilo,MI,48544,1000,0,)";
		
		//Insert into followers table
			String sql19 = "INSERT INTO followers VALUES('robin32@gmail.com', 'howard9033@gmail.com')";
			String sql20 = "INSERT INTO followers VALUES('robin32@gmail.com', 'mike93@gmail.com')";
			String sql21 = "INSERT INTO followers VALUES('letty490@gmail.com', 'susan39@gmail.com')";
			String sql22 = "INSERT INTO followers VALUES('letty490@gmail.com', 'howard9033@gmail.com')";		
			String sql23 = "INSERT INTO followers VALUES('howard9033@gmail.com', 'howard9033@gmail.com')";				
			String sql24 = "INSERT INTO followers VALUES('howard9033@gmail.com', 'susan39@gmail.com')";
			String sql25 = "INSERT INTO followers VALUES('sam490@gmail.com', 'letty490@gmail.com')";
			String sql26 = "INSERT INTO followers VALUES('sam490@gmail.com', 'howard9033@gmail.com')";
			String sql27 = "INSERT INTO followers VALUES('robin32@gmail.com', 'letty490@gmail.com')";		
			String sql28 = "INSERT INTO followers VALUES('robin32@gmail.com', 'susan39@gmail.com')";
		
			//INSERT into currentppsprice
			
			String sql29 = "INISERT INTO ppsprice VALUES(0.000001)";
			
			//statements to issue SQL queries to the database
			statement = connect.createStatement();
			
			//1. Deletes all existing tables in the database automatically
			statement.executeUpdate(sql1);
			statement.executeUpdate(sql2);
			statement.executeUpdate(sql3);
			statement.executeUpdate(sql4);
			
			//2. Create All table necessary for this project
			statement.executeUpdate(sql5);
			statement.executeUpdate(sql6);
			statement.executeUpdate(sql7);
			statement.executeUpdate(sql8);
			
			//3.Each table will be inserted with  10 realistic tuples
			 statement.executeUpdate(sql9);
			 statement.executeUpdate(sql10);
			 statement.executeUpdate(sql11);
			 statement.executeUpdate(sql12);
			 statement.executeUpdate(sql13);
			 statement.executeUpdate(sql14);
			 statement.executeUpdate(sql15);
			 statement.executeUpdate(sql16);
			 statement.executeUpdate(sql17);
			 statement.executeUpdate(sql18);
			 statement.executeUpdate(sql19);
			 statement.executeUpdate(sql20);
			 statement.executeUpdate(sql21);
			 statement.executeUpdate(sql22);
			 statement.executeUpdate(sql23);
			 statement.executeUpdate(sql24);
			 statement.executeUpdate(sql25);
			 statement.executeUpdate(sql26);
			 statement.executeUpdate(sql27);
			 statement.executeUpdate(sql28);
			 
			 statement.executeUpdate(sql29);
			 
			 System.out.println("Initialize Database Complete");
			 
			 request.getRequestDispatcher("initialize.jsp").forward(request, response);
			 	
		}catch(Exception e) {
			System.out.println(e);
	    }
		
		
		}
		

	}
	
	
	
	
