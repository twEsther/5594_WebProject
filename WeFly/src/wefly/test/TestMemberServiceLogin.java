package wefly.test;

import wefly.entity.Member;
import wefly.entity.WeflyException;
import wefly.service.MemberService;

public class TestMemberServiceLogin {

	public static void main(String[] args) {
		MemberService service = new MemberService();
		try {
			Member m = service.login("k870020@yahoo.com.tw", "28011338");
			System.out.println(m);			
		} catch (WeflyException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} System.out.println("登入跑完惹～");
	}
} //這裡是類別class結尾的大括號
