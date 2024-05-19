package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ViewTrainsServlet extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		
		if(c==null)
		{
			pw.println("please ! login first ....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Home.html");
			rd.include(req, res);
		}
		else
		{
			RetriveTrainsDAO rtd=new RetriveTrainsDAO();
			ArrayList<TrainBean> a1=rtd.retrive();
			
			String fname=c[0].getValue();
			pw.println("WELCOME"+fname+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("ALink.html");
			rd.include(req, res);
			if(a1.size()==0)
			{
				pw.println("<>br sorry! no trains found...");
			}
			else
			{
				pw.println("---list of trains---<br>");
				a1.forEach( (k)->
				{
					TrainBean tb=(TrainBean)k;
					
			     pw.println(tb.getTno()+"&nbsp&nbsp"+
							tb.getTname()+"&nbsp&nbsp"+
							tb.getFstation()+"&nbsp&nbsp"+
							tb.getTstation()+"&nbsp&nbsp"+
							tb.getAvl()+"<br>");
			     
				});
			}
		}
	}
}

