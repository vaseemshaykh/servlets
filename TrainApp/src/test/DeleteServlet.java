package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		if(c==null)
		{
			pw.println("<br>login first...");
			RequestDispatcher rd=req.getRequestDispatcher("Home.html");
			rd.include(req, res);
		}
		else
		{
			String fname=c[0].getValue();
			pw.println("WELCOME:"+fname);
			RequestDispatcher rd=req.getRequestDispatcher("ALink.html");
			rd.include(req, res);
			DeleteDAO ddao=new DeleteDAO();
			int k=ddao.delete(req);
			if(k>0)
			{
				pw.println("<br >deleted succesfully...");
			}
					
		}
	}
}
