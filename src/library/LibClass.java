package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA.Request;

public class LibClass {
	public void add(int id, String name, String gender, String dpt, String year, String contact, String email,
			String date) {
		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "insert into student(sid,Name,gender,dep,year,contact,email,rdate)values(" + id + ",'" + name
					+ "','" + gender + "','" + dpt + "','" + year + "','" + contact + "'," + "'" + email + "','" + date
					+ "')";
			stat.execute(query);
		} catch (Exception e) {

		}
	}

	public void stdupdate(int id, String Name, String gender, String dpt, String year, String contact, String email,
			String date) throws SQLException {

		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "update student set Name='" + Name + "',gender='" + gender + "',dep='" + dpt + "',year='"
					+ year + "',contact='" + contact + "',email='" + email + "',rdate='" + date + "' where sid=" + id;
			stat.execute(query);

		} catch (Exception e) {

		}
	}

	public void delete(int id) {

		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "delete from student where sid=" + id;
			stat.execute(query);

		} catch (Exception e) {

		}
	}

	public JSONObject getone(int sId) {
		JSONObject res1 = new JSONObject();
		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "select * from student where sid=" + sId;
			ResultSet rset = stat.executeQuery(query);
			if (rset.next()) {
				res1.put("name", rset.getString(2));
				res1.put("gender", rset.getString(3));
				res1.put("dep", rset.getString(4));
				res1.put("year", rset.getString(5));
				res1.put("contact", rset.getString(6));
				res1.put("email", rset.getString(7));
				res1.put("rdate", rset.getString(8));
			}
		} catch (Exception e) {

		}
		return res1;
	}

	public JSONArray getAll() {
		JSONArray res2 = new JSONArray();
		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
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

		}
		return res2;
	}

	public void bookadd(int bookid, String bookname, String aname, String cat) {

		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = " insert into book(bookid,bookname,authorname,cat)values(" + bookid + ",'" + bookname + "','"
					+ aname + "','" + cat + "')";
			stat.execute(query);

		} catch (Exception e) {

		}
	}

	public void bookupdate(int bookid, String bookname, String aname, String cat) {

		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "update book set bookname='" + bookname + "',authorname='" + aname + "',cat='" + cat
					+ "'where bookid=" + bookid;
			stat.execute(query);

		} catch (Exception e) {

		}
	}

	public void bookdelete(int bookid) {

		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "delete from book where bookid=" + bookid;
			stat.execute(query);

		} catch (Exception e) {

		}
	}

	public JSONObject bookone(int bookid) {
		JSONObject obj5 = new JSONObject();
		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "select * from book where bookid=" + bookid;
			ResultSet rs = stat.executeQuery(query);
			if (rs.next()) {
				obj5.put("booname", rs.getString(2));
				obj5.put("aname", rs.getString(3));
				obj5.put("cat", rs.getString(4));
			}
		} catch (Exception e) {

		}
		return obj5;
	}

	public JSONArray bookget() {
		JSONArray re1 = new JSONArray();
		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
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

		}
		return re1;

	}

	public void empAdd(int id, String name, String password, String gender, String mobileno, String address) {

		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "insert into employee(Id,Name,password,Gender,Mobileno,Address)values(" + id + ",'" + name
					+ "','" + password + "','" + gender + "','" + mobileno + "','" + address + "')";
			stat.execute(query);

		} catch (Exception e) {

		}
	}

	public void empdelete(int id) {

		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "delete from employee where Id=" + id;

			stat.execute(query);

		} catch (Exception e) {

		}
	}

	public void empupdate(int id, String name, String gender, String mobileno, String address) {

		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "update employee set Name='" + name + "',Gender='" + gender + "',Mobileno='" + mobileno
					+ "',Address='" + address + "' where Id=" + id;
			stat.execute(query);

		} catch (Exception e) {

		}
	}

	public JSONObject getonly(int id) {
		JSONObject get = new JSONObject();
		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "select * from employee where Id=" + id;
			ResultSet rs = stat.executeQuery(query);
			if (rs.next()) {

				get.put("Name", rs.getString(2));
				get.put("Gender", rs.getString(4));
				get.put("MoblieNo", rs.getString(5));
				get.put("addr", rs.getString(6));

			}
		} catch (Exception e) {

		}
		return get;
	}

	public JSONArray getAlls() {
		JSONArray all = new JSONArray();
		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "select * from employee";
			ResultSet rs = stat.executeQuery(query);
			while (rs.next()) {
				JSONObject gets = new JSONObject();
				gets.put("Id", rs.getInt(1));
				gets.put("Name", rs.getString(2));
				gets.put("Gender", rs.getString(4));
				gets.put("MoblieNo", rs.getString(5));
				gets.put("Address", rs.getString(6));
				all.put(gets);
			}
		} catch (Exception e) {

		}
		return all;

	}

	public void addborrow(int studid, int bkid, int empid) {

		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "insert into borrow(sid,bookid,bempid,bdate)values(" + studid + "," + bkid + "," + empid
					+ ",now())";
			stat.execute(query);

		} catch (Exception e) {

		}
	}

	public void rupdate(int studid, String bdate, String rdate) {

		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "update books set rdate='" + rdate + "' where sid=" + studid + " and bdate=" + bdate;
			stat.execute(query);

		} catch (Exception e) {

		}

	}

	public JSONObject getborrow(int eid) {
		JSONObject brget = new JSONObject();
		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "select * from borrow where bempid=" + eid;
			ResultSet rs = stat.executeQuery(query);
			if (rs.next()) {
				brget.put("sid", rs.getString(2));
				brget.put("bkid", rs.getString(3));

			}

		} catch (Exception e) {

		}
		return brget;
	}

	public JSONArray borrowAll() {
		JSONArray borrow = new JSONArray();
		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "select * from borrow";
			ResultSet rs = stat.executeQuery(query);
			while (rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("bid", rs.getInt(1));
				obj.put("sid", rs.getInt(2));
				obj.put("bookid", rs.getInt(3));
				obj.put("empid", rs.getInt(4));
				obj.put("bdate", rs.getInt(5));
				borrow.put(obj);
			}
		} catch (Exception e) {

		}
		return borrow;

	}

	public void addreturn(int sid, int rempid) {
		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "insert into returnbook(sid,rempid,rdate)values(" + sid + "," + rempid + ",now())";
			stat.execute(query);
		} catch (Exception e) {

		}

	}

	public JSONObject retunsons(int siedid) {
		JSONObject one = new JSONObject();
		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = " select returnbook.rempid,returnbook.rdate,borrow.bempid, borrow.bdate from returnbook,borrow where borrow.sid="
					+ siedid + " and returnbook.sid="+siedid+"";
			ResultSet rs = stat.executeQuery(query);
			while (rs.next()) {

				one.put("rempid", rs.getInt(1));
				one.put("rdate", rs.getDate(2));
				one.put("bempid", rs.getInt(3));
				one.put("bdate", rs.getDate(4));

			}
		} catch (Exception e) {

		}
		return one;

	}
	public JSONObject login(String name,String pwd){
	
		JSONObject log = new JSONObject();
		try {
			Class.forName(LibConstat.MYSQL_DRIVER);
			Connection con = DriverManager.getConnection(LibConstat.MYSQL_URL, LibConstat.MYSQL_USERNAME,
					LibConstat.MYSQL_PASSWORD);
			Statement stat = con.createStatement();
			String query = "select Name from employee where Name='" + name + "' AND password='" + pwd + "'";
			ResultSet rs = stat.executeQuery(query);
			if (rs.next()) {
				if (name != "") {
					log.put("username", rs.getString(1));
					log.put("status",1);
				}
			} else {
				log.put("status", "error");

			}
		} catch (Exception e) {

		}
		return log;

	}

}
