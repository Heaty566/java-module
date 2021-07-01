/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utils.DBContext;

/**
 *
 * @author heaty566
 */
public class UserDao {

	public static Connection con;
	public static PreparedStatement pre;

	public static void close() throws Exception {
		if (con != null) {
			con.close();
		}
		if (pre != null) {
			pre.close();
		}
	}

	public static User getUser(String username) throws Exception {
		try {
			User user = null;
			String sql = "SELECT UserName, UserPassword,FullName from StaffLoginTBL where UserName = ?";
			con = DBContext.getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, username);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("UserName"), rs.getString("UserPassword"), rs.getString("FullName"));
			}
			return user;
		} finally {
			close();
		}

	}
}
