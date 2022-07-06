package wefly.test;

import wefly.entity.Member;

public class TestMember {

	public static void main(String[] args) {
		Member member = new Member();
		
		member.setEmail("kimteayeon@yahoo.com.tw");
		member.setPassword("kyt893399");
		member.setName("金太妍");
		member.setBirthday("1989-03-09");
		member.setGender('F');
		
		member.setMember_plan(true);
		member.setExp("2020-10-07");
		
		
		System.out.println("E-mail:" + member.getEmail());
		System.out.println("Password:" + member.getPassword());
		System.out.println("Name:" + member.getName());
		System.out.println("Birthday:" + member.getBirthday());
		System.out.println("Gender:" + member.getGender());
		
		System.out.println("Member_plan" + member.isMember_plan());
		System.out.println("Exp" + member.getExp());
		
		
		System.out.println(member);
	}
}
