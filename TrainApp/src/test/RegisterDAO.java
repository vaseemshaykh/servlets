package test;
import javax.servlet.*; 
import java.sql.*;
public class RegisterDAO
{
	public int register(ServletRequest req)
	{
		int k=0;
		try
		{
			Connection con=DBConnection.getCon();
			String uname=req.getParameter("uname");
			String pword=req.getParameter("pword");
			String fname=req.getParameter("fname");
			String lname=req.getParameter("lname");
			String addr=req.getParameter("addr");
			Long phno=Long.parseLong(req.getParameter("phno"));
			String mid=req.getParameter("mid");
			
			PreparedStatement ps=con.prepareStatement("insert into userreg21 values(?,?,?,?,?,?,?)");
			ps.setString(1,uname);
			ps.setString(2,pword);
			ps.setString(3,fname);
			ps.setString(4,lname);
			ps.setString(5,addr);
			ps.setLong(6,phno);
			ps.setString(7,mid);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				k=1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
