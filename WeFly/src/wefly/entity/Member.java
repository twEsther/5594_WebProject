package wefly.entity;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import wefly.entity.DataInvalidException;

public class Member {
	
	private String email;
	private String password;
	private String name;
	private LocalDate birthday;
	private char gender;
	private boolean member_plan;
	private LocalDate exp;
	




	public Member() {}
	
	
	
	public String getEmail() {
		return email;
	}
	
	private static final String emailPattern = "^(.+)@(.+)$";
	public void setEmail(String email) {
		if(email!=null && email.matches(emailPattern)) {
			this.email = email;
	}else{ 
		throw new DataInvalidException("E-mail格式不正確:" + email);
	}
}
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password!=null && password.length()>=8) {
			this.password = password;
		}else {
			throw new DataInvalidException("密碼長度必須大於等於8個字:" + password);
		}
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name!=null && name.length()>0) {
			this.name = name;
		}else {
			throw new DataInvalidException("必須要設定個人檔案的名稱或暱稱:" + name);
		}
	}
	
	
		
	public LocalDate getBirthday() {
		return birthday;
	}
	
	public void setBirthday(LocalDate birthday) {
		if(birthday!=null && birthday.isBefore(LocalDate.now())) {
			this.birthday = birthday;
		}else {
			throw new DataInvalidException("生日不得大於今天:" + birthday);
		}
	}
	
	
	
	public void setBirthday (String dateString) {
		//這裡有三種setBirthday的檢查方式，只有一個get；注意String
		try {
			LocalDate bDate = LocalDate.parse(dateString);
			this.setBirthday(bDate);
		}catch (DateTimeParseException ex) {
			throw new DataInvalidException("客戶生日格式不正確，應為yyyy-mm-dd");
		}
	}
	
	
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		if(gender!=0 && gender == 'F' || gender == 'M') { //這裡的gender要跟register.jsp的value一樣！
			this.gender = gender;
		}else {
			throw new DataInvalidException("性別欄位只能是F(female)或M(male)。" + gender);
		}
	}
	
	
	
	
	public boolean isMember_plan() {
		return member_plan;
	}

	public void setMember_plan(boolean member_plan) {
		this.member_plan = member_plan;
	}



	public LocalDate getExp() {
		return exp;
	}

	public void setExp(LocalDate exp) {
		if(exp.isAfter(LocalDate.now().plusMonths(1))) {
			this.exp = exp;
		}else {
			throw new DataInvalidException("會員期限必須以一個月為限:" + exp);
		}
	}
	
	public void setExp(String expString) {
		
		try {
			LocalDate expS = LocalDate.parse(expString);
			this.setExp(expS);
		}catch (DateTimeParseException ex) {
			throw new DataInvalidException("有效期限格式不正確，應為yyyy-mm-dd", ex);
		}
	}
	
	
}//結尾大括號
