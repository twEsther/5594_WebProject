package wefly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wefly.entity.DataInvalidException;
import wefly.entity.Member;
import wefly.entity.WeflyException;
import wefly.service.MemberService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errors = new ArrayList<>();
		request.setCharacterEncoding("UTF-8");
		
		
		//1.讀取request中的FormData資料，並檢查
		//這邊Parameter的值是要抓前端register.jsp的name
		String email = request.getParameter("email");
		String checkemail = request.getParameter("emailcheck");
		String password = request.getParameter("password");
		String name = request.getParameter("nickname");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		
		String captcha = request.getParameter("captcha");
		
		
		//if(email==null || !Member.email.matches(emailPattern) 不能加這段嗎？
		//是Member那邊的emailPattern get.set要public嗎? 改過了但好像一樣不行
		if(email==null  || email.length()==0 || !email.equals(checkemail)) {
			errors.add("必須輸入一致的E-mail哦！");
		}
			
		if(password==null || password.length()==0) {
			errors.add("必須輸入正確的密碼！");
		}

		if(name==null || (name.trim()).length()==0) {
			errors.add("必須輸入正確的名字或暱稱！");
		}
		
		if(birthday==null || (birthday.trim()).length()==0) {
			errors.add("必須輸入正確的生日！");
		}
		
		if(gender==null || (gender.trim()).length()==0) {
			errors.add("必須輸入正確的性別！");
		}
		
			
		HttpSession session = request.getSession(); //參考LoginServlet
		if(captcha==null || (captcha=captcha.trim()).length()==0) {
			errors.add("輸入驗證碼啊啊啊！");
		}else {
			String oldCaptcha = (String)session.getAttribute("RegisterCaptchaServlet"); //session裡舊的oldCaptcha
			if(!captcha.equals(oldCaptcha)) { //大小寫要相同，若要不分大小寫:就用equalsIgnoreCase
				errors.add("驗證碼不正確喔……");
			}
		}
		session.removeAttribute("RegisterCaptchaServlet"); //否則會一直留在記憶體了占用記憶體
		
		
		
		
		//2.若無誤，呼叫商業邏輯		這一段是否可以不用加？因為上面檢查過了
		if(errors.isEmpty()) {
			Member m = new Member();
			try {
				m.setEmail(email);
				m.setPassword(password);
				m.setName(name);
				m.setBirthday(birthday);
				m.setGender(gender!=null && gender.length()>0?gender.charAt(0):' ');
				//上面這行甚麼意思？
				
				MemberService service = new MemberService();
				service.register(m);
				
				
				
				
		//3.1 顯示：也就是forward(內部轉交)給註冊成功畫面() 派遣給register_ok.html
				
				request.setAttribute("member", m);
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("index.jsp");
				
				dispatcher.forward(request, response);
				
				return;
			} catch (DataInvalidException e) {
				errors.add(e.getMessage());
			} catch(WeflyException e) {
				this.log(e.getMessage(),e);
				errors.add(e.getMessage());
			} catch(Exception e) {
				this.log("會員註冊發生非預期錯誤: "+e.getMessage(),e);
				errors.add("會員註冊失敗: "+e.getMessage());
			}
		}
		
		
		
		
		//3.2 forward(內部轉交)給註冊失敗畫面
		request.setAttribute("errors", errors);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("register.jsp");
		
		dispatcher.forward(request, response);
		
	}
} //這裡是類別class結尾的大括號
