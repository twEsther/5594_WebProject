package wefly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wefly.entity.Member;
import wefly.entity.WeflyException;
import wefly.service.MusicService;

/**
 * Servlet implementation class AddRecentlyListenListServlet
 */
@WebServlet("/member/add_recently.do")
public class AddRecentlyListenListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddRecentlyListenListServlet() {
        super();
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//1.取得request的Form Data (抓name的值) 並檢查
		List<String> errors = new ArrayList<>();
		
		Member m = (Member)session.getAttribute("member");
		String musicId = (String)request.getParameter("musicId");

		String l = (String)request.getParameter(request.getContextPath()+"/member/recently_listen.jsp");
	
		//2.執行商業邏輯
		String redirectURL=request.getContextPath();
		try {
			MusicService service = new MusicService();
	
	
			service.insertLoveListMusic(m.getEmail(), Integer.parseInt(musicId), love);
			//跳轉的網頁網址要寫在裡面，才知道要跳去哪裡。
			if("最近常聽".equals(recently)) {
				service.insertRecentlyListentMusic(m.getEmail(), Integer.parseInt(musicId), love);
				//redirectURL+="music_list.jsp?love=最近常聽";
				redirectURL+="/member/recently_listen.jsp";
			}

	
			//按讚or加歌單，都是在if區塊裡判斷完之後 出來再return
			//response.sendRedirect(redirectURL);
			response.sendRedirect(redirectURL+"/member/music_list.jsp");
			return;
			
		} catch (WeflyException e) {
			this.log("加入清單失敗", e);
		} catch (Exception ex) {
			this.log("加入清單發生非預期的錯！", ex);
			errors.add("加入清單發生非預期的錯" + ex);
		}
		System.out.println(errors);	
		response.sendRedirect(request.getContextPath());		
		//response.sendRedirect(redirectURL);
	}

}
