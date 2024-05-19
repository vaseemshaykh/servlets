package test;
import javax.servlet.http.*;
import java.sql.*;
@SuppressWarnings("serial")
public class DeleteDAO extends HttpServlet
{
	int k=0;
	public int delete(HttpServletRequest req)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("delete from train21 where tno=?");
			String dtno=req.getParameter("dtno");
			ps.setString(1,dtno);
			
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return k;	
	}
}
