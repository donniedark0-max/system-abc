package darko.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConectar {
	public Connection getConectar(){
		Connection cn=null;
		try {
			String url,user,pass;
			//driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			url="jdbc:mysql://localhost:3306/systemabc?serverTimezone=UTC";
			//url = "jdbc:mysql://localhost:3306/ong_web?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
			user="root";
			pass="";
			cn=DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
}
