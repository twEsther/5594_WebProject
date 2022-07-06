package wefly.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import wefly.entity.WeflyException;

class RDBConnection {
	private final static String driver = "com.mysql.cj.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/WeFly?serverTimezone=CST";
	private final static String user = "root";
	private final static String password = "1234";


	public static Connection getConnection() throws WeflyException {
		
		try {
				Class.forName(driver);
				
			try {
				Connection connection = DriverManager.getConnection(url, user, password);
				System.out.println("建立連線成功！！！");
				return connection;
				
			} catch (SQLException e) {
				System.out.println("建立連線失敗");
				throw new WeflyException("建立連線失敗", e);
			}

				
		} catch (ClassNotFoundException e) {
			System.out.println("載入driver失敗");
			throw new WeflyException("載入driver失敗");
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		try (
				Connection con = RDBConnection.getConnection();
			) {
				System.out.println(con.getCatalog());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (WeflyException e) {
			System.out.println(e);
		}catch (Exception e) {
			System.out.println("發生非預期的錯誤:" + e);
		}
		System.out.println("The END!");
	}
}	