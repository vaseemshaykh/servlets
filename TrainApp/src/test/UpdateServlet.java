package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		if(c==null)
		{
			pw.println("first login ....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Home.html");
			rd.include(req, res);
		}
		else
		{
			String fname=c[0].getValue();
			pw.println("WELCOME:"+fname+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("ALink.html");
			rd.include(req, res);
			UpdateDAO udao=new UpdateDAO();
			int k=udao.update(req);
			if(k>0)
			{
				pw.println("<br> succesfully updated...");
			}
		}
	}
}
