package tester;

import static utils.DBUtils.openConnection;

import java.sql.*;

public class DBTester {

	public static void main(String[] args) throws SQLException {
		try (Connection cn = openConnection()) {
			System.out.println("Connection Established...");
			Statement st = cn.createStatement();
			ResultSet rst = st.executeQuery("select * from users");
			while (rst.next()) {

				System.out.println("id: " + rst.getInt(1) + ", FN: " + rst.getString(2) + ", LN:" + rst.getString(3)
						+ ", Email:" + rst.getString(4) + ", Passwd: "+rst.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
