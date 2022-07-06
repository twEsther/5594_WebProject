package wefly.test;

import wefly.entity.Member;
import wefly.entity.WeflyException;
import wefly.service.MemberService;

public class TestMemberServiceRegister {

	public static void main(String[] args) {
		MemberService service = new MemberService();
		
		try {
			Member m = new Member();
			m.setEmail("k870020@yahoo.com.tw");
			m.setPassword("28011338");
			m.setName("黃雅晴");
			m.setBirthday("1992-05-14");
			m.setGender('F');
		
			service.register(m);
			System.out.println(m);
		} catch (WeflyException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("註冊跑完惹～"); //在main方法裡輸出在Console上
	}
} //這裡是類別class結尾的大括號
