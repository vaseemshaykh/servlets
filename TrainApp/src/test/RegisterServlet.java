package test;
import javax.servlet.*;  
import java.io.*;
@SuppressWarnings("serial")
public class RegisterServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		RegisterDAO rdao=new RegisterDAO();
		int k=rdao.register(req);
		if(k>0)
		{
			pw.println("registerred succesfully...");
			RequestDispatcher rd=req.getRequestDispatcher("ULogin.html");
			rd.include(req, res);
		}
		
	}
}
