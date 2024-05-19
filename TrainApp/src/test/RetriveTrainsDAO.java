package test;
import java.util.*; 
import java.sql.*;

public class RetriveTrainsDAO
{
	public ArrayList<TrainBean> al=new ArrayList<TrainBean>();
	public ArrayList<TrainBean> retrive()
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
										("select * from Train21");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				TrainBean tb=new TrainBean();
				tb.setTno(rs.getString(1));
				tb.setTname(rs.getString(2));
				tb.setFstation(rs.getString(3));
				tb.setTstation(rs.getString(4));
				tb.setAvl(rs.getInt(5));
				al.add(tb);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}
