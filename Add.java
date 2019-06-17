package todolist;

import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")

public class Add extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String str=req.getParameter("name");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:/todolist";
		try {
			Connection con=DriverManager.getConnection(url,"root","");
		    
			PreparedStatement ps=con.prepareStatement("INSERT INTO `table` VALUES(?)");
			
			ps.setString(1,str);
			ps.executeUpdate();
			
			ps.close();
			con.close();
            
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   RequestDispatcher rs= req.getRequestDispatcher("Index.jsp");
			try {
				rs.forward(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
