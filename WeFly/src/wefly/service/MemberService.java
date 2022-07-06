package wefly.service;

import wefly.entity.Member;
import wefly.entity.WeflyException;

public class MemberService {

//這邊是註冊
	private MemberDAO dao = new MemberDAO();
	public void register(Member m) throws WeflyException {
		if(m==null) {
			throw new IllegalArgumentException("註冊客戶m不得為null！");
		}
		dao.insert(m);
	}



//這邊是登入
	public Member login(String email, String pwd) throws WeflyException {
		Member m = null;
		if(email==null || email.length()==0 || pwd==null || pwd.length()==0) {
			throw new IllegalArgumentException("帳號密碼不得為null");
		}
		
		m = dao.selectMemberByEmail(email);
		
		if(m!=null) {
			if(pwd.equals(m.getPassword())) {
				return m;
			}
		} throw new WeflyException("登入失敗，帳號或密碼不正確！");
	}



	public Member getMember(String email) {
		return null;
	}



} //這裡是類別class結尾的大括號
