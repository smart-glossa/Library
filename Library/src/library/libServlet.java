package library;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/libServlet")
public class libServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		JSONObject result = new JSONObject();
		if (operation.equals("add")) {

			String Name = request.getParameter("Name");
			String std = request.getParameter("class");
			String List = request.getParameter("cards");
			String date = request.getParameter("date");

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "insert into student(Name,class,Listofcards,Expirydate)values('" + Name + "','" + std
						+ "','" + List + "','" + date + "')";
				stat.execute(query);
				result.put("status", 1);
			} catch (Exception e) {
				result.put("status", 0);
				e.printStackTrace();

			}
			response.getWriter().print(result);
		}

		else if (operation.equals("update")) {
			int Rollno = Integer.parseInt(request.getParameter("Rollno"));
			String Name = request.getParameter("Name");
			String std = request.getParameter("class");
			String List = request.getParameter("cards");
			String date = request.getParameter("date");
			JSONObject re = new JSONObject();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "update student set Name='" + Name + "',class='" + std + "',Listofcards='" + List
						+ "',Expirydate='" + date + "'where Rollno=" + Rollno;
				stat.execute(query);
				re.put("status", 1);
			} catch (Exception e) {
				re.put("status", 0);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.getWriter().print(re);

		} else if (operation.equals("delete")) {
			int Rollno = Integer.parseInt(request.getParameter("Rollno"));
			JSONObject res = new JSONObject();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "delete from student where Rollno=" + Rollno;
				stat.execute(query);
				res.put("status", 1);

			} catch (Exception e) {
				res.put("status", 0);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print(res);

		} else if (operation.equals("getone")) {

			int Rollno = Integer.parseInt(request.getParameter("Rollno"));
			JSONObject res1 = new JSONObject();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "Select * from student where Rollno=" + Rollno + "";
				stat.execute(query);
				res1.put("status", 1);
			} catch (Exception e) {
				res1.put("status", 0);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print(res1);

		} else if (operation.equals("getAll")) {
			int Rollno = Integer.parseInt(request.getParameter("Rollno"));
			JSONArray res2 = new JSONArray();

			try {

				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				ResultSet rs = stat.executeQuery("select * from student");
				while (rs.next()) {
					JSONObject obj = new JSONObject();
					obj.put("Rollno", rs.getInt(1));
					obj.put("Name", rs.getString(2));
					obj.put("class", rs.getString(3));
					obj.put("cards", rs.getString(4));
					obj.put("date", rs.getString(5));
					res2.put(obj);
				}

			} catch (Exception e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print(res2);

		} else if (operation.equals("bookadd")) {
			int bookid = Integer.parseInt(request.getParameter("bookid"));
			String bookname = request.getParameter("bookname");
			JSONObject obj1 = new JSONObject();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = " insert into book(bookid,bookname)values(" + bookid + ",'" + bookname + "')";
				stat.execute(query);
				obj1.put("status", 1);

			} catch (Exception e) {
				obj1.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().print(obj1);
		} else if (operation.equals("bookupdate")) {
			int bookid = Integer.parseInt(request.getParameter("bookid"));
			String bookname = request.getParameter("bookname");
			JSONObject obj3 = new JSONObject();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = " update book set bookname=" + bookname + " where bookid=" + bookid;
				stat.execute(query);
				obj3.put("status", "success");

			} catch (Exception e) {
				obj3.put("status", "error");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print(obj3);
		}
	}
}