package zickbe.vt.Servlet;

//import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyServlet extends HttpServlet {

	//private String ratings = "No ratings yet! Get out there and rate a classroom!";
	private static JSONArray ratings = new JSONArray();
	
	
	public static void main(String[] args) throws Exception {

		Server server = new Server(8080);
		WebAppContext context = new WebAppContext();
		context.setWar("war");
		context.setContextPath("/");
		server.setHandler(context);
		server.start();
		server.join();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		out.write(ratings.toString());
		///resp.getWriter().write("<a href=\"http://www.google.com\"><img src=\"rss.jpg\" border=\"0\"></a>");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		String temp = req.getParameter("temperature");
		String stars = req.getParameter("stars");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String pressure = req.getParameter("light");
		
		JSONObject obj = new JSONObject();
		try {
			obj.put("temperature", temp);		
			obj.put("stars", stars);
			obj.put("date", date);
			obj.put("time", time);
			obj.put("pressure", pressure);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ratings.put(obj);
		
//		PrintWriter out = resp.getWriter();
//		out.write("Success");
	}

}
