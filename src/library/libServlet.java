package library;

import java.io.IOException;

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

			int id = Integer.parseInt(request.getParameter("sId"));
			String name = request.getParameter("Name");
			String gender = request.getParameter("Gender");
			String dpt = request.getParameter("dep");
			String year = request.getParameter("Year");
			String contact = request.getParameter("Contact");
			String email = request.getParameter("Email");
			String date = request.getParameter("rdate");
			JSONObject result = new JSONObject();
			try {
				LibClass lib = new LibClass();
				lib.add(id, name, gender, dpt, year, contact, email, date);
				result.put("status", 1);
			} catch (Exception e) {
				System.out.println("welcome");
				result.put("status", 0);
			}
			response.getWriter().print(result);
		} else if (operation.equals("stdupdate")) {
			int id = Integer.parseInt(request.getParameter("sId"));
			String name = request.getParameter("Name");
			String gender = request.getParameter("Gender");
			String dpt = request.getParameter("dep");
			String year = request.getParameter("Year");
			String contact = request.getParameter("Contact");
			String email = request.getParameter("Email");
			String date = request.getParameter("rdate");
			JSONObject re = new JSONObject();
			try {
				LibClass lib1 = new LibClass();
				lib1.stdupdate(id, name, gender, dpt, year, contact, email, date);
				re.put("status", 1);
			} catch (Exception e) {
				e.printStackTrace();
				re.put("status", 0);

			}
			response.getWriter().print(re);
		} else if (operation.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("sId"));
			JSONObject res = new JSONObject();
			try {
				LibClass lib2 = new LibClass();
				lib2.delete(id);
				res.put("status", 1);
			} catch (Exception e) {
				res.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().print(res);
		} else if (operation.equals("getone")) {
			int sid = Integer.parseInt(request.getParameter("sId"));
			JSONObject res1 = new JSONObject();
			try {
				LibClass lib3 = new LibClass();
				res1 = lib3.getone(sid);
			} catch (Exception e) {
				res1.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().print(res1);
		} else if (operation.equals("getAll")) {
			JSONArray res2 = new JSONArray();
			try {
				LibClass lib4 = new LibClass();
				res2 = lib4.getAll();

			} catch (Exception e) {
				JSONObject error = new JSONObject();
				res2.put(error);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print(res2);
		} else if (operation.equals("bookadd")) {
			int bookid = Integer.parseInt(request.getParameter("bookid"));
			String bookname = request.getParameter("bookname");
			String aname = request.getParameter("aname");
			String cat = request.getParameter("cat");
			JSONObject obj1 = new JSONObject();
			try {
				LibClass libr = new LibClass();
				libr.bookadd(bookid, bookname, aname, cat);
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
				LibClass libr1 = new LibClass();
				libr1.bookupdate(bookid, bookname, aname, cat);
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
				LibClass libr2 = new LibClass();
				libr2.bookdelete(bookid);
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
				LibClass libr3 = new LibClass();
				obj5 = libr3.bookone(bookid);
			} catch (Exception e) {
				obj5.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().print(obj5);
		} else if (operation.equals("bookget")) {
			JSONArray re1 = new JSONArray();
			try {
				LibClass libr4 = new LibClass();
				re1 = libr4.bookget();
			} catch (Exception e) {
				JSONObject error = new JSONObject();
				error.put("status", 0);// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print(re1); // employee details add }
		} else if (operation.equals("empAdd")) {
			JSONObject obj = new JSONObject();
			int id = Integer.parseInt(request.getParameter("Id"));
			String name = request.getParameter("Name");
			String password = request.getParameter("password");
			String gender = request.getParameter("Gender");
			String mobileno = request.getParameter("Mobileno");
			String address = request.getParameter("Address");
			try {
				LibClass libra = new LibClass();
				libra.empAdd(id, name, password, gender, mobileno, address);
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
				LibClass libra1 = new LibClass();
				libra1.empdelete(id);
				del.put("status", 1);
			} catch (Exception e) {
				del.put("status", 0);
			}
			response.getWriter().print(del);
		} else if (operation.equals("empupdate")) {
			JSONObject updates = new JSONObject();
			int id = Integer.parseInt(request.getParameter("Id"));
			String name = request.getParameter("Name");
			String gender = request.getParameter("Gender");
			String mobileno = request.getParameter("Mobileno");
			String address = request.getParameter("Address");
			try {
				LibClass libra2 = new LibClass();
				libra2.empupdate(id, name, gender, mobileno, address);
				updates.put("status", 1);
			} catch (Exception e) {
				updates.put("status", 0);
			}
			response.getWriter().print(updates);
		} else if (operation.equals("getonly")) {
			int id = Integer.parseInt(request.getParameter("Id"));
			JSONObject get = new JSONObject();
			try {
				LibClass libra3 = new LibClass();
				get = libra3.getonly(id);
			} catch (Exception e) {
				get.put("status", 0);
			}
			response.getWriter().print(get);
		} else if (operation.equals("getAlls")) {
			JSONArray all = new JSONArray();
			try {
				LibClass libra4 = new LibClass();
				all = libra4.getAlls();
			} catch (Exception e) {
				JSONObject error = new JSONObject();
				error.put("status", 0);
			}
			response.getWriter().print(all);
		} else if (operation.equals("addborrow")) {
			JSONObject books = new JSONObject();
			int studid = Integer.parseInt(request.getParameter("sid"));
			int bkid = Integer.parseInt(request.getParameter("bookid"));
			int empid = Integer.parseInt(request.getParameter("empid"));

			try {
				LibClass library = new LibClass();
				library.addborrow(studid, bkid, empid);
				books.put("status", 1);
			} catch (Exception e) {
				books.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().print(books);
		} else if (operation.equals("rupdate")) {
			JSONObject rup = new JSONObject();
			int studid = Integer.parseInt(request.getParameter("sid"));
			String bdate = request.getParameter("bdate");
			String rdate = request.getParameter("rdate");
			try {
				LibClass library1 = new LibClass();
				library1.rupdate(studid, bdate, rdate);
				rup.put("status", 1);
			} catch (Exception e) {
				rup.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().print(rup);
		} else if (operation.equals("getborrow")) {
			JSONObject brget = new JSONObject();
			int eid = Integer.parseInt(request.getParameter("empid"));
			try {
				LibClass library2 = new LibClass();
				brget = library2.getborrow(eid);
			} catch (Exception e) {
				brget.put("status", 0);
			}
			response.getWriter().print(brget);
		} else if (operation.equals("borrowAll")) {
			JSONArray borrow = new JSONArray();
			try {
				LibClass bor = new LibClass();
				borrow = bor.borrowAll();
			} catch (Exception e) {
				JSONObject error = new JSONObject();
				error.put("status", 0);
			}
			response.getWriter().print(borrow);

		} else if (operation.equals("addreturn")) {
			int sid = Integer.parseInt(request.getParameter("sid"));
			int rempid = Integer.parseInt(request.getParameter("rempid"));
			JSONObject add = new JSONObject();
			try {
				LibClass addr = new LibClass();
				addr.addreturn(sid, rempid);
				add.put("status", 1);
			} catch (Exception e) {
				add.put("status", 0);
			}
			response.getWriter().print(add);
		} else if (operation.equals("getret")) {
			int siedid = Integer.parseInt(request.getParameter("sid"));
			JSONObject retun = new JSONObject();
			try {
				LibClass geton = new LibClass();
				retun= geton.retunsons(siedid);
				retun.put("status", 1);
			} catch (Exception e) {
				retun.put("status", 0);
			}
			response.getWriter().println(retun);
		}

	}

}
