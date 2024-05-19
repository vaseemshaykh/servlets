package test;
import java.io.*;    
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class HomeServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException
	{
		String sub=req.getParameter("sub");
		ServletContext sct=this.getServletContext();
		sct.setAttribute("sub",sub);
		if(sub.equals("Admin"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("ALogin.html");
			rd.forward(req, res);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("ULogin.html");
			rd.forward(req, res);
		}
		
	}
}
