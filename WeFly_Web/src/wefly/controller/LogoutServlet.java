package wefly.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//找得到舊的seesion就不要建立新的，因為是登入後要登出的，沒有舊的就加判斷
		
		if(session!=null) {
			session.invalidate();
			//做完之後也沒有什麼資料要取得所以就會產生一個空白畫面
			//因為是false所以就不用建立新的session
		}
		//外部轉交回首頁
		response.sendRedirect(request.getContextPath() + "/index.jsp"); //request.getContextPath()
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); //再傳回去給doPost
	}

}
