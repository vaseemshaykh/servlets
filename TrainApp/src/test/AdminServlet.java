package test;
import java.io.*;    
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class AdminServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ServletContext sct=this.getServletContext();
		LoginDAO ld=new LoginDAO();
		String fname=ld.validate(req, sct);
		
		if(fname!=null)
		{
			Cookie ck=new Cookie("fname",fname);
			pw.println("WELCOME"+fname+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("ALink.html");
			rd.include(req, res);
			res.addCookie(ck);
		}
		else
		{
			pw.println("invalid username or password...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("ALogin.html");
			rd.include(req, res);
		}
		
	}
}
