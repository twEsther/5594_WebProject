package wefly.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;

import wefly.entity.Member;
import wefly.entity.WeflyException;

class MemberDAO {

	private static final String INSERT_MEMBER="INSERT INTO Members (`Email`, `Password`, `Name`, `Birthday`, `Gender`, `Member_plan`, `Exp`) "
			+ "VALUES (?, ?, ?, ?, ?, ? ,?)";

	public void insert(Member m) throws WeflyException {
	
		try (
				Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_MEMBER);
			){
				pstmt.setString(1, m.getEmail());
				pstmt.setString(2, m.getPassword());
				pstmt.setString(3, m.getName());
				pstmt.setString(4, m.getBirthday().toString());
				pstmt.setString(5, String.valueOf(m.getGender()));
				pstmt.setBoolean(6, m.isMember_plan());
				pstmt.setString(7, m.getExp().toString());
				
				
				pstmt.executeUpdate();
			}	
		
		
		 catch (SQLIntegrityConstraintViolationException e) { 
			 
				String key="";
			
				if(e.getMessage().indexOf("email_UNIQUE")>=0) {
				 key="email";
				 
			 	} throw new WeflyException("會員新增失敗-" + key + "已重複註冊", e);
					
		 		} catch (SQLException e) {
		 			throw new WeflyException ("會員新增/註冊失敗！", e);
				}
		}

	
	
	
	
	
	private static final String SELECT_MEMBER_BY_EMAIL ="SELECT Email, Password, "
			+ "Name, Birthday, Gender FROM members WHERE Email = ?" ;
	
	public Member selectMemberByEmail(String email) throws WeflyException {
		Member m = null; 
		
		try (
				Connection connection = RDBConnection.getConnection();//1.2 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_MEMBER_BY_EMAIL);
		){
			
			//3.準備指令(傳入?的值)
			pstmt.setString(1, email);

			//要加while是因為要一個一個去查
			//有做買月費功能的時候才需要再加判斷(參考CustomersDAO)
			

			//4.執行指令
			try(
					ResultSet rs = pstmt.executeQuery();
			){
								
				while(rs.next()) {
					m=new Member();
					m.setEmail(rs.getString("Email"));
					m.setPassword(rs.getString("Password"));
					m.setName(rs.getString("Name"));
					m.setBirthday(rs.getString("Birthday"));
					m.setGender(rs.getString("Gender").charAt(0));
				}
			}
		} catch (SQLException e) {
			throw new WeflyException("用主鍵旨(Email)查詢客戶失敗", e);
		}

		return m;
	}	
}