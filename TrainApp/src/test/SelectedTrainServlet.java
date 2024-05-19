package test;
import java.io.*;  
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.stream.*;

@SuppressWarnings("serial")
public class SelectedTrainServlet extends HttpServlet
{
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
			String fname=c[0].getValue();
			pw.println("WELCOME"+fname+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("ULink.html");
			rd.include(req, res);
			ServletContext sct=this.getServletContext();
			ArrayList<TrainBean> al=(ArrayList<TrainBean>)sct.getAttribute("jcfref");
			String tno=req.getParameter("tno");
			pw.println("<br>---train details---<br>");
			List ll=al.stream().
								filter( (p)-> p.getTno().equals(tno)).collect(Collectors.toList());
			
			ll.forEach( (k)->
			{
				TrainBean tb=(TrainBean)k;
				pw.println(tb.getTno()+"&nbsp&nbsp"+
						tb.getTname()+"&nbsp&nbsp"+
						tb.getFstation()+"&nbsp&nbsp"+
						tb.getTstation()+"&nbsp&nbsp"+
						tb.getAvl());
				pw.println("<a href='BookTrain.html'>"+"BookTain"+"</a>");
			});
		}
	}
}