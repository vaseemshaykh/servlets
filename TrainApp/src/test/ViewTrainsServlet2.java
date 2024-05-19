package test;
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ViewTrainsServlet2 extends HttpServlet
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
			ArrayList<TrainBean> al=rtd.retrive();
			ServletContext sct=this.getServletContext();
			sct.setAttribute("jcfref", al);
			String fname=c[0].getValue();
			pw.println("WELCOME"+fname+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("ULink.html");
			rd.include(req, res);
			if(al.size()==0)
			{
				pw.println("<>br sorry! no trains found...");
			}
			else
			{
				
				pw.println("---list of trains---<br>");
				al.forEach( (k)->
				{
					TrainBean tb=(TrainBean)k;
					
					pw.println("<a href='select?tno="+tb.getTno()+"'>"+tb.getTno()+"</a>");
					pw.println("&nbsp&nbsp"+tb.getTname()+"<br>");
					
				});
			}
		}
	}
}

