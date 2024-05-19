package test;
import java.sql.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class UpdateDAO extends HttpServlet
{
	int k=0;
	public int update(HttpServletRequest req)
	{
		try
		{
			Connection con=DBConnection.getCon();
			
			PreparedStatement ps=con.prepareStatement("update train21 set avl=? where tno=?");
			String ptno=req.getParameter("ptno");
			String avl=req.getParameter("avl");
			
			ps.setString(1, avl);
			ps.setString(2, ptno);
			
			k=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
