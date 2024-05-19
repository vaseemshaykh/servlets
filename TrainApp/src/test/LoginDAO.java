package test;
import java.sql.*;   
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginDAO
{
	public String fname;
	public String validate(HttpServletRequest req,ServletContext sct)
	{
		String sub=(String)sct.getAttribute("sub");
		try
		{
			Connection con=DBConnection.getCon();
			if(sub.equals("Admin"))
			{
				PreparedStatement ps=con.prepareStatement
						("select * from admintab21 where uname=? and pword=?");
				
				String uname=req.getParameter("uname");
				String pword=req.getParameter("pword");
				
				ps.setString(1, uname);
				ps.setString(2,pword);
				
				ResultSet rs= ps.executeQuery();
			
				if(rs.next())
				{
					fname=rs.getString(3);
				}
			}
			else
			{
				PreparedStatement ps=con.prepareStatement
						("select * from userregg21 where uname=? and pword=?");
				String uname=req.getParameter("uname");
				String pword=req.getParameter("pword");
				ps.setString(1, uname);
				ps.setString(2, pword);
				ResultSet rs= ps.executeQuery();
				if(rs.next())
				{
					fname=rs.getString(3);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return fname;
	}
}
