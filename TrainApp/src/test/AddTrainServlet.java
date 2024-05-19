package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class AddTrainServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		
		if(c==null)
		{
			pw.println("please ! Loginfirst...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Home.html");
			rd.include(req, res);
		}
		else
		{
			String fname=c[0].getValue();
			pw.println("welcome"+fname+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("ALink.html");
			rd.include(req, res);
			AddTrainDAO atd=new AddTrainDAO();
			int k=atd.insert(req);
			
			if(k>0)
			{
				pw.println("<br> train added succesfully...");
			}
		}
		
	}
	
}

