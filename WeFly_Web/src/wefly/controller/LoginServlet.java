package wefly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wefly.entity.Member;
import wefly.entity.WeflyException;
import wefly.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		List<String> errors = new ArrayList<>();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email==null || email.length()==0) {
			errors.add("必須輸入帳號");
		} 
		
		if(password==null || password.length()==0) {
			errors.add("必須輸入密碼");
		}
		
		
		
		if(errors.isEmpty()) {
			MemberService service = new MemberService();
			try {
				Member m = service.login(email, password);
				
				String keepEmail = request.getParameter("keepEmail");
				
				Cookie emailCookie = new Cookie("email", email);
				Cookie keepEmailCookie = new Cookie("keepEmail", "checked");
				int maxAge=0; //單位是秒
				if(keepEmail!=null) {
					maxAge = 24*60*60; //有效期限是一天
				}
				emailCookie.setMaxAge(maxAge);
				keepEmailCookie.setMaxAge(maxAge);
				
				response.addCookie(emailCookie);
				response.addCookie(keepEmailCookie); //寫到這邊之後要先檢查有沒有成功把帳號密碼寫進去瀏覽器的cookie裡

				HttpSession session = request.getSession();
				session.setAttribute("member", m);  
				
				response.sendRedirect(request.getContextPath()); //這段註解掉就會跑出空白畫面，以確認有無成功
				
				return;
				
			} catch (WeflyException e) {
				this.log("會員登入發生錯誤！", e);
				errors.add(e.getMessage());
			
			} catch (Exception e) {
				this.log("會員登入發生非預期的錯", e);
				errors.add("會員無法登入" + e.toString());
			}
		}
		
		
		//3.2 登入失敗的畫面、回到login.jsp
		
		request.setAttribute("errors", errors);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
		
		return;
		
	}
}// 結尾大括號
