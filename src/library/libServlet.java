package library;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");

		if (operation.equals("add")) {
			JSONObject result = new JSONObject();
			String id = request.getParameter("Id");
			String Name = request.getParameter("Name");
			String std = request.getParameter("class");
			String gender = request.getParameter("Gender");
			String email = request.getParameter("Email");
			String contact = request.getParameter("Contact");
			String year= request.getParameter("Year");
			String List = request.getParameter("cards");
			String date = request.getParameter("date");

			try { // mysql connection
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
				ResultSet rset = stat.executeQuery(query);
				if (rset.next()) {
					res1.put("rollno", rset.getInt(1));
					res1.put("name", rset.getString(2));
					res1.put("class", rset.getString(3));
					res1.put("cards", rset.getString(4));
					res1.put("date", rset.getString(5));
				}
			} catch (Exception e) {
				res1.put("status", 0);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print(res1);

		} else if (operation.equals("getAll")) {
			// int Rollno = Integer.parseInt(request.getParameter("Rollno"));
			JSONArray res2 = new JSONArray();

			try {

				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "select * from student";
				ResultSet rs = stat.executeQuery(query);
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
				obj3.put("status", 1);

			} catch (Exception e) {
				obj3.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().print(obj3);
		} else if (operation.equals("bookdelete")) {
			int bookid = Integer.parseInt(request.getParameter("bookid"));

			JSONObject obj4 = new JSONObject();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "delete from book where bookid=" + bookid;
				stat.execute(query);
				obj4.put("status", 1);

			} catch (Exception e) {
				obj4.put("status", 0);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print(obj4);
		} else if (operation.equals("bookone")) {
			int bookid = Integer.parseInt(request.getParameter("bookid"));
			JSONObject obj5 = new JSONObject();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "Select * from book where bookid=" + bookid;
				ResultSet rs = stat.executeQuery(query);
				if (rs.next()) {
					obj5.put("bookid", rs.getInt(1));
					obj5.put("booname", rs.getString(2));
				}
				obj5.put("status", 1);
			} catch (Exception e) {
				obj5.put("status", 0);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.getWriter().print(obj5);
		} else if (operation.equals("bookget")) {

			JSONArray re1 = new JSONArray();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "select * from book";
				ResultSet rs = stat.executeQuery(query);
				while (rs.next()) {
					JSONObject ob = new JSONObject();
					ob.put("bookid", rs.getInt(1));
					ob.put("bookname", rs.getString(2));
					re1.put(ob);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.getWriter().print(re1);

		} else if (operation.equals("empAdd")) {
			JSONObject obj = new JSONObject();
			int id=Integer.parseInt(request.getParameter("Id"));
			String name = request.getParameter("Name");
			String gender = request.getParameter("Gender");
			String mobileno = request.getParameter("Mobileno");
			String address = request.getParameter("Address");
			String password = request.getParameter("password");
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "insert into employee(Id,Name,Gender,Mobileno,Address,Password)values("+id+",'" + name + "','" + gender
						+ "','" + mobileno + "','" + address + "','"+password+"')";
				stat.execute(query);
				obj.put("status", 1);

			} catch (Exception e) {
				obj.put("message", 0);
				e.printStackTrace();
			}
			response.getWriter().print(obj);
		} else if (operation.equals("empdelete")) {
			int id = Integer.parseInt(request.getParameter("Id"));
			JSONObject del = new JSONObject();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
						"root");
				Statement statement = connection.createStatement();
				String query = "delete from employee where Id=" + id;
				statement.execute(query);
				del.put("status", 1);
			} catch (Exception e) {
				del.put("status", 0);
			}
			response.getWriter().print(del);
		} else if (operation.equals("empupdate")) {
			JSONObject updates = new JSONObject();
			int id = Integer.parseInt(request.getParameter("Id"));
			String ename = request.getParameter("Name");
			String egender = request.getParameter("Gender");
			String emobno = request.getParameter("Mobileno");
			String eaddress = request.getParameter("Address");
			String epassword = request.getParameter("password");
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
						"root");
				Statement statement = connection.createStatement();
				String query = "update employee set Name='" + ename + "',Gender='" + egender + "',Mobileno='" + emobno
						+ "',Address='" + eaddress + "',password='"+epassword+"' where Id=" + id;
				statement.execute(query);
				updates.put("status", 1);
			} catch (Exception e) {
				updates.put("status", 0);
			}
			response.getWriter().print(updates);
		}else if(operation.equals("getonly")){
			int id=Integer.parseInt(request.getParameter("Id"));
			JSONObject get=new JSONObject();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement statement=connection.createStatement();
				String query="select Name,Gender,Mobileno,Password from employee where Id="+id;
				ResultSet rs=statement.executeQuery(query);
				if(rs.next()){
					get.put("Name",rs.getString(2));
					get.put("Gender",rs.getString(3));
					get.put("MoblieNo",rs.getString(4));
					get.put("Password",rs.getString(5));
					
				}
			} catch (Exception e) {
				get.put("status",0);
			}
			 response.getWriter().print(get);
			}else if(operation.equals("getAll")){
				JSONArray all=new JSONArray();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
					Statement statement=connection.createStatement();
					String query="select * from employee";
					ResultSet rs=statement.executeQuery(query);
					while(rs.next()){
						JSONObject gets=new JSONObject();
						gets.put("Name",rs.getString(2));
						gets.put("Gender",rs.getString(3));
						gets.put("MoblieNo",rs.getString(4));
						gets.put("Address",rs.getString(5));
						gets.put("Password",rs.getString(6));
						all.put(gets);
					}
				} catch (Exception e){
					JSONObject error=new JSONObject();
					error.put("status", 0);
				}
				response.getWriter().print(all);
			}
		}
	}