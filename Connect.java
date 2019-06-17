package todolist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Connect {

	public static List<String> connect() {
		List<String> list=new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:/todolist";
		try {
			Connection con=DriverManager.getConnection(url,"root","");
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery("Select * from `table`");
			
		   while(rs.next()) {
			    String a=rs.getString(1);
			    System.out.println(a);
			    list.add(a);
		   }
		   st.close();
		   con.close();
		   System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task completed");
		return list;	
	}
}
