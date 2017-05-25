package db.connection.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ServletConnection extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = conDB();
		resp.setContentType("text/html;charset=SJIS");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h4>Oracle DB Connection SAMPLE</h4>");
		out.println("<hr>");
		out.print(result);
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = conDB();
		resp.setContentType("text/html;charset=SJIS");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h4>Oracle DB Connection SAMPLE</h4>");
		out.println("<hr>");
		out.print(result);
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

	private String conDB() {

		InitialContext context = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("jdbc/test");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from SAMPLE_TABLE";
			rs = stmt.executeQuery(sql);

			StringBuilder result = new StringBuilder();
			while (rs.next()) {
				result.append(rs.getInt("no"));
				result.append(",");
				result.append(rs.getString("data"));
				result.append("<br>");
			}
			return result.toString();
		} catch (Exception e) {
			return e.getMessage();
		} finally {
			try {
				context.close();
			} catch (Exception e2) {
				return e2.getMessage();
			}

			try {
				if (rs != null)
					rs.close();

			} catch (Exception e2) {
				return e2.getMessage();
			}

			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e2) {
				return e2.getMessage();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				return e2.getMessage();
			}
		}

	}
}
