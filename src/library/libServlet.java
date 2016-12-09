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

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if (operation.equals("add")) {
			JSONObject result = new JSONObject();
			String id = request.getParameter("sId");
			String Name = request.getParameter("Name");
			String gender = request.getParameter("Gender");
			String dpt = request.getParameter("dep");
			String year = request.getParameter("Year");
			String contact = request.getParameter("Contact");
			String email = request.getParameter("Email");
			String date = request.getParameter("rdate");

			try { // mysql connection
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "insert into student(sid,Name,gender,dep,year,contact,email,rdate)values(" + id + ",'"
						+ Name + "','" + gender + "','" + dpt + "','" + year + "','" + contact + "'," + "'" + email
						+ "','" + date + "')";
				stat.execute(query);
				result.put("status", 1);
			} catch (Exception e) {
				result.put("status", 0);
				e.printStackTrace();

			}
			response.getWriter().print(result);
		}

		else if (operation.equals("stdupdate")) {
			String id = request.getParameter("sId");
			String Name = request.getParameter("Name");
			String gender = request.getParameter("Gender");
			String dpt = request.getParameter("dep");
			String year = request.getParameter("Year");
			String contact = request.getParameter("Contact");
			String email = request.getParameter("Email");
			String date = request.getParameter("rdate");
			JSONObject re = new JSONObject();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "update student set Name='" + Name + "',gender='" + gender + "',dep='" + dpt + "',year='"
						+ year + "',contact='" + contact + "',email='" + email + "',rdate='" + date + "' where sid="
						+ id;
				stat.execute(query);
				re.put("status", 1);
			} catch (Exception e) {
				re.put("status", 0);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.getWriter().print(re);

		} else if (operation.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("sId"));
			JSONObject res = new JSONObject();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "delete from student where sid=" + id;
				stat.execute(query);
				res.put("status", 1);

			} catch (Exception e) {
				res.put("status", 0);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print(res);

		} else if (operation.equals("getone")) {

			int id = Integer.parseInt(request.getParameter("sId"));
			JSONObject res1 = new JSONObject();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "select * from student where sid=" + id + "";
				ResultSet rset = stat.executeQuery(query);
				if (rset.next()) {
					// res1.put("stdId", rset.getInt(1));
					res1.put("name", rset.getString(2));
					res1.put("gender", rset.getString(3));
					res1.put("dep", rset.getString(4));
					res1.put("year", rset.getString(5));
					res1.put("contact", rset.getString(6));
					res1.put("email", rset.getString(7));
					res1.put("rdate", rset.getString(8));

				}
				res1.put("status", 1);
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
					obj.put("stdId", rs.getInt(1));
					obj.put("name", rs.getString(2));
					obj.put("gender", rs.getString(3));
					obj.put("dep", rs.getString(4));
					obj.put("Year", rs.getString(5));
					obj.put("contact", rs.getString(6));
					obj.put("email", rs.getString(7));
					obj.put("rdate", rs.getString(8));
					res2.put(obj);
				}

			} catch (Exception e) {
				JSONObject error = new JSONObject();
				res2.put(error);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print(res2);

			/************ add book details *************/

		} else if (operation.equals("bookadd")) {
			int bookid = Integer.parseInt(request.getParameter("bookid"));
			String bookname = request.getParameter("bookname");
			String aname = request.getParameter("aname");
			String cat = request.getParameter("cat");
			JSONObject obj1 = new JSONObject();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = " insert into book(bookid,bookname,authorname,cat)values(" + bookid + ",'" + bookname
						+ "','" + aname + "','" + cat + "')";
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
			String aname = request.getParameter("aname");
			String cat = request.getParameter("cat");
			JSONObject obj3 = new JSONObject();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = " update book set bookname='" + bookname + "',authorname='" + aname + "',cat='" + cat
						+ "' where bookid=" + bookid;
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
					//obj5.put("bookid", rs.getInt(1));
					obj5.put("booname", rs.getString(2));
					obj5.put("aname", rs.getString(3));
					obj5.put("cat", rs.getString(4));
				}
				obj5.put("status", 1);
			} catch (Exception e) {
				obj5.put("status", 0);
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
					ob.put("aname", rs.getString(3));
					ob.put("cat", rs.getString(4));
					re1.put(ob);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.getWriter().print(re1);
			// employee details add
		} else if (operation.equals("empAdd")) {
			JSONObject obj = new JSONObject();
			int id = Integer.parseInt(request.getParameter("Id"));
			String name = request.getParameter("Name");
			String password = request.getParameter("password");
			String gender = request.getParameter("Gender");
			String mobileno = request.getParameter("Mobileno");
			String address = request.getParameter("Address");

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "insert into employee(Id,Name,password,Gender,Mobileno,Address)values(" + id + ",'"
						+ name + "','" + password + "','" + gender + "','" + mobileno + "','" + address + "')";
				stat.execute(query);
				obj.put("status", 1);

			} catch (Exception e) {
				obj.put("message", 0);
				e.printStackTrace();
			}
			response.getWriter().print(obj);
			// employee delete
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
			// empupdate employee details
		} else if (operation.equals("empupdate")) {
			JSONObject updates = new JSONObject();
			int id = Integer.parseInt(request.getParameter("Id"));
			String ename = request.getParameter("Name");
			String egender = request.getParameter("Gender");
			String emobno = request.getParameter("Mobileno");
			String eaddress = request.getParameter("Address");
			// String epassword = request.getParameter("password");

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
						"root");
				Statement statement = connection.createStatement();
				String query = "update employee set Name='" + ename + "',Gender='" + egender + "',Mobileno='" + emobno
						+ "',Address='" + eaddress + "' where Id=" + id;
				statement.execute(query);
				updates.put("status", 1);
			} catch (Exception e) {
				updates.put("status", 0);
			}
			response.getWriter().print(updates);
		} else if (operation.equals("getonly")) {
			int id = Integer.parseInt(request.getParameter("Id"));
			JSONObject get = new JSONObject();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
						"root");
				Statement statement = connection.createStatement();
				String query = "select * from employee where Id=" + id;
				ResultSet rs = statement.executeQuery(query);
				if (rs.next()) {

					get.put("Name", rs.getString(2));
					get.put("Gender", rs.getString(4));
					get.put("MoblieNo", rs.getString(5));
					get.put("addr", rs.getString(6));

				}
				get.put("status", 1);
			} catch (Exception e) {
				get.put("status", 0);
			}
			response.getWriter().print(get);
		} else if (operation.equals("getAlls")) {
			JSONArray all = new JSONArray();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
						"root");
				Statement statement = connection.createStatement();
				String query = "select * from employee";
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					JSONObject gets = new JSONObject();
					gets.put("Id", rs.getInt(1));
					gets.put("Name", rs.getString(2));
					gets.put("Gender", rs.getString(4));
					gets.put("MoblieNo", rs.getString(5));
					gets.put("Address", rs.getString(6));
					// gets.put("Password",rs.getString(6));
					all.put(gets);
				}
			} catch (Exception e) {
				JSONObject error = new JSONObject();
				error.put("status", 0);
			}
			response.getWriter().print(all);
		} else if (operation.equals("addborrow")) {
			JSONObject books = new JSONObject();
			int studid = Integer.parseInt(request.getParameter("sid"));
			String name = request.getParameter("name");
			String bid = request.getParameter("bid");
			String cat = request.getParameter("cat");
			String bdate = request.getParameter("bdate");
			// String rdate=request.getParameter("rdate");

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
						"root");
				Statement statement = connection.createStatement();
				String query = "insert into books(sid,name,bid,cat,bdate)values(" + studid + ",'" + name + "','" + bid
						+ "','" + cat + "','" + bdate + "')";
				statement.execute(query);
				books.put("status", 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				books.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().print(books);
		} else if (operation.equals("rupdate")) {
			JSONObject rup = new JSONObject();
			int studid = Integer.parseInt(request.getParameter("studid"));
			String bdate = request.getParameter("bdate");
			String rdate = request.getParameter("rdate");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
						"root");
				Statement stat = connection.createStatement();
				String query = "update books set rdate='" + rdate + "' where sid=" + studid + " and bdate=" + bdate;
				stat.execute(query);
				rup.put("status", 1);

			} catch (Exception e) {
				// TODO: handle exception
				rup.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().print(rup);
		} else if (operation.equals("getbr")) {
			JSONObject brget = new JSONObject();
			int studid = Integer.parseInt(request.getParameter("studid"));
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
						"root");
				Statement stat = connection.createStatement();
				String query = "select * from where sid=" + studid + "";
				ResultSet rs = stat.executeQuery(query);
				if (rs.next()) {
					brget.put("name", rs.getString(2));
					brget.put("bid", rs.getString(3));
					brget.put("cat", rs.getString(4));
					brget.put("bdate", rs.getString(5));

				}
				brget.put("status", 1);
			} catch (Exception e) {
				brget.put("status", 0);
				// TODO: handle exception
			}
			response.getWriter().print(brget);
		} else if (operation.equals("getvalue")) {
			JSONObject nn = new JSONObject();
			int studid = Integer.parseInt(request.getParameter("sid"));
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
						"root");
				Statement stat = connection.createStatement();
				String get = "select * from student where sid=" + studid + "";
				ResultSet rs = stat.executeQuery(get);
				if (rs.next()) {
					nn.put("name", rs.getString(2));
					if (rs != null) {
						int bid = Integer.parseInt(request.getParameter("bid"));
						String query = "select * from book where bookid=" + bid + "";
						ResultSet rs1 = stat.executeQuery(query);
						if (rs1.next()) {
							nn.put("bname", rs1.getString(2));
						}

					}
				}
				nn.put("Status", 1);
			} catch (Exception e) {
				nn.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().println(nn);
		}
	}
}