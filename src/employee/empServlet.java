package employee;

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

/**
 * Servlet implementation class empServlet
 */
@WebServlet("/empServlet")
public class empServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");

		if (operation.equals("add")) {
			JSONObject obj = new JSONObject();
			String name = request.getParameter("Name");
			String gender = request.getParameter("Gender");
			String mobileno = request.getParameter("Mobileno");
			String address = request.getParameter("Address");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement stat = con.createStatement();
				String query = "insert into employee(Name,Gender,Mobileno,Address)values('" + name + "','" + gender
						+ "','" + mobileno + "','" + address + "')";
				stat.execute(query);
				obj.put("status", 1);
			} catch (Exception e) {
				obj.put("message", 0);
				e.printStackTrace();
			}
			response.getWriter().print(obj);

		} else if (operation.equals("empdelete"))

		{
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
				String query = "select Name,Gender,moblieno employee where Id=" + id;
				ResultSet rs = statement.executeQuery(query);
				if (rs.next()) {
					get.put("Name", rs.getString(2));
					get.put("Gender", rs.getString(3));
					get.put("MoblieNo", rs.getString(4));
				}
			} catch (Exception e) {
				get.put("status", 0);
			}
			response.getWriter().print(get);
		} else if (operation.equals("getAll")) {
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
					gets.put("Name", rs.getString(2));
					gets.put("Gender", rs.getString(3));
					gets.put("MoblieNo", rs.getString(4));
					gets.put("Address", rs.getString(5));
					all.put(gets);
				}
			} catch (Exception e) {
				JSONObject error = new JSONObject();
				error.put("status", 0);
			}
			response.getWriter().print(all);
		}
	}
}
